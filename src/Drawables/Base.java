package Drawables;

import Base.Entity;

import java.awt.*;

public class Base extends Entity
{

    public Base(Image i, int x, int y)
    {
        this.image = i;
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g)
    {
        g.drawImage(image, x, y, null);
        g.drawImage(image, x + image.getWidth(null), y, null);
    }

    public void update()
    {
        //Move code goes here
        if(x + image.getWidth(null) < 0)
        {
            x = 0;
        }
        else
        {
            x--;
        }
    }

    public String toString()
    {
        return "Base";
    }
}
