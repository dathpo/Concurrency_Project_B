import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class Display extends JFrame {

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JPanel panel = new JPanel();
	JTextArea outputBox;
	
	
		public Display(Thread[] allThreads){
			super();
			setUP();
			addLabel();
			addTextBox();
			displayText(allThreads);
			addButton();
			tidy();
		}

		private void setUP() {
			Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
			this.setLocation(center);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			
		
			panel.setLayout(new BorderLayout());
			this.add(panel);
			this.setVisible(true);
			
			
		}

		private void addLabel() {
			JLabel heading = new JLabel("THREAD TRACKER",SwingConstants.CENTER);
			panel.add(heading, BorderLayout.PAGE_START);			
		}

		private void addTextBox() {
			 outputBox = new JTextArea();
			JScrollPane scrollPane = new JScrollPane(outputBox); 
			outputBox.setEditable(false);
			panel.add(scrollPane,  BorderLayout.CENTER);

		}

		private void displayText(Thread [] allThreads) {
			int i =0;
			String groupName = "";
			String outputText = "THREAD GROUPS AND INFORMATION DISPLAY";
	        while ( i< allThreads.length) {
	               if(!groupName.equals(allThreads[i].getThreadGroup().getName())){
	                     groupName = allThreads[i].getThreadGroup().getName();
	                     outputText += "\n" + groupName ;
	               }
	 outputText +="\n 	Name : " + allThreads[i].getName() + ",  ID : "+ allThreads[i].getId()  +",  State : " + allThreads[i].getState() + ",  IS Daemon :"+ allThreads[i].isDaemon() ; 
	  i++;
	        }
	        
	   System.out.println(outputText);
	   outputBox.setText(outputText);
			
		}

		private void addButton() {
			JButton refresh = new JButton("REFRESH");
			panel.add(refresh, BorderLayout.PAGE_END);
			
		}

		private void tidy() {
			this.pack();		
			setMinimumSize(new Dimension(800, 300));
		}



		
		
}
