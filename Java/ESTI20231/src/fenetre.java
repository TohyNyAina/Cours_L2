import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class fenetre extends JFrame implements ActionListener{
	
	public JTextField z1,z2,z3;
	public JButton b1,b2;
	
	public fenetre()
	{
		Container c=getContentPane();
		c.setLayout(null);
		
		this.z1=new JTextField();
		this.z2=new JTextField();
		this.z3=new JTextField();
		this.b1=new JButton("Somme");
		this.b2=new JButton("Produit");
		
		this.z1.setBounds(10, 10, 150, 50);
		this.z2.setBounds(10, 80, 150, 50);
		this.z3.setBounds(10, 150, 150, 50);
		this.b1.setBounds(10, 220, 80, 50);
		this.b2.setBounds(100, 220, 80, 50);
		
		this.b1.addActionListener(this);
		this.b2.addActionListener(this);
		
		c.add(z1);c.add(z2);c.add(z3);
		c.add(b1);c.add(b2);
		
		setVisible(true);
		setSize(400,400);
		
	}
	public static void main(String[] args)
	{
		fenetre p=new fenetre();
	}
	@Override
	public void actionPerformed(ActionEvent ev) 
	{
		String clic=ev.getActionCommand();
		if(clic=="Somme")
		{
			float a=Float.parseFloat(this.z1.getText());
			float b=Float.parseFloat(this.z2.getText());
			float c=(a+b)*4;
			this.z3.setText(""+c);
		}
		else
		{
			float a=Float.parseFloat(this.z1.getText());
			float b=Float.parseFloat(this.z2.getText());
			float c=(a*b)+4;
			this.z3.setText(""+c);
		}
		
	}

}
