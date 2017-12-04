import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class MapEditor extends JPanel implements MouseListener{
	Dikdortgen[] d;
	int k=0;
	int dmevcut=0,dmax=50;
	int x,y,width,height;
	boolean ciz;
	ObjectInputStream iStream,iStreamS;
	public MapEditor()
	{
		super();
		d=new Dikdortgen[dmax];
		addMouseListener(this);
		dOku();
		
	}
	public void dOku()
	{
		try 
		{
			iStream=new ObjectInputStream(new FileInputStream("C:\\Users\\PC\\Desktop\\map\\dikdortgen.data"));
			iStreamS=new ObjectInputStream(new FileInputStream("C:\\Users\\PC\\Desktop\\map\\dikdortgenS.data"));
			Object okunan=iStream.readObject();
			d =(Dikdortgen[])okunan;
			dmevcut=(int)iStreamS.readInt();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		for(int i=0;i<10000;i+=20)
		{
			g.drawLine(0, i,10000 , i);
		}
		if(ciz==true)
		{
		g.setColor(Color.RED);
		g.drawOval(x-5, y-5,10, 10);
		}
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
		// TODO Auto-generated method stub
		if (e.getButton()==e.BUTTON1) 
		{
			if (k % 2 == 0) {
				x = e.getX();
				y = e.getY();
				ciz=true;
				repaint();
			} else if (k % 2 == 1) {
				width = e.getX() - x;
				height = e.getY() - y;
			}
			if (dmevcut < dmax - 1 && x != 0 && y != 0 && width != 0 && height != 0) {
				Dikdortgen yeniDikdortgen = new Dikdortgen(x, y, width, height);
				d[dmevcut] = yeniDikdortgen;
				dmevcut++;
				width = 0;
				height = 0;
			}
			k++;
			repaint();
		}	
		if(e.getButton()==e.BUTTON3)
		{
			if(dmevcut>0) {
			d[dmevcut-1]=new Dikdortgen(0,0, 0, 0);
			dmevcut--;
			repaint();
		}
			}
		if(e.getButton()==e.BUTTON2)
		{
			ObjectOutputStream oStream,oStreamS;
			
			try {
				oStream=new ObjectOutputStream(new FileOutputStream("C:\\Users\\PC\\Desktop\\map\\dikdortgen.data"));
				oStreamS=new ObjectOutputStream(new FileOutputStream("C:\\Users\\PC\\Desktop\\map\\dikdortgenS.data"));

				oStream.writeObject(d);
				oStreamS.writeInt(dmevcut);
			
				oStream.close();
				oStreamS.close();
				JOptionPane.showMessageDialog(null, "Map has been saved", "" + "MapEditor", JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			
		}
		
	}

	
	@Override
	public void mouseReleased(MouseEvent e) {
	}
}
