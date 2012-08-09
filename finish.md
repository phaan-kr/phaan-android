앱 종료
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_BACK) {

			new AlertDialog.Builder(this)
					.setTitle("Exit")
					.setMessage("Quit?")
					.setPositiveButton("종료",
							new DialogInterface.OnClickListener() 
							{
								@Override
								public void onClick(DialogInterface dialog, int which) 
								{
									this.finish();
								}
							})
							.setNegativeButton("취소", null).show();
		}
		return super.onKeyDown(keyCode, event);
	}