package com.stopwatch;

import java.util.Calendar;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements OnClickListener{

	Button start_button, pause_button, reset_button, save_button;
	TextView time,date_text;
	boolean state = false;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        date_text = (TextView) findViewById(R.id.date_text);
        time = (TextView) findViewById(R.id.time);
        start_button = (Button) findViewById(R.id.start_button);
        pause_button = (Button) findViewById(R.id.pause_button);
        reset_button = (Button) findViewById(R.id.reset_button);
        save_button = (Button) findViewById(R.id.save_button);
        start_button.setOnClickListener(this);
        pause_button.setOnClickListener(this);
        reset_button.setOnClickListener(this);
        Calendar c = Calendar.getInstance();
        
        Engine.year = c.get(Calendar.YEAR);
        Engine.month = c.get(Calendar.MONTH)+1;
        Engine.day = c.get(Calendar.DAY_OF_MONTH);
        date_text.setText(Engine.year + "-" + Engine.month + "-" + Engine.day);
        
        time.setText(Engine.hour + "시간 " + Engine.minute + "분 " + Engine.second + "초");
    }

	@Override
	public void onClick(View v) {
		
		if(v.getId() == R.id.start_button){
			
			if(state == false){
				asyn task = new asyn();
				state = true;
				task.execute();
			}
		}
		else if (v.getId() == R.id.pause_button){
			state = false;
		}
		else if (v.getId() == R.id.save_button){

		}
		else{
			state = false;
			Engine.second = 0;
			Engine.minute = 0;
			Engine.hour = 0;
			time.setText(Engine.hour + "시간 " + Engine.minute + "분 " + Engine.second + "초");
		}
	}
	
	class asyn extends AsyncTask {

		@Override
		protected Object doInBackground(Object... params) {
			
			while(state){
				if(Engine.hour == 24) return null;
				Engine.second++;
				publishProgress(null);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(Engine.second == 60){
					Engine.second = 0;
					Engine.minute++;
				}
				if(Engine.minute == 60){
					Engine.minute = 0;
					Engine.hour++;
				}
			}
			return null;
		}

		@Override
		protected void onProgressUpdate(Object... values) {
			time.setText(Engine.hour + "시간 " + Engine.minute + "분 " + Engine.second + "초");
			super.onProgressUpdate(values);
		}
		
	}

	@Override
	protected void onDestroy() {
		state = false;
		super.onDestroy();
	}


}
