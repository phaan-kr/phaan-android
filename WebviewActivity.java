import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends Activity {
    /** Called when the activity is first created. */
	
	WebView browser = null;
	Intent  intent;
	String  strUrl;
	static ProgressDialog pDlg = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_PROGRESS);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        intent = getIntent();
        
        final Activity activity = this;
    	setContentView(R.layout.web);
    	browser = (WebView)findViewById(R.id.appweb); 
    	
    	 CookieSyncManager.createInstance(this);
    	 
    	strUrl = intent.getStringExtra("webViewUrl"); 
    	
    	loadWaitDlg(this);

        browser.getSettings().setSupportZoom(true);
        browser.getSettings().setJavaScriptEnabled(true);
    	browser.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    	browser.getSettings().setLoadsImagesAutomatically(true);       
    	    	 
        browser.setVerticalScrollbarOverlay(true);
        browser.getSettings().setSavePassword(true);
        browser.getSettings().setAppCacheEnabled(true); 
        browser.getSettings().setPluginsEnabled(true);
        browser.getSettings().setSupportMultipleWindows (true);
 
    	browser.loadUrl(strUrl);
    	browser.setWebChromeClient(new WebChromeClient() {
    		   public void onProgressChanged(WebView view, int progress) {
    		     // Activities and WebViews measure progress with different scales.
    		     // The progress meter will automatically disappear when we reach 100%
    		     activity.setProgress(progress * 100);
    		   }
    		 });
        browser.setWebViewClient(new AppClient());   
//    	browser.setInitialScale(50);
    }
    
    public static void loadWaitDlg(Context con) {
		if(pDlg == null)
			pDlg = ProgressDialog.show(con, "", "로딩중입니다.", true);
	}
	public static void closeWaitDlg() {
		if(pDlg != null) {
			pDlg.dismiss();
			pDlg = null;
		}
	}
	
    private class AppClient extends WebViewClient {
    	AppClient() {    		
    	}
    	@Override
    	public boolean shouldOverrideUrlLoading(WebView view, String url) {
    		loadWaitDlg(WebViewActivity.this);
    		view.loadUrl(url);
    		return true;
    	}
    	@Override
    	public void onPageFinished(WebView view, String url) {
    		closeWaitDlg();
    	}
    	@Override
    	public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) { 
    	super.onReceivedError(view, errorCode, description, failingUrl); 
    		closeWaitDlg();   	
    	}
    }
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if ((keyCode == KeyEvent.KEYCODE_BACK) && browser.canGoBack()) {
            browser.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    
    @Override
    protected void onResume()
    {
        super.onResume();
        CookieSyncManager.getInstance().startSync();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        CookieSyncManager.getInstance().stopSync();
    }
}