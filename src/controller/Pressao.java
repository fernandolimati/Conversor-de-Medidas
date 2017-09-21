package controller;

public class Pressao {
	
	private double coeficiente=0.0689476;
	private double resultadoConversao;	
	
	public Pressao(String tipoEntrada,double numeroEntrada,String tipoSaida){
		if(tipoEntrada == "Psi")
			setResultadoConversao(numeroEntrada*coeficiente);
		else
			setResultadoConversao(numeroEntrada/coeficiente);
	}

	public double getResultadoConversao() {
		return (resultadoConversao);
	}

	public void setResultadoConversao(double resultadoConversao) {
		this.resultadoConversao = resultadoConversao;
	}
}
