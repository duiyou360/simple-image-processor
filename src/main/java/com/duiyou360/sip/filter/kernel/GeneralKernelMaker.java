package com.duiyou360.sip.filter.kernel;

import java.awt.image.Kernel;

public class GeneralKernelMaker implements KernelMaker{

    private int width;
    private int height;
    private float[] matrix;

    private static final float[] DEFAULT_MATRIX = {
            0.1111f, 0.1111f, 0.1111f,
            0.1111f, 0.1111f, 0.1111f,
            0.1111f, 0.1111f, 0.1111f,

    };

    public void setWidth(int width){
        this.width = width;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public void setMatrix(float[] matrix){
        this.matrix = matrix;
    }

    @Override
    public void useDefault() {
        this.width = 3;
        this.height = 3;
        this.matrix = DEFAULT_MATRIX;
    }

    @Override
    public Kernel make() {
        if(this.matrix == null){
            this.useDefault();
        }
        assert matrix.length == width * height : "matrix array size does not equal to width*height";
        return new Kernel(width, height, matrix);
    }
}
