import javax.swing.JFrame;

public class Level{
    private GameArena arena = new GameArena(1000, 1050);
    private Background background = new Background();
    private Mice mice;
    private Bullets bullets;
    private Battery battery = new Battery(10);
    private Cat cat = new Cat(0, 950, 10);
    private Rectangle juiceBar = new Rectangle(750, 0, 250, 25, "RED", 1);
    private Rectangle juiceBarBackground = new Rectangle(750, 0, 250, 25, "WHITE", 0);
    private Text scoreText = new Text("Score: " + cat.getScore(), 44, 0, 44, "WHITE", 1); 
    private Text levelText;
    private boolean haveWon = false;    

    public Level(String levelName, int numBullets, int bulletSize, double bulletSpeed, int miceCount) {
        arena.setName(levelName);
        arena.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        background.addTo(arena);
        mice = new Mice(arena, miceCount);
        bullets = new Bullets(arena, numBullets, bulletSize);
        bullets.increaseBulletSpeed(bulletSpeed+1);
        battery.addTo(arena);
        cat.addTo(arena);
        arena.addRectangle(juiceBar);
        arena.addRectangle(juiceBarBackground); 
        arena.addText(scoreText);
        levelText = new Text(levelName, 44, 400, 44, "WHITE");
        arena.addText(levelText);
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
            juiceBar.setXPosition(1000 - cat.getJuice() * 2.5);
            if(mice.checkCollision(cat.hitbox))
            {
                cat.scored();
                bullets.increaseBulletSpeed(0.2);
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
                System.out.println("cat died");
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