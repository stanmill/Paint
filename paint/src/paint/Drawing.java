package paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Drawing extends JPanel implements MouseListener, MouseMotionListener, ActionListener, ChangeListener{
	
	protected static int lastX;
	protected static int lastY;
	protected boolean mouseIsPressed;
	protected Color lineColor;
	protected int diameter;
	int x=0;
	int y=0;
	String figure = "";
	JSlider jslide;
	int value;
	
	public Drawing(){
		value =0;
		lastX = 0;
		lastY = 0;
		diameter = 50;
		addMouseListener(this);
		addMouseMotionListener(this);
		setSize(500, 500);
		setBackground(Color.WHITE);
		mouseIsPressed =false;
		Shapes sh = new Shapes();
		
		JLabel label = new JLabel();
		JButton eraser = new JButton("Eraser");
		eraser.addActionListener(this);
		
		label.setText("Draw Shapes");
		JRadioButton rb1 = new JRadioButton("Circle");
		JRadioButton rb2 = new JRadioButton("Square");
		JRadioButton rb3 = new JRadioButton("Oval");
		JRadioButton rb4 = new JRadioButton("Arc");

		jslide = new JSlider(JSlider.HORIZONTAL,0,100,0);
		jslide.setMinorTickSpacing(2);
		jslide.setMinorTickSpacing(10);
		jslide.setPaintTicks(true);
		jslide.setPaintLabels(true);
		jslide.setLabelTable(jslide.createStandardLabels(10));
		
		ButtonGroup bg = new ButtonGroup();
		sh.add(eraser);
		sh.add(label);
		bg.add(rb1);
		bg.add(rb2);
		bg.add(rb3);
		bg.add(rb4);


		sh.add(rb1);
		sh.add(rb2);
		sh.add(rb3);
		sh.add(rb4);

		add(jslide);


		rb2.setSelected(true);
		
		rb1.addActionListener(this);
		rb2.addActionListener(this);
		rb3.addActionListener(this);
		rb4.addActionListener(this);

		jslide.addChangeListener(this);


		add(sh);
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		 x = e.getX();
		 y = e.getY();
		 Graphics g = getGraphics();
			Graphics2D g2d = (Graphics2D)g;
			
		switch(figure) {
		case "circle":
			g2d.setColor(lineColor);
			g2d.setStroke(new BasicStroke(value));
			drawCircle(g);
			g.dispose();
				break;
		case "square":
			g2d.setColor(lineColor);
			g2d.setStroke(new BasicStroke(value));
			drawSquare(g);
			g.dispose();

			break;
		case "oval":
			g2d.setColor(lineColor);
			g2d.setStroke(new BasicStroke(value));
			drawOval(g);
			g.dispose();
			break;
		case "eraser":
			setBackground(Color.WHITE);
			repaint();
			break;
		case "arc":
			g2d.setColor(lineColor);
			g2d.setStroke(new BasicStroke(value));
			drawArc(g);
			g.dispose();
			break;
		}
	}

	private void drawCircle(Graphics g){
		g.fillOval(lastX - diameter/2, lastY- diameter/2, diameter, diameter);
	}
	
	private void drawSquare(Graphics g) {
		g.fillRect(lastX - diameter/2, lastY- diameter/2, diameter, diameter);
	}
	
	private void drawOval(Graphics g) {
		g.drawOval(lastX - diameter/2, lastY- diameter/2, diameter, diameter);
	}
	
	private void drawArc(Graphics g) {
		g.drawArc(lastX - diameter/2, lastY- diameter/2,diameter,diameter, 0, 180);
	}
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		mouseIsPressed = true;
		record(e.getX(), e.getY());
		
		System.out.println("In PRESSED AT: "+lastX+","+lastY);
		
	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mouseIsPressed = false;
		int x = e.getX();
		int y = e.getY();
		Graphics g = getGraphics();
		g.drawLine(lastX, lastY, x, y);
		record(x, y);
		g.dispose();

		System.out.println("Released AT: "+x+","+y);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		requestFocus();//request the focus on the jpanel when the mouse enters
		record(e.getX(), e.getY());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
	protected void record(int x, int y){
		lastX = x;
		lastY = y;
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		mouseIsPressed = true;
		int x = e.getX();
		int y = e.getY();
		Graphics g = getGraphics();
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(value));
		g2d.setColor(lineColor);
		g2d.drawLine(lastX, lastY, x, y);
		record(x, y);
		g.dispose();
		System.out.println("Dragged AT: "+x+","+y);
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	
		String cmd = e.getActionCommand();
		
		if(cmd.equalsIgnoreCase("Circle")) {
			figure= "circle";
		}else if(cmd.equalsIgnoreCase("Square")) {
				figure = "square";
			}else if(cmd.equalsIgnoreCase("Oval")) {
				figure = "oval";
			}else if(cmd.equalsIgnoreCase("eraser")) {
				setBackground(Color.WHITE);
				repaint();
			}else if(cmd.equalsIgnoreCase("arc")) {
				figure ="arc";
			}			
			
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider js = (JSlider) e.getSource();
		value =(int)js.getValue();
		  Write.setStroke(value);
	}
	

}
