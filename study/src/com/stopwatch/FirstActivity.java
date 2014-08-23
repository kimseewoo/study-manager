package com.stopwatch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class FirstActivity extends ActionBarActivity{

	TextView tv;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.first_main);
 
        tv = (TextView) findViewById(R.id.text1);
        Button bt = (Button) findViewById(R.id.button1);
        
        bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intent = new Intent(getApplicationContext(), MainActivity.class);
				startActivity(intent);
			}
		});
	}
	
	@Override
	protected void onResume() {
    	tv.setText(Engine.hour + "시간 " + Engine.minute + "분 " + Engine.second + "초");
		super.onResume();
	}
}
