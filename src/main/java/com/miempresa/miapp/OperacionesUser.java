package main.java.com.miempresa.miapp;

import java.util.List;
import java.util.Optional;

public class OperacionesUser implements UserService {
	DatabaseUser data;
	
	public OperacionesUser(DatabaseUser data) {
		this.data = data;
	}
	
	@Override
	public List<User> getUsuarios() {
		return this.data.getUsuarios();
	}
	
	@Override
	public Optional<User> getUsuariosPorId(String identificacion) {
		if (identificacion == null || identificacion.isEmpty()) {
			throw new IllegalArgumentException();
		}
		return this.data.getUsuariosPorId(identificacion);
	}
}
