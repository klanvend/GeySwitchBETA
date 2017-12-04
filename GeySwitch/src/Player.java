import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player {
	int x,y,width,height,a=0,b=0,tus;
	Rectangle r,d,c;
	int hiz=0,s=0;
	int gravitation=1;
	boolean engellen;
	boolean cakisma,cakisma1;
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
	public void GravityEffect(Player[] digerleri,Dikdortgen[] l,int dikdortgensayisi,int oyuncusayisi,int index) 
	{
		if(index%2==1&&b==0)
		{gravitation=Math.abs(gravitation)*-1;b++;}
		if(index%2==0&&b==0)
			{gravitation=Math.abs(gravitation);b++;}
		Rectangle gecici=new Rectangle(r);
		gecici.setLocation((int)r.getX(),(int)r.getY()+gravitation);
		cakisma1=false;
		for(int i=0;i<oyuncusayisi;i++)
		{
			if(i!=index) 
			{
				if(gecici.intersects(digerleri[i].getRectangle()))
			
				{
				cakisma1=true;	
				}
		}
		for(int i1=0;i1<dikdortgensayisi;i1++) 
		{
			if (gecici.intersects(l[i1].getRectangle())) 	
			{
				cakisma1 = true;
			}	
		}
		}
		if(cakisma1==false)
		{r.setLocation((int)r.getX(),(int)r.getY()+gravitation);}
	}
	public void HaraketEt(Dikdortgen[] digerleri,Player[] p,int oyuncusayisi,int index,int dikdortgensayisi,Rectangle r)
	{
		Rectangle gecici=new Rectangle(r);
		gecici.setLocation((int)r.getX()+hiz,(int)r.getY());
		engellen=false;
		for(int i=0;i<dikdortgensayisi;i++)
		{
			if(gecici.intersects(digerleri[i].getRectangle())) 
			{engellen=true;}
			if(engellen==true)
			{r.setLocation((int)r.getX()-digerleri[i].hiz,(int)r.getY());}
		}
		cakisma=false;
		for(int i=0;i<oyuncusayisi;i++)
		{
			if(i!=index) 
			{
			if(gecici.intersects(p[i].getRectangle()))
			{cakisma=true;System.out.println("cakisma");}
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
		if(engellen==true||cakisma1==true) 
		{
		gravitation=gravitation*-1;
		System.out.println("reverse");
		}
	}
	public int getX()
	{
		return (int)r.getX();
	}
	public int getY()
	{
		return (int)r.getY();
	}
	public void kill()
	{
		r.setBounds(0,0,0,0);
	}
}
