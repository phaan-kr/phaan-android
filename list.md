	MListAdapter adapter = new MListAdapter(this, R.layout.mlist_row);  
   	lv.setAdapter(adapter);
   	lv.setOnItemClickListener(new AdapterView.OnItemClickListener() 
   	{
   		public void onItemClick(AdapterView<?> parent, View v, int pos, long id) 
   		{
   			onClick_listItem(pos);
   		}
   	});
    	
	class MListAdapter extends BaseAdapter 
	{
	  	LayoutInflater inflater;
	  	int layout;
	  	
	  	public MListAdapter(Context context, int layout) {
	  		inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	  		this.layout = layout;    		
	  	}
	  	public int getCount() {
	  		return 7;
	  	}
	  	public String getItem(int position) {
	  		return "item";
	  	}    	
	  	public long getItemId(int position) {
	  		return position;
	  	}    	
	  	@Override
	  	public View getView(int position, View convertView, ViewGroup parent) 
	  	{    		
	  		String [] menuTexts = {"A","B","C","D","E","F","G"};
	  		
	  		convertView = inflater.inflate(layout, parent, false);
	  		TextView tv = (TextView)convertView.findViewById(R.id.menu_text);
	  		tv.setText(menuTexts[position]);
	  		return convertView;
	  	}
	}
	
	==============================================================================================
	
	
	