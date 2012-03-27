package hr.fer.asc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class TalkTVstart extends Activity {
    /** Called when the activity is first created. */
	
	Button btnUsername; 
	Button btnKanali;
	TextView txtGreet;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        btnUsername = (Button) findViewById(R.id.btnUser);
        btnKanali = (Button) findViewById(R.id.btnKanali);
        txtGreet = (TextView) findViewById(R.id.txtGreet);
        
        btnUsername.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				txtGreet.setText("dogodio se neparni klik");				
			}
		});
        btnKanali.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				txtGreet.setText("dogodio se parni klik");				
			}
		});
    }
}