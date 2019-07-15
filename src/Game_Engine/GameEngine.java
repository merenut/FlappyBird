package Game_Engine;

import Base.Entity;
import Drawables.Background;
import Drawables.Bird;
import Interfaces.Keyable;
import Utilities.ThreadUtils;
import Window.Window;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class GameEngine implements KeyListener
{
    private Window window;
    private boolean running = false;
    private ArrayList<Entity> entity;

    public GameEngine()
    {
        this(new Window());
    }

    public GameEngine(Window window)
    {
        this.window = window;
        this.window.addKeyListener(this);
        entity = new ArrayList<Entity>();
    }

    public void run()
    {
        if(running)
        {
            return;
        }
        running = true;

        while(running)
        {
            draw();
            update();
            ThreadUtils.sleep(20);
        }
    }

    public void draw()
    {
        window.draw();
    }

    public void update()
    {
        window.update();

        for(Entity ent1: entity)
        {
            for(Entity ent2: entity)
            {
                if(!(ent1 instanceof Background || ent1 instanceof Bird) && ent2 instanceof Bird)
                {
                    if(ent1.collision(ent2))
                    {
                       window.setGameOver();
                    }
                }
            }
        }
    }

    public void addEntity(Entity entity) {
        window.addDrawable(entity);
        window.addUpdatable(entity);
        this.entity.add(entity);
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
    }

    @Override
    public void keyPressed(KeyEvent en)
    {
        for(Entity e : entity)
        {
            if(e instanceof Keyable)
            {
                ((Keyable) e).keyTyped(en);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
    }
}
