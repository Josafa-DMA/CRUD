package br.com.gov.dma.service;

import java.util.List;

import br.com.gov.dma.entity.PerfilEntity;
import br.com.gov.dma.repository.PerfilRepository;


public class PerfilService {
	
	PerfilRepository perfilRepository = new PerfilRepository();
	
	public void criarNovoPefil(PerfilEntity novoPerfil) throws Exception{
		
		perfilRepository.criarNovoPefil(novoPerfil);
		
	}
	
	public List<PerfilEntity> listarPerfil(Long id, String tipo){
		
		return	perfilRepository.listarPerfilFiltro(id, tipo);
		
	}
	
	public PerfilEntity buscarPerfil(Long id) {
		
		return perfilRepository.buscarPerfil(id);
	}
	
	public void atualizaPeffil(PerfilEntity perfil) throws Exception{
		
		perfilRepository.atualizaPeffil(perfil);
			
	}
		
	public void removePerfil(PerfilEntity perfil) throws Exception{
		
		perfilRepository.removePerfil(perfil);
			
	}
	
}





