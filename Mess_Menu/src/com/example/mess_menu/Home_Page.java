package com.example.mess_menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class Home_Page extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home__page);
		ImageButton btn1;
		ImageButton btn2;
		btn1=(ImageButton)findViewById(R.id.boys_img);
		btn2=(ImageButton)findViewById(R.id.girls_img);
		
		btn1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Home_Page.this,Hostels.class);
				//Intent i1=new Intent("com.example.mess_menu.Hostels");
				intent.putExtra("hostel_type","boys");
				startActivity(intent);
			}
			
		});
		btn2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Home_Page.this,Hostels.class);
				intent.putExtra("hostel_type","girls");
				startActivity(intent);
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home__page, menu);
		return true;
	}

}
