package GameData;
import GameObjects.Background;
import GameObjects.Mice;
import GameObjects.Bullets;
import GameObjects.Battery;
import GameObjects.Cat;
import GameArena.GameArena;
import GameArena.Rectangle;
import GameArena.Text;
import javax.swing.JFrame;
import static GameData.GameSettings.WINDOW_SIZE;
import static GameData.GameSettings.HEADER_SIZE;
import static GameData.GameSettings.OBJ_SIZE;
import static GameData.GameSettings.CAT_SIZE;

public class Level{
    private final GameArena arena = new GameArena(WINDOW_SIZE, WINDOW_SIZE+HEADER_SIZE);
    private Background background = new Background();
    private final Mice mice;
    private final Bullets bullets;
    private final Battery battery = new Battery();
    private final Cat cat = new Cat(0, WINDOW_SIZE-CAT_SIZE);
    private final Rectangle juiceBar = new Rectangle(WINDOW_SIZE - ((double) WINDOW_SIZE /4), 0, (double) WINDOW_SIZE /4, 25, "RED", 1);
    private Rectangle juiceBarBackground = new Rectangle(WINDOW_SIZE - ((double) WINDOW_SIZE /4), 0, (double) WINDOW_SIZE /4, 25, "WHITE", 0);
    private final Text scoreText = new Text("Score: " + cat.getScore(), 44, 0, 44, "WHITE", 1);
    private boolean haveWon = false;
    public Level(String levelName, int numBullets, int bulletSize, double bulletSpeed, int miceCount) {
        arena.setName(levelName);
        arena.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        background.addTo(arena);
        mice = new Mice(arena, miceCount);
        bullets = new Bullets(arena, numBullets, bulletSize);
        battery.addTo(arena);
        cat.addTo(arena);
        arena.addRectangle(juiceBar);
        arena.addRectangle(juiceBarBackground);
        arena.addText(scoreText);
    }

    public void won(){
        haveWon = true;
        Text wonText = new Text("YOU WIN!", 100, 250, 500, "BLACK", 11);
        arena.addText(wonText);
    }

    public void runLevel()
    {
        while(true)
        {
            arena.pause();
            cat.update();
            bullets.updateBullets();
            juiceBar.setXPosition(WINDOW_SIZE - ((cat.getJuice()/100) * WINDOW_SIZE/4));
            if(mice.checkCollision(cat.hitbox))
            {
                cat.scored();
                bullets.increaseBulletSpeed(2);
                scoreText.setText("Score: " + cat.getScore());
                if(cat.getScore() == mice.getMouseCount())
                {
                    won();
                    break;
                }
            }
            if(cat.hitbox.collides(battery.hitbox))
            {
                battery.captured();
                cat.batteryCaptured();
            }
            // inputs 
            if(arena.letterPressed('d'))
            {
                cat.horizontalInput(1);
            }else if(arena.letterPressed('a'))
            {
                cat.horizontalInput(-1);
            }
            if(arena.letterPressed('w'))
            {
                cat.flameOn();
                cat.verticalInput();
            }else{
                cat.flameOff();
            }
            if(bullets.checkCollision(cat.hitbox)) // if hit by bullet
            {
                cat.died();
                break;
            }
        }
    }

    public void setMousePositions(int[][] positions)
    {
        if(positions.length != mice.getMouseCount())
            return;
        mice.setMousePositions(positions);
    }

    public boolean endGame()
    {
        arena.exit();
        return haveWon;
    }
}