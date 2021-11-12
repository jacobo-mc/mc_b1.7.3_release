package net.minecraft.src;

public class ServerCommand {
    public final String command;
    public final ICommandListener commandListener;

    public ServerCommand(String var1, ICommandListener var2) {
        this.command = var1;
        this.commandListener = var2;
    }
}
