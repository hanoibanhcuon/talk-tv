package com.hr.fer.asc;
 
import com.hr.fer.asc.R;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
 
/**
 * Activity kojem prikazujemo popis svih kanala
 * Hardkodirani su u kod radi sigurnosti, ali mo�e se napraviti da se �itaju iz datoteke
 * Klikom se otvara raspored zadanog kanala
 * @author TalkTV
 *
 */


	/**
	 * Element u kojem prikazujemo kanal sa trenutnom i sljedećom emisijom, a daje mogućnost pritiska naziva kanala
	 * i prebacivanje na neku drugu akivnost (konkretno tv raspored tog kanala).
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
				 * Hardcodirane �ifre za vi�e programa
				 * Mo�e se napraviti da ne bude hardcode nego da se �ita iz datoteke
				 * i sprema u HashMap ili ne�to sli�no
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
						/*zvanje sljede�eg porozora s prikazom kanala
						 * i programom od sada�nje epizode do dana�nje
						 */
				 Intent myIntent2 = new Intent(getApplicationContext(), ExpandableListEmisija.class);
				 myIntent2.putExtra("kanal", sifra);
				 startActivity(myIntent2);}
			
			}
		});
	}
}