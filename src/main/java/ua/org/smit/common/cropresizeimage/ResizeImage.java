package ua.org.smit.common.cropresizeimage;

import com.mortennobel.imagescaling.ResampleFilters;
import com.mortennobel.imagescaling.ResampleOp;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class ResizeImage {

    public BufferedImage resize(BufferedImage image, int maxWidth, int maxHeight) {

        ImageSizeConsider newImageSize = new ImageSizeConsider(
                image.getWidth(),
                image.getHeight(),
                maxWidth,
                maxHeight);

        return createResizedImg(image, newImageSize.getImgSize());
    }

    public BufferedImage cropAndResizeToSquare(BufferedImage image, int indent, int sideSize) {
        if (indent < 0 || indent > 10) {
            throw new IllegalArgumentException("Indent from top side of image must be '>0' and '<=10'!");
        }

        SquareCrop thumbnailPropperties = new SquareCrop(indent, sideSize);
        SquareCropProperties params = thumbnailPropperties.getParams(image.getWidth(), image.getHeight());

        BufferedImage croppedImage = getBufferedResizedImg(image, params, true);

        return resize(croppedImage, sideSize, sideSize);
    }

    private BufferedImage createResizedImg(BufferedImage imageToScale, Resolution imgSize) {
        ResampleOp resizeOp = new ResampleOp(imgSize.getWidth(), imgSize.getHeight());
        resizeOp.setFilter(ResampleFilters.getLanczos3Filter());
        BufferedImage scaledImage = resizeOp.filter(imageToScale, null);
        return scaledImage;
    }

    private BufferedImage getBufferedResizedImg(
            BufferedImage buffImg,
            SquareCropProperties params,
            boolean crop) {
        final BufferedImage bufferedImage = new BufferedImage(params.newWidth, params.newHeight, BufferedImage.TYPE_INT_RGB);
        final Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setComposite(AlphaComposite.Src);
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (crop) {
            graphics2D.drawImage(buffImg, params.widthCropPoint, params.heightCropPoint, buffImg.getWidth(), buffImg.getHeight(), null);
        } else {
            graphics2D.drawImage(buffImg, params.widthCropPoint, params.heightCropPoint, params.newWidth, params.newHeight, null);
        }
        graphics2D.dispose();

        return bufferedImage;
    }
}
