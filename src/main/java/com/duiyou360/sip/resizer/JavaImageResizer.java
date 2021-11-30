package com.duiyou360.sip.resizer;

import com.duiyou360.sip.resizer.ImageResizer;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class JavaImageResizer implements ImageResizer {

    @Override
    public BufferedImage resize(BufferedImage sourceImage, int targetWidth, int targetHeight) {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(sourceImage, 0, 0, targetWidth, targetHeight, null);
        graphics2D.dispose();
        return resizedImage;
    }
}
