package com.example.questoes;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SubMainActivity extends ActionBarActivity implements OnClickListener {
	private Button btnAcessar;
	private Button btnCadastrar;
	private Button btnVisitarQuestoes;
	private Button btnVoltarPrincipal;
	private EditText edTxNome;
	private EditText edTxSenha;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub_main);
		
		btnAcessar = (Button) findViewById(R.id.buttonSubPrinAcessar);
		btnCadastrar = (Button) findViewById(R.id.buttonSubPrinCadastrar);
		btnVisitarQuestoes = (Button) findViewById(R.id.buttonSubPrinVisitar);
		btnVoltarPrincipal = (Button) findViewById(R.id.buttonSubPrinVoltar);
		edTxNome = (EditText) findViewById(R.id.editTextNomeAcessoSubPrin);
		edTxSenha = (EditText) findViewById(R.id.editTextSenhaAcessoSubPrin);
		
		btnAcessar.setOnClickListener(this);
		btnCadastrar.setOnClickListener(this);
		btnVisitarQuestoes.setOnClickListener(this);
		btnVoltarPrincipal.setOnClickListener(this);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sub_main, menu);
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
		switch(v.getId()){
		case R.id.buttonSubPrinAcessar:{
			int flagNome = 0;
			int flagSenha = 0;
			
			if(edTxNome.length() != 0)
				flagNome = 1;
			
			if(edTxSenha.length() != 0)
				flagSenha = 1;
			
			if(flagNome == 0 && flagSenha > 0)
				Toast.makeText(this, "Nome nao inserido", Toast.LENGTH_SHORT).show();
			
			if(flagSenha == 0 && flagNome > 0)
				Toast.makeText(this, "Senha nao inserida", Toast.LENGTH_SHORT).show();
			
			if(flagNome == 0 && flagSenha == 0)
				Toast.makeText(this, "Nome e nao senha nao inseridos", Toast.LENGTH_SHORT).show();
			
			if(flagNome == 1 && flagSenha == 1){
				//Parei aqui
				Intent i = new Intent(this,FiltrosQuestaoActivity.class);
				startActivity(i);
			}
			
			
		}break;
		case R.id.buttonSubPrinCadastrar:{
			Intent i = new Intent(this,CadastroActivity.class);
			
			//envia nome para a pagina SubPrincipal
			if(edTxNome.length() > 0){
				String str = edTxNome.getText().toString();
				i.putExtra("NomeSubPrincipal", str);
			}
			
			startActivity(i);
			
		}break;
		case R.id.buttonSubPrinVisitar:{
			Intent i = new Intent(this,FiltrosQuestaoActivity.class);
			i.putExtra("nome_usuario", "Convidado");
			startActivity(i);
			
		}break;
		case R.id.buttonSubPrinVoltar:{
			Intent i = new Intent(this,MainActivity.class);
			startActivity(i);
			
		}break;
			
		}
		
	}
}
