Handler					     
	Handler	progressHandler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch(msg.what){
			case 0:
				new CountDownTimer(1500,300){}
				break;
			}
		}
	}
	
Timer 시작
	Message msg = new Message();
	msg.what = 0;	
    progressHandler.sendMessage(msg);

xml파싱 및 정보 세팅 후 
   	Thread.sleep(remainTime);
==> 걍 타이머 갖고 있다가 캔슬시키는게 나았을라나?