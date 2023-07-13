package com.hotelGeneration.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotelGeneration.demo.Entity.Producto;
import com.hotelGeneration.demo.Service.ProductoService;

@RestController //indica que es un controller
@RequestMapping (path="/hotelGeneration/productos")



//Anotacion cross origin
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,RequestMethod.PUT })

public class ProductoController {
	
	//inyeccion de dependecias
	
	//constante
	
	//modificador acceso+constante+nombredelaclase + nombreObjeto
	public final ProductoService productoService;
	
	//anotacion
	@Autowired
	
	//constructor
	
	public ProductoController(ProductoService productoService) {
		this.productoService=productoService;
	}

	//Metodos HTTP
	
	
	//Metodo Get TRAER TODOS LOS PRODUCTOS
	
	@GetMapping
	
	public List<Producto>getTodosLosProductos(){
		return productoService.leerTodosLosProductos();
	}
	
	// Metodo para traer un producto por Id
	
	@GetMapping(path="{prodId}")
	public Optional<Producto>getProducto(@PathVariable("prodId")Long id){
		return productoService.leerProductoID(id);
	}
	
	//Metodo POST para agregar productos
	
	@PostMapping
	public Producto postProducto(@RequestBody Producto producto) {
		return productoService.crearProducto(producto);
		
	}//post
	
	//Metodo put para modificar un producto
	
	@PutMapping (path="{prodId}") //el path para agregarle el id al endpoint
	public Producto updateProducto(@PathVariable("prodId")Long id, 
			@RequestParam (required=false) String nombre,
			@RequestParam (required=false)String descripcion, 
			@RequestParam (required=false)String imagen, 
			@RequestParam (required=false)Double precio) {
		
		return productoService.actualizarProducto(id, nombre, descripcion, imagen, precio);
		
	}// update
	
	//Metodo DELETE  para borra un producto por su Id
	
	@DeleteMapping (path="{prodId}")
	public Producto deleteProducto(@PathVariable("prodId")Long id) {
		return productoService.borrarProducto(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
