package paint;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class ColorSelect extends JPanel implements ActionListener{

	private Write jpWrite;
	JButton jbColor;
	public ColorSelect(){
		jbColor = new JButton("Pick A Color");
		jbColor.addActionListener(this);
		add(jbColor);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Color bgColor = JColorChooser.showDialog(this, "pick a color", Color.PINK);
		setBackground(bgColor);
		jpWrite.lineColor = bgColor;//set the line color
	}

}
