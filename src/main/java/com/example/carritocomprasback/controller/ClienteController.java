package com.example.carritocomprasback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.carritocomprasback.entity.Cliente;
import com.example.carritocomprasback.service.ClienteService;

@CrossOrigin(origins = "http://localhost:4200",maxAge=3600)
@RestController
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	@PostMapping("/API/cliente")
	public Cliente addCliente(@RequestBody Cliente cliente) {
		return service.saveCliente(cliente);
	}
	
	@GetMapping("/API/clientes")
	public List<Cliente> findAllClientes() {
		return service.getClientes();
	}
	
	@GetMapping("/API/cliente/{id}")
	public Cliente findClienteById(@PathVariable int id) {
		return service.getClienteById(id);
	}
	
	@GetMapping("/API/cliente/bymail/{mail}")
	public Cliente findClienteByMail(@PathVariable String mail) {
		return service.findClienteByMail(mail);
	}
	
	@PutMapping("/API/cliente/{id}")
	public Cliente updateClienteById(@RequestBody Cliente cliente, @PathVariable int id) {
		return service.updateClienteById(cliente, id);
	}

}
