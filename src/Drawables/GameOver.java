package Drawables;


import Interfaces.Drawable;
import Utilities.ImageUtils;

import java.awt.*;

public class GameOver implements Drawable
{

    public static Image image = ImageUtils.getImageFromStream("Resources/gameover.png");


    public void draw(Graphics g)
    {
        g.drawImage(image, 144-image.getWidth(null)/2, 50, null);
    }
}
