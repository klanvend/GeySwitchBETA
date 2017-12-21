import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

public class Dikdortgen implements Serializable{
	Rectangle r;
	transient BufferedImage gorsel;
	int x,y,width,height;
	int hiz=1;
	public Dikdortgen(int x, int y, int width, int height) {
		super();
		r=new Rectangle(x,y,width,height);
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		ResimOku();
	}
	public void ResimOku()
	{
		try {
			gorsel=ImageIO.read(new File("C:\\Users\\klanvend\\Desktop\\mep\\gey-switch-platform.png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	public void ekranaCiz(Graphics g)
	{
		g.drawImage(gorsel,(int)r.getX(), (int)r.getY(), 
				(int)r.getWidth(), (int)r.getHeight(),null);
	}
	public void haraketEt()
	{
		r.setLocation((int)r.getX()-hiz,(int)r.getY());
	}
	public Rectangle getRectangle()
	{
		return r;
	}
	public int getX()
	{
		return (int) r.getX();
	}
}