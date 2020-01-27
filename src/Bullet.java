import java.awt.*;

public class Bullet  {

    int x,y;
    final int WIDTH =10, HEIGHT = 13;
    double speed, dx, dy = 5;
    boolean remove;

    public Bullet(Player player){
        x = player.getX() + (player.getWIDTH()/2) - WIDTH/2;
        y = player.getY() - HEIGHT;
    }

    public void move(){
        y-=dy;
    }

    public Rectangle getBounds(){
        return new Rectangle(x,y,WIDTH, HEIGHT);
    }

    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillOval(x,y,WIDTH, HEIGHT);
    }

    public int getY() {
        return y;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public boolean getRemove() {
        return remove;
    }

    public void setRemove() {
        remove = true;
    }
}
