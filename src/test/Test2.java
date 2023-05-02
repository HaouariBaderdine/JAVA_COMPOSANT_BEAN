package test;

import java.beans.BeanInfo;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Exemple1.Document;

public class Test2 {
		
	public static void main(String[] args) {
		
		Document doc = new Document();
		doc.getPropretDescriptor();
		doc.getMhetohdDescriptor();
		doc.getEventDescriptor();
		
		JFrame f = new JFrame();
		
		f.setTitle("test");
		
		JTextField tt = new JTextField();
		
		tt.setText("dddd");
			
		f.add(tt);
		
		f.setVisible(true);
	}
	
}