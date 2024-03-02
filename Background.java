public class Background {
    private final static int sizeOfRects = 50;
    private Rectangle[] rectangles = new Rectangle[(1000/sizeOfRects)*(1000/sizeOfRects)];
    private static final String colour1 = "WHITE";
    private static final String colour2 = "GREY";
    

    public Background()
    {
        String lastStartignColour = colour2;
        String nextColour;
        int count = 0;
        for(int i = 0; i < 1000/sizeOfRects; i++)
        {
            if(lastStartignColour.equals(colour2))
            {
                lastStartignColour = colour1;
                nextColour = colour2;
            }else{
                lastStartignColour = colour2;
                nextColour = colour1;
            }
            for(int j = 0; j < 1000/sizeOfRects; j++)
            {
                if(nextColour.equals(colour1)){
                    nextColour = colour2;
                }
                else{
                    nextColour = colour1;
                }

                rectangles[count] = new Rectangle(j*sizeOfRects, (i*sizeOfRects)+50, sizeOfRects, sizeOfRects, nextColour, 1);
                count++;
            }
        }
    }

    public void addTo(GameArena gameArena)
    {
        for (Rectangle rectangle : rectangles) {
            gameArena.addRectangle(rectangle);
        }
    }
}
