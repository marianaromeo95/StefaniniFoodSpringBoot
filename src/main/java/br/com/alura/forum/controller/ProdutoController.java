package br.com.alura.forum.controller;

import br.com.alura.forum.modelo.Produto;
import br.com.alura.forum.modelo.dto.ProdutoDTO;
import br.com.alura.forum.modelo.mapper.ProdutoMapper;
import br.com.alura.forum.service.EstabelecimentoService;
import br.com.alura.forum.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/produtos")
@RestController
public class ProdutoController  {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private EstabelecimentoService estabelecimentoService;

    @Autowired
    ProdutoMapper produtoMapper;

    @PostMapping
    @Transactional
    public ProdutoDTO criar(@RequestBody @Valid ProdutoDTO produtoDTO) {
        Produto produto = produtoMapper.converterParaEntidadeProduto(produtoDTO);
        // salvar produto
        Produto produtoSalvo = produtoService.cadastrarProduto(produto);
        // transformar produto que FOI SALVO em produtoDTO
        ProdutoDTO produtoSalvadoDTO = produtoMapper.converterParaDTOProduto(produtoSalvo);
        // retorna o produto DTO

        return produtoSalvadoDTO;
    }

    @GetMapping
    @Transactional
    public List<ProdutoDTO> listar() {
        List<Produto> produtos = produtoService.listarProdutos();
        List<ProdutoDTO> listaProdutosDTO = new ArrayList<>();
        for (Produto produto : produtos) {
            ProdutoDTO produtoDTO = produtoMapper.converterParaDTOProduto(produto);
            listaProdutosDTO.add(produtoDTO);
        }

        return listaProdutosDTO;
    }

    @GetMapping("/{id}")
    @Transactional
    public ProdutoDTO listarPorId(@PathVariable("id") Integer id) {
        Produto produtoId = produtoService.buscarProdutosId(id);
        ProdutoDTO produtoDTO = produtoMapper.converterParaDTOProduto(produtoId);
        return produtoDTO;
    }

    @PutMapping("/{id}")
    @Transactional
    public ProdutoDTO atualizar(@PathVariable("id") Integer id, @RequestBody @Valid ProdutoDTO produtoDTO) {
        Produto produto = produtoMapper.converterParaEntidadeProduto(produtoDTO);
        Produto atualizarProduto = produtoService.atualizar(produto, id);
        ProdutoDTO atualizarProdutoDTO = produtoMapper.converterParaDTOProduto(atualizarProduto);
        return atualizarProdutoDTO;
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ProdutoDTO deletar(@PathVariable("id") Integer id) {
        Produto produtoDeletado = produtoService.deletarProdutoId(id);
        ProdutoDTO produtoDTO = produtoMapper.converterParaDTOProduto(produtoDeletado);
        return produtoDTO;
    }
}
