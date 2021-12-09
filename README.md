# simple-image-processor
Simple, Easy to use Java image processing utilities for common tasks like resizing, blurring.

[![Java CI with Maven](https://github.com/duiyou360/simple-image-processor/actions/workflows/maven.yml/badge.svg)](https://github.com/duiyou360/simple-image-processor/actions/workflows/maven.yml)

## Install

Use the lastest version from [Maven Central](https://search.maven.org/artifact/com.duiyou360/simple-image-processor)

## Image Resizing

```
BufferedImage sourceImage = .......; //load or create your own BufferedImage object
ImageResizer imageResizer = new JavaImageResizer();  //choose a resizer that implements ImageResizer

//resize source image within max width and max height, the aspect ratio will not be changed
BufferedImage resultImage2 = imageResizer.resizeWithin(sourceImage, 100,100);

//resize source image to target width and height and return the resized one (Caution: source image will be scaled to fit)
BufferedImage resultImage = imageResizer.resize(sourceImage, 100,200); 

```
### Resizers
- JavaImageResizer: pure java resizer without third party dependencies


## Image Filtering

```
BufferedImage sourceImage = .......; //load or create your own BufferedImage object
ImageFilter filter = new JavaImageFilter(); //choose a filter that implements ImageFilter
//blur image, choose a Kernal
Kernel customKernel = new GeneralKernelMaker().make(); //using custom kernel
BufferedImage resultImage = filter.blur(sourceImage, customKernel);

### Filters
- JavaImageFilter: pure java filter without third party dependencies

### operations
- blur: blur image using Kernel

### Kernels
- GeneralKernelMaker: kernel maker supporting custom matrix (a default 3*3 will be used if not provided)
- EmbossKernelMaker: used for embossing an image

```

