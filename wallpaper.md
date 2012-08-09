월페이퍼
	WallpaperManager wm = (WallpaperManager)ImagesGallery.this.getSystemService(Context.WALLPAPER_SERVICE);
	try
	{
		wm.setResource(currentImageResId);
	}
	catch(IOException ie)
	{
		Log.e(TAG, ie.getMessage());
		Toast.makeText(ImagesGallery.this, "try again!", Toast.LENGTH_SHORT).show();
		break;
	}
	
	Toast.makeText(ImagesGallery.this, "set wallpaper.", Toast.LENGTH_SHORT).show();
					
