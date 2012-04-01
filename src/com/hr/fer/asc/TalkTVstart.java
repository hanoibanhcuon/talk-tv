package com.hr.fer.asc;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class TalkTVstart extends Activity {
    /** Called when the activity is first created. */
	
	Button btnUsername; 
	Button btnKanali;
	Button btnLista;
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
				txtGreet.setText("dogodio se klik username-a");				
			}
		});
        btnKanali.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				txtGreet.setText("dogodio se klik kanala");
				//ExpandableListKanal noviView = new ExpandableListKanal("RTL", "trenutna", "sljedeca");
				//setContentView(noviView.getExpandableListView());
				 Intent myIntent = new Intent(getApplicationContext(), ExpandableListEmisija.class);
		         startActivity(myIntent);
			       
			}
		});
        
      
    }
}