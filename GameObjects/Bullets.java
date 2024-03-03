package GameObjects;
import java.util.Random;
import GameArena.Rectangle;
import GameArena.GameArena;

public class Bullets {
    private final Bullet[] bullets;
    private double bullet_velocity = -1;

    public Bullets(GameArena gameArena, int numBullets, int scaleMultiplier)
    {
        bullets = new Bullet[numBullets];
        for(int i = 0; i < numBullets; i++)
        {
            bullets[i] = new Bullet(1000, 1000, scaleMultiplier);
            resetBullet(bullets[i]);
            bullets[i].addTo(gameArena);
        }
    }

    public void updateBullets()
    {
        for (Bullet bullet : bullets)
        {
            bullet.move(bullet_velocity, 0);
            if(bullet.getXPosition() + (bullet.getSize()*7) < 0)
            {
                resetBullet(bullet);
            }
        }
    }

    private void resetBullet(Bullet bullet)
    {
        Random rand = new Random();
        double y = rand.nextDouble(950-(bullet.getSize()*6));
        double x = rand.nextDouble(2000);
        bullet.setPosition(x+1000, y+50);
    }

    public void increaseBulletSpeed(double dx)
    {
        bullet_velocity -= dx;
    }

    public boolean checkCollision(Rectangle hitbox)
    {
        for(Bullet bullet : bullets){
            if(bullet.checkCollision(hitbox))
            {
                System.out.println("game over");
                return true;
            }
        }
        return false;
    }
}
