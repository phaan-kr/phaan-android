팝업
	popupView = View.inflate(this, R.layout.popup, null);
	
	// popup 생성
	popupWindow = new PopupWindow(popupView, (int) (display.getWidth() * 0.9), (int) (display.getHeight() * 0.5), true);
	
	finBtn = (ImageView) popupView.findViewById(R.id.popup);
	finBtn.setOnClickListener(new View.OnClickListener() {
	
		@Override
		public void onClick(View v) {
			popupWindow.dismiss(); // 팝업 내리기
		}
	});
	
	pw.showAtLocation(mainLinear, Gravity.NO_GRAVITY, (int) (display.getWidth() * 0.05), (int) (display.getHeight() * 0.3));
	pw.setAnimationStyle(-1); // default
	pw.showAsDropDown(mainLinear); 