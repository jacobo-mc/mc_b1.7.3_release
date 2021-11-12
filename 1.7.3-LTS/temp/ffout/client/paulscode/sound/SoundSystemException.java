package paulscode.sound;

public class SoundSystemException extends Exception {
    private static final long serialVersionUID = 1L;
    public static final int ERROR_NONE = 0;
    public static final int UNKNOWN_ERROR = 1;
    public static final int NULL_PARAMETER = 2;
    public static final int CLASS_TYPE_MISMATCH = 3;
    public static final int LIBRARY_NULL = 4;
    public static final int LIBRARY_TYPE = 5;
    public static final int OPENAL_CREATE = 6;
    public static final int OPENAL_INVALID_NAME = 7;
    public static final int OPENAL_INVALID_ENUM = 8;
    public static final int OPENAL_INVALID_VALUE = 9;
    public static final int OPENAL_INVALID_OPERATION = 10;
    public static final int OPENAL_OUT_OF_MEMORY = 11;
    public static final int OPENAL_LISTENER = 12;
    public static final int OPENAL_NO_AL_PITCH = 13;
    public static final int JAVASOUND_MIXER_NOT_FOUND = 14;
    public static final int JAVASOUND_MIXER_NO_GAIN_CONTROL = 15;
    public static final int JAVASOUND_MIXER_NO_PAN_CONTROL = 16;
    public static final int JAVASOUND_MIXER_NO_SAMPLE_RATE_CONTROL = 17;
    private int myType = 1;

    public SoundSystemException(String var1) {
        super(var1);
    }

    public SoundSystemException(String var1, int var2) {
        super(var1);
        this.myType = var2;
    }

    public int getType() {
        return this.myType;
    }
}
