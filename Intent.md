Intent
	Intent intent;
	intent = new Intent(StartPage.this, Main.class);
	intent.putExtra("days", days);
	startActivity(intent);