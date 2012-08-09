	public class WidgetMain extends AppWidgetProvider 
	{
		private static final String ACTION_BTN  = "android.action.TO_WIDGET";
	
		private String TAG = WidgetMain.class.getSimpleName();
		private RemoteViews remoteViews;
		private static PendingIntent mSender;
		private static AlarmManager mManager;
	
		
		@Override
		public void onReceive(Context context, Intent intent) 
		{
			if(intent.getAction().equals(ACTION_BTN)||intent.getAction().equals("android.appwidget.action.APPWIDGET_UPDATE"))
			{			  			  			
				mSender = PendingIntent.getBroadcast(context, 0, intent, 0);
				mManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
				mManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+updateTime(), mSender);
					
				int[] appWidgetIds = AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context, WidgetMain.class));
				onUpdate(context, AppWidgetManager.getInstance(context), appWidgetIds);			
	
			}
			
			if(intent.getAction().equals("android.appwidget.action.APPWIDGET_DELETED"))
		    {
	      		Log.d(TAG+ " onDeleted", "");			      
		    }	
		}
	   
	    private static Thread updateButton;
		 
		@Override
		public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) { 
				
			
			Log.d(TAG,"call_onUpdate");  
			DB_Helper helper = new DB_Helper(context);
			db = helper.getWritableDatabase();
	       final int N = appWidgetIds.length; 
	      
	       for (int i=0; i<N; i++) 
	       {
	    	   final int appWidgetId = appWidgetIds[i];
	//    	   AppWidgetProviderInfo info = appWidgetManager.getAppWidgetInfo(appWidgetId);
	//    	   info.minHeight=150;
	    	       	   
	           remoteViews = new RemoteViews(context.getPackageName(), R.layout.mywidget1);//widgetLayoutId
	       }
	       super.onUpdate(context, appWidgetManager, appWidgetIds);
		}
	}
	
위젯으로 메시지 보낼 때
	Intent intent = new Intent(ACTION);
	PendingIntent pendingUpdateIntent = PendingIntent.getBroadcast(
			this, 1, intent,
			PendingIntent.FLAG_UPDATE_CURRENT);
	pendingUpdateIntent.send();