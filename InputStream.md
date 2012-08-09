Url & InputStream. readLine은 파일에서만?
	while(result.equals(""))
	{            
	    InputStream urlInputStream = url.openConnection().getInputStream();
	    
	    byte[] b = new byte[1024];
	    for (int n; (n = urlInputStream.read(b)) != -1;) 
	    {
	        out.append(new String(b, 0, n));
	    }
		    result = out.toString();
		    if (urlInputStream != null) 
		    	urlInputStream.close();
	    }
    }