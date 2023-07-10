package com.hotelGeneration.Entity;

public class User {
	
	/* utilizamos el atributo static para el id, ya que sera convertido en una variable de instancia. Esto significa que la variable le pertenece a la clase  y no al objeto que la instancia. Esto nos ayuda a tener mejor control del contador, y que independientemente de la instancia, este valor siempre otorga la clase, asi evitamos id repetidos o saltados*/
	
	
	
	
	// propiedades o atributos
	
	private static Long id=0L;// clase wrapper
	public String nombre;
	public String apellido;
	public String email;
	public String telefono;
	
	
	/* utilizamos un contador id++ dentro del constructor para poder emular el atributo autoincrementable de nuestra columna id de la BD. cuando conectemos la BD  ya no necesitamos este dato en el contrsuctor*/
	
	
	// constructor

public User( String nombre, String apellido, String email, String telefono) {
	id++; // contador para emular el autoincrementable de los usarios
	this.nombre = nombre;
	this.apellido = apellido;
	this.email = email;
	this.telefono = telefono;
	
}
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
