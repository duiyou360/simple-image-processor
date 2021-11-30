package com.duiyou360.sip.filter;

import com.duiyou360.sip.filter.ImageFilter;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

public class JavaImageFilter implements ImageFilter {
    @Override
    public BufferedImage blur(BufferedImage sourceImage, Kernel kernel) {
        BufferedImageOp op = new ConvolveOp(kernel);
        return op.filter(sourceImage, null);
    }



    public Kernel makeKernel(int width, int height){
        int total = width * height;
        float rowWeight = 1.0f/height;

        int leftRowNum = width/2;

        float leftRowWeight = rowWeight/leftRowNum;

        float[] matrix = new float[total];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(j<leftRowNum){
                    matrix[i * width + j] = leftRowWeight;
                }else{
                    matrix[i * width +j] = 0;
                }
            }
        }
        return new Kernel(width, height, matrix);
    }
}
