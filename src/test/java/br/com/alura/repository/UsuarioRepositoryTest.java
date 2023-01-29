package br.com.alura.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.alura.model.Usuario;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;

@QuarkusTest
class UsuarioRepositoryTest {

	@InjectMock
	UsuarioRepository usuarioRepository;

	@Test
	void testarSeListAllUsuariosCorretos() {
		
		Usuario u = new Usuario();
		u.setId(1l);
	
		Usuario u2 = new Usuario();
		u2.setId(2l);
		
		List<Usuario> list =  new ArrayList<>();
		list.add(u);
		list.add(u2);
		
		Mockito.when(usuarioRepository.listAll()).thenReturn(list);
		
		Assertions.assertSame(u2, usuarioRepository.listAll().get(1));
		
	}
}
