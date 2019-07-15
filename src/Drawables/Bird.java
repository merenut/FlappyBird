package Drawables;

import Base.Entity;
import Interfaces.Keyable;

import java.awt.*;
import java.awt.event.*;

public class Bird extends Entity implements Keyable
{
    private float dir = 0.4f, acc = 1, vel = 0;

    public Bird(Image image, int x, int y)
    {
        this.x = x;
        this.y = y;
        this.image = image;
    }

    @Override
    public void draw(Graphics g)
    {
        g.drawImage(image, x, y, null);
    }

    @Override
    public void update()
    {
        y += vel;
        vel += acc*dir;

        if(y > 500)
            y = 500;

        if (y < 20)
            y =20;
    }

    public void keyTyped(KeyEvent e)
    {
        int lul = e.getKeyCode();

        switch(lul)
        {
            case KeyEvent.VK_SPACE:
                vel = -4;
        }
    }

    public String toString()
    {
        return "Bird";
    }
}
