package br.com.gov.dma.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.gov.dma.entity.UsuarioEntity;
import br.com.gov.dma.service.UsuarioService;

@ManagedBean(name = "ListarUsuario")
@ViewScoped
public class ListarUsuarioController {
	
	UsuarioService usuarioService = new UsuarioService();
	
	//-- Variaveis dos filtros da tela
	private String nomeFiltro;
	private String cpfFiltro;
	private Date dataInicioFiltro;
	private Date dataFimFiltro;
	
	private List<UsuarioEntity> listaUsuariosFiltro = new ArrayList<UsuarioEntity>();
	
	public void filtrar() {
		
		listaUsuariosFiltro = 
				usuarioService.listarUsuariosFiltro(nomeFiltro, cpfFiltro, dataInicioFiltro, dataFimFiltro);
		
		if(listaUsuariosFiltro.isEmpty()) {
			
			//-- Nenhum usuario encontrado no filtro.. exibindo mensagem...
			FacesContext.getCurrentInstance().addMessage(
			         null,
			         new FacesMessage(FacesMessage.SEVERITY_INFO, "Nenhum usuário encontrado com os filtros informados!",
			           "Dados não encontrados!"));
		}
	}

	public void buscarPorCpf(String cpfTela) {
		try {
		
			UsuarioEntity usuario = 
					usuarioService.recuperarUsuarioPorCpf(cpfTela);
		
			System.out.println(usuario);
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
			         null,
			         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao recuperar usuário!",
			           "Erro ao recuperar usuário!"));
		}
	}
	
	public String getNomeFiltro() {
		return nomeFiltro;
	}

	public void setNomeFiltro(String nomeFiltro) {
		this.nomeFiltro = nomeFiltro;
	}

	public String getCpfFiltro() {
		return cpfFiltro;
	}

	public void setCpfFiltro(String cpfFiltro) {
		this.cpfFiltro = cpfFiltro;
	}

	public Date getDataInicioFiltro() {
		return dataInicioFiltro;
	}

	public void setDataInicioFiltro(Date dataInicioFiltro) {
		this.dataInicioFiltro = dataInicioFiltro;
	}

	public Date getDataFimFiltro() {
		return dataFimFiltro;
	}

	public void setDataFimFiltro(Date dataFimFiltro) {
		this.dataFimFiltro = dataFimFiltro;
	}



	public List<UsuarioEntity> getListaUsuariosFiltro() {
		return listaUsuariosFiltro;
	}

	public void setListaUsuariosFiltro(List<UsuarioEntity> listaUsuariosFiltro) {
		this.listaUsuariosFiltro = listaUsuariosFiltro;
	}
	
}
