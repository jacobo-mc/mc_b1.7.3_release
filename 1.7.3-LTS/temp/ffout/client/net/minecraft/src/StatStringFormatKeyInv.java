package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class StatStringFormatKeyInv implements IStatStringFormat {
    // $FF: synthetic field
    final Minecraft field_27344_a;

    public StatStringFormatKeyInv(Minecraft var1) {
        this.field_27344_a = var1;
    }

    public String func_27343_a(String var1) {
        return String.format(var1, Keyboard.getKeyName(this.field_27344_a.field_6304_y.field_1570_o.field_1370_b));
    }
}
