import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JPanel implements KeyListener,ActionListener{

	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,play,cancel;
	JLabel l1;
	Player[] p;
	int dinle=0;
	int a=0,start=0;
	public int oyuncusayisi;
	int harf;
	String b8t,b9t,b10t,b11t,b12t,b13t,b14t;
	int t;
	public Menu() 
	{
		super();
		oyuncusayisi=7;
		this.setFocusable(true);
		this.setBackground(Color.DARK_GRAY);
		/*l1=new JLabel("Yeni tusa basiniz."); 
		l1.setVisible(false);
		l1.setLocation(800,450);
		l1.setBackground(Color.WHITE);
		l1.setFont(new Font("Serif", Font.PLAIN, 14));
		l1.setForeground(Color.GREEN);*/
		cancel=new JButton("Iptal");
		cancel.setBounds(300,450,80,80);
		cancel.setVisible(false);
		b2=new JButton("2");
		b2.setBackground(Color.WHITE);
		b3=new JButton("3");
		b3.setBackground(Color.GREEN);
		b4=new JButton("4");
		b4.setBackground(Color.RED);
		b5=new JButton("5");
		b5.setBackground(Color.CYAN);
		b6=new JButton("6");
		b6.setBackground(Color.MAGENTA);
		b7=new JButton("7");
		b7.setBackground(Color.YELLOW);
		b8=new JButton("C");
		b9=new JButton("M");
		b10=new JButton("CTRL");
		b11=new JButton("RIGHT");
		b12=new JButton("A");
		b13=new JButton("Num 3");
		b14=new JButton("L");
		b2.setBounds(300, 100, 120, 120);
		b3.setBounds(500, 100, 120, 120);
		b4.setBounds(700, 100, 120, 120);
		b5.setBounds(900, 100, 120, 120);
		b6.setBounds(1100, 100, 120, 120);
		b7.setBounds(1300, 100, 120, 120);
		b8.setBounds(120,700,80,80);
		b9.setBounds(320,700,80,80);
		b10.setBounds(520,700,80,80);
		b11.setBounds(720,700,80,80);
		b12.setBounds(920,700,80,80);
		b13.setBounds(1120,700,80,80);
		b14.setBounds(1320,700,80,80);
		this.setLayout(null);
		play=new JButton("OYNA");
		play.setBounds(1450,710,100,100);
		b10.setVisible(false);
		b11.setVisible(false);
		b12.setVisible(false);
		b13.setVisible(false);
		b14.setVisible(false);		
		cancel.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b10.addActionListener(this);
		b11.addActionListener(this);
		b12.addActionListener(this);
		b13.addActionListener(this);
		b14.addActionListener(this);
		play.addActionListener(this);
		b2.setFocusable(false);
		b3.setFocusable(false);
		b4.setFocusable(false);
		b5.setFocusable(false);
		b6.setFocusable(false);
		b7.setFocusable(false);
		b8.setFocusable(false);
		b9.setFocusable(false);
		b10.setFocusable(false);
		b11.setFocusable(false);
		b12.setFocusable(false);
		b13.setFocusable(false);
		b14.setFocusable(false);
		add(cancel);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		add(b7);
		add(b8);
		add(b9);
		add(b10);
		add(b11);
		add(b12);
		add(b13);
		add(b14);
		add(play);
		oyuncuYarat();
		//add(l1);
		addKeyListener(this);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
	}
	public void oyuncuYarat()
	{
		p=new Player[oyuncusayisi];
		for(int i=0;i<oyuncusayisi;i++)
		{
			if (i==0) {t = 67; }
			if (i==1) {t = 77; }
			if (i==2) {t = 17; }
			if (i==3) {t = 39; }
			if (i==4) {t = 65; }
			if (i==5) {t = 99; }
			if (i==6) {t = 76; }
			p[i]=new Player(t,20,(75+100*i),50,50);
		}
		oyuncusayisi=2;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		b8t=b8.getText();
		b9t=b9.getText();
		b10t=b10.getText();
		b11t=b11.getText();
		b12t=b12.getText();
		b13t=b13.getText();
		b14t=b14.getText();
		if(e.getActionCommand()=="Iptal") // Iptal Butonu
		{
		cancel.setVisible(false);
		dinle=0;
		}
		if(e.getActionCommand().equals(play.getText()))
		{
			start=1;
		}
		if(e.getActionCommand().equals(b8t))
		{
			// l1.setVisible(true);
			cancel.setVisible(true);
			dinle=1;
			a=1;
		}
		if(e.getActionCommand().equals(b9t))
		{
			// l1.setVisible(true);
			cancel.setVisible(true);
			dinle=1;
			a=2;
		}
		if(e.getActionCommand().equals(b10t))
		{
			// l1.setVisible(true);
			cancel.setVisible(true);
			dinle=1;
			a=3;
		}
		if(e.getActionCommand().equals(b11t))
		{
			// l1.setVisible(true);
			cancel.setVisible(true);
			dinle=1;
			a=4;
		}
		if(e.getActionCommand().equals(b12t))
		{
			// l1.setVisible(true);
			cancel.setVisible(true);
			dinle=1;
			a=5;
		}
		if(e.getActionCommand().equals(b13t))
		{
			// l1.setVisible(true);
			cancel.setVisible(true);
			dinle=1;
			a=6;
		}
		if(e.getActionCommand().equals(b14t))
		{
			// l1.setVisible(true);
			cancel.setVisible(true);
			dinle=1;
			a=7;
		}
		
		switch(e.getActionCommand()) //Oyuncu Sayisi Butonlari
		{
		case "2":
	
			b8.setVisible(true);
			b9.setVisible(true);
			b10.setVisible(false);
			b11.setVisible(false);
			b12.setVisible(false);
			b13.setVisible(false);
			b14.setVisible(false);
			oyuncusayisi=2;
			break;
		case "3":
		
			b8.setVisible(true);
			b9.setVisible(true);
			b10.setVisible(true);
			b11.setVisible(false);
			b12.setVisible(false);
			b13.setVisible(false);
			b14.setVisible(false);
			oyuncusayisi=3;
			break;
		case "4":
		
			b8.setVisible(true);
			b9.setVisible(true);
			b10.setVisible(true);
			b11.setVisible(true);
			b12.setVisible(false);
			b13.setVisible(false);
			b14.setVisible(false);
			oyuncusayisi=4;
			break;
		case "5":
		
			b8.setVisible(true);
			b9.setVisible(true);
			b10.setVisible(true);
			b11.setVisible(true);
			b12.setVisible(true);
			b13.setVisible(false);
			b14.setVisible(false);
			oyuncusayisi=5;
			break;
		case "6":
		
			b8.setVisible(true);
			b9.setVisible(true);
			b10.setVisible(true);
			b11.setVisible(true);
			b12.setVisible(true);
			b13.setVisible(true);
			b14.setVisible(false);
			oyuncusayisi=6;
			break;
		case "7":
		
			b8.setVisible(true);
			b9.setVisible(true);
			b10.setVisible(true);
			b11.setVisible(true);
			b12.setVisible(true);
			b13.setVisible(true);
			b14.setVisible(true);
			oyuncusayisi=7;
			break;
		}
		
	}
	public void diziKlonla(Player[] d)
	{
		d=new Player[p.length];
		for(int i=0;i<d.length;i++)
		{
			d[i]=p[i];
		}
	}
	@Override
	public void keyPressed(KeyEvent k) {
		System.out.println("key pressed");
			if (dinle==1) 
			{
				System.out.println("dinle girdi");
				switch (a) 
				{
				
				case 1: 
					harf=k.getKeyCode();
					p[0].tus =harf;
					cancel.setVisible(false);
					b8.setText(k.getKeyText(harf));
					dinle=0;
					break;		
				case 2: 
					harf=k.getKeyCode();
					p[1].tus =harf;
					cancel.setVisible(false);
					b9.setText(k.getKeyText(harf));
					dinle=0;
					break;
				case 3: 
				
					harf=k.getKeyCode();
					p[2].tus =harf;
					cancel.setVisible(false);
					b10.setText(k.getKeyText(harf));
					dinle=0;
					break;
				case 4: 
				
					harf=k.getKeyCode();
					p[3].tus =harf;
					cancel.setVisible(false);
					b11.setText(k.getKeyText(harf));
					dinle=0;
					break;
				case 5: 
				
					harf=k.getKeyCode();
					p[4].tus =harf;
					cancel.setVisible(false);
					b12.setText(k.getKeyText(harf));
					dinle=0;
					break;
				case 6: 
				
					harf=k.getKeyCode();
					p[5].tus =harf;
					cancel.setVisible(false);
					b13.setText(k.getKeyText(harf));
					dinle=0;
					break;
				case 7: 
				
					harf=k.getKeyCode();
					p[6].tus =harf;
					cancel.setVisible(false);
					b14.setText(k.getKeyText(harf));
					dinle=0;
					break;
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
