	import java.util.Calendar;
	import java.util.Locale;
	
	public class mDate 
	{
		private Calendar cal;
		private int year;
		private int month;
		private int date;
		private int today;
		
	    public mDate()
	    {
	    	cal = Calendar.getInstance(Locale.KOREA);
	    	year = cal.get(Calendar.YEAR);
	    	month = cal.get(Calendar.MONTH)+1;
	    	date = cal.get(Calendar.DAY_OF_MONTH);
	    	today = cal.get(Calendar.DAY_OF_WEEK);
	    }
	    
	    public int getYear()
	    {
	    	return year;
	    }
	    
	    public int getMonth()
	    {
	    	return month;
	    }
	    
	    public int getDate()
	    {
	    	return date;
	    }
	    
	    //월/일(요일)
	    public String getCurrentDate()
	    {
	    	return  month+"/"+date+"("+getDay(today)+")";
	    }
	    
	    public String getNextDate(int day)
	    {
	    	cal.add(Calendar.DAY_OF_MONTH, day);
	    	month = cal.get(Calendar.MONTH)+1;
	    	date = cal.get(Calendar.DAY_OF_MONTH);
	    	today = cal.get(Calendar.DAY_OF_WEEK);
	    	return month+"/"+date +"("+getDay(today)+")";
	    }
	    
	    public String getDay(int day)
	    {
	    	String day_of_week = null;
	    	
	    	switch(day){
	    	case 1:
	    		day_of_week = "일";
	    		break;
	    	case 2:
	    		day_of_week = "월";
	    		break;
	    	case 3:
	    		day_of_week = "화";
	    		break;
	    	case 4:
	    		day_of_week = "수";
	    		break;
	    	case 5:
	    		day_of_week = "목";
	    		break;
	    	case 6:
	    		day_of_week = "금";
	    		break;
	    	case 7:
	    		day_of_week = "토";
	    		break;   		
	    	}    	
	    	return day_of_week;    	
	    }
	}
