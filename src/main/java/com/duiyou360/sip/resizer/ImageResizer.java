package com.duiyou360.sip.resizer;

import javax.imageio.ImageIO;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

public interface ImageResizer {

    BufferedImage resize(BufferedImage sourceImage, int targetWidth, int targetHeight);

    default BufferedImage resizeWithin(BufferedImage sourceImage, int maxWidth, int maxHeight){
        Dimension fitSize = calculateFitSize(sourceImage, maxWidth, maxHeight);
        return resize(sourceImage, fitSize.width, fitSize.height);
    }

    default Dimension calculateFitSize(BufferedImage sourceImage, int maxWidth, int maxHeight){
        int imageWidth = sourceImage.getWidth();
        int imageHeight = sourceImage.getHeight();
        if( imageWidth <= maxWidth && imageHeight <= maxHeight
            || maxWidth <= 0 && maxHeight <= 0

        ){
            return new Dimension(imageWidth, imageHeight);
        }
        int targetWidth, targetHeight;

        boolean fitWidth;

        double imageRatio = imageWidth/(double)imageHeight;
        if(maxHeight > 0 && maxWidth > 0){
            double maxRatio = maxWidth/(double)maxHeight;
            fitWidth = imageRatio >= maxRatio;
        }else {
            fitWidth = maxHeight <= 0;
        }

        if(fitWidth){
            targetWidth = maxWidth;
            targetHeight = (int) Math.ceil(targetWidth/imageRatio);
        }else{
            targetHeight = maxHeight;
            targetWidth = (int) Math.ceil(maxHeight * imageRatio);
        }
        return new Dimension(targetWidth, targetHeight);
    }

}
