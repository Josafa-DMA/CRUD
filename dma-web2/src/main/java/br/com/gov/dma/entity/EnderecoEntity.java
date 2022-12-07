package br.com.gov.dma.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the endereco database table.
 * 
 */
@Entity
@Table(name="endereco")
@NamedQuery(name="EnderecoEntity.findAll", query="SELECT e FROM EnderecoEntity e")
public class EnderecoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String cep;

	private String logradouro;

	//bi-directional many-to-many association to UsuarioEntity
	@ManyToMany
	@JoinTable(
		name="endereco_usuario"
		, joinColumns={
			@JoinColumn(name="id_endereco")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_usuario")
			}
		)
	private List<UsuarioEntity> usuarios;

	public EnderecoEntity() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return this.logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public List<UsuarioEntity> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<UsuarioEntity> usuarios) {
		this.usuarios = usuarios;
	}

}