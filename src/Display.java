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

/**
 * This class extends JFrame and adds all the GUI elements inside it. It also
 * display the console output. It does a little bit of variable assigning before
 * outputting to the relevant area
 * 
 * @author Group B
 *
 */

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

	/**
	 * This method separates the relevant information for the threads and adds
	 * it to the table or displays it in the console in a reasonable way
	 * 
	 * @param allThreads
	 *            the array of threads containing the every thread.
	 */

	public void updateOutput(Thread[] allThreads) {
		// create a 2D array with size for all the threads' information, seen in
		// column names.
		String[][] data = new String[allThreads.length][5];
		String[] columnNames = { "Thread Group", "Thread Name", "ID", "State", "Daemon? (True/False)" };

		// loop through and get the information from each thread and add it to
		// the 2D array. Some of them need to be turned into Strings.
		for (int i = 0; i < allThreads.length; i++) {
			data[i][0] = allThreads[i].getThreadGroup().getName() + "";
			data[i][1] = allThreads[i].getName();
			data[i][2] = allThreads[i].getId() + "";
			data[i][3] = allThreads[i].getState() + "";
			data[i][4] = allThreads[i].isDaemon() + "";
		}

		// build the table and add it to the display
		JTable outputTable = new JTable(data, columnNames);
		scrollPane = new JScrollPane(outputTable);

		panel.add(scrollPane, BorderLayout.CENTER);

		// loop through and when the thread group changes print out its name and
		// indent and print the rest of the information for all the threads of
		// that group.
		String curGroupName = "";
		for (int i = 0; i < data.length; i++) {
			if (!curGroupName.equals(data[i][0])) {
				curGroupName = data[i][0];
				System.out.println(curGroupName);
			}
			System.out.println("\t" + columnNames[1] + ": " + data[i][1] + ",  " + columnNames[2] + ": " + data[i][2]
					+ ",  " + columnNames[3] + ": " + data[i][3] + ",  " + columnNames[4] + ": " + data[i][4]);
		}
		tidy();
	}

	/**
	 * This method is only called by the the refresher runnable, to delete the
	 * table previously stored on the frame and allow a new one to be built
	 */
	public void clearScrollPane() {
		scrollPane.removeAll();
	}

	private void tidy() {
		this.pack();
		this.setMinimumSize(new Dimension(800, 300));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
