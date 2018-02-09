package at.gousoogames.dungeons.core.gui.console;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintStream;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class GUIConsole {

	
	public static JTextField textField;
	
	public GUIConsole(){
		
		JFrame frame = new JFrame();
		//frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.add( new JLabel(" Console " ));

        JTextArea ta = new JTextArea();
        TextAreaOutputStream taos;
		try {
			taos = new TextAreaOutputStream( ta );
			PrintStream ps = new PrintStream( taos );
	        System.setOut( ps );
	        System.setErr( ps );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JTextField tf = new JTextField();
        TextFieldInputStream tin = new TextFieldInputStream(tf);
        
        ta.setSize(800,500);
        frame.add(tf);
        frame.add(new JScrollPane(ta));
        
        
        //tf.setText("Enter text here");
        tf.setSize(800, 100);
        
        frame.pack();
        frame.setVisible( true );
        frame.setSize(800,800);
		
        System.setIn(tin);
		textField = tf;
	}
	
	
	
}
