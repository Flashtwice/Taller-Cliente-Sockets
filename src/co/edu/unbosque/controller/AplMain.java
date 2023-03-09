package co.edu.unbosque.controller;

public class AplMain {
	
	public static void main(String[] args) {
		
		 Controller c = new Controller();
		 Cliente client = new Cliente("192.168.59.180", 5000); 
		 client.start();
	}

}
