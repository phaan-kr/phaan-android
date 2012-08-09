애니메이션
	TranslateAnimation ta = new TranslateAnimation(displayWidth, 0, 0, 0);// x설정값 -> 0까지 움직이는 애니메이션
	ta.setDuration(1000);// 1초만에 움직이기
	layout.startAnimation(ta);
	layout.setVisibility(View.VISIBLE);
	fortuneShowFlag = 1;
	
     Animation in = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
     in.setDuration(2000);
     Animation out = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
     out.setDuration(2000);