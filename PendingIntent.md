PendingIntent	
	Intent intent = new Intent(ACTION);
	PendingIntent pendingUpdateIntent = PendingIntent.getBroadcast(
			this, 1, intent,
			PendingIntent.FLAG_UPDATE_CURRENT);
	pendingUpdateIntent.send();