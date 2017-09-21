package controller;

public class Comprimento {

	private double resultadoConversao;		
	
	public Comprimento(String tipoEntrada,double numeroEntrada,String tipoSaida){
		double coeficiente=0;
		
		switch(tipoEntrada){
		case "Polegada(in)":
			switch(tipoSaida){
			case"Mil�metro(mm)":
				coeficiente = 25.4;
				break;
			case"Cent�metro(cm)":
				coeficiente = 2.54;
				break;
			case"Metro(m)":
				coeficiente = 0.0254;
				break;
			case"Quil�metro(km)":
				coeficiente = 0.0000254;
				break;
			case"Milha(mi)":
				coeficiente = 0.0000157828;
				break;
			}
			resultadoConversao = coeficiente*numeroEntrada;
			break;
			
			
		case "Mil�metro(mm)":
			switch(tipoSaida){
			case"Polegada(in)":
				coeficiente = 0.03937;
				break;
			case"Cent�metro(cm)":
				coeficiente = 0.1;
				break;
			case"Metro(m)":
				coeficiente = 0.001;
				break;
			case"Quil�metro(km)":
				coeficiente = 0.000001;
				break;
			case"Milha(mi)":
				coeficiente = 0.621371*0.000001;
				break;
			}
			resultadoConversao = coeficiente*numeroEntrada;
			break;
			
			
			
		case "Cent�metro(cm)":
			switch(tipoSaida){
			case"Polegada(in)":
				coeficiente = 0.393701;
				break;
			case"Mil�metro(mm)":
				coeficiente = 10;
				break;
			case"Metro(m)":
				coeficiente = 0.01;
				break;
			case"Quil�metro(km)":
				coeficiente = 0.00001;
				break;
			case"Milha(mi)":
				coeficiente = 0.0000062137;
				break;
			}
			resultadoConversao = coeficiente*numeroEntrada;
			break;
			
			
			
			
		case "Metro(m)":
			switch(tipoSaida){
			case"Polegada(in)":
				coeficiente = 39.3701;
				break;
			case"Mil�metro(mm)":
				coeficiente = 1000;
				break;
			case"Cent�metro(cm)":
				coeficiente = 100;
				break;
			case"Quil�metro(km)":
				coeficiente = 0.001;
				break;
			case"Milha(mi)":
				coeficiente = 0.00062137;
				break;
			}
			resultadoConversao = coeficiente*numeroEntrada;
			break;
			
			
			
			
		case "Quil�metro(km)":
			switch(tipoSaida){
			case"Polegada(in)":
				coeficiente = 39370.08;
				break;
			case"Mil�metro(mm)":
				coeficiente = 1000000;
				break;
			case"Cent�metro(cm)":
				coeficiente = 100000;
				break;
			case"Metro(m)":
				coeficiente = 1000;
				break;
			case"Milha(mi)":
				coeficiente = 0.621371;
				break;
			}
			resultadoConversao = coeficiente*numeroEntrada;
			break;
			
			
			
			
		case "Milha(mi)":
			switch(tipoSaida){
			case"Polegada(in)":
				coeficiente = 63360;
				break;
			case"Mil�metro(mm)":
				coeficiente = 1609344;
				break;
			case"Cent�metro(cm)":
				coeficiente = 160934.4;
				break;
			case"Metro(m)":
				coeficiente = 1609.34;
				break;
			case"Quil�metro(km)":
				coeficiente = 1.6093;
				break;
			}
			resultadoConversao = coeficiente*numeroEntrada;
			break;
		}
		
	}
	

	public double getResultadoConversao() {
		return (resultadoConversao);
	}

	public void setResultadoConversao(double resultadoConversao) {
		this.resultadoConversao = resultadoConversao;
	}
}
