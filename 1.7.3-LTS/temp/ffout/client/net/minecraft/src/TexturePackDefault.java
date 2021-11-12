package net.minecraft.src;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class TexturePackDefault extends TexturePackBase {
    private int field_6491_e = -1;
    private BufferedImage field_6490_f;

    public TexturePackDefault() {
        this.field_6487_a = "Default";
        this.field_6486_b = "The default look of Minecraft";

        try {
            this.field_6490_f = ImageIO.read(TexturePackDefault.class.getResource("/pack.png"));
        } catch (IOException var2) {
            var2.printStackTrace();
        }

    }

    public void func_6484_b(Minecraft var1) {
        if (this.field_6490_f != null) {
            var1.field_6315_n.func_1078_a(this.field_6491_e);
        }

    }

    public void func_6483_c(Minecraft var1) {
        if (this.field_6490_f != null && this.field_6491_e < 0) {
            this.field_6491_e = var1.field_6315_n.func_1074_a(this.field_6490_f);
        }

        if (this.field_6490_f != null) {
            var1.field_6315_n.func_1076_b(this.field_6491_e);
        } else {
            GL11.glBindTexture(3553, var1.field_6315_n.func_1070_a("/gui/unknown_pack.png"));
        }

    }
}
