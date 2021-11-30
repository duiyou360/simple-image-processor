package com.duiyou360.sip.resizer;

import com.duiyou360.sip.BaseTest;
import org.junit.jupiter.api.Test;

import java.awt.Dimension;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.*;

class ImageResizerTest extends BaseTest {


    private ImageResizer resizer = new ImageResizer() {
        @Override
        public BufferedImage resize(BufferedImage sourceImage, int targetWidth, int targetHeight) {
            return null;
        }
    };

    @Test
    void calculateFitSize() {
        int maxWidth, maxHeight;
        Dimension fitSize;
        BufferedImage sourceImage = new BufferedImage(100, 80, BufferedImage.TYPE_INT_ARGB);

        //目标区域包含原图
        maxWidth = 300;
        maxHeight = 200;
        fitSize = resizer.calculateFitSize(sourceImage, maxWidth, maxHeight);
        assertEquals(100, fitSize.getWidth());
        assertEquals(80, fitSize.getHeight());

        //宽度包含，高度不包含，宽高比大于原图
        maxWidth = 200;
        maxHeight = 60;
        fitSize = resizer.calculateFitSize(sourceImage, maxWidth, maxHeight);
        assertEquals(75, fitSize.getWidth());
        assertEquals(60, fitSize.getHeight());


        //宽度 高度 均不包含，宽高比 小于原图
        maxWidth = 80;
        maxHeight = 60;
        fitSize = resizer.calculateFitSize(sourceImage, maxWidth, maxHeight);
        assertEquals(75, fitSize.getWidth());
        assertEquals(60, fitSize.getHeight());

        //宽度 高度 均不包含，宽高比 大于原图
        maxWidth = 80;
        maxHeight = 67;
        fitSize = resizer.calculateFitSize(sourceImage, maxWidth, maxHeight);
        assertEquals(80, fitSize.getWidth());
        assertEquals(64, fitSize.getHeight());

        //宽度不包含，高度包含
        maxWidth = 80;
        maxHeight = 150;
        fitSize = resizer.calculateFitSize(sourceImage, maxWidth, maxHeight);
        assertEquals(80, fitSize.getWidth());
        assertEquals(64, fitSize.getHeight());

        //无限制
        maxWidth = 0;
        maxHeight = 0;
        fitSize = resizer.calculateFitSize(sourceImage, maxWidth, maxHeight);
        assertEquals(100, fitSize.getWidth());
        assertEquals(80, fitSize.getHeight());

        //以高度为准
        maxWidth = 0;
        maxHeight = 60;
        fitSize = resizer.calculateFitSize(sourceImage, maxWidth, maxHeight);
        assertEquals(75, fitSize.getWidth());
        assertEquals(60, fitSize.getHeight());

        //以宽度为准
        maxWidth = 50;
        maxHeight = 0;
        fitSize = resizer.calculateFitSize(sourceImage, maxWidth, maxHeight);
        assertEquals(50, fitSize.getWidth());
        assertEquals(40, fitSize.getHeight());
    }
}