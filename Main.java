public class Main {
    public static void main(String[] args) {
        GameArena arena = new GameArena(1000, 1000);
        // Rectangle background = new Rectangle(0, 0, 1000, 1000, "WHITE", 1);
        // arena.addRectangle(background);
        Background background = new Background();
        background.addTo(arena);

        Mice mice = new Mice(arena, 15);

        Bullets bullets = new Bullets(arena, 15);

        Battery battery = new Battery();
        battery.addTo(arena);

        Cat cat = new Cat(0, 0);
        cat.addTo(arena);
        
        Rectangle juiceBar = new Rectangle(900, 0, 100, 20, "RED", 1);
        arena.addRectangle(juiceBar); 

        Text scoreText = new Text("Score: " + cat.getScore(), 22, 0, 22, "BLACK", 1);        
        arena.addText(scoreText);

        while(true)
        {
            arena.pause();
            cat.update();
            bullets.updateBullets();
            juiceBar.setXPosition(1000 - cat.getJuice());
            if(mice.checkCollision(cat.hitbox))
            {
                cat.scored();
                scoreText.setText("Score: " + cat.getScore());
            }
            if(cat.hitbox.collides(battery.hitbox))
            {
                battery.captured();
                cat.batteryCaptured();
            }
            if(bullets.checkCollision(cat.hitbox)) // if hit by bullet
            {
                System.out.println("cat died");
                cat.died();
                break;
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
        }

    }
}
