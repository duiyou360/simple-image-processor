package com.duiyou360.sip.filter;

import java.awt.image.BufferedImage;
import java.awt.image.Kernel;

public interface ImageFilter {
    BufferedImage blur(BufferedImage sourceImage, Kernel kernel);
}
