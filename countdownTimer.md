countdownTimer
finish가 불릴때까지의 시간, 인터벌
	new CountDownTimer(1500,300) 
	{ 
	     public void onTick(long millisUntilFinished) 
	     {
	    	 remainTime = millisUntilFinished;
	    	 Log.d(CLASSTAG+"remainTime", remainTime+"");
	     }
	     public void onFinish() {}
	}