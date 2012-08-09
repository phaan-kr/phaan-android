import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class IntroActivity extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);

        initialize();
    }

    private void checkWiFi() {
    	ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
    	NetworkInfo ni = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
    	boolean dlgRet = ni.isConnected();
    	AlertDialog.Builder dlg;
     	if(dlgRet == false) {
    		ni = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
    		if(ni.isConnected() == true) {
    			dlg = new AlertDialog.Builder(this);
    			dlg.setTitle("");
    			dlg.setMessage("현재 3G 모드로 연결되어 있습니다. 계속 하시겠습니까?");
    			dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
	    			public void onClick(DialogInterface dlg, int sumthin) {
	                    setResult(RESULT_OK , getIntent());
	                	finish();
	    			}
	    		});
    			dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
	    			public void onClick(DialogInterface dlg, int sumthin) {
	                    setResult(RESULT_CANCELED, getIntent());
	    				finish();
	    			}
	    		});    			
    			dlg.setCancelable(false);    			
    			dlg.show();
    		} else {
    			dlg = new AlertDialog.Builder(this);
    			dlg.setTitle("");
    			dlg.setMessage("네트워크 연결이 불가능합니다. ");
    			dlg.setNeutralButton("확인", new DialogInterface.OnClickListener() {
	    			public void onClick(DialogInterface dlg, int sumthin) {
	                    setResult(RESULT_CANCELED , getIntent());
	                	finish();
	    			}
	    		});
    			dlg.setCancelable(false);    			
    			dlg.show();
    		}
     	}
    }
    
    private void initialize()
    {
        Handler handler = new Handler()
        {
        	@Override
        	public void handleMessage(Message msg)
            {
        		checkWiFi(); 
            }
        };
        //인트로페이지 보여주기 위해
        handler.sendEmptyMessageDelayed(0, 1000);
    }
}
