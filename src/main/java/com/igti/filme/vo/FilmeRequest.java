package com.igti.filme.vo;
/**
 * classe de manipulacao de dado, para navegar de uma estrutura para outra
 * @author tabatista
 * 
 * Os dados do filme que sera adicionado serao mapeados na classe FilmeRequest
 *
 */
public class FilmeRequest {

	private String titulo;
	private String diretor;
	private String genero;
	private int ano;
	
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
