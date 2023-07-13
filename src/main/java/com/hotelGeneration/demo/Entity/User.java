package com.hotelGeneration.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// anoracion para decirle a Java que esta es una clase mapeada a una BD

@Entity
@Table (name="usuario")// me dice a que tabla de la BD voy a conectar esta clase POJO; 

public class User {// POJO plain Old Java Object
	
	/* utilizamos el atributo static para el id, ya que sera convertido en una variable de instancia. Esto significa que la variable le pertenece a la clase  y no al objeto que la instancia. Esto nos ayuda a tener mejor control del contador, y que independientemente de la instancia, este valor siempre otorga la clase, asi evitamos id repetidos o saltados*/
	
	
	
	
	// propiedades o atributos
	
	//private static Long id=0L;// clase wrapper ID antes de la conexcion de BD

	
	@Id // decimos que la PK de la tabla es el atribito ID
	@GeneratedValue(strategy = GenerationType.IDENTITY) // para generar valores automaticos, en el campo id que es nuestra PK de la BD
	
	@Column(name="id", unique=true, nullable=false)
	
	private Long id; //ID despues de la conexion a BD
	public String nombre;
	public String apellido;
	public String email;
	public String telefono;
	
	
	/* utilizamos un contador id++ dentro del constructor para poder emular el atributo autoincrementable de nuestra columna id de la BD. cuando conectemos la BD  ya no necesitamos este dato en el contrsuctor*/
	
	// Modificamos el constructor para agregar el id al constructor como parametro de construccion, ya que ahora el id si le pertecene al objeto y se tiene q construir con el
	// constructor

public User( Long id, String nombre, String apellido, String email, String telefono) {
	//id++; // contador para emular el autoincrementable de los usarios
	this.id=id;
	this.nombre = nombre;
	this.apellido = apellido;
	this.email = email;
	this.telefono = telefono;
	
}



// contructor vacio

public User() {
	
	
}// constructor vacio


	//getter y setter



/*quitamos el setter para el id ya que el atributo no debera modificar*/

public long getId() {
	return id;
}




public String getNombre() {
	return nombre;
}





public void setNombre(String nombre) {
	this.nombre = nombre;
}





public String getApellido() {
	return apellido;
}





public void setApellido(String apellido) {
	this.apellido = apellido;
}





public String getEmail() {
	return email;
}





public void setEmail(String email) {
	this.email = email;
}





public String getTelefono() {
	return telefono;
}





public void setTelefono(String telefono) {
	this.telefono = telefono;
}



}// cierre class
