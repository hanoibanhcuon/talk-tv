package com.hr.fer.asc;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
 
/**
 * Activity kojem prikazujemo popis svih kanala
 * Hardkodirani su u kod radi sigurnosti, ali može se napraviti da se èitaju iz datoteke
 * Klikom se otvara raspored zadanog kanala
 * @author TalkTV
 *
 */
public class ExpandableListKanal extends ListActivity {
 
	static final String[] KANALI = new String[] { "Kanali", "MojTv1", "MojTv2", "PrivatniTV",
			 "Nazad"};
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
 
//			String[] Popis;
//		
//		   try {  
//			    String str="";
//			    
//			 
//			 // textView is the TextView view that should display it
//			    String value = null;
//		       
//			   	InputStream is = this.getResources().openRawResource(R.drawable.popis);
//			   	BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//			   	if (is!=null) {							
//			   		while ((str += reader.readLine()) != null) {	
//			   			
//			   			
//			   			;}
//			   			
//			   			Popis=str.split("//n");
//			   		}				
//			   			
//	   	
//			   	is.close();
//		
//			
//	   	
//	        } catch (IOException e) {
//	        	// TODO Auto-generated catch block
//	        	//e.printStackTrace(); 
//	    	} 	
		
		
		
		
		
		
		 //spoji kanale s Popisom, pomocu mape, a ne ovako hardcode
		setListAdapter(new ArrayAdapter<String>(this, R.layout.probalista,KANALI));
 
		ListView listView = getListView();
		listView.setTextFilterEnabled(true);
		listView.setBackgroundResource(R.drawable.zpozadina1);
		
		
		
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
	
				/*
				 * Hardcodirane šifre za više programa
				 * Može se napraviti da ne bude hardcode nego da se èita iz datoteke
				 * i sprema u HashMap ili nešto slièno
				 */
				String sifra = null;
				String provjera=((TextView) view).getText().toString();
				if (provjera=="MojTv1") {
					sifra="program001";
				} else if (provjera=="MojTv2") {
					sifra="program002";
				}  else if (provjera=="Nazad") {
					sifra="Kraj";
				} else if (provjera=="PrivatniTV") {
					sifra="program003";
				} else
				{//nista}
					sifra="preskoci";
				}
				
				if (sifra!="preskoci") 
					if (sifra=="Kraj") {finish();}
					else{
						/*zvanje sljedeæeg porozora s prikazom kanala
						 * i programom od sadašnje epizode do današnje
						 */
				 Intent myIntent2 = new Intent(getApplicationContext(), ExpandableListEmisija.class);
				 myIntent2.putExtra("kanal", sifra);
				 startActivity(myIntent2);}
			
			}
		});
		
		
		
 
	}
 
}