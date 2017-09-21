package controller;

public class Angulo {
	private double resultadoConversao;	
	
	public Angulo(String tipoEntrada,double numeroEntrada,String tipoSaida){
		if(tipoEntrada.equals("Graus"))
			setResultadoConversao((numeroEntrada*(Math.PI/180)));
		else
			setResultadoConversao((numeroEntrada*(180/Math.PI)));
	}

	public double getResultadoConversao() {
		return (resultadoConversao);
	}

	public void setResultadoConversao(double resultadoConversao) {
		this.resultadoConversao = resultadoConversao;
	}
}
