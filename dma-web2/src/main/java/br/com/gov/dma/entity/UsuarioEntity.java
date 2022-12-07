package br.com.gov.dma.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="usuario")
@NamedQuery(name="UsuarioEntity.findAll", query="SELECT u FROM UsuarioEntity u")
public class UsuarioEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String cpf;

	private String email;

	private String name;
	
	@Column(name="data_cadastro")
	private Calendar dataCadastro;
	

	//bi-directional many-to-many association to EnderecoEntity
	@ManyToMany(mappedBy="usuarios")
	private List<EnderecoEntity> enderecos;

	//bi-directional many-to-one association to PerfilEntity
	@ManyToOne
	@JoinColumn(name="id_perfil")
	private PerfilEntity perfil;

	public UsuarioEntity() {
		this.perfil = new PerfilEntity();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EnderecoEntity> getEnderecos() {
		return this.enderecos;
	}

	public void setEnderecos(List<EnderecoEntity> enderecos) {
		this.enderecos = enderecos;
	}

	public PerfilEntity getPerfil() {
		return this.perfil;
	}

	public void setPerfil(PerfilEntity perfil) {
		this.perfil = perfil;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
}