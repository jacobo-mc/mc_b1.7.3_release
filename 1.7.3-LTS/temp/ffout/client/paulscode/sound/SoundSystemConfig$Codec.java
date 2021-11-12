package paulscode.sound;

import java.util.Locale;

class SoundSystemConfig$Codec {
    public String extensionRegX = "";
    public Class iCodecClass;

    public SoundSystemConfig$Codec(String var1, Class var2) {
        if (var1 != null && var1.length() > 0) {
            this.extensionRegX = ".*";

            for(int var4 = 0; var4 < var1.length(); ++var4) {
                String var3 = var1.substring(var4, var4 + 1);
                this.extensionRegX = this.extensionRegX + "[" + var3.toLowerCase(Locale.ENGLISH) + var3.toUpperCase(Locale.ENGLISH) + "]";
            }

            this.extensionRegX = this.extensionRegX + "$";
        }

        this.iCodecClass = var2;
    }

    public ICodec getInstance() {
        if (this.iCodecClass == null) {
            return null;
        } else {
            Object var1 = null;

            try {
                var1 = this.iCodecClass.newInstance();
            } catch (InstantiationException var3) {
                this.instantiationErrorMessage();
                return null;
            } catch (IllegalAccessException var4) {
                this.instantiationErrorMessage();
                return null;
            } catch (ExceptionInInitializerError var5) {
                this.instantiationErrorMessage();
                return null;
            } catch (SecurityException var6) {
                this.instantiationErrorMessage();
                return null;
            }

            if (var1 == null) {
                this.instantiationErrorMessage();
                return null;
            } else {
                return (ICodec)var1;
            }
        }
    }

    private void instantiationErrorMessage() {
        SoundSystemConfig.access$000("Unrecognized ICodec implementation in method 'getInstance'.  Ensure that the implementing class has one public, parameterless constructor.");
    }
}
