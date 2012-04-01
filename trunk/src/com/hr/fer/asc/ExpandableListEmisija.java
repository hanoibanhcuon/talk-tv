package com.hr.fer.asc;

import com.hr.fer.asc.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ExpandableListEmisija extends Activity  {

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);

        Button next = (Button) findViewById(R.id.button1);
        
        
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                
                finish();
            }

        });
    }
    
}