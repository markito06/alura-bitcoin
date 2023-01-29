package br.com.alura.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.alura.model.Usuario;
import br.com.alura.repository.UsuarioRepository;
import io.quarkus.elytron.security.common.BcryptUtil;

@ApplicationScoped
public class UsuarioService {

	@Inject
	private UsuarioRepository usuarioRepository;
	
	
	public void inserir(Usuario usuario) {
		usuario.setPassword(BcryptUtil.bcryptHash(usuario.getPassword()));
		usuario.setRole(validarUsername(usuario.getUsername()));
		
		usuarioRepository.persist(usuario);
	}
	
	
	public List<Usuario> listar(){
		return usuarioRepository.listAll();
	}
	
	private String validarUsername(String username) {
		if("alura".equals(username)) {
			return "admin";
		}
		return "user";
	}
	
	
}
