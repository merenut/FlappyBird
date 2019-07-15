package Drawables;

import Base.Entity;
import java.awt.*;

public class Background extends Entity
{

    public Background(int x, int y, Image image)
    {
        this.x = x;
        this.y = y;
        this.image = image;
    }

    @Override
    public void draw(Graphics g)
    {
        g.drawImage(image, x, y, null);
        g.drawImage(image, x + image.getWidth(null), y, null);
    }

    @Override
    public void update()
    {
        if(x + image.getWidth(null) < 0)
        {
            x = 0;
        }
        x--;
    }

    public String toString()
    {
        return "Background ";
    }
}
