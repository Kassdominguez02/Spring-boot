package com.hotelGeneration.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.hotelGeneration.demo.Entity.User;
import com.hotelGeneration.demo.Service.UserService;

/*
 Controller es quien lleva todo el peso referente a las solicitudes HTTP (es el mesero de nuestro restaurante)
 aqui suecede la manipulacion de los metodos HTTP (get, post, put, delete).
 
 * Para poder decirle a JAVA que esta clase es un controller, necesitamos usar la anotacion @RestController. Esto nos ayudara a poder manejar solicitudes HTTP, y ademas con esta anotacion podremos manejar el fetch que tengamos en nuestro front.*/


@RequestMapping (path="/hotelGeneration/users")// contrsui la ruta de nuestra API
@RestController // usamos esta anotacion para decirle que es una API del tipo REST (que trabaja con metodos HTTP)
public class UserController {
	
	// creo una Instancia de la clase  Userservice para que el controlador sepa la info del servicio
	
	private final UserService userService;
	
	@Autowired
	
	// Creo  un constructor para mi UserController, tomara como argumento la instancia del user service
	public UserController(UserService userService) {
		this.userService= userService;
	}// contructor que utiliza la instancia del service como parametro.
	
	
	/*
     * Ya que mi Controller depende de mi Service (con la instancia de UserService dentro de UserController), podre establecer los metodos HTTP que disparan las operaciones del CRUD (Controller - Service)
     */
	
	
	//Metods HTTP 
	@GetMapping
	
	public List<User> getUsuarios(){
		return userService.readUsuarios();
		}
	
	

}
