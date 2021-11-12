package net.minecraft.src;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.Reader;

final class J_PositionTrackingPushbackReader implements J_ThingWithPosition {
    private final PushbackReader pushbackReader;
    private int characterCount = 0;
    private int lineCount = 1;
    private boolean lastCharacterWasCarriageReturn = false;

    public J_PositionTrackingPushbackReader(Reader var1) {
        this.pushbackReader = new PushbackReader(var1);
    }

    public void unread(char var1) throws IOException {
        --this.characterCount;
        if (this.characterCount < 0) {
            this.characterCount = 0;
        }

        this.pushbackReader.unread(var1);
    }

    public void uncount(char[] var1) {
        this.characterCount -= var1.length;
        if (this.characterCount < 0) {
            this.characterCount = 0;
        }

    }

    public int read() throws IOException {
        int var1 = this.pushbackReader.read();
        this.updateCharacterAndLineCounts(var1);
        return var1;
    }

    public int read(char[] var1) throws IOException {
        int var2 = this.pushbackReader.read(var1);
        char[] var3 = var1;
        int var4 = var1.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            char var6 = var3[var5];
            this.updateCharacterAndLineCounts(var6);
        }

        return var2;
    }

    private void updateCharacterAndLineCounts(int var1) {
        if (13 == var1) {
            this.characterCount = 0;
            ++this.lineCount;
            this.lastCharacterWasCarriageReturn = true;
        } else {
            if (10 == var1 && !this.lastCharacterWasCarriageReturn) {
                this.characterCount = 0;
                ++this.lineCount;
            } else {
                ++this.characterCount;
            }

            this.lastCharacterWasCarriageReturn = false;
        }

    }

    public int getColumn() {
        return this.characterCount;
    }

    public int getRow() {
        return this.lineCount;
    }
}
