package br.com.alura.forum.modelo.mapper;

import br.com.alura.forum.modelo.Produto;
import br.com.alura.forum.modelo.dto.ProdutoDTO;
import br.com.alura.forum.service.EstabelecimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    @Autowired
    EstabelecimentoService estabelecimentoService;



    public Produto converterParaEntidadeProduto(ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        produto.setNome(produtoDTO.getNome());
        produto.setId(produtoDTO.getId());
        produto.setPreco(produtoDTO.getPreco());
        produto.setEstabelecimento(estabelecimentoService.buscarEstabelecimentosId(produtoDTO.getEstabelecimentoId()));
        return produto;
    }

    public ProdutoDTO converterParaDTOProduto(Produto produto) {
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setNome(produto.getNome());
        produtoDTO.setId(produto.getId());
        produtoDTO.setPreco(produto.getPreco());
        //pegar o id do estabelecimento do produto que vem do banco de dados e guardaar dentro do estabelecimento id dentro do DTO
        produtoDTO.setEstabelecimentoId(produto.getEstabelecimento().getId());
        return produtoDTO;
    }

}
