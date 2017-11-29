import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class PlayerCizici extends JPanel implements KeyListener,ActionListener{
	Rectangle d,c;
	Player[] p;
	Dikdortgen[] l;
	int oyuncusayisi;
	double oran=0.005;
	public PlayerCizici(Player[] g,int s) 
	{
	super();
	addKeyListener(this);
	Timer t1=new Timer(5,this);
	d=new Rectangle(0, 0,1600,50);
	c=new Rectangle(0,800,1600,50);
	l=new Dikdortgen[10];
	l[0]=new Dikdortgen(2500, 50,120, 320);
	diziKlonla(g);
	oyuncusayisi=s;
	t1.start();
	}
	public void diziKlonla(Player[] g)
	{
		p=new Player[g.length];
		for(int i=0;i<p.length;i++)
		{
			p[i]=g[i];
		}
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for(int i=0;i<oyuncusayisi;i++)
		{
			p[i].ekranaCiz(g);
			repaint();
		}
		g.setColor(Color.BLACK);
		g.fillRect((int)d.getX(), (int)d.getY(),(int)d.getWidth(),(int)d.getHeight());
		g.fillRect((int)c.getX(), (int)c.getY(),(int)c.getWidth(),(int)c.getHeight());
		l[0].ekranaCiz(g);
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<oyuncusayisi;i++)
		{
			p[i].hiz=(int)((800-p[i].getX())*oran);
			p[i].HaraketEt(l, p, oyuncusayisi, i, 1, p[i].getRectangle());
			p[i].GravityEffect(p,oyuncusayisi,i);
		}
		l[0].haraketEt();
	}
	@Override
	public void keyPressed(KeyEvent e) {
		for(int i=0;i<oyuncusayisi;i++) {
		if(e.getKeyCode()==p[i].tus)
			{p[i].Reverse();
			System.out.println("reverse");
			}
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
