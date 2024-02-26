import javax.swing.JFrame;

public class Level{
    private GameArena arena = new GameArena(1000, 1050);
    private Background background = new Background();
    private Mice mice = new Mice(arena, 15);
    private Bullets bullets;
    private Battery battery = new Battery();
    private Cat cat = new Cat(0, 0);
    private Rectangle juiceBar = new Rectangle(750, 0, 250, 25, "RED", 1);
    private Rectangle juiceBarBackground = new Rectangle(750, 0, 250, 25, "WHITE", 0);
    private Text scoreText = new Text("Score: " + cat.getScore(), 44, 0, 44, "WHITE", 1);        

    public Level(String levelName, int numBullets, int bulletSize) {
        arena.setName(levelName);
        arena.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        background.addTo(arena);
        bullets = new Bullets(arena, numBullets, bulletSize);
        battery.addTo(arena);
        cat.addTo(arena);
        arena.addRectangle(juiceBar);
        arena.addRectangle(juiceBarBackground); 
        arena.addText(scoreText);
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

    public void endGame()
    {
        arena.exit();
    }
}