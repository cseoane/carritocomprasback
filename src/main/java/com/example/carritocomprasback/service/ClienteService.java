package com.example.carritocomprasback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.carritocomprasback.entity.Cliente;
import com.example.carritocomprasback.repository.ClienteRepository;

@Service
public class ClienteService {

	private ClienteRepository repository;
	
	@Autowired
	public ClienteService(ClienteRepository repository) {
		this.repository = repository;
	}
	
	public Cliente saveCliente(Cliente Cliente) {
		return repository.save(Cliente);
	}
	
	public List<Cliente> saveClientes(List<Cliente> Clientes) {
		return repository.saveAll(Clientes);
	}
	
	public List<Cliente> getClientes() {
		return repository.findAll();
	}
	
	public Cliente getClienteById(Integer idCliente) {
		return repository.findById(idCliente).orElse(null);
	}

	public void destroyClienteById(int id) {
		repository.deleteById(id);
	}

	public Cliente updateClienteById(Cliente Cliente, int id) {
		Cliente ClienteActual = repository.getOne(id);
		if(!Cliente.getNombre().isEmpty()) {ClienteActual.setNombre(Cliente.getNombre());}
		return repository.save(ClienteActual);
	}

	public Cliente findClienteByMail(String mail) {
		// TODO Auto-generated method stub
		return null;
	}
}
