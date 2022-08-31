package br.com.alura.forum.modelo.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

public class EstabelecimentoDTO {

    private Integer id;
    @NotNull @NotEmpty @Length(max = 45)
    private String nome;
    @NotNull @NotEmpty @Length(max = 40)
    private String email;
    @NotNull @NotEmpty @Length(min = 10, max = 45)
    private String telefone;
    private List<ProdutoDTO> produtos;
    @Valid
    private EnderecoDTO endereco;

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

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstabelecimentoDTO that = (EstabelecimentoDTO) o;
        return id.equals(that.id) && nome.equals(that.nome) && email.equals(that.email) && Objects.equals(telefone, that.telefone) && Objects.equals(endereco, that.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, telefone, endereco);
    }

    @Override
    public String toString() {
        return "EstabelecimentoDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco=" + endereco +
                '}';
    }

    public List<ProdutoDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoDTO> produtos) {
        this.produtos = produtos;
    }
}
