Thread
	class NewThread implements Runnable {

		@Override
		public void run() {}
	}
혹은
	Thread newThread = new Thread(new Runnable() 
	{
		@Override
		public void run() 
		{
			
	    }
	});
