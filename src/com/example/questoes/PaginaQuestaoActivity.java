package com.example.questoes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PaginaQuestaoActivity extends ActionBarActivity implements OnClickListener{
	Button btnVerificaResposta;
	Button btnAvancar;
	Button btnPulaQuestao;
	TextView txViRespostaQuestao;
	TextView txViFiltros;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pagina_questao);
		
		btnVerificaResposta = (Button) findViewById(R.id.buttonVerificarRespostaPaginaQuestao);
		btnVerificaResposta.setOnClickListener(this);
		
		btnAvancar = (Button) findViewById(R.id.buttonAvancarPaginaQuestao);
		btnAvancar.setOnClickListener(this);
		
		btnPulaQuestao = (Button) findViewById(R.id.buttonPularPaginaQuestao);
		btnPulaQuestao.setOnClickListener(this);
		
		txViRespostaQuestao = (TextView) findViewById(R.id.textViewRespostaQuestaoPaginaQuestao);
		
		txViFiltros = (TextView) findViewById(R.id.textViewFiltrosPaginaQuestao);
		
		if(getIntent().getExtras() != null){
			Bundle dadosEnviados = getIntent().getExtras() ;
			
			//Nome da Pagina SubPrincipal
			String[] listaStr = {"","","",""};
			listaStr[0] = dadosEnviados.getString("Disciplina");
			listaStr[1] = dadosEnviados.getString("Categoria");
			listaStr[2] = dadosEnviados.getString("SubCategoria");
			listaStr[3] = dadosEnviados.getString("Modo de Ordem");
			txViFiltros.setText("Disciplina = " + listaStr[0] + "  " + 
			", Categoria = " + listaStr[1] + "  " +  
			", SubCategoria = " + listaStr[2] + "  " + 
			", Modo de Ordem = " + listaStr[3]);
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pagina_questao, menu);
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
		
		if(id == R.id.item_filtro){
			Intent i = new Intent(this,FiltrosQuestaoActivity.class);
			startActivity(i);
		}
		
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		if(v == btnVerificaResposta){
			Toast t = Toast.makeText(PaginaQuestaoActivity.this, "Reposta correta", Toast.LENGTH_LONG);
			//t.setGravity(gravity, xOffset, yOffset)
			t.show();
			
			//mostra itens, quando botao Verificar for pressionado
			txViRespostaQuestao.setVisibility(TextView.VISIBLE);
			txViRespostaQuestao.setText("Reposta correta!");
			
			btnAvancar.setVisibility(Button.VISIBLE);
			
		}
		if(v == btnAvancar){
			btnAvancar.setVisibility(Button.INVISIBLE);
			Intent i = new Intent(this, PaginaQuestaoActivity.class);
			startActivity(i);
			
		}
		if(v == btnPulaQuestao){
			Intent i = new Intent(this, PaginaQuestaoActivity.class);
			startActivity(i);
		}
		
	}
}
