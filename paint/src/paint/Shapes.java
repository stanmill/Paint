package paint;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class Shapes extends JPanel implements ActionListener{
public static String cmd;
JLabel label;
JButton eraser;
int lastX = 0;
int lastY = 0;
int diameter = 50;
	
	public Shapes(){
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		 
		Graphics g = getGraphics();
		switch(cmd) {
		case "Circle":
			
			Graphics2D g2d = (Graphics2D)g;
			g2d.fillOval(20,20, 100 ,100);
		
			
			g.dispose();
			break;
			
		}
		

	}

}
