package com.example.mess_menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class SQLView extends Activity {
	Intent intent=getIntent();
	String hostel_type = intent.getStringExtra("hostel_type");
	String block_id = intent.getStringExtra("block_id");
	String table_name=hostel_type+"_"+block_id;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sqlview);
		 ((TextView)findViewById(R.id.tvSQLinfo1)).setText(table_name);
		TextView tv=(TextView)findViewById(R.id.tvSQLinfo2);
		Database_info info =new Database_info(this);
		info.open();
		String data=info.getData(table_name);
		info.close();
		tv.setText(data);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sqlview, menu);
		return true;
	}

}
