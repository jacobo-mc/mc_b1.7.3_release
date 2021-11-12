package paulscode.sound;

import java.net.URL;
import java.util.LinkedList;
import java.util.ListIterator;
import javax.sound.sampled.AudioFormat;

public class Source {
    protected Class libraryType = Library.class;
    private static final boolean GET = false;
    private static final boolean SET = true;
    private static final boolean XXX = false;
    private SoundSystemLogger logger = SoundSystemConfig.getLogger();
    public boolean rawDataStream = false;
    public AudioFormat rawDataFormat = null;
    public boolean temporary = false;
    public boolean priority = false;
    public boolean toStream = false;
    public boolean toLoop = false;
    public boolean toPlay = false;
    public String sourcename = "";
    public FilenameURL filenameURL = null;
    public Vector3D position;
    public int attModel = 0;
    public float distOrRoll = 0.0F;
    public float gain = 1.0F;
    public float sourceVolume = 1.0F;
    protected float pitch = 1.0F;
    public float distanceFromListener = 0.0F;
    public Channel channel = null;
    private boolean active = true;
    private boolean stopped = true;
    private boolean paused = false;
    protected SoundBuffer soundBuffer = null;
    protected ICodec codec = null;
    protected boolean reverseByteOrder = false;
    protected LinkedList soundSequenceQueue = null;
    protected final Object soundSequenceLock = new Object();
    public boolean preLoad = false;
    protected float fadeOutGain = -1.0F;
    protected float fadeInGain = 1.0F;
    protected long fadeOutMilis = 0L;
    protected long fadeInMilis = 0L;
    protected long lastFadeCheck = 0L;

    public Source(boolean var1, boolean var2, boolean var3, String var4, FilenameURL var5, SoundBuffer var6, float var7, float var8, float var9, int var10, float var11, boolean var12) {
        this.priority = var1;
        this.toStream = var2;
        this.toLoop = var3;
        this.sourcename = var4;
        this.filenameURL = var5;
        this.soundBuffer = var6;
        this.position = new Vector3D(var7, var8, var9);
        this.attModel = var10;
        this.distOrRoll = var11;
        this.temporary = var12;
        if (var2 && var5 != null) {
            this.codec = SoundSystemConfig.getCodec(var5.getFilename());
        }

    }

    public Source(Source var1, SoundBuffer var2) {
        this.priority = var1.priority;
        this.toStream = var1.toStream;
        this.toLoop = var1.toLoop;
        this.sourcename = var1.sourcename;
        this.filenameURL = var1.filenameURL;
        this.position = var1.position.clone();
        this.attModel = var1.attModel;
        this.distOrRoll = var1.distOrRoll;
        this.temporary = var1.temporary;
        this.sourceVolume = var1.sourceVolume;
        this.rawDataStream = var1.rawDataStream;
        this.rawDataFormat = var1.rawDataFormat;
        this.soundBuffer = var2;
        if (this.toStream && this.filenameURL != null) {
            this.codec = SoundSystemConfig.getCodec(this.filenameURL.getFilename());
        }

    }

    public Source(AudioFormat var1, boolean var2, String var3, float var4, float var5, float var6, int var7, float var8) {
        this.priority = var2;
        this.toStream = true;
        this.toLoop = false;
        this.sourcename = var3;
        this.filenameURL = null;
        this.soundBuffer = null;
        this.position = new Vector3D(var4, var5, var6);
        this.attModel = var7;
        this.distOrRoll = var8;
        this.temporary = false;
        this.rawDataStream = true;
        this.rawDataFormat = var1;
    }

    public void cleanup() {
        if (this.codec != null) {
            this.codec.cleanup();
        }

        synchronized(this.soundSequenceLock) {
            if (this.soundSequenceQueue != null) {
                this.soundSequenceQueue.clear();
            }

            this.soundSequenceQueue = null;
        }

        this.sourcename = null;
        this.filenameURL = null;
        this.position = null;
        this.soundBuffer = null;
        this.codec = null;
    }

    public void queueSound(FilenameURL var1) {
        if (!this.toStream) {
            this.errorMessage("Method 'queueSound' may only be used for streaming and MIDI sources.");
        } else if (var1 == null) {
            this.errorMessage("File not specified in method 'queueSound'");
        } else {
            synchronized(this.soundSequenceLock) {
                if (this.soundSequenceQueue == null) {
                    this.soundSequenceQueue = new LinkedList();
                }

                this.soundSequenceQueue.add(var1);
            }
        }
    }

    public void dequeueSound(String var1) {
        if (!this.toStream) {
            this.errorMessage("Method 'dequeueSound' may only be used for streaming and MIDI sources.");
        } else if (var1 != null && !var1.equals("")) {
            synchronized(this.soundSequenceLock) {
                if (this.soundSequenceQueue != null) {
                    this.soundSequenceQueue.remove(var1);
                }
            }

            synchronized(this.soundSequenceLock) {
                if (this.soundSequenceQueue != null) {
                    ListIterator var3 = this.soundSequenceQueue.listIterator();

                    while(var3.hasNext()) {
                        if (((FilenameURL)var3.next()).getFilename().equals(var1)) {
                            var3.remove();
                            break;
                        }
                    }
                }

            }
        } else {
            this.errorMessage("Filename not specified in method 'dequeueSound'");
        }
    }

    public void fadeOut(FilenameURL var1, long var2) {
        if (!this.toStream) {
            this.errorMessage("Method 'fadeOut' may only be used for streaming and MIDI sources.");
        } else if (var2 < 0L) {
            this.errorMessage("Miliseconds may not be negative in method 'fadeOut'.");
        } else {
            this.fadeOutMilis = var2;
            this.fadeInMilis = 0L;
            this.fadeOutGain = 1.0F;
            this.lastFadeCheck = System.currentTimeMillis();
            synchronized(this.soundSequenceLock) {
                if (this.soundSequenceQueue != null) {
                    this.soundSequenceQueue.clear();
                }

                if (var1 != null) {
                    if (this.soundSequenceQueue == null) {
                        this.soundSequenceQueue = new LinkedList();
                    }

                    this.soundSequenceQueue.add(var1);
                }

            }
        }
    }

    public void fadeOutIn(FilenameURL var1, long var2, long var4) {
        if (!this.toStream) {
            this.errorMessage("Method 'fadeOutIn' may only be used for streaming and MIDI sources.");
        } else if (var1 == null) {
            this.errorMessage("Filename/URL not specified in method 'fadeOutIn'.");
        } else if (var2 >= 0L && var4 >= 0L) {
            this.fadeOutMilis = var2;
            this.fadeInMilis = var4;
            this.fadeOutGain = 1.0F;
            this.lastFadeCheck = System.currentTimeMillis();
            synchronized(this.soundSequenceLock) {
                if (this.soundSequenceQueue == null) {
                    this.soundSequenceQueue = new LinkedList();
                }

                this.soundSequenceQueue.clear();
                this.soundSequenceQueue.add(var1);
            }
        } else {
            this.errorMessage("Miliseconds may not be negative in method 'fadeOutIn'.");
        }
    }

    public boolean checkFadeOut() {
        if (!this.toStream) {
            return false;
        } else if (this.fadeOutGain == -1.0F && this.fadeInGain == 1.0F) {
            return false;
        } else {
            long var1 = System.currentTimeMillis();
            long var3 = var1 - this.lastFadeCheck;
            this.lastFadeCheck = var1;
            float var5;
            if (this.fadeOutGain >= 0.0F) {
                if (this.fadeOutMilis == 0L) {
                    this.fadeOutGain = 0.0F;
                    this.fadeInGain = 0.0F;
                    if (!this.incrementSoundSequence()) {
                        this.stop();
                    }

                    this.positionChanged();
                    this.preLoad = true;
                    return false;
                } else {
                    var5 = (float)var3 / (float)this.fadeOutMilis;
                    this.fadeOutGain -= var5;
                    if (this.fadeOutGain <= 0.0F) {
                        this.fadeOutGain = -1.0F;
                        this.fadeInGain = 0.0F;
                        if (!this.incrementSoundSequence()) {
                            this.stop();
                        }

                        this.positionChanged();
                        this.preLoad = true;
                        return false;
                    } else {
                        this.positionChanged();
                        return true;
                    }
                }
            } else if (this.fadeInGain < 1.0F) {
                this.fadeOutGain = -1.0F;
                if (this.fadeInMilis == 0L) {
                    this.fadeOutGain = -1.0F;
                    this.fadeInGain = 1.0F;
                } else {
                    var5 = (float)var3 / (float)this.fadeInMilis;
                    this.fadeInGain += var5;
                    if (this.fadeInGain >= 1.0F) {
                        this.fadeOutGain = -1.0F;
                        this.fadeInGain = 1.0F;
                    }
                }

                this.positionChanged();
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean incrementSoundSequence() {
        if (!this.toStream) {
            this.errorMessage("Method 'incrementSoundSequence' may only be used for streaming and MIDI sources.");
            return false;
        } else {
            synchronized(this.soundSequenceLock) {
                if (this.soundSequenceQueue != null && this.soundSequenceQueue.size() > 0) {
                    this.filenameURL = (FilenameURL)this.soundSequenceQueue.remove(0);
                    if (this.codec != null) {
                        this.codec.cleanup();
                    }

                    this.codec = SoundSystemConfig.getCodec(this.filenameURL.getFilename());
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public void setTemporary(boolean var1) {
        this.temporary = var1;
    }

    public void listenerMoved() {
    }

    public void setPosition(float var1, float var2, float var3) {
        this.position.x = var1;
        this.position.y = var2;
        this.position.z = var3;
    }

    public void positionChanged() {
    }

    public void setPriority(boolean var1) {
        this.priority = var1;
    }

    public void setLooping(boolean var1) {
        this.toLoop = var1;
    }

    public void setAttenuation(int var1) {
        this.attModel = var1;
    }

    public void setDistOrRoll(float var1) {
        this.distOrRoll = var1;
    }

    public float getDistanceFromListener() {
        return this.distanceFromListener;
    }

    public void setPitch(float var1) {
        float var2 = var1;
        if (var1 < 0.5F) {
            var2 = 0.5F;
        } else if (var1 > 2.0F) {
            var2 = 2.0F;
        }

        this.pitch = var2;
    }

    public float getPitch() {
        return this.pitch;
    }

    public boolean reverseByteOrderRequired() {
        return this.reverseByteOrder;
    }

    public void changeSource(boolean var1, boolean var2, boolean var3, String var4, FilenameURL var5, SoundBuffer var6, float var7, float var8, float var9, int var10, float var11, boolean var12) {
        this.priority = var1;
        this.toStream = var2;
        this.toLoop = var3;
        this.sourcename = var4;
        this.filenameURL = var5;
        this.soundBuffer = var6;
        this.position.x = var7;
        this.position.y = var8;
        this.position.z = var9;
        this.attModel = var10;
        this.distOrRoll = var11;
        this.temporary = var12;
    }

    public int feedRawAudioData(Channel var1, byte[] var2) {
        if (!this.active(false, false)) {
            this.toPlay = true;
            return -1;
        } else {
            if (this.channel != var1) {
                this.channel = var1;
                this.channel.close();
                this.channel.setAudioFormat(this.rawDataFormat);
                this.positionChanged();
            }

            this.stopped(true, false);
            this.paused(true, false);
            return this.channel.feedRawAudioData(var2);
        }
    }

    public void play(Channel var1) {
        if (!this.active(false, false)) {
            if (this.toLoop) {
                this.toPlay = true;
            }

        } else {
            if (this.channel != var1) {
                this.channel = var1;
                this.channel.close();
            }

            this.stopped(true, false);
            this.paused(true, false);
        }
    }

    public boolean stream() {
        if (this.channel == null) {
            return false;
        } else {
            if (this.preLoad) {
                if (!this.rawDataStream) {
                    return this.preLoad();
                }

                this.preLoad = false;
            }

            if (this.rawDataStream) {
                if (this.stopped() || this.paused()) {
                    return true;
                }

                if (this.channel.buffersProcessed() > 0) {
                    this.channel.processBuffer();
                }
            } else {
                if (this.codec == null) {
                    return false;
                }

                if (this.stopped()) {
                    return false;
                }

                if (this.paused()) {
                    return true;
                }

                int var1 = this.channel.buffersProcessed();
                SoundBuffer var2 = null;

                for(int var3 = 0; var3 < var1; ++var3) {
                    var2 = this.codec.read();
                    if (var2 != null) {
                        if (var2.audioData != null) {
                            this.channel.queueBuffer(var2.audioData);
                        }

                        var2.cleanup();
                        var2 = null;
                    }

                    if (this.codec.endOfStream()) {
                        return false;
                    }
                }
            }

            return true;
        }
    }

    public boolean preLoad() {
        if (this.channel == null) {
            return false;
        } else if (this.codec == null) {
            return false;
        } else {
            URL var1 = this.filenameURL.getURL();
            this.codec.initialize(var1);
            SoundBuffer var2 = null;

            for(int var3 = 0; var3 < SoundSystemConfig.getNumberStreamingBuffers(); ++var3) {
                var2 = this.codec.read();
                if (var2 != null) {
                    if (this.soundBuffer.audioData != null) {
                        this.channel.queueBuffer(this.soundBuffer.audioData);
                    }

                    var2.cleanup();
                    var2 = null;
                }
            }

            return true;
        }
    }

    public void pause() {
        this.toPlay = false;
        this.paused(true, true);
        if (this.channel != null) {
            this.channel.pause();
        } else {
            this.errorMessage("Channel null in method 'pause'");
        }

    }

    public void stop() {
        this.toPlay = false;
        this.stopped(true, true);
        this.paused(true, false);
        if (this.channel != null) {
            this.channel.stop();
        } else {
            this.errorMessage("Channel null in method 'stop'");
        }

    }

    public void rewind() {
        if (this.paused(false, false)) {
            this.stop();
        }

        if (this.channel != null) {
            boolean var1 = this.playing();
            this.channel.rewind();
            if (this.toStream && var1) {
                this.stop();
                this.play(this.channel);
            }
        } else {
            this.errorMessage("Channel null in method 'rewind'");
        }

    }

    public void flush() {
        if (this.channel != null) {
            this.channel.flush();
        } else {
            this.errorMessage("Channel null in method 'flush'");
        }

    }

    public void cull() {
        if (this.active(false, false)) {
            if (this.playing() && this.toLoop) {
                this.toPlay = true;
            }

            if (this.rawDataStream) {
                this.toPlay = true;
            }

            this.active(true, false);
            if (this.channel != null) {
                this.channel.close();
            }

            this.channel = null;
        }
    }

    public void activate() {
        this.active(true, true);
    }

    public boolean active() {
        return this.active(false, false);
    }

    public boolean playing() {
        if (this.channel != null && this.channel.attachedSource == this) {
            return !this.paused() && !this.stopped() ? this.channel.playing() : false;
        } else {
            return false;
        }
    }

    public boolean stopped() {
        return this.stopped(false, false);
    }

    public boolean paused() {
        return this.paused(false, false);
    }

    private synchronized boolean active(boolean var1, boolean var2) {
        if (var1) {
            this.active = var2;
        }

        return this.active;
    }

    private synchronized boolean stopped(boolean var1, boolean var2) {
        if (var1) {
            this.stopped = var2;
        }

        return this.stopped;
    }

    private synchronized boolean paused(boolean var1, boolean var2) {
        if (var1) {
            this.paused = var2;
        }

        return this.paused;
    }

    public String getClassName() {
        String var1 = SoundSystemConfig.getLibraryTitle(this.libraryType);
        return var1.equals("No Sound") ? "Source" : "Source" + var1;
    }

    protected void message(String var1) {
        this.logger.message(var1, 0);
    }

    protected void importantMessage(String var1) {
        this.logger.importantMessage(var1, 0);
    }

    protected boolean errorCheck(boolean var1, String var2) {
        return this.logger.errorCheck(var1, this.getClassName(), var2, 0);
    }

    protected void errorMessage(String var1) {
        this.logger.errorMessage(this.getClassName(), var1, 0);
    }

    protected void printStackTrace(Exception var1) {
        this.logger.printStackTrace(var1, 1);
    }
}
