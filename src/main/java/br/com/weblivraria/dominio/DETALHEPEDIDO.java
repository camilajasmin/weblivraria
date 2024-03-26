package br.com.weblivraria.dominio;

public class DETALHEPEDIDO {
	private Integer IDdetalhepedido;
	private Integer IDpedido;
	private Integer IDlivro;
	private Integer QUANTIDADElivro;
	private Double PRECOTOTALpedido;
	
	public Integer getIDdetalhepedido() {
		return IDdetalhepedido;
	}
	public void setIDdetalhepedido(Integer iDdetalhepedido) {
		IDdetalhepedido = iDdetalhepedido;
	}
	public Integer getIDpedido() {
		return IDpedido;
	}
	public void setIDpedido(Integer iDpedido) {
		IDpedido = iDpedido;
	}
	public Integer getIDlivro() {
		return IDlivro;
	}
	public void setIDlivro(Integer iDlivro) {
		IDlivro = iDlivro;
	}
	public Integer getQUANTIDADElivro() {
		return QUANTIDADElivro;
	}
	public void setQUANTIDADElivro(Integer qUANTIDADElivro) {
		QUANTIDADElivro = qUANTIDADElivro;
	}
	public Double getPRECOTOTALpedido() {
		return PRECOTOTALpedido;
	}
	public void setPRECOTOTALpedido(Double pRECOTOTALpedido) {
		PRECOTOTALpedido = pRECOTOTALpedido;
	}
	
}
