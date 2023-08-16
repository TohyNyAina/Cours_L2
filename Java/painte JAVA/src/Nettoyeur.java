import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Nettoyeur implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {
		princ p =new princ();
			Graphics g =p. getGraphics();
			g.clearRect(0,0,p.getSize().width,p.getSize().height);
			g.dispose();
	
	}

	
}