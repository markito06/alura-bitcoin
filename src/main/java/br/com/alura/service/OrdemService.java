package br.com.alura.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;

import br.com.alura.exception.BussinessException;
import br.com.alura.model.Ordem;
import br.com.alura.model.Usuario;
import br.com.alura.repository.OrdemRepository;
import br.com.alura.repository.UsuarioRepository;

@ApplicationScoped
public class OrdemService {

	@Inject
	private OrdemRepository ordemRepository;
	
	@Inject
	private UsuarioRepository usuarioRepository;

	public void salvarOrdem(final SecurityContext securityContext, Ordem ordem) {
			
		Usuario usuario = usuarioRepository.findByIdOptional(ordem.getUserId()).orElseThrow();
		if(!usuario.getUsername().equals(securityContext.getUserPrincipal().getName())) {
			throw new BussinessException("Usuario logado é diferente do que está chegando na Ordem");
		}
		
		ordem.setData(LocalDateTime.now());
		ordem.setStatus("ENVIADA");
		ordemRepository.persist(ordem);
		
	}

	public List<Ordem> listar() {
		return ordemRepository.listAll();
	}
	
	
}
