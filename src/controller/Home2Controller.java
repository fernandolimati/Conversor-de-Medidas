package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.controlsfx.control.Notifications;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.KeyEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class Home2Controller {

	@FXML ListView<String> listViewUnidadeEntrada;
	@FXML ListView<String> listViewUnidadeSaida;
	@FXML TextField textFieldEntrada;
	@FXML TextField textFieldSaida;
	@FXML String categoriaConversao;
	@FXML static boolean checkBoxStatus;
	@FXML CheckBox checkBoxAlwaysOnTop;
	@FXML Button buttonClipboard;
	int numeroDeCasasDecimais = 4;
	
	@FXML public void initialize(){
		carregarListViewEntrada();
		checkBoxAlwaysOnTop.setSelected(checkBoxStatus);
	}
	
	@FXML public void carregarListViewEntrada(){
		List<String> listaEntrada = new ArrayList<String>();
		listaEntrada.add("--------   BASE   -------");
		listaEntrada.add("Binário");
		listaEntrada.add("Decimal");
		listaEntrada.add("Hexadecimal");
		listaEntrada.add("Octal");
	
		listaEntrada.add("-------- PRESSÃO ------");
		listaEntrada.add("Psi");
		listaEntrada.add("Bar");
		
		listaEntrada.add("-------- VOLUME -------");
		listaEntrada.add("Litro(L)");
		listaEntrada.add("Galão(Gal)");
		listaEntrada.add("Quilolitro(qL)");
		listaEntrada.add("Metro Cúbico(m3)");
		listaEntrada.add("Centímetro Cúbico(cm3)");
		listaEntrada.add("Decímetro Cúbico(dm3)");
		
		listaEntrada.add("-------- ÂNGULOS -----");
		listaEntrada.add("Graus");
		listaEntrada.add("Radianos(rad)");
		
		listaEntrada.add("----- TEMPERATURA ----");
		listaEntrada.add("Graus Celsius(C)");
		listaEntrada.add("Kelvin(K)");
		listaEntrada.add("Fahrenheit(F)");
		
		listaEntrada.add("----- COMPRIMENTO ---");
		listaEntrada.add("Polegada(in)");
		listaEntrada.add("Milímetro(mm)");
		listaEntrada.add("Centímetro(cm)");
		listaEntrada.add("Metro(m)");
		listaEntrada.add("Quilômetro(km)");
		listaEntrada.add("Milha(mi)");
		ObservableList<String> obsList = FXCollections.observableArrayList(listaEntrada);
		listViewUnidadeEntrada.setItems(obsList);
	}

	@FXML public void listViewUnidadeEntradaClick(MouseEvent event) {
		List<String> listaSaida = new ArrayList<String>();
		
		if(listViewUnidadeEntrada.getSelectionModel().getSelectedIndex() == -1 || listViewUnidadeEntrada.getSelectionModel().getSelectedIndex() == 0 || listViewUnidadeEntrada.getSelectionModel().getSelectedIndex() == 5 || listViewUnidadeEntrada.getSelectionModel().getSelectedIndex() == 8 || listViewUnidadeEntrada.getSelectionModel().getSelectedIndex() == 15 || listViewUnidadeEntrada.getSelectionModel().getSelectedIndex() == 18 || listViewUnidadeEntrada.getSelectionModel().getSelectedIndex() == 22){
			listaSaida.add("Seleção incorreta!");
			textFieldEntrada.setEditable(false);
			textFieldEntrada.setDisable(true);
			textFieldEntrada.clear();
			textFieldSaida.clear();
		}else{
			
			if(listViewUnidadeEntrada.getSelectionModel().getSelectedIndex() > 0 && listViewUnidadeEntrada.getSelectionModel().getSelectedIndex() <5){
				categoriaConversao = "Base";
				listaSaida.add("Binário");
				listaSaida.add("Decimal");
				listaSaida.add("Hexadecimal");
				listaSaida.add("Octal");
				
				
			}else if(listViewUnidadeEntrada.getSelectionModel().getSelectedIndex() > 5 && listViewUnidadeEntrada.getSelectionModel().getSelectedIndex() <8){
				categoriaConversao = "Pressão";
				listaSaida.add("Psi");
				listaSaida.add("Bar");
				
			}else if(listViewUnidadeEntrada.getSelectionModel().getSelectedIndex() > 8 && listViewUnidadeEntrada.getSelectionModel().getSelectedIndex() <15){
				categoriaConversao = "Volume";
				listaSaida.add("Litro(L)");
				listaSaida.add("Galão(Gal)");
				listaSaida.add("Quilolitro(qL)");
				listaSaida.add("Metro Cúbico(m3)");
				listaSaida.add("Centímetro Cúbico(cm3)");
				listaSaida.add("Decímetro Cúbico(dm3)");
				
			}else if(listViewUnidadeEntrada.getSelectionModel().getSelectedIndex() > 15 && listViewUnidadeEntrada.getSelectionModel().getSelectedIndex() <18){
				categoriaConversao = "Ângulos";
				listaSaida.add("Graus");
				listaSaida.add("Radianos(rad)");
				
			}else if(listViewUnidadeEntrada.getSelectionModel().getSelectedIndex() > 18 && listViewUnidadeEntrada.getSelectionModel().getSelectedIndex() <22){
				categoriaConversao = "Temperatura";
				listaSaida.add("Graus Celsius(C)");
				listaSaida.add("Kelvin(K)");
				listaSaida.add("Fahrenheit(F)");
				
			}else if(listViewUnidadeEntrada.getSelectionModel().getSelectedIndex() > 22){
				categoriaConversao = "Comprimento";
				listaSaida.add("Polegada(in)");
				listaSaida.add("Milímetro(mm)");
				listaSaida.add("Centímetro(cm)");
				listaSaida.add("Metro(m)");
				listaSaida.add("Quilômetro(km)");
				listaSaida.add("Milha(mi)");
				
			}
			
		}
		listaSaida.remove(listViewUnidadeEntrada.getSelectionModel().getSelectedItem());
		ObservableList<String> obsList = FXCollections.observableArrayList(listaSaida);
		listViewUnidadeSaida.setItems(obsList);
		textFieldEntrada.setEditable(false);
		textFieldEntrada.setDisable(true);
		textFieldEntrada.clear();
		textFieldSaida.clear();
	}

	@FXML public void listViewUnidadeSaidaClick(MouseEvent event) {
		
		try{
			if(!listViewUnidadeSaida.getSelectionModel().getSelectedItem().equals("Seleção incorreta!") && textFieldEntrada.getText().isEmpty()){
				textFieldEntrada.setEditable(true);
				textFieldEntrada.setDisable(false);
			}else{
				textFieldEntrada.setEditable(false);
				textFieldEntrada.setDisable(true);
				textFieldEntrada.clear();
				textFieldSaida.clear();
			}	
		}catch (Exception e) {
		}
	}
	
	@FXML public void textFieldEntrada(KeyEvent event) {

		String unidadeEntrada = listViewUnidadeEntrada.getSelectionModel().getSelectedItem().toString();
		
		switch(categoriaConversao){
		case "Base":
			textFieldFormatarBase(textFieldEntrada, unidadeEntrada);
			break;
			
		case "Pressão":
			textFieldFormatarPressao(textFieldEntrada, unidadeEntrada);
			break;
			
		case "Volume":
			textFieldFormatarVolume(textFieldEntrada, unidadeEntrada);
			break;
			
		case "Ângulos":
			textFieldFormatarAngulo(textFieldEntrada, unidadeEntrada);
			break;
			
		case "Temperatura":
			if(unidadeEntrada.equals("Kelvin")){
				textFieldFormatarTemperaturaKelvin(textFieldEntrada, unidadeEntrada);
			}else if(unidadeEntrada.equals("Fahrenheit(F)")){
				textFieldFormatarTemperaturaFC(textFieldEntrada, unidadeEntrada,-459.67);
			}else{
				textFieldFormatarTemperaturaFC(textFieldEntrada, unidadeEntrada,-273.15);
			}
			break;
			
		case "Comprimento":
			textFieldFormatarComprimento(textFieldEntrada, unidadeEntrada);
			break;
			
		}
		
	}
	
	public void textFieldFormatarBase(TextField tfEntrada,String maskEntrada){
		int nCasas = 0;
		String ch;
		String entradaDados = tfEntrada.getText().toString();
		if(tfEntrada.getText().equals(""))	textFieldSaida.clear();
		
		switch(maskEntrada){
		case "Binário":
			nCasas = 50;
			if(tfEntrada.getText().length()>1 && tfEntrada.getText().length()<nCasas){
				if(entradaDados.charAt(entradaDados.length()-1) == '0' || entradaDados.charAt(entradaDados.length()-1) == '1'){
					Base objBase = new Base(listViewUnidadeEntrada.getSelectionModel().getSelectedItem(), entradaDados, listViewUnidadeSaida.getSelectionModel().getSelectedItem());
					textFieldSaida.setText(objBase.getResultadoConversao());
				}else if(entradaDados.charAt(entradaDados.length()-1) == '.'){
					int ponto = 0;
					for(int i=0;i<entradaDados.length();i++){
						if(entradaDados.charAt(i)=='.') ponto ++;
					}
					if(ponto > 1){
						tfEntrada.clear();
						tfEntrada.setText(entradaDados.substring(0,entradaDados.length()-1));
						for(int i=0;i<(entradaDados.length()-1);i++){
							tfEntrada.forward();
						}
					}
				}else{
					tfEntrada.clear();
					tfEntrada.setText(entradaDados.substring(0,entradaDados.length()-1));
					for(int i=0;i<(entradaDados.length()-1);i++){
						tfEntrada.forward();
					}
				}
			//IF SE A ENTRADA TEM MAIS QUE 1 CHAR
			}else if(tfEntrada.getText().length()==1){
				if(!tfEntrada.getText().equals("1") && !tfEntrada.getText().equals("0"))
					tfEntrada.clear();
				else{
					Base objBase = new Base(listViewUnidadeEntrada.getSelectionModel().getSelectedItem(), entradaDados, listViewUnidadeSaida.getSelectionModel().getSelectedItem());
					textFieldSaida.setText(objBase.getResultadoConversao());
				}
				//ELSE SE A ENTRADA FOR IGUAL A 1
			}else if(tfEntrada.getText().length()>=nCasas){
				tfEntrada.clear();
				tfEntrada.setText(entradaDados.substring(0,entradaDados.length()-1));
				for(int i=0;i<(entradaDados.length()-1);i++){
					tfEntrada.forward();
				}
			}
			break;
			
			
			
			
			
			
		case "Decimal":
			nCasas = 18;
			if(tfEntrada.getText().length()>1 && tfEntrada.getText().length()<nCasas){
				ch = Character.toString(entradaDados.charAt(entradaDados.length()-1));
				if(ch.equals("0") || ch.equals("1") || ch.equals("2") || ch.equals("3") || ch.equals("4") || ch.equals("5") || ch.equals("6") || ch.equals("7") || ch.equals("8") || ch.equals("9")){
					Base objBase = new Base(listViewUnidadeEntrada.getSelectionModel().getSelectedItem(), entradaDados, listViewUnidadeSaida.getSelectionModel().getSelectedItem());
					textFieldSaida.setText(objBase.getResultadoConversao());
				}else if(entradaDados.charAt(entradaDados.length()-1) == '.'){
					int ponto = 0;
					for(int i=0;i<entradaDados.length();i++){
						if(entradaDados.charAt(i)=='.') ponto ++;
					}
					if(ponto > 1){
						tfEntrada.clear();
						tfEntrada.setText(entradaDados.substring(0,entradaDados.length()-1));
						for(int i=0;i<(entradaDados.length()-1);i++){
							tfEntrada.forward();
						}
					}
				}else{
					tfEntrada.clear();
					tfEntrada.setText(entradaDados.substring(0,entradaDados.length()-1));
					for(int i=0;i<(entradaDados.length()-1);i++){
						tfEntrada.forward();
					}
				}
			//IF SE A ENTRADA TEM MAIS QUE 1 CHAR
			}else if(tfEntrada.getText().length() == 1){
				ch = entradaDados;
				if(!ch.equals("0") && !ch.equals("1") && !ch.equals("2") && !ch.equals("3") && !ch.equals("4") && !ch.equals("5") && !ch.equals("6") && !ch.equals("7") && !ch.equals("8") && !ch.equals("9"))
					tfEntrada.clear();
				else{
					Base objBase = new Base(listViewUnidadeEntrada.getSelectionModel().getSelectedItem(), entradaDados, listViewUnidadeSaida.getSelectionModel().getSelectedItem());
					textFieldSaida.setText(objBase.getResultadoConversao());
				}
			}else if(tfEntrada.getText().length() >= nCasas){
				tfEntrada.clear();
				tfEntrada.setText(entradaDados.substring(0,entradaDados.length()-1));
				for(int i=0;i<(entradaDados.length()-1);i++){
					tfEntrada.forward();
				}
			}
			//ELSE SE A ENTRADA FOR IGUAL A 1
			break;
			
			
			
			
		case "Hexadecimal":
			nCasas = 20;
			if(tfEntrada.getText().length()>1 && tfEntrada.getText().length()<nCasas){
				ch = Character.toString(entradaDados.charAt(entradaDados.length()-1));
				if(ch.equals("0") || ch.equals("1") || ch.equals("2") || ch.equals("3") || ch.equals("4") || ch.equals("5") || ch.equals("6") || ch.equals("7") || ch.equals("8") || ch.equals("9") || ch.equals("A") || ch.equals("B") || ch.equals("C") || ch.equals("D") || ch.equals("E") || ch.equals("F")){
					Base objBase = new Base(listViewUnidadeEntrada.getSelectionModel().getSelectedItem(), entradaDados, listViewUnidadeSaida.getSelectionModel().getSelectedItem());
					textFieldSaida.setText(objBase.getResultadoConversao());
				}else{
					tfEntrada.clear();
					tfEntrada.setText(entradaDados.substring(0,entradaDados.length()-1));
					for(int i=0;i<(entradaDados.length()-1);i++){
						tfEntrada.forward();
					}
				}
			//IF SE A ENTRADA TEM MAIS QUE 1 CHAR
			}else if(tfEntrada.getText().length() == 1){
				ch = entradaDados;
				if(!ch.equals("0") && !ch.equals("1") && !ch.equals("2") && !ch.equals("3") && !ch.equals("4") && !ch.equals("5") && !ch.equals("6") && !ch.equals("7") && !ch.equals("8") && !ch.equals("9") && !ch.equals("A") && !ch.equals("B") && !ch.equals("C") && !ch.equals("D") && !ch.equals("E") && !ch.equals("F"))
					tfEntrada.clear();
				else{
					Base objBase = new Base(listViewUnidadeEntrada.getSelectionModel().getSelectedItem(), entradaDados, listViewUnidadeSaida.getSelectionModel().getSelectedItem());
					textFieldSaida.setText(objBase.getResultadoConversao());
				}
			}else if(tfEntrada.getText().length() >= nCasas){
				tfEntrada.clear();
				tfEntrada.setText(entradaDados.substring(0,entradaDados.length()-1));
				for(int i=0;i<(entradaDados.length()-1);i++){
					tfEntrada.forward();
				}
			}
			//ELSE SE A ENTRADA FOR IGUAL A 1
			break;
			
			
		case "Octal":
			nCasas = 20;
			if(tfEntrada.getText().length()>1 && tfEntrada.getText().length()<nCasas){
				ch = Character.toString(entradaDados.charAt(entradaDados.length()-1));
				if(ch.equals("0") || ch.equals("1") || ch.equals("2") || ch.equals("3") || ch.equals("4") || ch.equals("5") || ch.equals("6") || ch.equals("7")){
					Base objBase = new Base(listViewUnidadeEntrada.getSelectionModel().getSelectedItem(), entradaDados, listViewUnidadeSaida.getSelectionModel().getSelectedItem());
					textFieldSaida.setText(objBase.getResultadoConversao());
				}else{
					tfEntrada.clear();
					tfEntrada.setText(entradaDados.substring(0,entradaDados.length()-1));
					for(int i=0;i<(entradaDados.length()-1);i++){
						tfEntrada.forward();
					}
				}
			//IF SE A ENTRADA TEM MAIS QUE 1 CHAR
			}else if(tfEntrada.getText().length() == 1){
				ch = entradaDados;
				if(!ch.equals("0") && !ch.equals("1") && !ch.equals("2") && !ch.equals("3") && !ch.equals("4") && !ch.equals("5") && !ch.equals("6") && !ch.equals("7"))
					tfEntrada.clear();
				else{
					Base objBase = new Base(listViewUnidadeEntrada.getSelectionModel().getSelectedItem(), entradaDados, listViewUnidadeSaida.getSelectionModel().getSelectedItem());
					textFieldSaida.setText(objBase.getResultadoConversao());
				}
			}else if(tfEntrada.getText().length() >= nCasas){
				tfEntrada.clear();
				tfEntrada.setText(entradaDados.substring(0,entradaDados.length()-1));
				for(int i=0;i<(entradaDados.length()-1);i++){
					tfEntrada.forward();
				}
			}
			//ELSE SE A ENTRADA FOR IGUAL A 1
			break;
		}
	}
	
	public void textFieldFormatarPressao(TextField tfEntrada,String maskEntrada){
		int nCasas = 0;
		String ch;
		String entradaDados = tfEntrada.getText().toString();
		if(tfEntrada.getText().equals(""))	textFieldSaida.clear();
		
		switch(maskEntrada){
		case "Psi":
			nCasas = 50;
			if(tfEntrada.getText().length()>1 && tfEntrada.getText().length()<nCasas){
				ch = Character.toString(entradaDados.charAt(entradaDados.length()-1));
				if(ch.equals("0") || ch.equals("1") || ch.equals("2") || ch.equals("3") || ch.equals("4") || ch.equals("5") || ch.equals("6") || ch.equals("7") || ch.equals("8") || ch.equals("9")){
					Pressao objPressao = new Pressao(listViewUnidadeEntrada.getSelectionModel().getSelectedItem(), Double.parseDouble(entradaDados), listViewUnidadeSaida.getSelectionModel().getSelectedItem());
					FormatadorSaida objFormatador = new FormatadorSaida(Double.toString(objPressao.getResultadoConversao()),numeroDeCasasDecimais,true);
					textFieldSaida.setText(""+objFormatador.getNovoNumeroFormatado());
				}else if(entradaDados.charAt(entradaDados.length()-1) == '.'){
					int ponto = 0;
					for(int i=0;i<entradaDados.length();i++){
						if(entradaDados.charAt(i)=='.') ponto ++;
					}
					if(ponto > 1){
						tfEntrada.clear();
						tfEntrada.setText(entradaDados.substring(0,entradaDados.length()-1));
						for(int i=0;i<(entradaDados.length()-1);i++){
							tfEntrada.forward();
						}
					}
				}else{
					tfEntrada.clear();
					tfEntrada.setText(entradaDados.substring(0,entradaDados.length()-1));
					for(int i=0;i<(entradaDados.length()-1);i++){
						tfEntrada.forward();
					}
				}
			//IF SE A ENTRADA TEM MAIS QUE 1 CHAR
			}else if(tfEntrada.getText().length()==1){
				ch = entradaDados;
				if(!ch.equals("0") && !ch.equals("1") && !ch.equals("2") && !ch.equals("3") && !ch.equals("4") && !ch.equals("5") && !ch.equals("6") && !ch.equals("7") && !ch.equals("8") && !ch.equals("9"))
					tfEntrada.clear();
				else{
					Pressao objPressao = new Pressao(listViewUnidadeEntrada.getSelectionModel().getSelectedItem(), Double.parseDouble(entradaDados), listViewUnidadeSaida.getSelectionModel().getSelectedItem());
					FormatadorSaida objFormatador = new FormatadorSaida(Double.toString(objPressao.getResultadoConversao()),numeroDeCasasDecimais,true);
					textFieldSaida.setText(""+objFormatador.getNovoNumeroFormatado());
				}
				//ELSE SE A ENTRADA FOR IGUAL A 1
			}else if(tfEntrada.getText().length()>=nCasas){
				tfEntrada.clear();
				tfEntrada.setText(entradaDados.substring(0,entradaDados.length()-1));
				for(int i=0;i<(entradaDados.length()-1);i++){
					tfEntrada.forward();
				}
			}
			break;
			
			
			
			
			
			
		case "Bar":
			nCasas = 18;
			if(tfEntrada.getText().length()>1 && tfEntrada.getText().length()<nCasas){
				ch = Character.toString(entradaDados.charAt(entradaDados.length()-1));
				if(ch.equals("0") || ch.equals("1") || ch.equals("2") || ch.equals("3") || ch.equals("4") || ch.equals("5") || ch.equals("6") || ch.equals("7") || ch.equals("8") || ch.equals("9")){
					Pressao objPressao = new Pressao(listViewUnidadeEntrada.getSelectionModel().getSelectedItem(), Double.parseDouble(entradaDados), listViewUnidadeSaida.getSelectionModel().getSelectedItem());
					FormatadorSaida objFormatador = new FormatadorSaida(Double.toString(objPressao.getResultadoConversao()),numeroDeCasasDecimais,true);
					textFieldSaida.setText(""+objFormatador.getNovoNumeroFormatado());
				}else if(entradaDados.charAt(entradaDados.length()-1) == '.'){
					int ponto = 0;
					for(int i=0;i<entradaDados.length();i++){
						if(entradaDados.charAt(i)=='.') ponto ++;
					}
					if(ponto > 1){
						tfEntrada.clear();
						tfEntrada.setText(entradaDados.substring(0,entradaDados.length()-1));
						for(int i=0;i<(entradaDados.length()-1);i++){
							tfEntrada.forward();
						}
					}
				}else{
					tfEntrada.clear();
					tfEntrada.setText(entradaDados.substring(0,entradaDados.length()-1));
					for(int i=0;i<(entradaDados.length()-1);i++){
						tfEntrada.forward();
					}
				}
			//IF SE A ENTRADA TEM MAIS QUE 1 CHAR
			}else if(tfEntrada.getText().length() == 1){
				ch = entradaDados;
				if(!ch.equals("0") && !ch.equals("1") && !ch.equals("2") && !ch.equals("3") && !ch.equals("4") && !ch.equals("5") && !ch.equals("6") && !ch.equals("7") && !ch.equals("8") && !ch.equals("9"))
					tfEntrada.clear();
				else{
					Pressao objPressao = new Pressao(listViewUnidadeEntrada.getSelectionModel().getSelectedItem(), Double.parseDouble(entradaDados), listViewUnidadeSaida.getSelectionModel().getSelectedItem());
					FormatadorSaida objFormatador = new FormatadorSaida(Double.toString(objPressao.getResultadoConversao()),numeroDeCasasDecimais,true);
					textFieldSaida.setText(""+objFormatador.getNovoNumeroFormatado());
				}
			}else if(tfEntrada.getText().length() >= nCasas){
				tfEntrada.clear();
				tfEntrada.setText(entradaDados.substring(0,entradaDados.length()-1));
				for(int i=0;i<(entradaDados.length()-1);i++){
					tfEntrada.forward();
				}
			}
			//ELSE SE A ENTRADA FOR IGUAL A 1
			break;
		}
	}

	public void textFieldFormatarVolume(TextField tfEntrada,String maskEntrada){
		int nCasas = 0;
		String ch;
		String entradaDados = tfEntrada.getText().toString();
		if(tfEntrada.getText().equals(""))	textFieldSaida.clear();
		
		nCasas = 50;
		if(tfEntrada.getText().length()>1 && tfEntrada.getText().length()<nCasas){
			ch = Character.toString(entradaDados.charAt(entradaDados.length()-1));
			if(ch.equals("0") || ch.equals("1") || ch.equals("2") || ch.equals("3") || ch.equals("4") || ch.equals("5") || ch.equals("6") || ch.equals("7") || ch.equals("8") || ch.equals("9")){
				Volume objVolume = new Volume(listViewUnidadeEntrada.getSelectionModel().getSelectedItem(), Double.parseDouble(entradaDados), listViewUnidadeSaida.getSelectionModel().getSelectedItem());
				FormatadorSaida objFormatador = new FormatadorSaida(Double.toString(objVolume.getResultadoConversao()),numeroDeCasasDecimais,true);
				textFieldSaida.setText(""+objFormatador.getNovoNumeroFormatado());
			}else if(entradaDados.charAt(entradaDados.length()-1) == '.'){
				int ponto = 0;
				for(int i=0;i<entradaDados.length();i++){
					if(entradaDados.charAt(i)=='.') ponto ++;
				}
				if(ponto > 1){
					tfEntrada.clear();
					tfEntrada.setText(entradaDados.substring(0,entradaDados.length()-1));
					for(int i=0;i<(entradaDados.length()-1);i++){
						tfEntrada.forward();
					}
				}
			}else{
				tfEntrada.clear();
				tfEntrada.setText(entradaDados.substring(0,entradaDados.length()-1));
				for(int i=0;i<(entradaDados.length()-1);i++){
					tfEntrada.forward();
				}
			}
		//IF SE A ENTRADA TEM MAIS QUE 1 CHAR
		}else if(tfEntrada.getText().length()==1){
			ch = entradaDados;
			if(!ch.equals("0") && !ch.equals("1") && !ch.equals("2") && !ch.equals("3") && !ch.equals("4") && !ch.equals("5") && !ch.equals("6") && !ch.equals("7") && !ch.equals("8") && !ch.equals("9"))
				tfEntrada.clear();
			else{
				Volume objVolume = new Volume(listViewUnidadeEntrada.getSelectionModel().getSelectedItem(), Double.parseDouble(entradaDados), listViewUnidadeSaida.getSelectionModel().getSelectedItem());
				FormatadorSaida objFormatador = new FormatadorSaida(Double.toString(objVolume.getResultadoConversao()),numeroDeCasasDecimais,true);
				textFieldSaida.setText(""+objFormatador.getNovoNumeroFormatado());
			}
			//ELSE SE A ENTRADA FOR IGUAL A 1
		}else if(tfEntrada.getText().length()>=nCasas){
			tfEntrada.clear();
			tfEntrada.setText(entradaDados.substring(0,entradaDados.length()-1));
			for(int i=0;i<(entradaDados.length()-1);i++){
				tfEntrada.forward();
			}
		}
	}

	public void textFieldFormatarTemperaturaKelvin(TextField tfEntrada,String maskEntrada){
		int nCasas = 0;
		String ch;
		String entradaDados = tfEntrada.getText().toString();
		if(tfEntrada.getText().equals(""))	textFieldSaida.clear();
		
		nCasas = 50;
		if(tfEntrada.getText().length()>1 && tfEntrada.getText().length()<nCasas){
			ch = Character.toString(entradaDados.charAt(entradaDados.length()-1));
			if(ch.equals("0") || ch.equals("1") || ch.equals("2") || ch.equals("3") || ch.equals("4") || ch.equals("5") || ch.equals("6") || ch.equals("7") || ch.equals("8") || ch.equals("9")){
				Temperatura objTemperatura = new Temperatura(listViewUnidadeEntrada.getSelectionModel().getSelectedItem(), Double.parseDouble(entradaDados), listViewUnidadeSaida.getSelectionModel().getSelectedItem());
				FormatadorSaida objFormatador = new FormatadorSaida(Double.toString(objTemperatura.getResultadoConversao()),numeroDeCasasDecimais,true);
				textFieldSaida.setText(""+objFormatador.getNovoNumeroFormatado());
			}else if(entradaDados.charAt(entradaDados.length()-1) == '.'){
				int ponto = 0;
				for(int i=0;i<entradaDados.length();i++){
					if(entradaDados.charAt(i)=='.') ponto ++;
				}
				if(ponto > 1){
					tfEntrada.clear();
					tfEntrada.setText(entradaDados.substring(0,entradaDados.length()-1));
					for(int i=0;i<(entradaDados.length()-1);i++){
						tfEntrada.forward();
					}
				}
			}else{
				tfEntrada.clear();
				tfEntrada.setText(entradaDados.substring(0,entradaDados.length()-1));
				for(int i=0;i<(entradaDados.length()-1);i++){
					tfEntrada.forward();
				}
			}
		//IF SE A ENTRADA TEM MAIS QUE 1 CHAR
		}else if(tfEntrada.getText().length()==1){
			ch = entradaDados;
			if(!ch.equals("0") && !ch.equals("1") && !ch.equals("2") && !ch.equals("3") && !ch.equals("4") && !ch.equals("5") && !ch.equals("6") && !ch.equals("7") && !ch.equals("8") && !ch.equals("9"))
				tfEntrada.clear();
			else{
				Temperatura objTemperatura = new Temperatura(listViewUnidadeEntrada.getSelectionModel().getSelectedItem(), Double.parseDouble(entradaDados), listViewUnidadeSaida.getSelectionModel().getSelectedItem());
				FormatadorSaida objFormatador = new FormatadorSaida(Double.toString(objTemperatura.getResultadoConversao()),numeroDeCasasDecimais,true);
				textFieldSaida.setText(""+objFormatador.getNovoNumeroFormatado());
			}
			//ELSE SE A ENTRADA FOR IGUAL A 1
		}else if(tfEntrada.getText().length()>=nCasas){
			tfEntrada.clear();
			tfEntrada.setText(entradaDados.substring(0,entradaDados.length()-1));
			for(int i=0;i<(entradaDados.length()-1);i++){
				tfEntrada.forward();
			}
		}
		
	}
	
	public void textFieldFormatarAngulo(TextField tfEntrada,String maskEntrada){
		int nCasas = 0;
		String ch;
		String entradaDados = tfEntrada.getText().toString();
		if(tfEntrada.getText().equals(""))	textFieldSaida.clear();
		
		nCasas = 50;
		if(tfEntrada.getText().length()>1 && tfEntrada.getText().length()<nCasas){
			ch = Character.toString(entradaDados.charAt(entradaDados.length()-1));
			if(ch.equals("0") || ch.equals("1") || ch.equals("2") || ch.equals("3") || ch.equals("4") || ch.equals("5") || ch.equals("6") || ch.equals("7") || ch.equals("8") || ch.equals("9")){
				Angulo objAngulo = new Angulo(listViewUnidadeEntrada.getSelectionModel().getSelectedItem(), Double.parseDouble(entradaDados), listViewUnidadeSaida.getSelectionModel().getSelectedItem());
				FormatadorSaida objFormatador = new FormatadorSaida(Double.toString(objAngulo.getResultadoConversao()),numeroDeCasasDecimais,true);
				textFieldSaida.setText(""+objFormatador.getNovoNumeroFormatado());
			}else if(entradaDados.charAt(entradaDados.length()-1) == '.'){
				int ponto = 0;
				for(int i=0;i<entradaDados.length();i++){
					if(entradaDados.charAt(i)=='.') ponto ++;
				}
				if(ponto > 1){
					tfEntrada.clear();
					tfEntrada.setText(entradaDados.substring(0,entradaDados.length()-1));
					for(int i=0;i<(entradaDados.length()-1);i++){
						tfEntrada.forward();
					}
				}
			}else{
				tfEntrada.clear();
				tfEntrada.setText(entradaDados.substring(0,entradaDados.length()-1));
				for(int i=0;i<(entradaDados.length()-1);i++){
					tfEntrada.forward();
				}
			}
		//IF SE A ENTRADA TEM MAIS QUE 1 CHAR
		}else if(tfEntrada.getText().length()==1){
			ch = entradaDados;
			if(!ch.equals("0") && !ch.equals("1") && !ch.equals("2") && !ch.equals("3") && !ch.equals("4") && !ch.equals("5") && !ch.equals("6") && !ch.equals("7") && !ch.equals("8") && !ch.equals("9"))
				tfEntrada.clear();
			else{
				Angulo objAngulo = new Angulo(listViewUnidadeEntrada.getSelectionModel().getSelectedItem(), Double.parseDouble(entradaDados), listViewUnidadeSaida.getSelectionModel().getSelectedItem());
				FormatadorSaida objFormatador = new FormatadorSaida(Double.toString(objAngulo.getResultadoConversao()),numeroDeCasasDecimais,true);
				textFieldSaida.setText(""+objFormatador.getNovoNumeroFormatado());
			}
			//ELSE SE A ENTRADA FOR IGUAL A 1
		}else if(tfEntrada.getText().length()>=nCasas){
			tfEntrada.clear();
			tfEntrada.setText(entradaDados.substring(0,entradaDados.length()-1));
			for(int i=0;i<(entradaDados.length()-1);i++){
				tfEntrada.forward();
			}
		}
	}
		
	public void textFieldFormatarComprimento(TextField tfEntrada,String maskEntrada){
		int nCasas = 0;
		String ch;
		String entradaDados = tfEntrada.getText().toString();
		if(tfEntrada.getText().equals(""))	textFieldSaida.clear();
		
		nCasas = 50;
		if(tfEntrada.getText().length()>1 && tfEntrada.getText().length()<nCasas){
			ch = Character.toString(entradaDados.charAt(entradaDados.length()-1));
			if(ch.equals("0") || ch.equals("1") || ch.equals("2") || ch.equals("3") || ch.equals("4") || ch.equals("5") || ch.equals("6") || ch.equals("7") || ch.equals("8") || ch.equals("9")){
				Comprimento objComprimento = new Comprimento(listViewUnidadeEntrada.getSelectionModel().getSelectedItem(), Double.parseDouble(entradaDados), listViewUnidadeSaida.getSelectionModel().getSelectedItem());
				FormatadorSaida objFormatador = new FormatadorSaida(Double.toString(objComprimento.getResultadoConversao()),numeroDeCasasDecimais,true);
				textFieldSaida.setText(""+objFormatador.getNovoNumeroFormatado());
			}else if(entradaDados.charAt(entradaDados.length()-1) == '.'){
				int ponto = 0;
				for(int i=0;i<entradaDados.length();i++){
					if(entradaDados.charAt(i)=='.') ponto ++;
				}
				if(ponto > 1){
					tfEntrada.clear();
					tfEntrada.setText(entradaDados.substring(0,entradaDados.length()-1));
					for(int i=0;i<(entradaDados.length()-1);i++){
						tfEntrada.forward();
					}
				}
			}else{
				tfEntrada.clear();
				tfEntrada.setText(entradaDados.substring(0,entradaDados.length()-1));
				for(int i=0;i<(entradaDados.length()-1);i++){
					tfEntrada.forward();
				}
			}
		//IF SE A ENTRADA TEM MAIS QUE 1 CHAR
		}else if(tfEntrada.getText().length()==1){
			ch = entradaDados;
			if(!ch.equals("0") && !ch.equals("1") && !ch.equals("2") && !ch.equals("3") && !ch.equals("4") && !ch.equals("5") && !ch.equals("6") && !ch.equals("7") && !ch.equals("8") && !ch.equals("9"))
				tfEntrada.clear();
			else{
				Comprimento objComprimento = new Comprimento(listViewUnidadeEntrada.getSelectionModel().getSelectedItem(), Double.parseDouble(entradaDados), listViewUnidadeSaida.getSelectionModel().getSelectedItem());
				FormatadorSaida objFormatador = new FormatadorSaida(Double.toString(objComprimento.getResultadoConversao()),numeroDeCasasDecimais,true);
				textFieldSaida.setText(""+objFormatador.getNovoNumeroFormatado());
			}
			//ELSE SE A ENTRADA FOR IGUAL A 1
		}else if(tfEntrada.getText().length()>=nCasas){
			tfEntrada.clear();
			tfEntrada.setText(entradaDados.substring(0,entradaDados.length()-1));
			for(int i=0;i<(entradaDados.length()-1);i++){
				tfEntrada.forward();
			}
		}
	}

	public void textFieldFormatarTemperaturaFC(TextField tfEntrada,String maskEntrada,double range){
		int nCasas = 0;
		String ch;
		String entradaDados = tfEntrada.getText().toString();
		if(tfEntrada.getText().equals(""))	textFieldSaida.clear();
		
		nCasas = 50;
		if(tfEntrada.getText().length()>1 && tfEntrada.getText().length()<nCasas){
			ch = Character.toString(entradaDados.charAt(entradaDados.length()-1));
			if(ch.equals("0") || ch.equals("1") || ch.equals("2") || ch.equals("3") || ch.equals("4") || ch.equals("5") || ch.equals("6") || ch.equals("7") || ch.equals("8") || ch.equals("9")){
				if(Double.parseDouble(entradaDados) >= range){
					Temperatura objTemperatura = new Temperatura(listViewUnidadeEntrada.getSelectionModel().getSelectedItem(), Double.parseDouble(entradaDados), listViewUnidadeSaida.getSelectionModel().getSelectedItem());
					FormatadorSaida objFormatador = new FormatadorSaida(Double.toString(objTemperatura.getResultadoConversao()),numeroDeCasasDecimais,true);
					textFieldSaida.setText(""+objFormatador.getNovoNumeroFormatado());
				}else{
					textFieldSaida.setText("Temperatura fora do range.");
				}
				
			}else if(entradaDados.charAt(entradaDados.length()-1) == '.'){
				int ponto = 0;
				for(int i=0;i<entradaDados.length();i++){
					if(entradaDados.charAt(i)=='.') ponto ++;
				}
				if(ponto > 1){
					tfEntrada.clear();
					tfEntrada.setText(entradaDados.substring(0,entradaDados.length()-1));
					for(int i=0;i<(entradaDados.length()-1);i++){
						tfEntrada.forward();
					}
				}
			}else{
				tfEntrada.clear();
				tfEntrada.setText(entradaDados.substring(0,entradaDados.length()-1));
				for(int i=0;i<(entradaDados.length()-1);i++){
					tfEntrada.forward();
				}
			}
		//IF SE A ENTRADA TEM MAIS QUE 1 CHAR
		}else if(tfEntrada.getText().length()==1){
			ch = entradaDados;
			if(!ch.equals("0") && !ch.equals("1") && !ch.equals("2") && !ch.equals("3") && !ch.equals("4") && !ch.equals("5") && !ch.equals("6") && !ch.equals("7") && !ch.equals("8") && !ch.equals("9") && !ch.equals("-"))
				tfEntrada.clear();
			else if(!ch.equals("-")){
				Temperatura objTemperatura = new Temperatura(listViewUnidadeEntrada.getSelectionModel().getSelectedItem(), Double.parseDouble(entradaDados), listViewUnidadeSaida.getSelectionModel().getSelectedItem());
				FormatadorSaida objFormatador = new FormatadorSaida(Double.toString(objTemperatura.getResultadoConversao()),numeroDeCasasDecimais,true);
				textFieldSaida.setText(""+objFormatador.getNovoNumeroFormatado());
			}
			//ELSE SE A ENTRADA FOR IGUAL A 1
		}else if(tfEntrada.getText().length()>=nCasas){
			tfEntrada.clear();
			tfEntrada.setText(entradaDados.substring(0,entradaDados.length()-1));
			for(int i=0;i<(entradaDados.length()-1);i++){
				tfEntrada.forward();
			}
		}
		
	}

	@FXML public void checkBoxAlwaysOnTop(ActionEvent event) {
		Stage stage = new Stage();
		BorderPane root;
		try {
			if(checkBoxAlwaysOnTop.isSelected()){
				Home2Controller.setarCheckBox(true);
				root = (BorderPane)FXMLLoader.load(getClass().getResource("/view/HomaLayout2.fxml"));
				Scene scene = new Scene(root,320,250);
				scene.getStylesheets().add(getClass().getResource("/view/application.css").toExternalForm());
				stage.setScene(scene);
				stage.setTitle("Conversor de Medidas");
				stage.getIcons().add(new Image(("file:calculator.jpg")));
				stage.setResizable(false);
				stage.setAlwaysOnTop(true);
				stage.show();
				((Node) (event.getSource())).getScene().getWindow().hide();
			}else{
				Home2Controller.setarCheckBox(false);
				root = (BorderPane)FXMLLoader.load(getClass().getResource("/view/HomaLayout2.fxml"));
				Scene scene = new Scene(root,320,250);
				scene.getStylesheets().add(getClass().getResource("/view/application.css").toExternalForm());
				stage.setScene(scene);
				stage.setTitle("Conversor de Medidas");
				stage.getIcons().add(new Image(("file:calculator.jpg")));
				stage.setResizable(false);
				stage.setAlwaysOnTop(false);
				stage.show();
				((Node) (event.getSource())).getScene().getWindow().hide();
			}
		}catch (IOException e) {
		}
	}
	
	public static void setarCheckBox(boolean status){
		checkBoxStatus = status;
	}

	@FXML public void buttonClipboard(ActionEvent event) {
		if(!textFieldSaida.equals("")){
			final Clipboard clipboard = Clipboard.getSystemClipboard();
	        final ClipboardContent content = new ClipboardContent();
	        content.putString(textFieldSaida.getText());
	        clipboard.setContent(content);	
	        
	        Image img = new Image("file:imagens/confirm-notif-60-60.png");
			Notifications notificacao = Notifications.create().title("Àrea de Transferência")
					.text("Numero copiado com sucesso para a área de transferência!").graphic(new ImageView(img)).hideAfter(Duration.seconds(3))
					.position(Pos.CENTER).onAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							// System.out.println("Clicado nas notificacoes");
							// CAPTURAR EVENTO DE CLICK NO NOTIFICATION
						}

					}); 
			notificacao.darkStyle();
			notificacao.show(); 
		}
	}

	
}
