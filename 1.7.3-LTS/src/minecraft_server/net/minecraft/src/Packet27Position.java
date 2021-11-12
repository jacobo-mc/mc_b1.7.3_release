package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet27Position extends Packet {
    private float strafeMovement;
    private float fowardMovement;
    private boolean field_22039_c;
    private boolean isInJump;
    private float pitchRotation;
    private float yawRotation;

    public void readPacketData(DataInputStream var1) throws IOException {
        this.strafeMovement = var1.readFloat();
        this.fowardMovement = var1.readFloat();
        this.pitchRotation = var1.readFloat();
        this.yawRotation = var1.readFloat();
        this.field_22039_c = var1.readBoolean();
        this.isInJump = var1.readBoolean();
    }

    public void writePacketData(DataOutputStream var1) throws IOException {
        var1.writeFloat(this.strafeMovement);
        var1.writeFloat(this.fowardMovement);
        var1.writeFloat(this.pitchRotation);
        var1.writeFloat(this.yawRotation);
        var1.writeBoolean(this.field_22039_c);
        var1.writeBoolean(this.isInJump);
    }

    public void processPacket(NetHandler var1) {
        var1.handleMovementTypePacket(this);
    }

    public int getPacketSize() {
        return 18;
    }

    public float func_22031_c() {
        return this.strafeMovement;
    }

    public float func_22029_d() {
        return this.pitchRotation;
    }

    public float func_22028_e() {
        return this.fowardMovement;
    }

    public float func_22033_f() {
        return this.yawRotation;
    }

    public boolean func_22032_g() {
        return this.field_22039_c;
    }

    public boolean func_22030_h() {
        return this.isInJump;
    }
}
