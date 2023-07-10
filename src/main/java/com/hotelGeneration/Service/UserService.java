package com.hotelGeneration.Service;

import org.springframework.stereotype.Service; // importacion de la libreria de spring
import java.util.ArrayList;
import java.util.List;
import com.hotelGeneration.Entity.User;

/*Recuerda que la capa services, se encarga de definir la logica de negocio del lado de Java (aqui es donde vamos a definir los metodos enfocados a las operaciones del CRUD que seran desparados por metodos HTTP que se encontraran en el controller)*/


// anotaciones son instrucciones que le damos a Java para que sepa hacer algo( @test, @Override)



@Service // usamos la anotacion service para decirle a Java que esta clase es un servicio
public class UserService {
	
	
	// emular una pqueña base de datos usando un ArrayList
	
	public List<User> listaDeUsuarios=new ArrayList<User>();
	
	// creo un metodo llamado UserService que me permita agregar info a mi lista
	
	public UserService() {
	//intancias de personas
	
	
	 listaDeUsuarios.add(new User ("Felipe", "Maqueda", "felipe@mail.com", "5512345678"));
	 listaDeUsuarios.add(new User ("Mariana", "Valladolid", "mariana@mail.com", "3312312312"));
	 listaDeUsuarios.add(new User ("Naruto", "Uzumaki", "naruto@mail.com", "5598765432"));
	}
	
	
	// metodo crud
	
	// metodo para traer todos los usuarios
	
	//Metodos CRUD para poder iterar sobre esos usuarios
		public List<User> readUsuarios(){
			return listaDeUsuarios;
		}

}// cierre clase
