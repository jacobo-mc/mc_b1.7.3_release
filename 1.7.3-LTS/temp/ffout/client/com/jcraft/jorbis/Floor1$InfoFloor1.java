package com.jcraft.jorbis;

class Floor1$InfoFloor1 {
    static final int VIF_POSIT = 63;
    static final int VIF_CLASS = 16;
    static final int VIF_PARTS = 31;
    int partitions;
    int[] partitionclass;
    int[] class_dim;
    int[] class_subs;
    int[] class_book;
    int[][] class_subbook;
    int mult;
    int[] postlist;
    float maxover;
    float maxunder;
    float maxerr;
    int twofitminsize;
    int twofitminused;
    int twofitweight;
    float twofitatten;
    int unusedminsize;
    int unusedmin_n;
    int n;
    // $FF: synthetic field
    final Floor1 this$0;

    Floor1$InfoFloor1(Floor1 var1) {
        this.this$0 = var1;
        this.partitionclass = new int[31];
        this.class_dim = new int[16];
        this.class_subs = new int[16];
        this.class_book = new int[16];
        this.class_subbook = new int[16][];
        this.postlist = new int[65];

        for(int var2 = 0; var2 < this.class_subbook.length; ++var2) {
            this.class_subbook[var2] = new int[8];
        }

    }

    void free() {
        this.partitionclass = null;
        this.class_dim = null;
        this.class_subs = null;
        this.class_book = null;
        this.class_subbook = (int[][])null;
        this.postlist = null;
    }

    Object copy_info() {
        Floor1$InfoFloor1 var1 = this;
        Floor1$InfoFloor1 var2 = new Floor1$InfoFloor1(this.this$0);
        var2.partitions = this.partitions;
        System.arraycopy(this.partitionclass, 0, var2.partitionclass, 0, 31);
        System.arraycopy(this.class_dim, 0, var2.class_dim, 0, 16);
        System.arraycopy(this.class_subs, 0, var2.class_subs, 0, 16);
        System.arraycopy(this.class_book, 0, var2.class_book, 0, 16);

        for(int var3 = 0; var3 < 16; ++var3) {
            System.arraycopy(var1.class_subbook[var3], 0, var2.class_subbook[var3], 0, 8);
        }

        var2.mult = var1.mult;
        System.arraycopy(var1.postlist, 0, var2.postlist, 0, 65);
        var2.maxover = var1.maxover;
        var2.maxunder = var1.maxunder;
        var2.maxerr = var1.maxerr;
        var2.twofitminsize = var1.twofitminsize;
        var2.twofitminused = var1.twofitminused;
        var2.twofitweight = var1.twofitweight;
        var2.twofitatten = var1.twofitatten;
        var2.unusedminsize = var1.unusedminsize;
        var2.unusedmin_n = var1.unusedmin_n;
        var2.n = var1.n;
        return var2;
    }
}
