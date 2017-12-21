import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class MapEditor extends JPanel implements MouseMotionListener,MouseListener,KeyListener,ActionListener{
	Dikdortgen[] d;
	int k=0;
	int dmevcut=0,dmax=32000;
	int x,y,width,height;
	int x2,y2;
	ObjectInputStream iStream,iStreamS;
	private boolean b1;
	private boolean b2;
	private boolean shifted=false;
	private boolean controlled,placed;
	private int y3;
	private int x3;
	private boolean cik;
	private int dbos=0;
	JButton but1;
	public MapEditor()
	{
		super();
		this.setLayout(null);
		d=new Dikdortgen[dmax];
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
		dOku();
		but1=new JButton();
		but1.setBounds(20, 20, 40, 40);
		but1.addActionListener(this);
		add(but1);
	}
	public void dOku()
	{
		try 
		{
			iStream=new ObjectInputStream(new FileInputStream("C:\\Users\\klanvend\\Desktop\\mep\\dikdortgen.data"));
			iStreamS=new ObjectInputStream(new FileInputStream("C:\\Users\\klanvend\\Desktop\\mep\\dikdortgenS.data"));
			Object okunan=iStream.readObject();
			d =(Dikdortgen[])okunan;
			dmevcut=(int)iStreamS.readInt();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Okunacak Dosya Yok");
		}
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for(int i=0;i<dmevcut;i++)
		{
			d[i].ekranaCiz(g);
		}
		for(int i=0;i<10000;i+=20)
		{
			g.drawLine(i, 0,i , 900);
		}
		for(int i=0;i<900;i+=20)
		{
			g.drawLine(0, i,10000 , i);
		}
		for(int i=0;i<10000;i+=100)
		{
			for(int u=0;u<900;u+=100)
			{
				g.setColor(Color.RED);
				g.fillOval(i-5, u-5, 10, 10);
			}
		}
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, 80,900);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton()==e.BUTTON1) {
		b1=true;y2=e.getY() - (e.getY() % 20);
		x2=e.getX()-(e.getX()%20);}
		else b1=false;
		if(e.getButton()==e.BUTTON3)
		{
			b2=true;
		}
		else b2=false;
		if(e.getButton()==e.BUTTON3) b2=true;
		if(e.getButton()==e.BUTTON2)
		{
			ObjectOutputStream oStream,oStreamS;
			
			try {
				oStream=new ObjectOutputStream(new FileOutputStream("C:\\Users\\klanvend\\Desktop\\mep\\dikdortgen.data"));
				oStreamS=new ObjectOutputStream(new FileOutputStream("C:\\Users\\klanvend\\Desktop\\mep\\dikdortgenS.data"));

				oStream.writeObject(d);
				oStreamS.writeInt(dmevcut);
			
				oStream.close();
				oStreamS.close();
				JOptionPane.showMessageDialog(null, "Map has been saved", "" + "MapEditor by SelimY", JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}							
		}}
		
		
	

	
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		
		if (b1) {
			placed=false;
			if(controlled==false) {
			x2 = e.getX() - (e.getX() % 20);}
			if(shifted==false) {
			y2 = e.getY() - (e.getY() % 20);}
			if (dmevcut < dmax - 1) {
				cik=false;
				Dikdortgen yeniDikdortgen = new Dikdortgen(x2, y2, 20, 20);
				for(int i=0;i<dmevcut;i++)
				{
					if(yeniDikdortgen.getRectangle().intersects(d[i].getRectangle())) placed=true;
				}
				if(placed==false)
				{
				for(int i=0;i<dmevcut;i++) 
				{
					if(d[i].getRectangle().getWidth()==0&&cik==false)
					{
						dbos=i;
						d[i]=yeniDikdortgen;
						cik=true;
					}
				}
					if(dbos==0)	
					{
						d[dmevcut] = yeniDikdortgen;
						dmevcut++;
					}
					dbos=0;
					repaint();
				}
				}
		}
		if(b2)
		{
			if(controlled==false)
			x3 = e.getX() - (e.getX() % 20);
			if(shifted==false)
			y3 = e.getY() - (e.getY() % 20);			
			if (dmevcut>0) {
				Dikdortgen yeniDikdortgen = new Dikdortgen(x3, y3, 20, 20);		
				for(int i=0;i<dmevcut;i++)
				{
					if(yeniDikdortgen.getRectangle().intersects(d[i].getRectangle()))
					{
						d[i].getRectangle().setBounds(0,0,0,0);	
					}
				}
				repaint();
			}
		}
		}
		
			
	
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==e.VK_SHIFT)
			shifted=true;
		if(e.getKeyCode()==e.VK_CONTROL)
			controlled=true;
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		shifted=false;
		controlled=false;
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}