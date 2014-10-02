package com.example.questoes;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends ActionBarActivity implements OnClickListener {
	Button btnAcessar;
	Button btnSair;
	Button btnSobre;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnAcessar = (Button) findViewById(R.id.buttonPrinAcessar);
		btnSair = (Button) findViewById(R.id.buttonPrinSair);
		btnSobre = (Button) findViewById(R.id.buttonPrincipalSobre);
		
		btnSair.setOnClickListener(this);
		btnAcessar.setOnClickListener(this);
		btnSobre.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		//encaminha para a atividade SubMainActivity
		if(v == btnAcessar){
			Intent intSubPrin = new Intent(this,SubMainActivity.class);
			startActivity(intSubPrin);
		}
		else if(v == btnSair){
			
		}
		else if(v == btnSobre){
			Intent intSubPrin = new Intent(this,SobreActivity.class);
			startActivity(intSubPrin);
		}
		
	}
}
