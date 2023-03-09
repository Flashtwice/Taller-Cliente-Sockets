package co.edu.unbosque.model;
/**
 * Esta clase se encarga de todos los atributos de un candidato
 * @author: Esteban Uribe Calderon
 * @version: 12/02/2023
 */
public class Candidate {
	//Variables de la clase
	private String name;
	private String lastName;
	private String id;
	private String age;
	private String workStation;
	
	 /**
     * Constructor para la lista que guardara los candidatos
     * @param name El parametro name define el nombre del candidato a agregar
     * @param lastName El parametro lastName define el apellido del candidato a agregar
     * @param id El parametro id define la cedula del candidato a agregar
     * @param age El parametro age define la edad del candidato a agregar
     * @param workStation El parametro workStation define el cargo del candidato a agregar
     */
	public Candidate(String name, String lastName, String id, String number, String workStation) {
		this.name = name;
		this.lastName = lastName;
		this.id = id;
		this.age = number;
		this.workStation = workStation;
	} //Cierre del Constructor

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getWorkStation() {
		return workStation;
	}

	public void setWorkStation(String workStation) {
		this.workStation = workStation;
	}
	
	@Override
	public String toString() {
		return "Candidatos [Nombre = " + name + ", Apellido = " + lastName + ", Cedula = " + id + ", edad = " + age + ", cargo = "
				+ workStation + "]";
	}
	
	
	

}//Cierre de la clase
