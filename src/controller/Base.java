package controller;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Base {
		
		private String resultadoConversao;	
		private String tipoEntrada;
		private String tipoSaida;
		
		public Base(String tipoEntrada,String numeroEntrada,String tipoSaida){
			this.setTipoEntrada(tipoEntrada);
			this.setTipoSaida(tipoSaida);
			
			if(tipoEntrada.equals("Decimal")){
				if(tipoSaida.equals("Binário"))
					setResultadoConversao(setDecimalParaBaseN(numeroEntrada,2));
				else if(tipoSaida.equals("Octal")){
					setResultadoConversao(setDecimalParaBaseN(numeroEntrada,8));
				}else if(tipoSaida.equals("Hexadecimal")){
					setResultadoConversao(setDecimalParaBaseN(numeroEntrada,16));
				}
	
			}else if(tipoEntrada.equals("Binário")){
				if(tipoSaida.equals("Decimal")){
					setResultadoConversao(setNBaseParaDecimal(numeroEntrada,2));
				}else if(tipoSaida.equals("Octal")){
					setResultadoConversao(setDecimalParaBaseN(setNBaseParaDecimal(numeroEntrada,2),8));
				}else if(tipoSaida.equals("Hexadecimal")){
					setResultadoConversao(setDecimalParaBaseN(setNBaseParaDecimal(numeroEntrada,2),16));
				}
				

			}else if(tipoEntrada.equals("Octal")){
				if(tipoSaida.equals("Decimal")){
					setResultadoConversao(setNBaseParaDecimal(numeroEntrada,8));
				}else if(tipoSaida.equals("Binário")){
					setResultadoConversao(setDecimalParaBaseN(setNBaseParaDecimal(numeroEntrada,8),2));
				}else if(tipoSaida.equals("Hexadecimal")){
					setResultadoConversao(setDecimalParaBaseN(setNBaseParaDecimal(numeroEntrada,8),16));
				}
				
				
			}else if(tipoEntrada.equals("Hexadecimal")){
				if(tipoSaida.equals("Decimal")){
					setResultadoConversao(setNBaseParaDecimal(numeroEntrada,16));
				}else if(tipoSaida.equals("Binário")){
					setResultadoConversao(setDecimalParaBaseN(setNBaseParaDecimal(numeroEntrada,16),2));
				}else if(tipoSaida.equals("Octal")){
					setResultadoConversao(setDecimalParaBaseN(setNBaseParaDecimal(numeroEntrada, 16),8));
				}
			}	
		}

		public void setResultadoConversao(String resultadoConversao) {
			this.resultadoConversao = resultadoConversao;
		}
		
		//ENTRADA DE UM NUMERO DECIMAL - SAIDA UM NUMERO DE BASE INDICADA NA CHAMADA
		public String setDecimalParaBaseN(String numeroEntrada,int base){
			//SPLIT DA STRING NO DIVISOR .
			String[] numDividido = numeroEntrada.split("\\.");
			String numeroBaseInicial="";
			String numeroBaseFinal="";
			ArrayList<String> arrayHexa = new ArrayList<String>();
			long resto;
			long denominador= Long.parseLong(numDividido[0]);
			boolean saida = false;
			
			//CONVERSAO DA PARTE INTEIRA
			while(!saida){
				if(denominador < base){
					if(base == 16){
						arrayHexa.add(Long.toString(denominador));
					}else
						numeroBaseInicial = numeroBaseInicial+Long.toString(denominador);	
					saida = true;
				}else{
					resto = denominador%(base);
					denominador = denominador/(base);
					if(base == 16){
						arrayHexa.add(Long.toString(resto));
					}else{
						numeroBaseInicial = numeroBaseInicial+Long.toString(resto);
					}
				}
			}
			
			if(base==16){
				numeroBaseFinal = "";
				for(int i=(arrayHexa.size()-1);i>=0;i--){
					switch(arrayHexa.get(i).toString()){
					case"10":
						numeroBaseFinal = numeroBaseFinal +"A";
						break;
					case"11":
						numeroBaseFinal = numeroBaseFinal +"B";
						break;
					case"12":
						numeroBaseFinal = numeroBaseFinal +"C";
						break;
					case"13":
						numeroBaseFinal = numeroBaseFinal +"D";
						break;
					case"14":
						numeroBaseFinal = numeroBaseFinal +"E";
						break;
					case"15":
						numeroBaseFinal = numeroBaseFinal +"F";
						break;
						
						default:
							numeroBaseFinal = numeroBaseFinal + arrayHexa.get(i);
							break;
					}
				}
			}else{
				for(int i=(numeroBaseInicial.length()-1);i>=0;i--){
					numeroBaseFinal = numeroBaseFinal + Character.toString(numeroBaseInicial.charAt(i));
				}
			}
			
			//CONVERSAO PARTE FRACIONARIA
			if(numeroEntrada.contains(".")){
				double numFracionarioDouble = Double.parseDouble("0."+numDividido[1]);
				String numFracionarioBase="";
				DecimalFormat decimalFormatter = new DecimalFormat("0.00000000000000000000");
				
				for(int i=0;i<=4;i++){
					numFracionarioDouble = numFracionarioDouble*base;
					String parteInteira = decimalFormatter.format(numFracionarioDouble).substring(0, decimalFormatter.format(numFracionarioDouble).indexOf(","));
					String parteFracionada  = decimalFormatter.format(numFracionarioDouble).substring(decimalFormatter.format(numFracionarioDouble).toString().indexOf(",")+1);
					numFracionarioBase = numFracionarioBase + parteInteira;
					numFracionarioDouble = Double.parseDouble("0."+parteFracionada);
				}	
				numeroBaseFinal = numeroBaseFinal + "." + numFracionarioBase;
			}
				
			//System.out.println("Numero Decimal: "+numeroEntrada);
			//System.out.println("Numero da Base "+base+": "+numeroBaseFinal);
			return numeroBaseFinal;
			
		}
		
		
		//ENTRADA NUMERO DE BASE INDICADA NA ENTRADA - SAIDA UM NUMERO DECIMAL
		public String setNBaseParaDecimal(String numeroEntrada,int base){
			double numeroDecimal=0;
			double numeroDecimalFracionario=0;
			String numParteInteira="";
			String numParteFracionaria = "";
			int exp=0;
			
			if(numeroEntrada.contains(".")){
				float exp2=-1;
				//SPLIT DA STRING NO DIVISOR .
				String[] numDividido = numeroEntrada.split("\\.");
				numParteInteira = numDividido[0];
				numParteFracionaria = numDividido[1];
				if(base != 16){
					//CALCULO PARTE FRACIONÁRIA
					for(int i=0;i<numParteFracionaria.length();i++){
						numeroDecimalFracionario = numeroDecimalFracionario + (Integer.parseInt(Character.toString(numParteFracionaria.charAt(i)))*(Math.pow(base, exp2)));
						exp2--;
					}
				}else{
					for(int i=0;i<numParteFracionaria.length();i++){
						
						switch(numParteFracionaria.charAt(i)){
						case'A':
							numeroDecimalFracionario = numeroDecimalFracionario +(10*(Math.pow(base, exp)));
							break;
						case'B':
							numeroDecimalFracionario = numeroDecimalFracionario +(11*(Math.pow(base, exp)));
							break;
						case'C':
							numeroDecimalFracionario = numeroDecimalFracionario +(12*(Math.pow(base, exp)));
							break;
						case'D':
							numeroDecimalFracionario = numeroDecimalFracionario +(13*(Math.pow(base, exp)));
							break;
						case'E':
							numeroDecimalFracionario = numeroDecimalFracionario +(14*(Math.pow(base, exp)));
							break;
						case'F':
							numeroDecimalFracionario = numeroDecimalFracionario +(15*(Math.pow(base, exp)));
							break;
							default:
								numeroDecimalFracionario = numeroDecimalFracionario + (Integer.parseInt(Character.toString(numParteFracionaria.charAt(i)))*(Math.pow(base, exp2)));
								break;
						}
						exp++;
					}
				
				}	
			}else{
				numParteInteira = numeroEntrada;
			}
						
			
			if(base != 16){
				exp=0;
				for(int i = (numParteInteira.length()-1);i>=0;i--){
					numeroDecimal = numeroDecimal + (Integer.parseInt(Character.toString(numParteInteira.charAt(i)))*(Math.pow(base, exp)));
					exp++;
				}
			}else{
				for(int i = (numParteInteira.length()-1);i>=0;i--){
					
					switch(numParteInteira.charAt(i)){
					case'A':
						numeroDecimal = numeroDecimal +(10*(Math.pow(base, exp)));
						break;
					case'B':
						numeroDecimal = numeroDecimal +(11*(Math.pow(base, exp)));
						break;
					case'C':
						numeroDecimal = numeroDecimal +(12*(Math.pow(base, exp)));
						break;
					case'D':
						numeroDecimal = numeroDecimal +(13*(Math.pow(base, exp)));
						break;
					case'E':
						numeroDecimal = numeroDecimal +(14*(Math.pow(base, exp)));
						break;
					case'F':
						numeroDecimal = numeroDecimal +(15*(Math.pow(base, exp)));
						break;
						default:
							numeroDecimal = numeroDecimal + (Integer.parseInt(Character.toString(numParteInteira.charAt(i)))*(Math.pow(base, exp)));
							break;
					}
					exp++;
				}
			}
			
			
			
			
			if(numeroEntrada.contains(".")){
				numeroDecimal = numeroDecimal + numeroDecimalFracionario;
				return Double.toString(numeroDecimal);
			}else{
				return Integer.toString((int)numeroDecimal);
			}
			//System.out.println("Numero Base "+base+": "+numeroEntrada);
			//System.out.println("Numero da Decimal: "+numeroDecimal);
			
		}

		
		
		public String getTipoSaida() {
			return tipoSaida;
		}

		public void setTipoSaida(String tipoSaida) {
			this.tipoSaida = tipoSaida;
		}

		public String getTipoEntrada() {
			return tipoEntrada;
		}

		public void setTipoEntrada(String tipoEntrada) {
			this.tipoEntrada = tipoEntrada;
		}

		public String getResultadoConversao() {
			return (resultadoConversao);
		}
		
		
	}

