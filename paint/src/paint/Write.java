package paint;

import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Write extends Drawing implements KeyListener{

	private Font font;
	private FontMetrics fm;
	private static int stroke;
	public Write(){	

		super();//call parent constructor
		stroke=0;
		font = new Font("Serif", Font.BOLD, 25);//default size;
		fm = getFontMetrics(font);//want to be able to measure my String to draw
		addKeyListener(this);

	}

	
	@Override
	public void keyTyped(KeyEvent e) {
		String s = String.valueOf(e.getKeyChar());
		if(!mouseIsPressed){
			Graphics g = getGraphics();
			Graphics2D g2d = (Graphics2D)g;
			g2d.setStroke(new BasicStroke(getStroke()));
			lastX += fm.stringWidth(s+10); //increase x by width to move next char over
			g.drawString(s, lastX, lastY);
			record(x,y);
			//going to write all the chars we type on top of each other
			g.dispose();
		}
		System.out.println("In key typed "+ s);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	public static int getStroke() {
		return stroke;
	}


	public static void setStroke(int stroke) {
		Write.stroke = stroke;
	}

}
