package net.minecraft.src;

import java.util.Arrays;

/** Overrides rendering brightness only; saved sky/block light levels are unchanged. */
final class ClientLighting {
    private WorldProvider provider;
    private float[] original;

    boolean update(WorldProvider next, boolean enabled) {
        if (enabled && next != null && next == this.provider) return false;
        boolean changed = this.provider != null;
        if (this.provider != null) {
            System.arraycopy(this.original, 0, this.provider.lightBrightnessTable, 0, this.original.length);
            this.provider = null;
            this.original = null;
        }
        if (enabled && next != null) {
            this.provider = next;
            this.original = next.lightBrightnessTable.clone();
            Arrays.fill(next.lightBrightnessTable, 1.0F);
            changed = true;
        }
        return changed;
    }
}
