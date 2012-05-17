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
	
	Button btn1P; 
	Button btn2P;
	Button btn3P;
	Button btn4P;
	
	TextView txtGreet;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        btn1P = (Button) findViewById(R.id.btn1P);
        btn2P = (Button) findViewById(R.id.btn2P);
        btn3P = (Button) findViewById(R.id.btn3P);
        btn4P = (Button) findViewById(R.id.btn4P);
        
        txtGreet = (TextView) findViewById(R.id.txtGreet);
   
        
        btn1P.setOnClickListener(new OnClickListener() {
		
        	
        	
			@Override
			public void onClick(View v) {
				 Intent myIntent = new Intent(getApplicationContext(), ExpandableListEmisija.class);
				 myIntent.putExtra("kanal", "program001");
				 startActivity(myIntent);			
			}
		});
        btn2P.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
		
				//ExpandableListKanal noviView = new ExpandableListKanal("RTL", "trenutna", "sljedeca");
				//setContentView(noviView.getExpandableListView());
				 Intent myIntent = new Intent(getApplicationContext(), ExpandableListEmisija.class);
				 myIntent.putExtra("kanal", "program002");
				 startActivity(myIntent);
			       
			}
		});
  btn3P.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
		
				//ExpandableListKanal noviView = new ExpandableListKanal("RTL", "trenutna", "sljedeca");
				//setContentView(noviView.getExpandableListView());
				 Intent myIntent = new Intent(getApplicationContext(), ExpandableListEmisija.class);
				 myIntent.putExtra("kanal", "program003");
				 startActivity(myIntent);
			       
			}
		});
       

   
       
        
    }
}