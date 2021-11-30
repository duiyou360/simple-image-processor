package com.duiyou360.sip.filter.kernel;

import java.awt.image.Kernel;


public class EmbossKernelMaker implements KernelMaker {

    private int length;
    private float[] matrix;

    private static final float[] DEFAULT_MATRIX = {
            -2, -1, 0,
            -1,1,1,
            0,1,2
    };

    @Override
    public void useDefault() {
        this.length = 3;
        this.matrix = DEFAULT_MATRIX;
    }

    @Override
    public Kernel make() {
        if(this.length == 0){
            useDefault();
        }
        return new Kernel(this.length, this.length, this.matrix);
    }
}
