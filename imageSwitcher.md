이미지스위쳐
  	private ImageSwitcher imgSwitcher;
  	
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