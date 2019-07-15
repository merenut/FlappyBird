package Window;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

import Base.Entity;
import Drawables.GameOver;
import Interfaces.Drawable;
import Interfaces.Updatable;

import java.util.ArrayList;

public class Window extends JFrame
{
    private Canvas canvas;
    private BufferStrategy buffer;

    private ArrayList<Updatable> updatables;
    private ArrayList<Drawable> drawables;

    public Window()
    {

        updatables = new ArrayList<Updatable>();
        drawables =  new ArrayList<Drawable>();

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(288, 512));

        add(canvas);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);

        this.setFocusable(true);
        if (this.requestFocus(true))
            System.out.println("true");

        //Buffer must be created after
        //Canvas is added to JFrame
        canvas.createBufferStrategy(2);
        buffer = canvas.getBufferStrategy();
    }

    public void draw()
    {
        Graphics g = buffer.getDrawGraphics();

        g.setColor(Color.BLACK);
        for(Drawable d : drawables)
        {
            d.draw(g);
        }

        if(gameOver == true)
        {
            GameOver gameO = new GameOver();
            gameO.draw(g);
        }

        if(!buffer.contentsLost())
        {
            buffer.show();
        }
        if(g != null)
        {
            g.dispose();
        }
    }

    public void update()
    {
        for(Updatable u : updatables)
        {
            u.update();
        }
    }

    public Canvas getCanvas()
    {
        return canvas;
    }

    public void createCanvas()
    {
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(288, 512));
        canvas.createBufferStrategy(2);
        buffer = canvas.getBufferStrategy();
    }

    boolean gameOver = false;

    public void setGameOver()
    {
        gameOver = true;
    }

    public void addUpdatable(Updatable updatable)
    {
        updatables.add(updatable);
    }

    public void addDrawable(Drawable drawable)
    {
        drawables.add(drawable);
    }
}
