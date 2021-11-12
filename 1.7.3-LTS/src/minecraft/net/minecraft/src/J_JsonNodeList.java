package net.minecraft.src;

import java.util.ArrayList;
import java.util.Iterator;

final class J_JsonNodeList extends ArrayList {
    // $FF: synthetic field
    final Iterable field_27405_a;

    J_JsonNodeList(Iterable var1) {
        this.field_27405_a = var1;
        Iterator var2 = this.field_27405_a.iterator();

        while(var2.hasNext()) {
            J_JsonNode var3 = (J_JsonNode)var2.next();
            this.add(var3);
        }

    }
}
