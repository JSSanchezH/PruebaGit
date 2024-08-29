package main.test.com.miempresa.miapp;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import main.java.com.miempresa.miapp.DatabaseUser;
import main.java.com.miempresa.miapp.OperacionesUser;
import main.java.com.miempresa.miapp.User;

class OperacionesUserTest {
	
	@DisplayName("Probando OperacionesUserTest con datos mock")
	@Test
	void testGetUsuarios() {
		List<User> conocidos = new ArrayList<User>();
		conocidos.add(new User("Pepe", "Perez", "7622623", 24));
		conocidos.add(new User("Maria", "González", "34535", 21));
		
		DatabaseUser repoMock = Mockito.mock(DatabaseUser.class);
		OperacionesUser ope = new OperacionesUser(repoMock);
		
		when(repoMock.getUsuarios()).thenReturn(conocidos);
		List<User> listaUsuarios = ope.getUsuarios();
		assertNotNull(listaUsuarios);
		assertEquals(listaUsuarios, conocidos);
	}
	
	@DisplayName("Probando hallar un usuario por id con datos mock")
	@Test
	void testGetUsuariosPorIdEncontrado() {

		Optional<User> conocidos = Optional.of(new User("Pepe", "Perez", "7622623", 24));
		
		DatabaseUser repoMock = Mockito.mock(DatabaseUser.class);
		OperacionesUser ope = new OperacionesUser(repoMock);
		
		when(repoMock.getUsuariosPorId("7622623")).thenReturn(conocidos);
		Optional<User> listaUsuarios = ope.getUsuariosPorId("7622623");
		assertNotNull(listaUsuarios);
		assertEquals(listaUsuarios, conocidos);
	}
	
	@DisplayName("Probando usuario no encontrado por id con datos mock")
	@Test
	void testGetUsuariosPorIdNoEncontrado() {

		Optional<User> conocidos = Optional.empty();
		
		DatabaseUser repo = Mockito.mock(DatabaseUser.class);
		OperacionesUser ope = new OperacionesUser(repo);
		
		when(repo.getUsuariosPorId("7622623")).thenReturn(conocidos);
		Optional<User> listaUsuarios = ope.getUsuariosPorId("7622623");
		assertNotNull(listaUsuarios);
		assertEquals(listaUsuarios, conocidos);
		Mockito.verify(repo).getUsuariosPorId("7622623");
	}
	
	
	@DisplayName("Probando excepción cuando se busca un usuario por id")
	@Test
	void testGetUsuariosPorIdExcepcion() {
		DatabaseUser repo = Mockito.mock(DatabaseUser.class);
		OperacionesUser ope = new OperacionesUser(repo);
		assertThrows(IllegalArgumentException.class, () -> {
			ope.getUsuariosPorId("");
		}, "Bebería lanzarse IllegalArgumentException");
	}
	
}






