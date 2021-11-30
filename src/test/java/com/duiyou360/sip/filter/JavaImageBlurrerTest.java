package com.duiyou360.sip.filter;

import com.duiyou360.sip.BaseTest;
import com.duiyou360.sip.filter.JavaImageFilter;
import com.duiyou360.sip.filter.kernel.EmbossKernelMaker;
import com.duiyou360.sip.filter.kernel.GeneralKernelMaker;
import com.duiyou360.sip.resizer.JavaImageResizer;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class JavaImageBlurrerTest extends BaseTest {

    private JavaImageFilter blurrer = new JavaImageFilter();

    private BufferedImage sourceImage = ImageIO.read(Class.class.getResourceAsStream("/image-with-text.png"));

    JavaImageBlurrerTest() throws IOException {
    }


    @Test
    void testBlur()  {

        //resize
        BufferedImage resized = new JavaImageResizer().resizeWithin(sourceImage, 1080,0);

        BufferedImage blurred = blurrer.blur(resized, new GeneralKernelMaker().make());

        assertNotNull(blurred);
        assertEquals(resized.getWidth(), blurred.getWidth());
        assertEquals(resized.getHeight(), blurred.getHeight());

        int width = blurred.getWidth();
        int height = blurred.getHeight();

        this.writeImageToTargetDirectory(blurred, "blurred-image.png");
    }

    @Test
    void testPerformance(){
        assertTimeout(Duration.ofMillis(1000),()->{
            blurrer.blur(sourceImage, new EmbossKernelMaker().make());
        });
    }

}