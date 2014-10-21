package com.example.mess_menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;


public class Hostels extends Activity {
	RadioGroup hostel_list;
	int selected;
	Intent intent=getIntent();
	String hostel_type = intent.getStringExtra("hostel_type");
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hostels);
	 onselectconfigure();
	}
	

	private void onselectconfigure() {
		// TODO Auto-generated method stub
	
		hostel_list=(RadioGroup)findViewById(R.id.radioGroup1);
		hostel_list.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				selected=hostel_list.indexOfChild(findViewById(checkedId));
				switch(selected)
				{
				case 0:
					Intent intent1 = new Intent(Hostels.this,SQLView.class);
					intent1.putExtra("hostel_type",hostel_type);
					intent1.putExtra("block_id",selected);
					startActivity(intent1);
					break;
				case 1:
					Intent intent2 = new Intent(Hostels.this,SQLView.class);
					intent2.putExtra("hostel_type",hostel_type);
					intent2.putExtra("block_id",selected);
					startActivity(intent2);
					break;
				default :
				    	break;
				}
			}
		});
	
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hostels, menu);
		return true;
	}

}
