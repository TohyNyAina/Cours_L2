import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

class Dragueur extends MouseMotionAdapter {
	public int x,y;
	public void mouseDragged(MouseEvent e)
	{
		princ p=new princ();
		x = e.getX(); y = e.getY();
		System.out.println(""+x+"   pp"+y);
		p.repaint();
	}
	
	
}