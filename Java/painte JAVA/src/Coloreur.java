import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


class Coloreur implements ItemListener {
	
public void itemStateChanged(ItemEvent e) 
{	
	princ p=new princ();
	String a = (String) e.getItem();
	if (a.equals("black"))
		p.c = Color.black;
	else 
		if (a.equals("red")) 
			p.c = Color.red;
		else 
			if (a.equals("yellow"))
				p.c = Color.yellow;
			else 
				if (a.equals("green"))
					p.c = Color.green;
				else 
					p.c = Color.pink;
}
}
