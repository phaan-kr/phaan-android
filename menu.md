메뉴
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		super.onCreateOptionsMenu(menu);

		//group, order, itemId, title
		menu.add(0, 0, 0, "A").setIcon(android.R.drawable.ic_menu_info_details);
		menu.add(0, 1, 0, "B").setIcon(android.R.drawable.ic_menu_help);

		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		super.onOptionsItemSelected(item);

		switch (item.getItemId()) 
		{
			case 0:
				break;
		}
	}