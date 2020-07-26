package com.com.springMQproducer.dto;

import javax.validation.constraints.NotNull;

public class Email {

	@NotNull
	private String autor;
	@NotNull
	private String destinarario;
	private String titulo;
	private String conteudo;

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getDestinarario() {
		return destinarario;
	}

	public void setDestinarario(String destinarario) {
		this.destinarario = destinarario;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

}
