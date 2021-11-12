package net.minecraft.src;

class ThreadRunIsoClient extends Thread {
    // $FF: synthetic field
    final CanvasIsomPreview isoCanvas;

    ThreadRunIsoClient(CanvasIsomPreview var1) {
        this.isoCanvas = var1;
    }

    public void run() {
        while(CanvasIsomPreview.isRunning(this.isoCanvas)) {
            this.isoCanvas.showNextBuffer();

            try {
                Thread.sleep(1L);
            } catch (Exception var2) {
            }
        }

    }
}
