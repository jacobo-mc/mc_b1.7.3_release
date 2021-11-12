package net.minecraft.src;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.TreeSet;

public final class J_CompactJsonFormatter implements J_JsonFormatter {
    public String func_27327_a(J_JsonRootNode var1) {
        StringWriter var2 = new StringWriter();

        try {
            this.func_27329_a(var1, var2);
        } catch (IOException var4) {
            throw new RuntimeException("Coding failure in Argo:  StringWriter gave an IOException", var4);
        }

        return var2.toString();
    }

    public void func_27329_a(J_JsonRootNode var1, Writer var2) throws IOException {
        this.func_27328_a(var1, var2);
    }

    private void func_27328_a(J_JsonNode var1, Writer var2) throws IOException {
        boolean var3 = true;
        Iterator var4;
        switch(EnumJsonNodeTypeMappingHelper.field_27341_a[var1.func_27218_a().ordinal()]) {
        case 1:
            var2.append('[');
            var4 = var1.func_27215_d().iterator();

            while(var4.hasNext()) {
                J_JsonNode var6 = (J_JsonNode)var4.next();
                if (!var3) {
                    var2.append(',');
                }

                var3 = false;
                this.func_27328_a(var6, var2);
            }

            var2.append(']');
            break;
        case 2:
            var2.append('{');
            var4 = (new TreeSet(var1.func_27214_c().keySet())).iterator();

            while(var4.hasNext()) {
                J_JsonStringNode var5 = (J_JsonStringNode)var4.next();
                if (!var3) {
                    var2.append(',');
                }

                var3 = false;
                this.func_27328_a(var5, var2);
                var2.append(':');
                this.func_27328_a((J_JsonNode)var1.func_27214_c().get(var5), var2);
            }

            var2.append('}');
            break;
        case 3:
            var2.append('"').append((new J_JsonEscapedString(var1.func_27216_b())).toString()).append('"');
            break;
        case 4:
            var2.append(var1.func_27216_b());
            break;
        case 5:
            var2.append("false");
            break;
        case 6:
            var2.append("true");
            break;
        case 7:
            var2.append("null");
            break;
        default:
            throw new RuntimeException("Coding failure in Argo:  Attempt to format a JsonNode of unknown type [" + var1.func_27218_a() + "];");
        }

    }
}
