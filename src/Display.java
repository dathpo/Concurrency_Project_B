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

	public void updateTable(Thread[] allThreads) {
		String[][] data = new String[allThreads.length][5];
		String[] columnNames = { "Thread Group", "Thread Name", "ID", "State", "Daemon? (True/False)" };

		for (int i = 0; i < allThreads.length; i++) {
			data[i][0] = allThreads[i].getThreadGroup().getName() + "";
			data[i][1] = allThreads[i].getName();
			data[i][2] = allThreads[i].getId() + "";
			data[i][3] = allThreads[i].getState() + "";
			data[i][4] = allThreads[i].isDaemon() + "";
		}
		
		JTable outputTable = new JTable(data, columnNames);
		scrollPane = new JScrollPane(outputTable);
		 
		panel.add(scrollPane, BorderLayout.CENTER);

		String curGroupName = "";
		for (int i = 0; i < data.length; i++) {
			if (!curGroupName.equals(data[i][0])) {
				curGroupName = data[i][0];
				System.out.println(curGroupName);
			}
			System.out.println("\t"+columnNames[1]+": " + data[i][1] + ",  "+columnNames[2]+": " + data[i][2] + ",  "+columnNames[3]+": " + data[i][3]
					+ ",  "+ columnNames[4]+ ": " + data[i][4]);
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
