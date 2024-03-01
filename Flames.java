public class Flames extends GameObject{
    public Flames(double x, double y)
    {
        super(x, y);
        rectangles = new Rectangle[12];

        rectangles[0] = new Rectangle(x+30, y+80, 20, 10, "WHITE", 10);
        rectangles[1] = new Rectangle(x+20, y+80, 10, 10, "YELLOW", 10);
        rectangles[2] = new Rectangle(x+50, y+80, 10, 10, "YELLOW", 10);
        rectangles[3] = new Rectangle(x+30, y+90, 20, 10, "YELLOW", 10);
        rectangles[4] = new Rectangle(x+20, y+90, 10, 20, "ORANGE", 10);
        rectangles[5] = new Rectangle(x+30, y+100, 20, 10, "ORANGE", 10);
        rectangles[6] = new Rectangle(x+50, y+90, 10, 10, "ORANGE", 10);
        rectangles[7] = new Rectangle(x+20, y+100, 10, 20, "RED", 10);
        rectangles[8] = new Rectangle(x+30, y+110, 30, 10, "RED", 10);
        rectangles[9] = new Rectangle(x+50, y+100, 10, 20, "RED", 10);
        rectangles[10] = new Rectangle(x+10, y+70, 10, 30, "RED", 10);
        rectangles[11] = new Rectangle(x+60, y+70, 10, 40, "RED", 10);

    }
}
