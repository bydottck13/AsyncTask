package com.example.asynctask;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SecondAcitvity extends Activity {
	
	// String for LogCat documentation
	private final static String TAG = "AsyncTask-SecondAcitvity";
	
	private Button btnFinish;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acitvity_second);
		Log.i(TAG,"Enter onCreate().");
		
		btnFinish = (Button) findViewById(R.id.buttonFinish);
		btnFinish.setOnClickListener(btnLinster);
	}
	
	private Button.OnClickListener btnLinster = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			finish();
		}
	};
}
