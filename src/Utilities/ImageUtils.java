package Utilities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageUtils
{
    private ImageUtils(){}

    public static Image getImageFromStream(String filename)
    {

        System.out.println(filename);
        Image i = null;

        try {
            i = ImageIO.read(ImageUtils.class.getClassLoader().getResourceAsStream(filename));
        }catch(IOException e){
            e.printStackTrace();
        }

        return i;
    }

    public static Image rotateImage(Image i, float degrees)
    {
        double rotationRequired = Math.toRadians (degrees);
        double locationX = i.getWidth(null) / 2;
        double locationY = i.getHeight(null) / 2;
        AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

        BufferedImage bi = op.filter((BufferedImage)i, null);

        return bi;
    }

    public static Image scaleImage(Image i, float yScale, float xscale)
    {
        BufferedImage bi = (BufferedImage)i;

        int w = (int) (i.getWidth(null) * xscale);
        int h = (int) (i.getHeight(null) * yScale);

        return bi.getScaledInstance(w, h, Image.SCALE_DEFAULT );
    }
}
