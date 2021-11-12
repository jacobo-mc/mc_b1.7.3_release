package net.minecraft.src;

class ThreadRunIsoClient extends Thread {
    // $FF: synthetic field
    final CanvasIsomPreview field_1197_a;

    ThreadRunIsoClient(CanvasIsomPreview var1) {
        this.field_1197_a = var1;
    }

    public void run() {
        while(CanvasIsomPreview.func_1271_a(this.field_1197_a)) {
            this.field_1197_a.func_1265_d();

            try {
                Thread.sleep(1L);
            } catch (Exception var2) {
            }
        }

    }
}
