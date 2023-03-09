package co.edu.unbosque.model;

import java.util.ArrayList;

/**
 * Esta clase se encarga de los metodos CRUD para la lista de Candidatos
 * @author: Esteban Uribe Calderon
 * @version: 12/02/2023
 */

public class EmployeeCRUD {
	//variables de la clase
	private ArrayList<Candidate> list;
	private Candidate candidate;
	 /**
     * Constructor para la lista que guardara los candidatos
     */
	public EmployeeCRUD() {
		
		list = new ArrayList<>();
	}// Cierre del Constructor
	
    /**
     * Metodo que crea o agrega un nuevo candidato a la lista
     * @param name El parametro name define el nombre del candidato a agregar
     * @param lastName El parametro lastName define el apellido del candidato a agregar
     * @param id El parametro id define la cedula del candidato a agregar
     * @param age El parametro age define la edad del candidato a agregar
     * @param workStation El parametro workStation define el cargo del candidato a agregar
     */
	public void create(String name, String lastName, String id, String age, String workStation) {
		
		candidate = new Candidate(name, lastName, id, age, workStation);
		list.add(candidate);
	} // Cierre del metodo
	
	 /**
     * Metodo que elimina un candidato de la lista
     * @param id El parametro id define la cedula a buscar del candidato a eliminar
     */
	public void delete(String id) {
		
		for(int i=0; i<list.size(); i++ ) {
			if(id.equals(list.get(i).getId())) {
				list.remove(i);
			}
		}
	} // Cierre del metodo
	
	 /**
     * Metodo que lee y devuelve el candidato a buscar
     * @return Los datos del candidato buscado 
     */
	public String read(String id) {
		
		String result = null;
		
		for(int i=0; i<list.size(); i++) {
			if(id.equals(list.get(i).getId())) {
				result = "El candidato buscado es: [Nombre = " + list.get(i).getName() + ", Apellido = " + list.get(i).getLastName() + ", Cedula = " + list.get(i).getId() + ", edad = " + list.get(i).getAge() + ", cargo = "
						+ list.get(i).getWorkStation()+ "]";;
			}
		}
		return result;
	} // Cierre del metodo
	
	/**
     * Metodo que actualza o modifica los datos de un candidato
     * @param id El parametro id define la cedula del candidato a modificar
     * @param newName El parametro newName define el nuevo nombre del candidato
     * @param newLastName El parametro newName define el nuevo nombre del candidato
     * @param newId El parametro newName define el nuevo nombre del candidato
     * @param newAge El parametro newName define el nuevo nombre del candidato
     * @param newWorkStation El parametro newName define el nuevo nombre del candidato
     */
	public void update(String id, String newName, String newLastName, String newId, String newAge, String newWorkStation) {
		
		for(int i=0; i<list.size(); i++ ) {
			if(id.equals(list.get(i).getId())) {
				list.get(i).setName(newName);
				list.get(i).setLastName(newLastName);
				list.get(i).setId(newId);
				list.get(i).setAge(newAge);
				list.get(i).setWorkStation(newWorkStation);
				}
		}
	} // Cierre del metodo
	   /**
     * Metodo que muestra todos los candidatos
     */
	public void showList() {
		System.out.println("\nLos candidatos de la lista son:\n");
		int i = 0;
		for(i=0; i<list.size(); i++){
			
				System.out.println("\n"+"Candidato "+ (i+1) +"\n"+"Nombre: " 
						+list.get(i).getName()+"\nApellido: "
						+list.get(i).getLastName()+"\nCedula: "
						+list.get(i).getId()+"\nEdad: "
						+list.get(i).getAge()+"\nCargo: "
						+list.get(i).getWorkStation());
		}		
	} // Cierre del metodo

}//Cierre de la clase
