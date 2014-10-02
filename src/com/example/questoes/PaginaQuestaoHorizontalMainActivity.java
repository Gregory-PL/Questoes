package com.example.questoes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.questoes_scroll_horizontal.PageIndicator;
import com.example.questoes_scroll_horizontal.Pager;

public class PaginaQuestaoHorizontalMainActivity extends ActionBarActivity implements OnClickListener{
	
	private Pager scroller;
	private PageIndicator indicator;
	public View paginaQuestaoHorizontal1;
	public View paginaQuestaoHorizontal2;
	public View paginaQuestaoHorizontal3;
	
	Button btnVerificaResposta;
	Button btnAvancar;
	Button btnPulaQuestao;
	TextView txViRespostaQuestao;
	TextView txViFiltros;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pagina_questao_horizontal_main);
		
		scroller = ((Pager)findViewById(R.id.scrollView));
		indicator = ((PageIndicator)findViewById(R.id.indicator));
		indicator.setPager(scroller);
		
		LayoutInflater layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		paginaQuestaoHorizontal1 = layoutInflater.inflate(R.layout.activity_pagina_questao_horizontal_pg1, null);
		scroller.addPage(paginaQuestaoHorizontal1);
		
		paginaQuestaoHorizontal2 = layoutInflater.inflate(R.layout.activity_pagina_questao_horizontal_pg2, null);
		scroller.addPage(paginaQuestaoHorizontal2);
		
		paginaQuestaoHorizontal3 = layoutInflater.inflate(R.layout.activity_pagina_questao_horizontal_pg3, null);
		scroller.addPage(paginaQuestaoHorizontal3);
		
		btnVerificaResposta = (Button) paginaQuestaoHorizontal2.findViewById(R.id.buttonVerificarPaginaHorizontal);
		btnVerificaResposta.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Toast t = Toast.makeText(PaginaQuestaoHorizontalMainActivity.this, "Reposta correta", Toast.LENGTH_LONG);
				//t.setGravity(gravity, xOffset, yOffset)
				t.show();
				
				//mostra itens, quando botao Verificar for pressionado
				txViRespostaQuestao.setVisibility(TextView.VISIBLE);
				txViRespostaQuestao.setText("Reposta correta!");
				
				btnAvancar.setVisibility(Button.VISIBLE);
				
			}
		});
		
		
		btnAvancar = (Button) paginaQuestaoHorizontal2.findViewById(R.id.buttonAvancarPaginaQuestaoHorizontal);
		btnAvancar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				btnAvancar.setVisibility(Button.INVISIBLE);
				Intent i = new Intent(PaginaQuestaoHorizontalMainActivity.this, PaginaQuestaoActivity.class);
				startActivity(i);
				
			}
		});
		
		btnPulaQuestao = (Button) paginaQuestaoHorizontal2.findViewById(R.id.buttonPularPaginaQuestaoHorizontal);
		btnPulaQuestao.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(PaginaQuestaoHorizontalMainActivity.this, PaginaQuestaoActivity.class);
				startActivity(i);
				
			}
		});
		
		txViRespostaQuestao = (TextView) paginaQuestaoHorizontal2.findViewById(R.id.textViewRespotaPaginaQuestaoHorizontal);
		
		txViFiltros = (TextView) paginaQuestaoHorizontal1.findViewById(R.id.textViewFiltrosPaginaQuestaoHorizontal);
		
		if(getIntent().getExtras() != null){
			Bundle dadosEnviados = getIntent().getExtras() ;
			
			//Nome da Pagina SubPrincipal
			String[] listaStr = {"","","",""};
			listaStr[0] = dadosEnviados.getString("Disciplina");
			listaStr[1] = dadosEnviados.getString("Categoria");
			listaStr[2] = dadosEnviados.getString("SubCategoria");
			listaStr[3] = dadosEnviados.getString("Modo de Ordem");
			txViFiltros.setText("Filtros ->  Disciplina = " + listaStr[0] + "  " + 
			", Categoria = " + listaStr[1] + "  " +  
			", SubCategoria = " + listaStr[2] + "  " + 
			", Modo de Ordem = " + listaStr[3]);
			
		}		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pagina_questao_horizontal_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		//if (id == R.id.action_settings) {
			//return true;
		//}
		
		if(id == R.id.item_filtro){
			Intent i = new Intent(this,FiltrosQuestaoActivity.class);
			startActivity(i);
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		if(v == btnVerificaResposta){
			Toast t = Toast.makeText(PaginaQuestaoHorizontalMainActivity.this, "Reposta correta", Toast.LENGTH_LONG);
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
