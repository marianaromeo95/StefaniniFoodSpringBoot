package br.com.alura.forum.modelo.mapper;

import br.com.alura.forum.modelo.Endereco;
import br.com.alura.forum.modelo.dto.EnderecoDTO;

public class EnderecoMapper {
    public Endereco converterParaEntidade(EnderecoDTO enderecoDTO) {
        Endereco endereco = new Endereco();
        endereco.setEndereco(enderecoDTO.getEndereco());
        endereco.setCep(enderecoDTO.getCep());
        endereco.setCidade(enderecoDTO.getCidade());
        endereco.setEstado(enderecoDTO.getEstado());
        endereco.setNumero(enderecoDTO.getNumero());
        endereco.setId(enderecoDTO.getId());
        return endereco;
    }

    public EnderecoDTO converterParaDTO(Endereco endereco) {
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setEndereco(endereco.getEndereco());
        enderecoDTO.setCep(endereco.getCep());
        enderecoDTO.setCidade(endereco.getCidade());
        enderecoDTO.setEstado(endereco.getEstado());
        enderecoDTO.setNumero(endereco.getNumero());
        enderecoDTO.setId(endereco.getId());
        return enderecoDTO;
    }
}
