import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * This is thread which refreshes the system. It is passed in the display and
 * clears the table before creating a new instance of GetThreads to update the
 * display with the most recent information.
 * 
 * @author Group B
 *
 */
public class RefreshThreads implements Runnable {

	Display d;
	ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);

	public RefreshThreads(Display d) {
		this.d = d;
	}

	@Override
	public void run() {
		d.clearScrollPane();
		new GetThreads(d);
		// run this class initially after 10 seconds and and then every 10
		// seconds after that.
		exec.scheduleAtFixedRate(this, 10, 10, TimeUnit.SECONDS);
	}

}
