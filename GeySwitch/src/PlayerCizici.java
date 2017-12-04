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
	public PlayerCizici(Player[] g,int s) 
	{
	super();
	addKeyListener(this);
	Timer t1=new Timer(15,this);
	d=new Rectangle(0, 0,1600,50);
	c=new Rectangle(0,800,1600,50);
	l=new Dikdortgen[50];
	dOku();
	System.out.println(dmevcut);
	dTasi();
	diziKlonla(g);
	oyuncusayisi=s;
	t1.start();
	}
	public void dTasi()
	{
		for(int i=0;i<dmevcut;i++)
		{
			l[i].getRectangle().setLocation((int) (l[i].getRectangle().getX()+2000),(int) (l[i].getRectangle().getY()));
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
			iStream=new ObjectInputStream(new FileInputStream("C:\\Users\\PC\\Desktop\\map\\dikdortgen.data"));
			iStreamS=new ObjectInputStream(new FileInputStream("C:\\Users\\PC\\Desktop\\map\\dikdortgenS.data"));
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
			p[i].ekranaCiz(g);
		}
		for(int i=0;i<dmevcut;i++)
		{
			l[i].ekranaCiz(g);
		}
	}	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<oyuncusayisi;i++)
		{
			p[i].hiz=(int)((1200-p[i].getX())*oran);
			p[i].HaraketEt(l, p, oyuncusayisi, i, dmevcut, p[i].getRectangle());
			p[i].GravityEffect(p,l,dmevcut,oyuncusayisi,i);
			if(p[i].getX()+p[i].width<-50||p[i].getY()+p[i].height<-50)
			{p[i].kill();}
			repaint();
		}
		for(int i=0;i<dmevcut;i++)
		{
			l[i].haraketEt();
			repaint();
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		for(int i=0;i<oyuncusayisi;i++) {
		if(e.getKeyCode()==p[i].tus)
			{p[i].Reverse();}
		}
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
