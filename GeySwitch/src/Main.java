import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Scrollbar;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class Main {
	static JFrame pencere;
	static int a=0;
	public static void main(String[] args) {
		
		pencere=new JFrame("Arayüz");//
		pencere.setVisible(true);
		pencere.setSize(1600,900);
		pencere.setResizable(true);
		pencere.setLocationRelativeTo(null);
		pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	openMapEditor();
	letTheGameBegin();
	}
	public static void openMapEditor()
	{
		MapEditor a=new MapEditor();
		a.setPreferredSize(new Dimension(10000,900));
		JScrollPane sc=new JScrollPane(a, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
										  JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pencere.addMouseListener(a);
		pencere.addKeyListener(a);
		pencere.addMouseMotionListener(a);
		pencere.add(sc);
	}
	public static void letTheGameBegin()
	{
		PlayerCizici p;
		Menu m=new Menu();
		if(m.start==0) 
		{
			System.out.println("if girdi");
		pencere.add(m);
		pencere.addKeyListener(m);
		}
		while(m.start==0) 
		{
			System.out.println("a");
		}
		if(m.start==1)
		{
			p=new PlayerCizici(m.p,m.oyuncusayisi);
			JFrame pencere2=new JFrame("GeySwitch");
			pencere2.setVisible(true);
			pencere.dispose();
			pencere2.setSize(1600,900);
			pencere2.add(p);
			pencere2.addKeyListener(p);
			System.out.println("else if girdi");
			pencere2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
	
	}
	

