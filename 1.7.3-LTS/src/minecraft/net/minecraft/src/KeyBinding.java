package net.minecraft.src;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class KeyBinding {
    public String keyDescription;
    // Positive: LWJGL keyboard code. Negative: mouse button minus 100. Zero: unbound.
    public int keyCode;
    public final int defaultKeyCode;

    public KeyBinding(String description, int code) {
        this.keyDescription = description;
        this.keyCode = this.defaultKeyCode = code;
    }

    public boolean matches(int code) {
        return this.keyCode != 0 && this.keyCode == code;
    }

    public boolean isDown() {
        if (this.keyCode < 0) {
            int button = this.keyCode + 100;
            return Mouse.isCreated() && button >= 0 && button < Mouse.getButtonCount() && Mouse.isButtonDown(button);
        }
        return Keyboard.isCreated() && this.keyCode > 0 && this.keyCode < Keyboard.KEYBOARD_SIZE && Keyboard.isKeyDown(this.keyCode);
    }

    public String getDisplayName() {
        if (this.keyCode == 0) return "Unbound";
        if (this.keyCode < 0) return "Mouse " + (this.keyCode + 101);
        String name = this.keyCode < Keyboard.KEYBOARD_SIZE ? Keyboard.getKeyName(this.keyCode) : null;
        return name == null ? "Unknown" : name;
    }
}
