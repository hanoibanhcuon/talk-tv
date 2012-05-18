package com.hr.fer.asc;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.facebook.android.*;
import com.facebook.android.Facebook.*;


/**
 * Activity za komunikaciju s facebookom
 * Preuzeto s interneta, kreator Steffen Luypaert
 * Preuredjen samo jezik
 * http://www.integratingstuff.com/2010/10/14/integrating-facebook-into-an-android-application/
 * 
 * @author Hrvoje
 *
 */
public class Connect extends Activity{

	private static final String APP_ID = "190232824433004";
	private static final String[] PERMISSIONS = new String[] {"publish_stream"};

	private static final String TOKEN = "access_token";
        private static final String EXPIRES = "expires_in";
        private static final String KEY = "facebook-credentials";

	private Facebook facebook;
	private String messageToPost;

	public boolean saveCredentials(Facebook facebook) {
        	Editor editor = getApplicationContext().getSharedPreferences(KEY, Context.MODE_PRIVATE).edit();
        	editor.putString(TOKEN, facebook.getAccessToken());
        	editor.putLong(EXPIRES, facebook.getAccessExpires());
        	return editor.commit();
    	}

    	public boolean restoreCredentials(Facebook facebook) {
        	SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(KEY, Context.MODE_PRIVATE);
        	facebook.setAccessToken(sharedPreferences.getString(TOKEN, null));
        	facebook.setAccessExpires(sharedPreferences.getLong(EXPIRES, 0));
        	return facebook.isSessionValid();
    	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		facebook = new Facebook(APP_ID);
		restoreCredentials(facebook);

		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.faceconnect);

		String facebookMessage = getIntent().getStringExtra("facebookMessage");
		if (facebookMessage == "novi"){

		}
		messageToPost = facebookMessage;
	}

	public void doNotShare(View button){
		finish();
	}
	public void share(View button){
		if (! facebook.isSessionValid()) {
			loginAndPostToWall();
		}
		else {
			postToWall(messageToPost);
		}
	}

	public void loginAndPostToWall(){
		 facebook.authorize(this, PERMISSIONS, Facebook.FORCE_DIALOG_AUTH, new LoginDialogListener());
	}

	public void postToWall(String message){
		Bundle parameters = new Bundle();
                parameters.putString("message", message);
                parameters.putString("description", "topic share");
                try {
        	        facebook.request("me");
			String response = facebook.request("me/feed", parameters, "POST");
			Log.d("Tests", "got response: " + response);
			if (response == null || response.equals("") ||
			        response.equals("false")) {
				showToast("Blank response.");
			}
			else {
				showToast("Poruka je napisana na tvom zidu!!");
			}
			finish();
		} catch (Exception e) {
			showToast("Neuspješno slanje na zid");
			e.printStackTrace();
			finish();
		}
	}

	class LoginDialogListener implements DialogListener {
	    public void onComplete(Bundle values) {
	    	saveCredentials(facebook);
	    	if (messageToPost != null){
			postToWall(messageToPost);
		}
	    }
	    public void onFacebookError(FacebookError error) {
	    	showToast("Autentikacija neuspjela!");
	        finish();
	    }
	    public void onError(DialogError error) {
	    	showToast("Autentikacija neuspjela!");
	        finish();
	    }
	    public void onCancel() {
	    	showToast("Autentikacija neuspjela!");
	        finish();
	    }
	}

	private void showToast(String message){
		Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
	}
}