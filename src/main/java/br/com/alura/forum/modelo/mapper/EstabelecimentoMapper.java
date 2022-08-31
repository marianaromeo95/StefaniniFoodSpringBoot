package br.com.alura.forum.modelo.mapper;

import br.com.alura.forum.modelo.Estabelecimento;
import br.com.alura.forum.modelo.dto.EstabelecimentoDTO;
import org.springframework.stereotype.Component;

@Component
public class EstabelecimentoMapper {

    public Estabelecimento converterParaEntidade(EstabelecimentoDTO estabelecimentoDTO) {
        Estabelecimento estabelecimento = new Estabelecimento();
        estabelecimento.setEmail(estabelecimentoDTO.getEmail());
        estabelecimento.setId(estabelecimentoDTO.getId());
        estabelecimento.setNome(estabelecimentoDTO.getNome());
        estabelecimento.setTelefone(estabelecimentoDTO.getTelefone());
        estabelecimento.setEndereco(new EnderecoMapper().converterParaEntidade(estabelecimentoDTO.getEndereco()));
        return estabelecimento;
    }

    public EstabelecimentoDTO converterEstabelecimentoParaDTO(Estabelecimento estabelecimento) {
        EstabelecimentoDTO estabelecimentoDTO = new EstabelecimentoDTO();
        estabelecimentoDTO.setEmail(estabelecimento.getEmail());
        estabelecimentoDTO.setId(estabelecimento.getId());
        estabelecimentoDTO.setNome(estabelecimento.getNome());
        estabelecimentoDTO.setTelefone(estabelecimento.getTelefone());
        estabelecimentoDTO.setEndereco(new EnderecoMapper().converterParaDTO(estabelecimento.getEndereco()));
        return estabelecimentoDTO;
    }
}
