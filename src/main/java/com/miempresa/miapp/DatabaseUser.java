package main.java.com.miempresa.miapp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class DatabaseUser implements UserRepositorio{
List<User> users; 
	
	public  DatabaseUser() {
		this.users = new ArrayList<User>();
		users.add(new User("Pepe", "Perez", "7622623", 24));
		users.add(new User("Maria", "González", "34535", 21));
	}
	
	@Override
	public List<User> getUsuarios() {
		return this.users;
	}
	
	@Override
	public Optional<User> getUsuariosPorId(String identificacion) {
	
		return this.users.stream().filter(
				user -> user.identificacion().equals(identificacion))
				.findFirst();
	}
}
