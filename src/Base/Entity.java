package Base;

import Interfaces.Drawable;
import Interfaces.Updatable;

import java.awt.*;

public abstract class Entity implements Drawable, Updatable
{
    public Image image;
    protected int x, y;

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    @Override
    public abstract void draw(Graphics g);

    @Override
    public abstract void update();

    public boolean collision(Entity e)
    {
        boolean collision = false;

        int x1, x2, x3, x4, y1, y2, y3, y4;
        x1 = e.getX();
        x2 = e.image.getWidth(null);
        y1 = e.getY();
        y2 = e.image.getHeight(null);

        x3 = getX();
        x4 = image.getWidth(null);
        y3 = getY();
        y4 = image.getHeight(null);

        if(x1 + x2 >= x3 &&
            x1 <= x3 + x4 &&
            y1 + y2 >= y3 &&
            y1 <= y3 + y4)
        {
            collision = true;
        }


        return collision;
    }
}
