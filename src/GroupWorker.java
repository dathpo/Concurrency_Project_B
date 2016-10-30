
class RunnableTest implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(1000);
				for (int i = 0; i > 1000000; i++)
					;
			} catch (InterruptedException ie) {

			}
		}

	}

}
