package paulscode.sound;

public class SimpleThread extends Thread {
    private static final boolean GET = false;
    private static final boolean SET = true;
    private static final boolean XXX = false;
    private boolean alive = true;
    private boolean kill = false;

    protected void cleanup() {
        this.kill(true, true);
        this.alive(true, false);
    }

    public void run() {
        this.cleanup();
    }

    public void restart() {
        (new SimpleThread$1(this)).start();
    }

    private void rerun() {
        this.kill(true, true);

        while(this.alive(false, false)) {
            this.snooze(100L);
        }

        this.alive(true, true);
        this.kill(true, false);
        this.run();
    }

    public boolean alive() {
        return this.alive(false, false);
    }

    public void kill() {
        this.kill(true, true);
    }

    protected boolean dying() {
        return this.kill(false, false);
    }

    private synchronized boolean alive(boolean var1, boolean var2) {
        if (var1) {
            this.alive = var2;
        }

        return this.alive;
    }

    private synchronized boolean kill(boolean var1, boolean var2) {
        if (var1) {
            this.kill = var2;
        }

        return this.kill;
    }

    protected void snooze(long var1) {
        try {
            Thread.sleep(var1);
        } catch (InterruptedException var4) {
        }

    }

    // $FF: synthetic method
    static void access$000(SimpleThread var0) {
        var0.rerun();
    }
}
