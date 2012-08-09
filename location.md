locationManager		
	locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
	Log.v(TAG, locationManager+"locationmanager");

gps환경설정
	Criteria criteria = new Criteria();	
	criteria.setAccuracy(Criteria.ACCURACY_FINE);		//정확도
	criteria.setPowerRequirement(Criteria.POWER_LOW);	//전원소비
	criteria.setAltitudeRequired(false);				//고도,높이값을얻어올지결
	criteria.setBearingRequired(false);					//프로바이더기본정보
	criteria.setSpeedRequired(false);					//속도	
	criteria.setCostAllowed(true);						//위치정보를 금전적비용발생확인

getBestProvider		
//	provider = locationManager.getBestProvider(criteria, true);
//	Log.v(TAG, "프로바이더 :"+provider);

	provider = locationManager.NETWORK_PROVIDER;		//무조건 네트워크로 위치정보를 받아옴
	location = locationManager.getLastKnownLocation(provider);
	Log.v(TAG, "location"+location);
	
위도, 경도		
	latitude = location.getLatitude();	
	longitude = location.getLongitude();
지역 이름	
	Geocoder gcEng = new Geocoder(getApplicationContext(),Locale.ENGLISH);	
	Geocoder gcKor = new Geocoder(getApplicationContext(),Locale.KOREA);		

여러개 있을수도 있으나 하나만 받아서 씀.	
    List<Address>  addressesE = gcE.getFromLocation(latitude, longitude, 1);
    List<Address>  addressesK = gcK.getFromLocation(latitude, longitude, 1);
	
	
gps가 off인지 아닌지 확인	
	private boolean chkGpsService() {
		String gs = android.provider.Settings.Secure.getString(
				getContentResolver(),
				android.provider.Settings.Secure.LOCATION_PROVIDERS_ALLOWED);

		if (gs.indexOf("gps", 0) < 0) {
			AlertDialog.Builder gsDialog = new AlertDialog.Builder(this);
			gsDialog.setTitle("off GPS")
					.setMessage("on GPS")
					.setCancelable(false)
					.setPositiveButton("OK",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									// gps설정화면으로 이동
									configGPS();

								}

							})
					.setNegativeButton("Cancel",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									dialog.cancel();

								}
							}).create().show();
			return false;
		} else {

			return true;
		}
	}
	

	void configGPS() {
		Intent intent = new Intent(
				android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
		intent.addCategory(Intent.CATEGORY_DEFAULT);
		startActivity(intent);
	}