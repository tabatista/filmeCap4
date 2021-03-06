package com.igti.filme.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

//lombok para nao implementar get e set
@Data
//declara a entidade como um documento - para usar com o mongo (Collection filme)
@Document
public class Filme { //resource filme
	private String id;
	private String titulo;
	private String diretor;
	private String genero;
	private int ano;
	
	//mas aqui no eclise nao funfou
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDiretor() {
		return diretor;
	}
	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}	
}
