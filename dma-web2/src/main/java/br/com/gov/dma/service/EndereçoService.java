package br.com.gov.dma.service;

import java.util.List;

import br.com.gov.dma.entity.EnderecoEntity;
import br.com.gov.dma.repository.EnderecoRepository;

public class EndereçoService {
	
	EnderecoRepository enderecoRepository = new EnderecoRepository();
	
	public void criarNovoEndereco(EnderecoEntity novoEndereco) throws Exception{
		
		enderecoRepository.criarNovoEndereco(novoEndereco);
		
	}
	
	public List<EnderecoEntity> listarEndereco(String cep, String logradouro){
		
		return enderecoRepository.listarEndereco(cep, logradouro);
		
	}
			
	public EnderecoEntity buscarEndereco(String cep) {
		
		
		return enderecoRepository.buscarEndereco(cep);
		
	}
	
	public void atualizaEndereco(EnderecoEntity endereco) throws Exception{
		
		enderecoRepository.atualizaEndereco(endereco);
		
	}
	
	public void removeEndereco(EnderecoEntity endereco) throws Exception {
		enderecoRepository.removeEndereco(endereco);
		
		
	}

}
