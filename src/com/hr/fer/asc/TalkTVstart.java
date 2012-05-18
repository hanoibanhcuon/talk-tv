package com.hr.fer.asc;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
/**
 * Glavni Activity, u njemu biramo opcije
 * Pregled kanala pokazuje kanale
 * Sinkroniziraj skida program za danas (ili automatski)
 * Korisnik postavlja facebook account
 * Kraj zavr�ava aplikaciju
 * @author TalkTV
 *
 */
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
   
        
   
       
        
        
        //gumbi
        btn1P.setOnClickListener(new OnClickListener() {
		
        	
        	
			@Override
			public void onClick(View v) {
				 Intent myIntent = new Intent(getApplicationContext(), ExpandableListKanal.class);
					// myIntent.putExtra("kanal", "program001");
					 startActivity(myIntent);		
			}
		});
        btn2P.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Downloader.Sinkroniziraj() ;//popravi ovo
//			       
			}
		});
  btn3P.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
		
			
				Intent logirajse = new Intent(getApplicationContext(), Connect.class);
				logirajse.putExtra("facebookMessage", "Skinuo sam novu aplikaciju: TalkTV" );
				startActivity(logirajse);		}
		});
       

  btn4P.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
	
			   System.runFinalizersOnExit(true);
			   System.exit(0);
			   }
	});
       
        
    }
  
}