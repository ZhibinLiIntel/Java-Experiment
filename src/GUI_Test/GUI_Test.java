package GUI_Test;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
public class GUI_Test{
	public static void main(String args[]){
		Frame frame=new Frame("адлЛ");
		Panel p=new Panel();
		TextField tf=new TextField();
		frame.add(p);
		p.add(tf);
		frame.setSize(600,400);
		frame.setVisible(true);
		tf.setText("test");
		System.out.println(tf.getText());
		tf.addActionListener(null);
		
	}
}
