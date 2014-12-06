package com.example.asynctask;

import java.net.URL;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

public class AlertDialog extends AsyncTask<URL, Integer, String> {
	
	// String for LogCat documentation
	private final static String TAG = "AsyncTask-AlertDialog";
	private Activity mParentActivity;
	
	private final CharSequence DialogTitle = "Loading";
	private final CharSequence DialogMessage = "Wait to load data...";
	
	// ProgressDialog
	private ProgressDialog barProgressDialog;
	private int fileNumber = 10;
	private int diff = 1;
	private String doInReturn = "ok";
		
	public AlertDialog(Activity parentActivity) {
		// TODO Auto-generated constructor stub
		super();
		mParentActivity = parentActivity;
	}
	
	@Override
	protected String doInBackground(URL... urls) {
		// TODO Auto-generated method stub
		int progress = 0;
		while(progress<=fileNumber) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			publishProgress(Integer.valueOf(progress));
			progress++;
		}
		return doInReturn;
	}

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		Log.i(TAG, "AlertDialog onPreExecute().");
		barProgressDialog = new ProgressDialog(mParentActivity);
		
		barProgressDialog.setTitle(DialogTitle);
		barProgressDialog.setMessage(DialogMessage);
		barProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		barProgressDialog.setProgress(0);
		barProgressDialog.setMax(fileNumber);
		barProgressDialog.show();
		super.onPreExecute();
	}
	
	@Override
	protected void onProgressUpdate(Integer... progress) {
		// TODO Auto-generated method stub
		Log.i(TAG, "AlertDialog onProgressUpdate() "+ progress.toString());
		barProgressDialog.incrementProgressBy(diff);
		super.onProgressUpdate(progress);
	}
	
	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		Log.i(TAG, "DownloaderTask onPostExecute().");
		if(result.equals(doInReturn)) {
			barProgressDialog.dismiss();
			Intent intent = new Intent();
			intent.setClass(mParentActivity, SecondAcitvity.class);
			// Launch the Activity using the intent
			mParentActivity.startActivity(intent);
		}
		super.onPostExecute(result);
	}
}
