package com.duiyou360.sip;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BaseTest {

    public void writeImageToTargetDirectory(BufferedImage image, String name){

        File testClasses = new File(BaseTest.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        File targetDir = testClasses.getParentFile();

        try {
            ImageIO.write(image, "png",new File(targetDir, name));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
