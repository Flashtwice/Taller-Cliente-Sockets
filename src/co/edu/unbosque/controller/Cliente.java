package co.edu.unbosque.controller;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.edu.unbosque.model.CajaPC;
import co.edu.unbosque.model.Entrenador;
import co.edu.unbosque.model.EquipoPokemon;
import co.edu.unbosque.model.Pokemon;
import co.edu.unbosque.view.ConsoleUtil;

public class Cliente {
    private static final int PUERTO = 5000;
    private static final String IP = "localhost";

    private static Socket socket;
    private static ObjectInputStream entrada;
    private static ObjectOutputStream salida;
    private static ConsoleUtil view;
    
    static ArrayList<EquipoPokemon> equipos;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCaja = 0;
    	int numPokemon = 0;
        try {
            // Conectar al servidor
            socket = new Socket(IP, PUERTO);
            entrada = new ObjectInputStream(socket.getInputStream());
            salida = new ObjectOutputStream(socket.getOutputStream());

            // Solicitar el nombre del entrenador
            System.out.println("Ingrese su nombre de entrenador:");
            String nombreEntrenador = scanner.nextLine();

            // Crear un objeto Entrenador con el nombre ingresado
            // Agregar un Pokémon al equipo del entrenador
            EquipoPokemon equipo = new EquipoPokemon();
            int[] estadisticaBase = {23, 42,34,54};
            String[] ataque = {"Hola", "bola", "hed"};
            Pokemon p = new Pokemon("Pikachu", 12, estadisticaBase, ataque );
            equipo.agregarPokemon(p);
            Entrenador entrenador = new Entrenador(equipo);

            // Enviar el entrenador al servidor
            salida.writeObject(entrenador);

            // Recibir los equipos de la caja 1 del PC del entrenador
            equipos = (ArrayList<EquipoPokemon>) entrada.readObject();
            System.out.println("Equipos de la caja 1:");
            for (EquipoPokemon eq : equipos) {
                System.out.println(eq);

            // Mostrar el menú principal
            while (true) {
                mostrarMenuPrincipal(entrenador);
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        // Capturar un Pokemon
                    	String nombre = view.readString("Ingrese nombre del pokemon a capturar");
                    	int nivel = view.readInteger("Ingrese nivel del pokemon");
                    	int estadisticas = view.readInteger("Ingrese cantidad de estadisticas");
                    	int[]estadistica = new int[estadisticas];
                    	for(int i=0; i<estadisticas; i++) {
                    	
                    		estadistica[i] = view.readInteger("Ingrese la estadistica "+i);
                    	}
                    	int numAtaques = view.readInteger("Ingrese numero de ataques a guardar");
                    	String[] ataques = new String[numAtaques];
                    	for(int i= 0; i<numAtaques; i++) {
                    		ataques[i] = view.readString("Ingrese el ataque "+i);
                    	}
                    	Pokemon pokeNew = new Pokemon(nombre, nivel, estadistica, ataques);
                        entrenador.capturarPokemon(p);
                        break;

                    case 2:
                    	
                    	numCaja = view.readInteger("Ingrese el numero de la caja al que quiere transferir");
                    	numPokemon = view.readInteger("Ingrese el numero del pokemon a transferir");
                        // Transferir un Pokemon del equipo a una caja en la PC
                        entrenador.transferirPokemonAEquipo(numCaja, numPokemon);;
                        break;

                    case 3:
                    	numCaja = view.readInteger("Ingrese el numero de la caja al que quiere transferir");
                    	numPokemon = view.readInteger("Ingrese el numero del pokemon a transferir");
                        // Transferir un Pokemon de una caja en la PC al equipo
                        entrenador.transferirPokemonAPC(numCaja, numPokemon);
                        break;

                    case 4:
                        // Liberar un Pokemon del equipo o una caja en la PC
                    	numPokemon = view.readInteger("Ingrese el numero del pokemon a liberar");
                        entrenador.liberarPokemon(numPokemon);
                        break;

                    case 5:
                        // Mostrar el equipo del entrenador
                        entrenador.mostrarEquipoEntrenador();
                        break;

                    case 6:
                        // Mostrar una caja de la PC
                    	numPokemon = view.readInteger("Ingrese el numero del pokemon a transferir");
                        entrenador.mostrarCajaPC(numCaja);
                        break;

                    case 7:
                        // Salir del programa
                        System.out.println("Adios!");
                        System.exit(0);

                    default:
                        System.out.println("Opcion no valida, intente de nuevo.");
                        break;
                }
            }

        }} catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Cerrar los recursos
            try {
                socket.close();
                entrada.close();
                salida.close();
                scanner.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void mostrarMenuPrincipal(Entrenador entrenador) {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("Entrenador: "  /*entrenador.getNombreEntrenador()*/);
        System.out.println("1. Capturar Pokemon");
        System.out.println("2. Transferir Pokemon del equipo a la PC");
        System.out.println("3. Transferir Pokemon de la PC al equipo");
        System.out.println("4. Liberar Pokemon");
        System.out.println("5. Mostrar equipo");
        System.out.println("6. Mostrar caja de la PC");
        System.out.println("7. Salir");
        System.out.println("=======================");
        System.out.println("Seleccione una opcion:");
    
    }
}


