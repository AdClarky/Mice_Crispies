public class Main {
    public static void main(String[] args) {
        GameArena arena = new GameArena(1000, 1000);
        Rectangle background = new Rectangle(0, 0, 1000, 1000, "WHITE");
        arena.addRectangle(background);

        Mice mice = new Mice(arena, 15);

        Battery battery = new Battery();
        battery.addTo(arena);

        Cat cat = new Cat(0, 0);
        cat.addTo(arena);
        
        Rectangle juiceBar = new Rectangle(900, 0, 100, 20, "RED");
        arena.addRectangle(juiceBar); 

        Text scoreText = new Text("Score: " + cat.getScore(), 22, 0, 22, "BLACK");        
        arena.addText(scoreText);

        while(true)
        {
            arena.pause();
            cat.update();
            juiceBar.setXPosition(1000 - cat.getJuice());
            if(mice.checkCollision(cat.getXPosition(), cat.getYPosition(), 80))
            {
                cat.scored();
                scoreText.setText("Score: " + cat.getScore());
            }
            if(cat.hitbox.collides(battery.hitbox))
            {
                System.out.println("here");
                battery.captured();
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
