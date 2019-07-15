package Drawables;

import Base.Entity;
import Utilities.ImageUtils;
import java.util.Random;

import java.awt.*;

public class Pipe extends Entity
{
    private Image upsideDownPipe;
    public static final int vert = 75, hor = 288/ 3 + 52 ;
    private int random;

    public Pipe(Image image, int x)
    {
        this.x = x;
        this.image = image;
        upsideDownPipe = ImageUtils.rotateImage(image, 180);

       randomGen(this);
    }

    @Override
    public void draw(Graphics g)
    {
        g.drawImage(image, x, y, null);
        g.drawImage(upsideDownPipe, x, y - vert - image.getHeight(null), null);
    }

    @Override
    public void update()
    {
        if(x + hor <= 0)
        {
            x = 288;
            randomGen(this);
        }
        else
        {
            x--;
        }
    }

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

        x3 = getX();
        x4 = image.getWidth(null);
        y3 = y - vert - image.getHeight(null);
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

    private void randomGen(Pipe p)
    {
        Random rand = new Random();
        random = image.getHeight(null) / 2;
        rand.setSeed(System.currentTimeMillis());
        p.y = image.getHeight(null) - rand.nextInt(random);
    }

    public String toString()
    {
        return "Pipe";
    }
}
