package com.example.questoes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class FiltrosQuestaoActivity extends ActionBarActivity implements OnClickListener, 
android.content.DialogInterface.OnClickListener{
	
	Button btnAvancar;
	ListView lvEscolhas;
	
	ArrayAdapter<String> listAdp;
	//ListView list;
	//ArrayList<String> toDoList;
	ArrayAdapter<String> aaFiltros;
	ArrayList<String> listaItens;
	String itemSelecionado;
	String[] filtrosSelecionados = {"","","",""};
	//Map<String,String> mapFiltrosSelecionados;
	String[] filtros = {"Disciplina","Categoria", "SubCategoria","Modo de Ordem"};
	String[] filtrosDisciplina = {"Todos", "Portugues", "Ingles", "Matematica", "Fisica", "Quimica"};
	String[] filtrosCategoria = {"Todos","Morfologia", "Regencia Verbal", "Interpretação de Texto"};
	String[] filtrosSubCategoria1 = {"Todos", "Analise sintatica", "Substantivo", "Verbo", "Artigo"};
	String[] filtrosModoOrdem = {"Aleatorio", "Linear"};
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_filtros_questao);
		
		filtrosSelecionados[0] = filtrosDisciplina[0];
		filtrosSelecionados[1] = filtrosCategoria[0];
		filtrosSelecionados[2] = filtrosSubCategoria1[0];
		filtrosSelecionados[3] = filtrosModoOrdem[0];
				
		
		//mapFiltrosSelecionados = new HashMap<String, String>();
		
		//mapFiltrosSelecionados.
		
		btnAvancar = (Button) findViewById(R.id.buttonAvancarPaginaFiltro);
		lvEscolhas = (ListView) findViewById(R.id.listViewPaginaFiltro);
		
		//String[] listaItens = getResources().getStringArray(R.array.lista_filtro);
		listaItens = new ArrayList<String>();
		listaItens.add(filtros[0] + " - " + filtrosDisciplina[0]);
		listaItens.add(filtros[1] + " - " + filtrosCategoria[0]);
		listaItens.add(filtros[2] + " - " + filtrosSubCategoria1[0]);
		listaItens.add(filtros[3] + " - " + filtrosModoOrdem[0]);
		
		//ArrayAdapter<String> aaFiltros = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listaItens);
		//lvEscolhas.setAdapter(aaFiltros);
		
		
		btnAvancar.setOnClickListener(this);
		
		//list = (ListView) findViewById(R.id.listViewPaginaFiltro);
		
		//toDoList = new ArrayList<String>();
		listAdp = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listaItens);
		lvEscolhas.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
				if(filtros[arg2] == "Disciplina"){
					FiltrosQuestaoActivity.this.mostraDialogo(filtros[arg2],filtrosDisciplina);
				}
				
				if(filtros[arg2] == "Categoria"){
					FiltrosQuestaoActivity.this.mostraDialogo(filtros[arg2],filtrosCategoria);
				}
				
				if(filtros[arg2] == "SubCategoria"){
					FiltrosQuestaoActivity.this.mostraDialogo(filtros[arg2],filtrosSubCategoria1);
				}
				
				if(filtros[arg2] == "Modo de Ordem"){
					FiltrosQuestaoActivity.this.mostraDialogo(filtros[arg2],filtrosModoOrdem);
				}
					
					
				itemSelecionado = filtros[arg2];
				//Toast t = Toast.makeText(FiltrosQuestaoActivity.this, filtros[arg2], Toast.LENGTH_SHORT);
				//t.show();
				
			}
			
		} );
		lvEscolhas.setAdapter(listAdp);
		
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.filtros_questao, menu);
		//menu.add(filtros[0]);
		//menu.add(filtros[1]);
		//menu.add(filtros[2]);
		//menu.add(filtros[3]);
		
		if(getIntent().getExtras() != null){
			Bundle dadosEnviados = getIntent().getExtras() ;
			
			MenuItem item = menu.findItem(R.id.item_pagina_filtro_nome_usuario);
			
			//Nome da Pagina SubPrincipal
			String strNome = dadosEnviados.getString("nome_usuario");
			item.setTitle(getString(R.string.menu_perfil_titulo_cadastro,strNome));			
			
		}
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
		else if(id == R.id.item_pagina_filtro_nome_usuario){
			Intent i = new Intent(this,PerfilUsuarioActivity.class);
			startActivity(i);
		}
		return super.onOptionsItemSelected(item);
		
		/*
		if(item.hasSubMenu() == false){
			if(item.getTitle() == filtros[0]){
				this.mostraDialogo(item.getTitle().toString(),filtrosDisciplina);
			}
			
			if(item.getTitle() == filtros[1]){
				this.mostraDialogo(item.getTitle().toString(),filtrosCategoria);
			}
			
			if(item.getTitle() == filtros[2]){
				this.mostraDialogo(item.getTitle().toString(),fitrosSubCategoria1);
			}
			
			if(item.getTitle() == filtros[2]){
				this.mostraDialogo(item.getTitle().toString(),filtrosModoOrdem);
			}
			
			
		}
		itemSelecionado = item.getTitle().toString();
		return true;
		*/
	}

	@Override
	public void onClick(View v) {
		if(v == btnAvancar){
			Intent i = new Intent(this,PaginaQuestaoHorizontalMainActivity.class);
			i.putExtra(filtros[0], filtrosSelecionados[0]);
			i.putExtra(filtros[1], filtrosSelecionados[1]);
			i.putExtra(filtros[2], filtrosSelecionados[2]);
			i.putExtra(filtros[3], filtrosSelecionados[3]);
			startActivity(i);
		}
		
		//if(v == lvEscolhas){
			//Toast t = Toast.makeText(this, "Lista", Toast.LENGTH_SHORT);
			//t.show();
		//}
		
	}
	
	public void mostraDialogo(final String menu, final String[] itensLista){
		AlertDialog.Builder construtor = new AlertDialog.Builder(this);
		construtor.setTitle(menu);
		construtor.setItems(itensLista, new DialogInterface.OnClickListener(){


			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				if(filtros[0] == menu){
					filtrosSelecionados[0] = menu;
				}
				
				if(filtros[1] == menu){
					filtrosSelecionados[1] = menu;
				}
				
				if(filtros[2] == menu){
					filtrosSelecionados[2] = menu;
				}
				
				if(filtros[3] == menu){
					filtrosSelecionados[3] = menu;
				}
				Toast t = Toast.makeText(FiltrosQuestaoActivity.this, menu + " - " + itensLista[arg1].toString() , Toast.LENGTH_SHORT);
				t.show();
				
			}
			
		});
		
		construtor.show();
	}
	
	
	@Override
	public void onClick(DialogInterface arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}
}
