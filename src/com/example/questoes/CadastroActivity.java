package com.example.questoes;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class CadastroActivity extends ActionBarActivity implements OnClickListener {
	Button btnRegistar;
	EditText edTxNome;
	EditText edTxEmail;
	EditText edTxSenha;
	EditText edTxConfirmacaoSenha;
	EditText edTxConfirmacaoEmail;
	
	ImageButton iBtnPerfil;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cadastro);
		
		
		edTxNome = (EditText) findViewById(R.id.editTextNomeCadastro);
		edTxEmail = (EditText) findViewById(R.id.editTextEmailCadastro);
		edTxSenha = (EditText) findViewById(R.id.editTextSenhaCadastro);
		edTxConfirmacaoSenha = (EditText) findViewById(R.id.editTextConfirmacaoSenhaCadastro);
		edTxConfirmacaoEmail = (EditText) findViewById(R.id.editTextConfirmacaoEmailCadastro);
		
		if(getIntent().getExtras() != null){
			Bundle dadosEnviados = getIntent().getExtras() ;
			
			//Nome da Pagina SubPrincipal
			String strNome = dadosEnviados.getString("NomeSubPrincipal");
			edTxNome.setText(strNome);
			
		}
		
		
		btnRegistar = (Button) findViewById(R.id.buttonCadastrarCadastro);
		
		iBtnPerfil = (ImageButton) findViewById(R.id.imageButtonPerfilCadastro);
		
		btnRegistar.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cadastro, menu);
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
		
		//vai para o perfil do Usuario
		if(id == R.id.action_perfil_cadastro){
			Intent intPerfilUsuario = new Intent(this,PerfilUsuarioActivity.class);
			startActivity(intPerfilUsuario);
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		if(v == btnRegistar){
			String nome = edTxNome.getText().toString();
			String email = edTxEmail.getText().toString();
			String senha = edTxSenha.getText().toString();
			String confirmacaoSenha = edTxConfirmacaoSenha.getText().toString();
			String confirmacaoEmail = edTxConfirmacaoEmail.getText().toString();
			
			boolean dadosOK = true;
			
			if(nome.length() != 0){
				
			}
			if(email.length() != 0){
				if(confirmacaoEmail.length() != 0){
					if(email.compareTo(confirmacaoEmail) == 0){
						
					}
				}
				
			}
			
			if(senha.length() != 0){
				if(confirmacaoSenha.length() != 0){
					if(senha.compareTo(confirmacaoSenha)== 0){
						
					}
				}
			}
			//Imagem tambem
			
			if(dadosOK){
				mostraDialogoConfirmacaoCadastro();
				//Toast t = Toast.makeText(this,getString(R.string.toast_cadastro_cadastro_aceito,nome),Toast.LENGTH_SHORT);
				//t.show();
			}
			
			else{
				Toast t = Toast.makeText(this,getString(R.string.toast_cadastro_cadastro_nao_aceito),Toast.LENGTH_SHORT);
				t.show();
			}
			
			
			
		}
		
	}
	
	//Controe o dialogo
	public void mostraDialogoConfirmacaoCadastro(){
		AlertDialog.Builder construtor = new AlertDialog.Builder(this);
		construtor.setTitle(R.string.dialogo_titulo_cadastro);
		construtor.setMessage(R.string.dialogo_texto_cadastro);
		construtor.setPositiveButton(getString(R.string.dialogo_botao_positivo_cadastro), new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast t = Toast.makeText(CadastroActivity.this,getString(R.string.toast_cadastro_cadastro_aceito, edTxNome.getText().toString()),Toast.LENGTH_SHORT);
				t.show();				
			}
			
		});
		construtor.setNegativeButton(getString(R.string.dialogo_botao_negativo_cadastro), new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				//Toast t = Toast.makeText(MainActivity.this, getString(R.string.toast_menssagem, getString(R.string.btn_tarde)),Toast.LENGTH_SHORT);
				//t.show();
				
			}
		});
		
		construtor.setCancelable(false);
		//Cria uma instancia do dialogo criado e mostra na tela
		AlertDialog dia = construtor.create();
		dia.show();
	}
}
