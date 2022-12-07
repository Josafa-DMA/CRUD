package br.com.gov.dma.service;

import java.util.Date;
import java.util.List;

import br.com.gov.dma.entity.UsuarioEntity;
import br.com.gov.dma.repository.UsuarioRepository;

public class UsuarioService {
	
	UsuarioRepository usuarioRepository = new UsuarioRepository();
	
	public List<UsuarioEntity> listarUsuariosFiltro(String nome, String cpf, Date dataInicio, Date dataFinal) {
		return usuarioRepository.listarUsuariosFiltro(nome, cpf, dataInicio, dataFinal);
	}
	
	
	public void cadastrarNovoUsuario(UsuarioEntity novoUsuario) 
	throws Exception {
		usuarioRepository.criarNovoUsuario(novoUsuario);
	}
	
	
	public UsuarioEntity recuperarUsuarioPorCpf(String cpf) 
	throws Exception {
		return usuarioRepository.buscarUsuario(cpf);
	}
	
	public UsuarioEntity recuperarUsuario(UsuarioEntity usuario) {
		return usuarioRepository.buscarUsuario(usuario);
	}
	
	public void removerUsuario(UsuarioEntity usuario) throws Exception{
		usuarioRepository.removeUsuario(usuario);
	}
	
	public void atualizarUsuario(UsuarioEntity usuario) throws Exception{
		usuarioRepository.atualizaUsuario(usuario);
	}
	
	

	
	
	
}
