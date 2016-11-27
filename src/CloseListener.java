import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * closes the window when close is pressed
 * 
 * @author Group B
 *
 */
public class CloseListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.exit(0);
	}

}
