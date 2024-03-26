package br.com.weblivraria.dominio;

import java.sql.Date;

public class PEDIDO {
	private Integer IDpedido;
	private Integer IDUser;
	private Date DATAHORApedido;
	private Double TOTALpedido;
	
	
	public Integer getIDpedido() {
		return IDpedido;
	}
	public void setIDpedido(Integer iDpedido) {
		IDpedido = iDpedido;
	}
	public Integer getIDUser() {
		return IDUser;
	}
	public void setIDUser(Integer iDUser) {
		IDUser = iDUser;
	}
	public Date getDATAHORApedido() {
		return DATAHORApedido;
	}
	public void setDATAHORApedido(Date dATAHORApedido) {
		DATAHORApedido = dATAHORApedido;
	}
	public Double getTOTALpedido() {
		return TOTALpedido;
	}
	public void setTOTALpedido(Double tOTALpedido) {
		TOTALpedido = tOTALpedido;
	}
	

}
