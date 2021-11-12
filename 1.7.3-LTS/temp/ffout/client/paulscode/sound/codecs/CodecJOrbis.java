package paulscode.sound.codecs;

import com.jcraft.jogg.Packet;
import com.jcraft.jogg.Page;
import com.jcraft.jogg.StreamState;
import com.jcraft.jogg.SyncState;
import com.jcraft.jorbis.Block;
import com.jcraft.jorbis.Comment;
import com.jcraft.jorbis.DspState;
import com.jcraft.jorbis.Info;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownServiceException;
import java.nio.ByteOrder;
import javax.sound.sampled.AudioFormat;
import paulscode.sound.ICodec;
import paulscode.sound.SoundBuffer;
import paulscode.sound.SoundSystemConfig;
import paulscode.sound.SoundSystemLogger;

public class CodecJOrbis implements ICodec {
    private static final boolean GET = false;
    private static final boolean SET = true;
    private static final boolean XXX = false;
    protected URL url;
    protected URLConnection urlConnection = null;
    private InputStream inputStream;
    private AudioFormat audioFormat;
    private boolean endOfStream = false;
    private boolean initialized = false;
    private byte[] buffer = null;
    private int bufferSize;
    private int count = 0;
    private int index = 0;
    private int convertedBufferSize;
    private float[][][] pcmInfo;
    private int[] pcmIndex;
    private Packet joggPacket = new Packet();
    private Page joggPage = new Page();
    private StreamState joggStreamState = new StreamState();
    private SyncState joggSyncState = new SyncState();
    private DspState jorbisDspState = new DspState();
    private Block jorbisBlock;
    private Comment jorbisComment;
    private Info jorbisInfo;
    private SoundSystemLogger logger;
    private static final boolean LITTLE_ENDIAN;

    public CodecJOrbis() {
        this.jorbisBlock = new Block(this.jorbisDspState);
        this.jorbisComment = new Comment();
        this.jorbisInfo = new Info();
        this.logger = SoundSystemConfig.getLogger();
    }

    public void reverseByteOrder(boolean var1) {
    }

    public boolean initialize(URL var1) {
        this.initialized(true, false);
        if (this.joggStreamState != null) {
            this.joggStreamState.clear();
        }

        if (this.jorbisBlock != null) {
            this.jorbisBlock.clear();
        }

        if (this.jorbisDspState != null) {
            this.jorbisDspState.clear();
        }

        if (this.jorbisInfo != null) {
            this.jorbisInfo.clear();
        }

        if (this.joggSyncState != null) {
            this.joggSyncState.clear();
        }

        if (this.inputStream != null) {
            try {
                this.inputStream.close();
            } catch (IOException var7) {
            }
        }

        this.url = var1;
        this.bufferSize = SoundSystemConfig.getStreamingBufferSize() / 2;
        this.buffer = null;
        this.count = 0;
        this.index = 0;
        this.joggStreamState = new StreamState();
        this.jorbisBlock = new Block(this.jorbisDspState);
        this.jorbisDspState = new DspState();
        this.jorbisInfo = new Info();
        this.joggSyncState = new SyncState();

        try {
            this.urlConnection = var1.openConnection();
        } catch (UnknownServiceException var5) {
            this.errorMessage("Unable to create a UrlConnection in method 'initialize'.");
            this.printStackTrace(var5);
            this.cleanup();
            return false;
        } catch (IOException var6) {
            this.errorMessage("Unable to create a UrlConnection in method 'initialize'.");
            this.printStackTrace(var6);
            this.cleanup();
            return false;
        }

        if (this.urlConnection != null) {
            try {
                this.inputStream = this.openInputStream();
            } catch (IOException var4) {
                this.errorMessage("Unable to acquire inputstream in method 'initialize'.");
                this.printStackTrace(var4);
                this.cleanup();
                return false;
            }
        }

        this.endOfStream(true, false);
        this.joggSyncState.init();
        this.joggSyncState.buffer(this.bufferSize);
        this.buffer = this.joggSyncState.data;

        try {
            if (!this.readHeader()) {
                this.errorMessage("Error reading the header");
                return false;
            }
        } catch (IOException var8) {
            this.errorMessage("Error reading the header");
            return false;
        }

        this.convertedBufferSize = this.bufferSize * 2;
        this.jorbisDspState.synthesis_init(this.jorbisInfo);
        this.jorbisBlock.init(this.jorbisDspState);
        int var2 = this.jorbisInfo.channels;
        int var3 = this.jorbisInfo.rate;
        this.audioFormat = new AudioFormat((float)var3, 16, var2, true, false);
        this.pcmInfo = new float[1][][];
        this.pcmIndex = new int[this.jorbisInfo.channels];
        this.initialized(true, true);
        return true;
    }

    protected InputStream openInputStream() {
        return this.urlConnection.getInputStream();
    }

    public boolean initialized() {
        return this.initialized(false, false);
    }

    public SoundBuffer read() {
        byte[] var1 = this.readBytes();
        return var1 == null ? null : new SoundBuffer(var1, this.audioFormat);
    }

    public SoundBuffer readAll() {
        byte[] var1 = this.readBytes();

        while(!this.endOfStream(false, false)) {
            var1 = appendByteArrays(var1, this.readBytes());
            if (var1 != null && var1.length >= SoundSystemConfig.getMaxFileSize()) {
                break;
            }
        }

        return new SoundBuffer(var1, this.audioFormat);
    }

    public boolean endOfStream() {
        return this.endOfStream(false, false);
    }

    public void cleanup() {
        this.joggStreamState.clear();
        this.jorbisBlock.clear();
        this.jorbisDspState.clear();
        this.jorbisInfo.clear();
        this.joggSyncState.clear();
        if (this.inputStream != null) {
            try {
                this.inputStream.close();
            } catch (IOException var2) {
            }
        }

        this.joggStreamState = null;
        this.jorbisBlock = null;
        this.jorbisDspState = null;
        this.jorbisInfo = null;
        this.joggSyncState = null;
        this.inputStream = null;
    }

    public AudioFormat getAudioFormat() {
        return this.audioFormat;
    }

    private boolean readHeader() {
        this.index = this.joggSyncState.buffer(this.bufferSize);
        int var1 = this.inputStream.read(this.joggSyncState.data, this.index, this.bufferSize);
        if (var1 < 0) {
            var1 = 0;
        }

        this.joggSyncState.wrote(var1);
        if (this.joggSyncState.pageout(this.joggPage) != 1) {
            if (var1 < this.bufferSize) {
                return true;
            } else {
                this.errorMessage("Ogg header not recognized in method 'readHeader'.");
                return false;
            }
        } else {
            this.joggStreamState.init(this.joggPage.serialno());
            this.jorbisInfo.init();
            this.jorbisComment.init();
            if (this.joggStreamState.pagein(this.joggPage) < 0) {
                this.errorMessage("Problem with first Ogg header page in method 'readHeader'.");
                return false;
            } else if (this.joggStreamState.packetout(this.joggPacket) != 1) {
                this.errorMessage("Problem with first Ogg header packet in method 'readHeader'.");
                return false;
            } else if (this.jorbisInfo.synthesis_headerin(this.jorbisComment, this.joggPacket) < 0) {
                this.errorMessage("File does not contain Vorbis header in method 'readHeader'.");
                return false;
            } else {
                int var2 = 0;

                while(var2 < 2) {
                    label73:
                    while(true) {
                        int var3;
                        do {
                            if (var2 >= 2) {
                                break label73;
                            }

                            var3 = this.joggSyncState.pageout(this.joggPage);
                            if (var3 == 0) {
                                break label73;
                            }
                        } while(var3 != 1);

                        this.joggStreamState.pagein(this.joggPage);

                        while(var2 < 2) {
                            var3 = this.joggStreamState.packetout(this.joggPacket);
                            if (var3 == 0) {
                                break;
                            }

                            if (var3 == -1) {
                                this.errorMessage("Secondary Ogg header corrupt in method 'readHeader'.");
                                return false;
                            }

                            this.jorbisInfo.synthesis_headerin(this.jorbisComment, this.joggPacket);
                            ++var2;
                        }
                    }

                    this.index = this.joggSyncState.buffer(this.bufferSize);
                    var1 = this.inputStream.read(this.joggSyncState.data, this.index, this.bufferSize);
                    if (var1 < 0) {
                        var1 = 0;
                    }

                    if (var1 == 0 && var2 < 2) {
                        this.errorMessage("End of file reached before finished readingOgg header in method 'readHeader'");
                        return false;
                    }

                    this.joggSyncState.wrote(var1);
                }

                this.index = this.joggSyncState.buffer(this.bufferSize);
                this.buffer = this.joggSyncState.data;
                return true;
            }
        }
    }

    private byte[] readBytes() {
        if (!this.initialized(false, false)) {
            return null;
        } else if (this.endOfStream(false, false)) {
            return null;
        } else {
            byte[] var1 = null;
            switch(this.joggSyncState.pageout(this.joggPage)) {
            case -1:
            case 0:
                this.endOfStream(true, true);
                break;
            case 1:
                this.joggStreamState.pagein(this.joggPage);
                if (this.joggPage.granulepos() == 0L) {
                    this.endOfStream(true, true);
                } else {
                    label47:
                    while(true) {
                        switch(this.joggStreamState.packetout(this.joggPacket)) {
                        case -1:
                        case 0:
                            if (this.joggPage.eos() != 0) {
                                this.endOfStream(true, true);
                            }
                            break label47;
                        case 1:
                            var1 = appendByteArrays(var1, this.decodeCurrentPacket());
                        }
                    }
                }
            }

            if (!this.endOfStream(false, false)) {
                this.index = this.joggSyncState.buffer(this.bufferSize);
                if (this.index == -1) {
                    this.endOfStream(true, true);
                } else {
                    this.buffer = this.joggSyncState.data;

                    try {
                        this.count = this.inputStream.read(this.buffer, this.index, this.bufferSize);
                    } catch (Exception var3) {
                        this.printStackTrace(var3);
                        return var1;
                    }

                    this.joggSyncState.wrote(this.count);
                    if (this.count == 0) {
                        this.endOfStream(true, true);
                    }
                }
            }

            return var1;
        }
    }

    private byte[] decodeCurrentPacket() {
        byte[] var1 = new byte[this.convertedBufferSize];
        if (this.jorbisBlock.synthesis(this.joggPacket) == 0) {
            this.jorbisDspState.synthesis_blockin(this.jorbisBlock);
        }

        int var4 = this.convertedBufferSize / (this.jorbisInfo.channels * 2);
        int var5 = 0;

        int var2;
        while(var5 < this.convertedBufferSize && (var2 = this.jorbisDspState.synthesis_pcmout(this.pcmInfo, this.pcmIndex)) > 0) {
            int var3;
            if (var2 < var4) {
                var3 = var2;
            } else {
                var3 = var4;
            }

            for(int var6 = 0; var6 < this.jorbisInfo.channels; ++var6) {
                int var7 = var6 * 2;

                for(int var8 = 0; var8 < var3; ++var8) {
                    int var9 = (int)(this.pcmInfo[0][var6][this.pcmIndex[var6] + var8] * 32767.0F);
                    if (var9 > 32767) {
                        var9 = 32767;
                    }

                    if (var9 < -32768) {
                        var9 = -32768;
                    }

                    if (var9 < 0) {
                        var9 |= 32768;
                    }

                    if (LITTLE_ENDIAN) {
                        var1[var5 + var7] = (byte)var9;
                        var1[var5 + var7 + 1] = (byte)(var9 >>> 8);
                    } else {
                        var1[var5 + var7 + 1] = (byte)var9;
                        var1[var5 + var7] = (byte)(var9 >>> 8);
                    }

                    var7 += 2 * this.jorbisInfo.channels;
                }
            }

            var5 += var3 * this.jorbisInfo.channels * 2;
            this.jorbisDspState.synthesis_read(var3);
        }

        var1 = trimArray(var1, var5);
        return var1;
    }

    private synchronized boolean initialized(boolean var1, boolean var2) {
        if (var1) {
            this.initialized = var2;
        }

        return this.initialized;
    }

    private synchronized boolean endOfStream(boolean var1, boolean var2) {
        if (var1) {
            this.endOfStream = var2;
        }

        return this.endOfStream;
    }

    private static byte[] trimArray(byte[] var0, int var1) {
        byte[] var2 = null;
        if (var0 != null && var0.length > var1) {
            var2 = new byte[var1];
            System.arraycopy(var0, 0, var2, 0, var1);
        }

        return var2;
    }

    private static byte[] appendByteArrays(byte[] var0, byte[] var1) {
        if (var0 == null && var1 == null) {
            return null;
        } else {
            byte[] var2;
            Object var4;
            if (var0 == null) {
                var2 = new byte[var1.length];
                System.arraycopy(var1, 0, var2, 0, var1.length);
                var4 = null;
            } else {
                Object var3;
                if (var1 == null) {
                    var2 = new byte[var0.length];
                    System.arraycopy(var0, 0, var2, 0, var0.length);
                    var3 = null;
                } else {
                    var2 = new byte[var0.length + var1.length];
                    System.arraycopy(var0, 0, var2, 0, var0.length);
                    System.arraycopy(var1, 0, var2, var0.length, var1.length);
                    var3 = null;
                    var4 = null;
                }
            }

            return var2;
        }
    }

    private void errorMessage(String var1) {
        this.logger.errorMessage("CodecJOrbis", var1, 0);
    }

    private void printStackTrace(Exception var1) {
        this.logger.printStackTrace(var1, 1);
    }

    static {
        LITTLE_ENDIAN = ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN;
    }
}
