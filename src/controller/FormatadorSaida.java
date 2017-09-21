package controller;


import java.math.BigDecimal;

public class FormatadorSaida {
	private String novoNumeroFormatado;
	
	
	FormatadorSaida(String numeroEntrada, int casasDecimais, boolean notacaoCientifica){
		if(numeroEntrada.contains(".")){
			double aux = Double.parseDouble(numeroEntrada);
			BigDecimal d = new BigDecimal(aux);
			d = d.setScale(casasDecimais, BigDecimal.ROUND_UP);
			double tableValue = d.doubleValue();
			setNovoNumeroFormatado(Double.toString(tableValue));
		}else{
			novoNumeroFormatado = numeroEntrada;
		}
		if(novoNumeroFormatado.contains("E") && notacaoCientifica){
			for(int i=0;i<novoNumeroFormatado.length()-1;i++){
				if(novoNumeroFormatado.charAt(i)=='E'){
					setNovoNumeroFormatado(novoNumeroFormatado.substring(0, i-1)+" x10^("+novoNumeroFormatado.substring(i+1, novoNumeroFormatado.length())+")");
					if(getNovoNumeroFormatado().contains(".")){
						int iPonto=0, iX=0;
						for(int j=0;j<getNovoNumeroFormatado().length();j++){
							if(getNovoNumeroFormatado().charAt(j) == '.') iPonto = j;
							if(getNovoNumeroFormatado().charAt(j) == 'x') iX = j;
						}
						if((iX-iPonto) > casasDecimais){
							String aux = getNovoNumeroFormatado();
							String parte1 = aux.substring(0,iPonto+casasDecimais);
							String parte2 = aux.substring(iX-1,aux.length());
							aux = parte1+parte2;
							setNovoNumeroFormatado(aux);
						}
					}
				}
			}
		}
	}


	public String getNovoNumeroFormatado() {
		return novoNumeroFormatado;
	}


	public void setNovoNumeroFormatado(String novoNumeroFormatado) {
		this.novoNumeroFormatado = novoNumeroFormatado;
	}
}
