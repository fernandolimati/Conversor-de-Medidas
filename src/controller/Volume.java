package controller;

public class Volume {
	private double resultadoConversao;	
	
	public Volume(String tipoEntrada,double numeroEntrada,String tipoSaida){
		double coeficiente=0;
				
		switch(tipoEntrada){
		case "Litro(L)":
			switch(tipoSaida){
			case"Gal�o(Gal)":
				coeficiente = 0.264172;
				break;
			case"Quilolitro(qL)":
				coeficiente = 0.001;
				break;
			case"Metro C�bico(m3)":
				coeficiente = 0.001;
				break;
			case"Cent�metro C�bico(cm3)":
				coeficiente = 1000;
				break;
			case"Dec�metro C�bico(dm3)":
				coeficiente = 1;
				break;
			}
			resultadoConversao = coeficiente*numeroEntrada;
			break;
			
		case "Gal�o(Gal)":
			switch(tipoSaida){
			case"Litro(L)":
				coeficiente = 3.785411784;
				break;
			case"Quilolitro(qL)":
				coeficiente = 0.003785411784;
				break;
			case"Metro C�bico(m3)":
				coeficiente = 0.003785411784;
				break;
			case"Cent�metro C�bico(cm3)":
				coeficiente = 3785.4117840;
				break;
			case"Dec�metro C�bico(dm3)":
				coeficiente = 3.785411784;
				break;
			}
			resultadoConversao = coeficiente*numeroEntrada;
			break;
			
		case "Quilolitro(qL)":
			switch(tipoSaida){
			case"Litro(L)":
				coeficiente = 1000;
				break;
			case"Gal�o(Gal)":
				coeficiente = 264.172052358;
				break;
			case"Metro C�bico(m3)":
				coeficiente = 1;
				break;
			case"Cent�metro C�bico(cm3)":
				coeficiente = 1000000;
				break;
			case"Dec�metro C�bico(dm3)":
				coeficiente = 1000;
				break;
			}
			resultadoConversao = coeficiente*numeroEntrada;
			break;
			
			
		case "Metro C�bico(m3)":
			switch(tipoSaida){
			case"Litro(L)":
				coeficiente = 1000;
				break;
			case"Gal�o(Gal)":
				coeficiente = 264.172052358;
				break;
			case"Quilolitro(qL)":
				coeficiente = 1;
				break;
			case"Cent�metro C�bico(cm3)":
				coeficiente = 1000000;
				break;
			case"Dec�metro C�bico(dm3)":
				coeficiente = 1000;
				break;
			}
			resultadoConversao = coeficiente*numeroEntrada;
			break;
			
			
		case "Cent�metro C�bico(cm3)":
			switch(tipoSaida){
			case"Litro(L)":
				coeficiente = 0.001;
				break;
			case"Gal�o(Gal)":
				coeficiente = 0.00026417205235815;
				break;
			case"Quilolitro(qL)":
				coeficiente = 0.000001;
				break;
			case"Metro C�bico(m3)":
				coeficiente = 0.000001;
				break;
			case"Dec�metro C�bico(dm3)":
				coeficiente = 0.001;
				break;
			}
			resultadoConversao = coeficiente*numeroEntrada;
			break;
			
		case "Dec�metro C�bico(dm3)":
			switch(tipoSaida){
			case"Litro(L)":
				coeficiente = 1;
				break;
			case"Gal�o(Gal)":
				coeficiente = 0.26417205235815;
				break;
			case"Quilolitro(qL)":
				coeficiente = 0.001;
				break;
			case"Metro C�bico(m3)":
				coeficiente = 0.001;
				break;
			case"Cent�metro C�bico(cm3)":
				coeficiente = 1000;
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
