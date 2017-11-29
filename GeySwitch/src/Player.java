import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player {
	int x,y,width,height,a=0,b=0,tus;
	Rectangle r,d,c;
	int hiz=0;
	int gravitation=1;

	public Player(int tus,int x, int y, int width, int height) {
			r=new Rectangle(x,y,width,height);
			this.tus=tus;
			d=new Rectangle(0, 0,1600,50);
			c=new Rectangle(0,800,1600,50);
	}

	public void ekranaCiz(Graphics g)
	{
			g.drawRect((int)r.getX(), (int)r.getY(), 
				(int)r.getWidth(), (int)r.getHeight());
			
	}
	public void GravityEffect(Player[] digerleri,int oyuncusayisi,int index) 
	{
		if(index%2==1&&b==0)
		{gravitation=Math.abs(gravitation)*-1;b++;}
		if(index%2==0&&b==0)
			{gravitation=Math.abs(gravitation);b++;}
		Rectangle gecici=new Rectangle(r);
		gecici.setLocation((int)r.getX(),(int)r.getY()+gravitation);
		boolean cakisma=false;
		for(int i=0;i<oyuncusayisi;i++)
		{
			if(i!=index) {
			if(gecici.intersects(digerleri[i].getRectangle())||gecici.intersects(c)||gecici.intersects(d))
			{cakisma=true;}
			}
		}
		if(cakisma==false)
		{r.setLocation((int)r.getX(),(int)r.getY()+gravitation);}
	}
	public void HaraketEt(Dikdortgen[] digerleri,Player[] p,int oyuncusayisi,int index,int dikdortgensayisi,Rectangle r)
	{
		Rectangle gecici=new Rectangle(r);
		gecici.setLocation((int)r.getX()+hiz,(int)r.getY());
		boolean engellen=false;
		for(int i=0;i<dikdortgensayisi;i++)
		{
			if(gecici.intersects(digerleri[i].getRectangle())) 
			{engellen=true;System.out.println("engellen");}
			if(engellen==true)
			{r.setLocation((int)r.getX()-digerleri[i].hiz,(int)r.getY());}
		}
		boolean cakisma=false;
		for(int i=0;i<oyuncusayisi;i++)
		{
			if(i!=index) {
			if(gecici.intersects(p[i].getRectangle()))
			{cakisma=true;}
			}
		}
			if(engellen==false&&cakisma==false)
			{r.setLocation((int)r.getX()+hiz,(int)r.getY());}
	}
	public Rectangle getRectangle()
	{
		return r;
	}
	public void Reverse() 
	{
		gravitation=gravitation*-1;
	}
	public int getX()
	{
		return (int)r.getX();
	}
}
