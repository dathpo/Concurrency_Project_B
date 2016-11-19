import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RefreshThreads implements Runnable {
	
	Display d;
	ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
	
	public RefreshThreads(Display d){
		this.d = d;
	}
	
	
	@Override
	public void run() {
        new GetThreads(d);
    	exec.scheduleAtFixedRate(this, 1, 1, TimeUnit.SECONDS);
	}

}


