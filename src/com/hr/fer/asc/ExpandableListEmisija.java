package com.hr.fer.asc;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import com.hr.fer.asc.Emisija;

import com.hr.fer.asc.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class ExpandableListEmisija extends Activity  {

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);
        
        Bundle extras = getIntent().getExtras(); 
       
        
        String imePrograma="";
        
        List<Emisija> ProgramKanala= new ArrayList<Emisija>();
       
       //Citanje dokumenata      
        StringBuffer vri = new StringBuffer();	
        StringBuffer emi = new StringBuffer();	
        int redniBroj = 0;
        String vrijemePocetka;
        String vrijemeKraja;
        String imeEmisije="default";
        try {  
		    String str="";
		    
		 
		 // textView is the TextView view that should display it
		    String value = null;
	        if(extras !=null)
	        {
	        value = (extras.getString("kanal"));
	        }
	        int drawableId = 0;
	        try {
	            Class res = R.drawable.class;
	            Field field = res.getField(value);
	            drawableId = field.getInt(null);
	        }
	        catch (Exception e) {
	          
	        }
		   	InputStream is = this.getResources().openRawResource(drawableId);
		   	BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		   	if (is!=null) {							
		   		while ((str = reader.readLine()) != null) {	
		   			if (str.contains("Program")) {
		   				imePrograma=str.split(":")[1];
		   			
		   				}
		   			else {
		   			if (str.contains("-")) {
		   			String[] polje = str.split("-");
		   			redniBroj=Integer.parseInt(polje[0]);
		   			vrijemePocetka=polje[1];
		   			vrijemeKraja=polje[2];
		   			imeEmisije=polje[3];
		   			
		   			Emisija temp= new Emisija(redniBroj, vrijemePocetka, vrijemeKraja, imeEmisije);
		   			ProgramKanala.add(temp);
		   			;}
		   			}
		   		}				
		   	}		
   	
		   	is.close();
	
		
   	
        } catch (IOException e) {
        	// TODO Auto-generated catch block
        	//e.printStackTrace(); 
    	} 
        //Naslov programa
        TextView naslov = (TextView) findViewById(R.id.textImePrograma); 
        //Popis programa
        
        TextView vrijeme = (TextView) findViewById(R.id.textVrijeme);
        
        TextView nazivEmisije = (TextView) findViewById(R.id.textEmisija);
        for (int i = 0; i <ProgramKanala.size(); i++) {
        	
        	//if (ProgramKanala.get(i).getVrijemePocetka()<) && (ProgramKanala.get(i).getVrijemePocetka()>)
        	String currentTime = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.FRANCE).format(new Date());
          	currentTime=currentTime.split(" ")[0].replaceAll(":", "");	
          	int trenVrijeme=Integer.parseInt(currentTime);
        	Emisija temp=ProgramKanala.get(i);
        	if ((temp.getVrijemeKraja()>trenVrijeme))
    		{vri.append(temp.getStrVrijemePocetka()+ "\n" );
    		emi.append(temp.getImeEmisije() + "\n" );
    		}
    	}
       
        		
      
    	vrijeme.setText(vri);
    	nazivEmisije.setText(emi);
       	naslov.setText(imePrograma);  
       	
       	
        Button next = (Button) findViewById(R.id.button1);       
        
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                
                finish();
            }

        });
    }
    
}