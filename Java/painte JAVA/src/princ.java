import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;
import java.applet.*;

public class princ extends Applet implements MouseListener,MouseMotionListener,ActionListener,ItemListener
{ 
	
	int xd, yd, x, y,xr,yr,xdd,ydd,SX,SY;
	Color c = Color.black,xx;
	Button nettoyer,b2,rec,pol;
	Choice couleurs;
	int gom=4;
	int choix;
	public princ() 
	{
		setBackground(Color.blue);
		nettoyer = new Button("effacer");
		rec = new Button("Rectangle");
		pol = new Button("Polyligne");
		b2 = new Button("SafidyFond");
		nettoyer.setForeground(Color.black);
		nettoyer.setBackground(Color.lightGray);
		couleurs = new Choice();
		couleurs.addItem("black");
		couleurs.addItem("red");
		couleurs.addItem("yellow");
		couleurs.addItem("green");
		couleurs.addItem("GOMME");
		couleurs.setForeground(Color.black);
		couleurs.setBackground(Color.lightGray);
	}
	public void init() 
	{
		xr=xdd=yr=ydd=-1;
		SX=SY=0;
		add(rec);
		add(pol);
		add(b2);
		add(nettoyer);
		add(new Label("coloris: "));
		add(couleurs);
		addMouseListener(this);
		addMouseMotionListener(this);
		nettoyer.addActionListener(this);
		b2.addActionListener(this);
		rec.addActionListener(this);
		pol.addActionListener(this);
		couleurs.addItemListener(this);
	}
	public boolean mouseMove(Event evt, int x, int y)
	{	
		// Mémoriser la position de la souris
		xdd = x;
		ydd = y;
		System.out.println("eeeeeeeeeeeeeeee");
		repaint();
		return true;
	}
	
	public boolean mouseUp(Event evt, int x, int y)
	{
		// Si le premier point est indéfini, l'initialiser
		// De même si les 2 points sont définis (on repart à 0)
		if ((xdd == -1) || (xr != -1))
		{
			xdd = x;
			ydd= y;
			xr = yr = -1;
		}
		else
		{
			// Fixer le 2ème point
			xr = x;
			yr = y;
		}	
		System.out.println("eeeeeeeeeeeee");
		repaint();
		return true;
	}

	public void update(Graphics g) 
	{
		g.setColor(c);
		paint(g);
	}
	public void paint(Graphics g) 
	{	Graphics2D g2 = (Graphics2D) g;
		switch(choix)
		{ case 1:
			
			g2.setStroke(new BasicStroke(gom));
			g2.drawLine(xd, yd, x, y);
			//g.drawLine(xd+1, yd+1, x+1, y+1);	
			//g.drawLine(xd+2, yd+2, x+2, y+2);
			xd = x; yd = y;
			break;
		case 2:
			g.setColor(Color.white);
			if (xdd != -1)
				if (xr != -1)
					g.drawLine(xdd, ydd, xr, yr);
				else
					g.drawLine(xdd, ydd, SX, SY);
			break;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String x=e.getActionCommand();
		if(x=="effacer")
		{
			Graphics g = getGraphics();
			g.clearRect(0,0,getSize().width,getSize().height);
			System.out.println("mamafa");
			g.dispose();
		}
		else
		{
			if(x=="SafidyFond")
			{
				xx = JColorChooser.showDialog(this, "IREO LOKOLOKO ....", getBackground());
				if (xx != null) setBackground(xx);
			}
			else
			{
				if(x=="Polyligne")
				{
					this.choix=1;
				}
				else
				{
					if(x=="Rectangle")
					{
						this.choix=2;
					}
				}
			}
		}
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		x = e.getX(); y = e.getY();
		System.out.println(""+x+"   pp"+y);
		repaint();
			
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		xd = e.getX(); yd = e.getY();
		System.out.println(""+xd+" rrr "+yd);
	/*	int i=0;
		if(i==0)
		{
		xdd = e.getX(); ydd = e.getY();
		System.out.println(""+xd+" rrrcccc "+yd);
		i++;
		}*/
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		String a = (String) e.getItem();
		gom=4;
		if (a.equals("black"))
			c = Color.black;
		else 
			if (a.equals("red")) 
				c = Color.red;
			else 
				if (a.equals("yellow"))
					c = Color.yellow;
				else 
					if (a.equals("green"))
						c = Color.green;
					else 
						if(a.equals("GOMME"))
							{
							c =this.xx;
							gom=16;
							}
							
						else
							c = Color.pink;
		
	}
	
		
}