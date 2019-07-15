import Drawables.Background;
import Drawables.Base;
import Game_Engine.GameEngine;
import Interfaces.Drawable;
import Interfaces.Updatable;
import Utilities.ImageUtils;
import Window.Window;
import Drawables.Bird;
import Drawables.Pipe;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] e)
    {
        GameEngine gameEngine = new GameEngine();
        ArrayList<Pipe> pipes = new ArrayList<Pipe>();

        Background background = new Background(0 ,0, ImageUtils.getImageFromStream("Resources/background-day.png"));
        Base base = new Base(ImageUtils.getImageFromStream("Resources/base.png"), 0, 400);
        Bird bird = new Bird(ImageUtils.getImageFromStream("Resources/bluebird-midflap.png"), 144, 256);

        for(int i = 0; i < 3; i++)
        {
            pipes.add(new Pipe(ImageUtils.getImageFromStream("Resources/pipe-green.png"), 288 + Pipe.hor * i));
        }


        gameEngine.addEntity(background);

        for(Pipe p : pipes)
        {
            gameEngine.addEntity(p);
        }

        gameEngine.addEntity(base);
        gameEngine.addEntity(bird);


        gameEngine.run();
    }
}
