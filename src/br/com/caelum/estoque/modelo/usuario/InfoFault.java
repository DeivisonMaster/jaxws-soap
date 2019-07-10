package br.com.caelum.estoque.modelo.usuario;

import java.util.Date;

public class InfoFault {

	private String msg;
	private Date data;

	public InfoFault(String msg, Date data) {
		this.msg = msg;
		this.data = data;
	}
	
	
}
