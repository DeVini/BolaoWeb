package br.com.project.model.classes;

public enum TipoAcesso {
	
	JOGADOR("Jogador"), CAMBISTA("Cambista");
	
	String valor;
	
	private TipoAcesso(String valor) {
		
		this.valor = valor;
	}
	
	
	@Override
	public String toString() {
		
		return this.valor;
	}
}
