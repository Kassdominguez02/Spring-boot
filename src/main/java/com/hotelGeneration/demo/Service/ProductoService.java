package com.hotelGeneration.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelGeneration.demo.Entity.Producto;
import com.hotelGeneration.demo.Repository.ProductoRepository;

@Service //anotacion, le decimos a la clase que es un servicio
public class ProductoService {
	
	//Para manejar la inyeccion de dependecias
	
	//Constante para el autowired
	
	public final ProductoRepository productoRepository;
	
	
	//Anotacion
	@Autowired
	
	// Constructor 
	
	public ProductoService(ProductoRepository productoRepository) {
		this.productoRepository=productoRepository;
	}//constructor

	
	//Metodos del CRUD para el manejo de Productos
	
	//Metodo para leer todos los productos
	
	
	public List<Producto>leerTodosLosProductos(){
		return productoRepository.findAll(); //busca todos los productos en el repository
	}//leerTodosLosProductos
	
	
	
	//metodo para leer un producto por su id
	
	public Optional<Producto>leerProductoID(Long id){
		return productoRepository.findById(id);
		
	}
	
	
	//metodo para crear un producto
	
	public Producto crearProducto(Producto producto) {
		
		
		Producto prodTemporal=null;
		
		if(productoRepository.findByNombre(producto.getNombre()).isEmpty()) {
			prodTemporal=productoRepository.save(producto);
			
		}else {
			// si el producto ya existe, imprimo mensaje de producto existente
			System.out.println("el producto ya existe");
		}
		
		return prodTemporal;
		
	}//crearproducto
	
	
	//Metodo para  modificar un producto
	
	public Producto actualizarProducto(Long id, String nombre, String descripcion, String imagen, Double precio) {
		
		Producto prodTemporal=null;
		//si el producto existe lo modifico
		if(productoRepository.existsById(id)) {
		//modifico paramentro
			
			prodTemporal=productoRepository.findById(id).get();
			if(nombre!=null)prodTemporal.setNombre(nombre);
			if(descripcion!=null)prodTemporal.setDescripcion(descripcion);
			if(imagen!=null)prodTemporal.setImagen(imagen);
			if(precio!=null)prodTemporal.setPrecio(precio);
			
			productoRepository.save(prodTemporal);
			
	}else {
		System.out.println("el producto no existe");
	}//cierre else
		
		return prodTemporal; //nulo o producto modificado
		
		//si el producto no existe, no se modifica y mando un msj que diga el producto no existe
		
		
	}//actualizar
	
	//metodo para borrar un producto
	
	
	public Producto borrarProducto(Long id) {
		Producto prodTemporal=null;
		
		// si el producto existe, lo borro
		if(productoRepository.existsById(id)) {
			prodTemporal=productoRepository.findById(id).get();
			productoRepository.deleteById(id);
		}//if
		
		return prodTemporal;
		
	}// borrarProducto
	
	
}//clase
