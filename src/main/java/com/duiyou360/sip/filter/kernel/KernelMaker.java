package com.duiyou360.sip.filter.kernel;

import java.awt.image.Kernel;

public interface KernelMaker {
    void useDefault();
    Kernel make();
}
