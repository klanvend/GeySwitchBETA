import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JPanel;
import javax.swing.Timer;

public class PlayerCizici extends JPanel implements KeyListener,ActionListener{
	Rectangle d,c;
	Player[] p;
	Dikdortgen[] l;
	ObjectInputStream iStream,iStreamS;
	int oyuncusayisi;
	double oran=0.002;
	int dmevcut;
	Timer t1;
	private int j=0;
	public PlayerCizici(Player[] g,int s) 
	{
	super();
	addKeyListener(this);
	t1=new Timer(10,this);
	d=new Rectangle(0, 0,1600,50);
	c=new Rectangle(0,800,1600,50);
	l=new Dikdortgen[50];
	dOku();
	dHiz();
	dTasi();
	System.out.println(dmevcut);
	diziKlonla(g);
	oyuncusayisi=s;
	
	}
	public void dHiz()
	{
		for(int i=0;i<dmevcut;i++)
		{
			l[i].hiz=5;
		}
	}
	public void dTasi()
	{
		for(int i=0;i<dmevcut;i++)
		{
			l[i].getRectangle().setLocation((int) (l[i].getRectangle().getX()-220),(int) (l[i].getRectangle().getY()));
		}
	}
	public void diziKlonla(Player[] g)
	{
		p=new Player[g.length];
		for(int i=0;i<p.length;i++)
		{
			p[i]=g[i];
		}
	}
	public void dOku()
	{
		try 
		{
			iStream=new ObjectInputStream(new FileInputStream("C:\\Users\\klanvend\\Desktop\\mep\\dikdortgen.data"));
			iStreamS=new ObjectInputStream(new FileInputStream("C:\\Users\\klanvend\\Desktop\\mep\\dikdortgenS.data"));
			Object okunan=iStream.readObject();
			l =(Dikdortgen[])okunan;
			dmevcut=(int)iStreamS.readInt();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for(int i=0;i<oyuncusayisi;i++)
		{
			g.setColor(p[i].renk);
			p[i].ekranaCiz(g);
		}
		g.setColor(Color.BLACK);
		for(int i=0;i<dmevcut;i++)
		{
			l[i].ekranaCiz(g);
		}
	}	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<oyuncusayisi;i++)
		{
			if(p[i].getX()<100) p[i].hiz=5; 
			else if(p[i].getX()<200) p[i].hiz=4;
			else if(p[i].getX()<400) p[i].hiz=3;
			else if(p[i].getX()<600) p[i].hiz=2;
			else if(p[i].getX()<1400) p[i].hiz=1;
			else p[i].hiz=0;
			p[i].HaraketEt(l, p, oyuncusayisi, i, dmevcut, p[i].getRectangle());
			p[i].GravityEffect(p,l,dmevcut,oyuncusayisi,i);
			if(p[i].getX()+p[i].width<-50||p[i].getY()+p[i].height<-50||p[i].getY()+p[i].height>950)
			{p[i].kill();}
			repaint();
		}
		for(int i=0;i<dmevcut;i++)
		{
			l[i].haraketEt();
			repaint();
		}
		for(int i=0;i<oyuncusayisi;i++)
		{
			if(p[i].hayat==false)
			j++;
		}
		if(j==oyuncusayisi)
		{
			t1.stop();
		}
		else j=0;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		for(int i=0;i<oyuncusayisi;i++) {
		if(e.getKeyCode()==p[i].tus)
			{p[i].Reverse();}
		}
		if(e.getKeyCode()==e.VK_ENTER)
			t1.start();
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}