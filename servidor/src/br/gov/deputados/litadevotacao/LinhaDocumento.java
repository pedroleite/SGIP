package br.gov.deputados.litadevotacao;







public class LinhaDocumento {
	

	
	
	
	private String numeroDoVoto;
	private String parlamentar;
	private boolean estavaPresente;
	private String partido;
	private String estado;

	public LinhaDocumento(String numeroDoVoto, String parlamentar,
			boolean estavaPresente, String partido, String estado) {
		this.numeroDoVoto = numeroDoVoto;
		this.parlamentar = parlamentar;
		this.estavaPresente = estavaPresente;
		this.partido = partido;
		this.estado = estado;
	}

	public String getNumeroDoVoto() {
		return numeroDoVoto;
	}

	public void setNumeroDoVoto(String numeroDoVoto) {
		this.numeroDoVoto = numeroDoVoto;
	}

	public String getParlamentar() {
		return parlamentar;
	}

	public void setParlamentar(String parlamentar) {
		this.parlamentar = parlamentar;
	}

	public boolean isEstavaPresente() {
		return estavaPresente;
	}

	public void setEstavaPresente(boolean estavaPresente) {
		this.estavaPresente = estavaPresente;
	}

	public String getPartido() {
		return partido;
	}

	public void setPartido(String partido) {
		this.partido = partido;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
