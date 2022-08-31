package br.com.alura.forum.modelo.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class EnderecoDTO {

    private Integer id;

    @NotNull @NotEmpty @Length(min = 5)
    private String endereco;

    @NotNull @NotEmpty
    private String numero;

    @NotNull @NotEmpty
    private String cidade;

    @NotNull @NotEmpty
    private String estado;

    @NotNull @NotEmpty @Length(max = 8)
    private String cep;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnderecoDTO that = (EnderecoDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(endereco, that.endereco) && Objects.equals(numero, that.numero) && Objects.equals(cidade, that.cidade) && Objects.equals(estado, that.estado) && Objects.equals(cep, that.cep);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, endereco, numero, cidade, estado, cep);
    }

    @Override
    public String toString() {
        return "EnderecoDTO{" +
                "id=" + id +
                ", endereco='" + endereco + '\'' +
                ", numero='" + numero + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
