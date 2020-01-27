import java.awt.*;

public class Player {

    int x,y;
    final int WIDTH = 25, HEIGHT = 40;
    double speed, dx = 4, dy;

    public Player(Board board){

        x = board.getWidth()/2;
        y = board.getHeight() - (HEIGHT + 10);

    }

    public void moveRight(){
        x+=dx;
    }

    public void moveLeft(){
        x-=dx;
    }

    public void paint(Graphics g){
        g.setColor(Color.ORANGE);
        g.fillRect(x,y,WIDTH,HEIGHT);
    }

    public int getX() {
        return x;
    }

    public int getWIDTH(){
        return WIDTH;
    }

    public int getY() {
        return y;
    }
}
