package br.com.gov.dma.controller;

import java.util.Calendar;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.gov.dma.entity.UsuarioEntity;
import br.com.gov.dma.service.UsuarioService;

@ManagedBean(name = "UsuarioController")
@ViewScoped
public class CadastroUsuarioController {
	
	UsuarioService usuarioService = new UsuarioService();
	UsuarioEntity novoUsuario = new UsuarioEntity();
	
	public void cadastrarNovoUsuario() {
		
		
		try {
			novoUsuario.setDataCadastro(Calendar.getInstance());
			
			usuarioService.cadastrarNovoUsuario(novoUsuario);
			
			FacesContext.getCurrentInstance().addMessage(
			         null,
			         new FacesMessage(FacesMessage.SEVERITY_INFO, "Usu�rio cadastrado com sucesso!",
			           "Usu�rio cadastrado com sucesso!"));
			
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
			         null,
			         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao cadastrar o novo usu�rio!",
			           "Erro ao cadastrar usu�rio!"));
		}
		
	}

	public UsuarioEntity getNovoUsuario() {
		return novoUsuario;
	}

	public void setNovoUsuario(UsuarioEntity novoUsuario) {
		this.novoUsuario = novoUsuario;
	}
	
	
}
