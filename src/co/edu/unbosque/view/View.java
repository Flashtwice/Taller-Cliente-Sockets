package co.edu.unbosque.view;

import java.util.Scanner;
/**
 * Esta clase se encarga de la vista al cliente para el manejo del programa
 * @author: Esteban Uribe Calderon
 * @version: 12/02/2023
 */
 public class View {
 	//Variables de la clase
	private Scanner reader;
	
	 /**
     * Constructor para el lector por consola
     */
	public View() {
		reader = new Scanner(System.in);
	}//cierre del Constructor
	
	/**
     * Metodo que lee un mensaje por consola
     * @param message El parametro message define el mensaje guia para recibir una entrada
     * @return Devuelve la entrada capturada
     */
	public String readInfo(String message) {
		String info = "";
		System.out.println(message);
		info = reader.nextLine();
		return info;
	}//Cierre del metodo
	
	/**
     * Metodo que muestra un mensaje por consola
     * @param message El parametro message define el mensaje a mostrar en pantalla
     */
	public void showMessage(String message) {
		System.out.println(message);
	}//Cierre del metodo
	
	
}//Cierre de la clase
