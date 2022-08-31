package br.com.alura.forum.modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Estabelecimento implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 8844422391791268646L;

	@Id
	@GeneratedValue
	private Integer id;

	private String nome;
	private String email;
	private String telefone;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "estabelecimento")
	private List<Produto> produtos;
	
	public Estabelecimento() {
		endereco = new Endereco();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Estabelecimento that = (Estabelecimento) o;
		return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(email, that.email) && Objects.equals(telefone, that.telefone) && Objects.equals(endereco, that.endereco) && Objects.equals(produtos, that.produtos);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, email, telefone, endereco, produtos);
	}

	@Override
	public String toString() {
		return "Estabelecimento{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", email='" + email + '\'' +
				", telefone='" + telefone + '\'' +
				", endereco=" + endereco +
				", produtos=" + produtos +
				'}';
	}


}
