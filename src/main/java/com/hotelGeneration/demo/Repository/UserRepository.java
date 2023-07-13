package com.hotelGeneration.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotelGeneration.demo.Entity.User;

@Repository // Anotation para convertir mi interface en un repository
public interface UserRepository extends JpaRepository<User, Long> {
	//query personalizada
	//@Query("SELECT usuario FROM User WHERE usuario.nombre=?1")
	//Optional <User>encontrarPorEmail(String email);
	
}

//T type-ID identificador

/*Un Optional es una clase que se utiliza paara representar un valor que puede o no existir. Es decir, cuando se usa el Optional puede o no contener un objeto, asi tenemos la seguridad de que el obejto no sera nulo o undefined (objeto vacio). Esto evita errores en tiempo de ejecucion.*/

	//clase abstracta tiene metodos abstactos y metodos concretos
	//interface solo tiene metodos abstractos
	
	// Contratos que metodos si o si se tienen que implementar(abstractos)
	
	/*JPQL (Java persistance Query Language)
	 * 
	 * 
	 * Es practicamente lo mismo que trabajar con SQL, solo que en lugar de trabajar con tablas y columnas, trabajamos con entidades y atributos (POJOS y repositorios)*/
