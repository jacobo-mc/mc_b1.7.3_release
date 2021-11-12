package paulscode.sound;

class MidiChannel$FadeThread extends SimpleThread {
    // $FF: synthetic field
    final MidiChannel this$0;

    private MidiChannel$FadeThread(MidiChannel var1) {
        this.this$0 = var1;
    }

    public void run() {
        while(!this.dying()) {
            if (this.this$0.fadeOutGain == -1.0F && this.this$0.fadeInGain == 1.0F) {
                this.snooze(3600000L);
            }

            MidiChannel.access$100(this.this$0);
            this.snooze(50L);
        }

        this.cleanup();
    }

    // $FF: synthetic method
    MidiChannel$FadeThread(MidiChannel var1, MidiChannel$1 var2) {
        this(var1);
    }
}
