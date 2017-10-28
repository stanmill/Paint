package paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GuiDemo extends JFrame{
	private Write jpWrite;//set outside the default constructor to be used by the ColorSelect class
	public GuiDemo() {
		JPanel mainInfo = new JPanel();
		mainInfo.setLayout(new BorderLayout());
		ColorSelect jpColor = new ColorSelect();
		jpWrite = new Write();
		//Shapes jpShape = new Shapes();
		
		mainInfo.add(jpColor, BorderLayout.NORTH);
		mainInfo.add(jpWrite, BorderLayout.CENTER);
		//mainInfo.add(jpShape, BorderLayout.WEST);

		add(mainInfo);
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//permit or deny the change in size of the frame
		setResizable(false);
		//set the position of the opening frame
		setLocationRelativeTo(null);
		//set the title of the frame
		setTitle("Creative World");
		
	}
	
	private class ColorSelect extends JPanel implements ActionListener{

		JButton jbColor;
		public ColorSelect(){
			jbColor = new JButton("Pick A Color");
			jbColor.addActionListener(this);
			add(jbColor);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			Color bgColor = JColorChooser.showDialog(this, "pick a color", Color.BLACK);
			setBackground(bgColor);
			jpWrite.lineColor = bgColor;//set the line color
			
		}

	}
	
	public static void main(String[] args) {
		System.out.println("Creating gui now");
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				
				GuiDemo gui = new GuiDemo();
				
			}
		});

		System.out.println("gui completed");
	}


}
