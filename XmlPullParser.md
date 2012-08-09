XmlPullParser
	XmlPullParser parser = factory.newPullParser();
    parser.setInput(url.openStream(),"EUC-KR");//한글 깨짐 방지
    Log.d(CLASSTAG+"getColumnNumber: ", parser.getColumnNumber()+"");
    
    parser.setInput(new StringReader(result));
    Log.d(CLASSTAG+"getColumnNumber: ", parser.getColumnNumber()+"");


	while(eventType != XmlPullParser.END_DOCUMENT)
	{
		switch(eventType)
		{
		    case XmlPullParser.START_DOCUMENT:
		        break;
		        
		    case XmlPullParser.END_DOCUMENT:
		        break;
		        
		    case XmlPullParser.START_TAG:
		        if(parser.getName().equals("temp_c")){
		            item = new Item()
		            temp_c = parser.getAttributeValue(0);
		            Log.d(CLASSTAG+"temp_c: ", parser.getAttributeValue(0)+"");
		
		        }
		        else if(parser.getName().equals("icon")){
		                item.icon = parser.getAttributeValue(0);
		                Log.d(CLASSTAG+"item.icon", item.icon);
		        }
		        
		        break;
		        
		    case XmlPullParser.END_TAG:
		        if(parser.getName().equals("current_conditions"))
		        {
		            tempIcon = item.icon;
		            Log.d(CLASSTAG+"current_conditions: ", tempIcon+"");
		        }
		        else if(parser.getName().equals("forecast_conditions")){
		            items.add(item);
		            Log.d(CLASSTAG+"forecast_conditions: ", items.size()+"");
		        }
		        break;
		}
	
		try {
		    eventType = parser.next();
		} catch (XmlPullParserException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	}