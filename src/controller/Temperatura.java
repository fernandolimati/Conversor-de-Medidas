package controller;

public class Temperatura {
	
	private double resultadoConversao;	
	
	public Temperatura(String tipoEntrada,double numeroEntrada,String tipoSaida){
		if(tipoEntrada.equals("") && tipoSaida.equals("")){
			
		}else if(tipoEntrada.equals("Kelvin(K)")){
			if(tipoSaida.equals("Fahrenheit(F)"))
				setResultadoConversao(((numeroEntrada-273.15)*1.8+32));
			else
				setResultadoConversao((numeroEntrada-273.15));
			
		}else if(tipoEntrada.equals("Fahrenheit(F)")){
			if(tipoSaida.equals("Kelvin(K)"))
				setResultadoConversao(((numeroEntrada-32)/1.8)+273.15);
			else
				setResultadoConversao((numeroEntrada-32)/1.8);
			
		}else if(tipoEntrada.equals("Graus Celsius(C)")){
			if(tipoSaida.equals("Fahrenheit(F)"))
				setResultadoConversao(((numeroEntrada*1.8)+32));
			else
				setResultadoConversao((numeroEntrada+273.15));
			
		}
	}

	public double getResultadoConversao() {
		return (resultadoConversao);
	}

	public void setResultadoConversao(double resultadoConversao) {
		this.resultadoConversao = resultadoConversao;
	}
}
