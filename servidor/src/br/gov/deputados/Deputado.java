package br.gov.deputados;

public class Deputado {
	private String nome;
	private String partido;
	private String estado;
	private String gabiente;
	private String anexo;
	private String telefoneGabinete;
	private boolean deputadoEmExercicio;
	private String email;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getGabiente() {
		return gabiente;
	}

	public void setGabiente(String gabiente) {
		this.gabiente = gabiente;
	}

	public String getAnexo() {
		return anexo;
	}

	public void setAnexo(String anexo) {
		this.anexo = anexo;
	}

	public String getTelefoneGabinete() {
		return telefoneGabinete;
	}

	public void setTelefoneGabinete(String telefoneGabinete) {
		this.telefoneGabinete = telefoneGabinete;
	}

	public boolean isDeputadoEmExercicio() {
		return deputadoEmExercicio;
	}

	public void setDeputadoEmExercicio(boolean deputadoEmExercicio) {
		this.deputadoEmExercicio = deputadoEmExercicio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;

	}
}
