package net.minecraft.src;

import org.lwjgl.input.Keyboard;

public class GuiControls extends GuiScreen {
    private final GuiScreen parentScreen;
    private final GameSettings options;
    private int buttonId = -1;
    private int page;
    private int pageSize;

    public GuiControls(GuiScreen parent, GameSettings options) {
        this.parentScreen = parent;
        this.options = options;
    }

    public void initGui() {
        this.controlList.clear();
        this.pageSize = Math.max(2, (this.height - 115) / 24) * 2;
        this.page = Math.min(this.page, (this.options.keyBindings.length - 1) / this.pageSize);
        int start = this.page * this.pageSize;
        int end = Math.min(start + this.pageSize, this.options.keyBindings.length);
        for (int i = start; i < end; i++) {
            int slot = i - start;
            this.controlList.add(new GuiSmallButton(i, this.width / 2 - 155 + slot % 2 * 160,
                    48 + slot / 2 * 24, 70, 20, this.options.getOptionDisplayString(i)));
        }
        GuiButton previous = new GuiButton(201, this.width / 2 - 155, this.height - 54, 70, 20, "Previous");
        previous.enabled = this.page > 0;
        this.controlList.add(previous);
        GuiButton next = new GuiButton(202, this.width / 2 + 85, this.height - 54, 70, 20, "Next");
        next.enabled = end < this.options.keyBindings.length;
        this.controlList.add(next);
        this.controlList.add(new GuiButton(203, this.width / 2 - 75, this.height - 54, 150, 20, "Reset All"));
        this.controlList.add(new GuiButton(200, this.width / 2 - 100, this.height - 28, "Done"));
    }

    protected void actionPerformed(GuiButton button) {
        if (button.id == 200) this.mc.displayGuiScreen(this.parentScreen);
        else if (button.id == 201 || button.id == 202) {
            this.page += button.id == 201 ? -1 : 1;
            this.buttonId = -1;
            this.initGui();
        } else if (button.id == 203) {
            for (KeyBinding key : this.options.keyBindings) key.keyCode = key.defaultKeyCode;
            this.options.saveOptions();
            this.buttonId = -1;
        } else this.buttonId = button.id;
    }

    protected void mouseClicked(int x, int y, int button) {
        if (this.buttonId >= 0) this.bind(button - 100);
        else super.mouseClicked(x, y, button);
    }

    // Capture even F11 while rebinding, instead of triggering fullscreen.
    public void handleKeyboardInput() {
        if (Keyboard.getEventKeyState()) this.keyTyped(Keyboard.getEventCharacter(), Keyboard.getEventKey());
    }

    protected void keyTyped(char character, int key) {
        if (this.buttonId >= 0) this.bind(key == Keyboard.KEY_ESCAPE ? 0 : key);
        else if (key == Keyboard.KEY_ESCAPE) this.mc.displayGuiScreen(this.parentScreen);
    }

    private void bind(int code) {
        this.options.setKeyBinding(this.buttonId, code);
        this.buttonId = -1;
    }

    public void onGuiClosed() {
        this.options.saveOptions();
    }

    public void drawScreen(int mouseX, int mouseY, float partialTick) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, "Controls - " + (this.page + 1) + "/" +
                ((this.options.keyBindings.length + this.pageSize - 1) / this.pageSize), this.width / 2, 12, 16777215);
        this.drawCenteredString(this.fontRenderer, "Select a binding, then press a key or mouse button. Esc: unbind", this.width / 2, 30, 10526880);
        for (Object entry : this.controlList) {
            GuiButton button = (GuiButton)entry;
            if (button.id >= this.options.keyBindings.length) continue;
            KeyBinding binding = this.options.keyBindings[button.id];
            boolean conflict = false;
            for (KeyBinding other : this.options.keyBindings) {
                if (other != binding && other.matches(binding.keyCode)) conflict = true;
            }
            button.displayString = (conflict ? "\u00a7c" : "") + binding.getDisplayName();
            if (button.id == this.buttonId) button.displayString = "> " + binding.getDisplayName() + " <";
            String label = this.options.getKeyBindingDescription(button.id);
            this.fontRenderer.drawSplitString(label, button.xPosition + 74, button.yPosition + 2, 82, 16777215);
        }
        super.drawScreen(mouseX, mouseY, partialTick);
    }
}
