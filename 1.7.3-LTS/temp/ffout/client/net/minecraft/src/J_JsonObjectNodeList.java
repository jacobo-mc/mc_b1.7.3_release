package net.minecraft.src;

import java.util.HashMap;
import java.util.Iterator;

class J_JsonObjectNodeList extends HashMap {
    // $FF: synthetic field
    final J_JsonObjectNodeBuilder field_27308_a;

    J_JsonObjectNodeList(J_JsonObjectNodeBuilder var1) {
        this.field_27308_a = var1;
        Iterator var2 = J_JsonObjectNodeBuilder.func_27236_a(this.field_27308_a).iterator();

        while(var2.hasNext()) {
            J_JsonFieldBuilder var3 = (J_JsonFieldBuilder)var2.next();
            this.put(var3.func_27303_b(), var3.func_27302_c());
        }

    }
}
