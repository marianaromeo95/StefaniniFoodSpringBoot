package br.com.alura.forum.modelo.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class ProdutoDTO {

    private Integer id;
    @NotNull @NotEmpty @Length(min = 3, max = 40)
    private String nome;
    @NotNull
    private Double preco;
    private Integer estabelecimentoId;

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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getEstabelecimentoId() {
        return estabelecimentoId;
    }

    public void setEstabelecimentoId(Integer estabelecimentoId) {
        this.estabelecimentoId = estabelecimentoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoDTO that = (ProdutoDTO) o;
        return id.equals(that.id) && nome.equals(that.nome) && Objects.equals(preco, that.preco) && estabelecimentoId.equals(that.estabelecimentoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, preco, estabelecimentoId);
    }

    @Override
    public String toString() {
        return "ProdutoDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", estabelecimentoId=" + estabelecimentoId +
                '}';
    }
}
