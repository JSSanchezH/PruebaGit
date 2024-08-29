package main.java.com.miempresa.miapp;
import java.util.List;
import java.util.Optional;


public interface UserRepositorio {
	List<User> getUsuarios();
	Optional<User> getUsuariosPorId(String identificacion);
}
