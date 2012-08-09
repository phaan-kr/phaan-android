		 @Override
		    public void onCreate(Bundle savedInstanceState) {
		        super.onCreate(savedInstanceState);
		        setContentView(R.layout.gallery_main);   
		        
		        gallery=(GalleryOnFling)findViewById(R.id.gallery);
		        
		        //Image Switcher Setting
		        imgSwitcher = (ImageSwitcher)findViewById(R.id.imageswitcher);
		       
		        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
		        in.setDuration(2000);
		        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
		        out.setDuration(2000);
		        imgSwitcher.setFactory(new ImageSwitcher.ViewFactory() {
		
		            public View makeView() {
		                ImageView iv = new ImageView(ImagesGallery.this);
		                iv.setBackgroundColor(0xFF000000);
		                iv.setScaleType(ImageView.ScaleType.FIT_XY);
		                iv.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
		                return iv;
		            }
		
		        });
		        imgSwitcher.setInAnimation(in);
		        imgSwitcher.setOutAnimation(out);
		            
		        adapter=new CustomAdapter(this, R.layout.gallery, picture);       
		        gallery.setAdapter(adapter);
		        
		        gallery.setOnItemSelectedListener(new OnItemSelectedListener() {
		
					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
						currentImageResId = picture[position];
						imgSwitcher.setImageResource(currentImageResId);
						
					}
		
					@Override
					public void onNothingSelected(AdapterView<?> arg0)
				    {
						// TODO Auto-generated method stub
					}
				});
		    }
		    
		     View.OnClickListener listener = new View.OnClickListener() 
		     {
				@Override
				public void onClick(View v)
				{
					switch(v.getId())
					{
						case R.id.set_Wallpaper_Btn:
							break;
					}
				}
			};
			
		class CustomAdapter extends BaseAdapter{
		    	private Context context;
		    	private int resourceId;
		    	private int[] picture;
		    	
		    	public CustomAdapter(Context context, int resourceId, int[] picture){
		    		this.context=context;
		    		this.resourceId=resourceId;
		    		this.picture=picture;
		    	}
		    	
				@Override
				public int getCount() {
					return picture.length;
				}
				
				@Override
				public Object getItem(int position) {
					return picture[position];
				}
		
				@Override
				public long getItemId(int position) {
					return position;
				}
		
				@Override
				public View getView(final int position, View convertView, ViewGroup parent) 
				{
					if(convertView==null)
					{
						convertView=View.inflate(context,resourceId, null);
					}			
					ImageView imgView=(ImageView)convertView;
					imgView.setImageBitmap(modifyPicture(picture[position], 1));
					imgView.setLayoutParams(new Gallery.LayoutParams(100, LayoutParams.FILL_PARENT));
					imgView.setScaleType(ImageView.ScaleType.FIT_XY);
					
					return imgView;
				}
		    }
		    
			private Bitmap modifyPicture(int num, int sampleSize)
			{
		  		BitmapFactory.Options options = new BitmapFactory.Options();
		  		options.inSampleSize = sampleSize; 		
		  		bitmap = BitmapFactory.decodeResource(getResources(), num, options);
		  		
		  		return bitmap;
		  	}
			
			@Override
			protected void onDestroy() 
			{
				bitmap.recycle();
				
				super.onDestroy();
			}
			
			
		}
		
		class GalleryOnFling extends Gallery {
			
			public GalleryOnFling(Context context) {
				super(context);
			}	
		
			@Override
			public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
				int keyCode;
				if(e2.getX() > e1.getX()){
					keyCode = KeyEvent.KEYCODE_DPAD_LEFT;
				}
				else{
					keyCode = KeyEvent.KEYCODE_DPAD_RIGHT;
				}
				onKeyDown(keyCode, null);
				return true;
			}
		}
