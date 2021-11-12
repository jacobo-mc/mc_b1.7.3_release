package com.jcraft.jorbis;

class Mapping0$InfoMapping0 {
    int submaps;
    int[] chmuxlist;
    int[] timesubmap;
    int[] floorsubmap;
    int[] residuesubmap;
    int[] psysubmap;
    int coupling_steps;
    int[] coupling_mag;
    int[] coupling_ang;
    // $FF: synthetic field
    final Mapping0 this$0;

    Mapping0$InfoMapping0(Mapping0 var1) {
        this.this$0 = var1;
        this.chmuxlist = new int[256];
        this.timesubmap = new int[16];
        this.floorsubmap = new int[16];
        this.residuesubmap = new int[16];
        this.psysubmap = new int[16];
        this.coupling_mag = new int[256];
        this.coupling_ang = new int[256];
    }

    void free() {
        this.chmuxlist = null;
        this.timesubmap = null;
        this.floorsubmap = null;
        this.residuesubmap = null;
        this.psysubmap = null;
        this.coupling_mag = null;
        this.coupling_ang = null;
    }
}
