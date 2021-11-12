package net.minecraft.src;

public class ChatLine {
    public String message;
    public int updateCounter;

    public ChatLine(String var1) {
        this.message = var1;
        this.updateCounter = 0;
    }
}
