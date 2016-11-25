import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class Display extends JFrame {

	private static final long serialVersionUID = 1L;

	JPanel panel = new JPanel();
	JScrollPane scrollPane;

	public Display() {
		super();
		setUP();
		addLabel();
		addButton();
		tidy();
	}

	private void setUP() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel.setLayout(new BorderLayout());
		this.add(panel);
	}

	private void addLabel() {
		JLabel heading = new JLabel("THREAD TRACKER", SwingConstants.CENTER);
		heading.setFont(new Font("Centaur", Font.BOLD, 32));
		panel.add(heading, BorderLayout.PAGE_START);
	}

	private void addButton() {
		JPanel bottomPanel = new JPanel();
		JButton close = new JButton("CLOSE");
		close.addActionListener(new CloseListener());
		bottomPanel.add(close);

		panel.add(bottomPanel, BorderLayout.PAGE_END);

	}

	public void updateText(Thread[] allThreads) {
		int i = 0;
		String[][] data = new String[allThreads.length][5];
		String[] columnNames = { "Thread Group", "Thread Name", "ID", "State", "Deamon(True/False)" };
		
		JTable outputTable = new JTable(data, columnNames);
		scrollPane = new JScrollPane(outputTable);
		 
		panel.add(scrollPane, BorderLayout.CENTER);

		for (; i < allThreads.length; i++) {
			data[i][0] = allThreads[i].getThreadGroup().getName() + "";
			data[i][1] = allThreads[i].getName();
			data[i][2] = allThreads[i].getId() + "";
			data[i][3] = allThreads[i].getState() + "";
			data[i][4] = allThreads[i].isDaemon() + "";
		}

		String groupName = "";
		for (int j = 0; j < data.length; j++) {
			if (!groupName.equals(allThreads[j].getThreadGroup().getName())) {
				groupName = data[j][0];
				System.out.println(groupName);
			}
			System.out.println("\tName: " + data[j][1] + ",  ID: " + data[j][2] + ",  State: " + data[j][3]
					+ ",  IS Daemon:" + data[j][4]);
		}
		tidy();
	}
	
	public void clearScrollPane(){
			scrollPane.removeAll();
	}

	private void tidy() {
		this.pack();
		this.setMinimumSize(new Dimension(800, 300));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
