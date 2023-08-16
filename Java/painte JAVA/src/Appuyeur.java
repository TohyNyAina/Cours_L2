import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


class Appuyeur extends MouseAdapter {
	public int xd,yd;
		public void mousePressed(MouseEvent e) 
		{
			xd = e.getX(); yd = e.getY();
			System.out.println(""+xd+" rrr "+yd);
		}
}