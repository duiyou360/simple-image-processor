package com.duiyou360.sip.filter;

import com.duiyou360.sip.BaseTest;
import com.duiyou360.sip.resizer.JavaImageResizer;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class JavaImageResizerTest extends BaseTest {

    private JavaImageResizer imageResizer = new JavaImageResizer();

    private BufferedImage sourceImage = ImageIO.read(BaseTest.class.getResourceAsStream("/source-image.png"));

    private int sourceWidth = sourceImage.getWidth();
    private int sourceHeight = sourceImage.getHeight();

    JavaImageResizerTest() throws IOException {
    }


    @Test
    void resize() throws IOException {
        int targetWidth = (int) ((double)sourceWidth * 0.5);
        int targetHeight = (int) ((double) sourceHeight * 0.5);
        BufferedImage resized = imageResizer.resize(sourceImage, targetWidth, targetHeight);
        assertEquals(targetWidth, resized.getWidth());
        assertEquals(targetHeight, resized.getHeight());
    }

    @Test
    void performance(){
        int targetWidth = (int) ((double)sourceWidth * 0.5);
        int targetHeight = (int) ((double) sourceHeight * 0.5);

        assertTimeout(Duration.ofMillis(500), ()->{
                imageResizer.resize(sourceImage, targetWidth, targetHeight);
        });
    }



}