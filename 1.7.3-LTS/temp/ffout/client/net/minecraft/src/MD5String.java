package net.minecraft.src;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5String {
    private String field_27370_a;

    public MD5String(String var1) {
        this.field_27370_a = var1;
    }

    public String func_27369_a(String var1) {
        try {
            String var2 = this.field_27370_a + var1;
            MessageDigest var3 = MessageDigest.getInstance("MD5");
            var3.update(var2.getBytes(), 0, var2.length());
            return (new BigInteger(1, var3.digest())).toString(16);
        } catch (NoSuchAlgorithmException var4) {
            throw new RuntimeException(var4);
        }
    }
}
