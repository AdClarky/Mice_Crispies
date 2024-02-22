public class Main {
    public static void main(String[] args) {
        GameArena arena = new GameArena(1000, 1000);
        Rectangle background = new Rectangle(0, 0, 1000, 1000, "WHITE");
        arena.addRectangle(background);

        int score = 0;
        Text scoreText = new Text("Score: " + score, 22, 0, 22, "BLACK");        
        arena.addText(scoreText);

        Mice mice = new Mice(arena, 15);

        Cat cat = new Cat(0, 0);
        cat.addTo(arena);
        
        Rectangle juiceBar = new Rectangle(900, 0, 100, 20, "RED");
        arena.addRectangle(juiceBar); 

        while(true)
        {
            arena.pause();
            cat.update();
            juiceBar.setXPosition(1000 - cat.getJuice());
            if(mice.checkCollision(cat.getXPosition(), cat.getYPosition(), 80))
            {
                score++;
                scoreText.setText("Score: " + score);
            }
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
