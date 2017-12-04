import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.Serializable;

public class Dikdortgen implements Serializable{
	Rectangle r;
	int x,y,width,height;
	int hiz=3;
	public Dikdortgen(int x, int y, int width, int height) {
		super();
		r=new Rectangle(x,y,width,height);
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}
	public void ekranaCiz(Graphics g)
	{
		g.fillRect((int)r.getX(), (int)r.getY(), 
				(int)r.getWidth(), (int)r.getHeight());
	}
	public void haraketEt()
	{
		r.setLocation((int)r.getX()-hiz,(int)r.getY());
	}
	public Rectangle getRectangle()
	{
		return r;
	}
}
