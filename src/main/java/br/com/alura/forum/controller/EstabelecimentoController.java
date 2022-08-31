package br.com.alura.forum.controller;

/*
C- criar um usuario  --> POST /usuarios --> JSON com os dados do usuarios
R- listar todos usuarios --> GET /usuarios --> nao tem corpo
R- ler só um usuario --> GET /usuarios/{id} --> nao tem corpo
U- edita/atualiza um usuario --> PUT /usuarios/{id} -->  JSON com os novos dados dos usuarios
D- deleta um usuario --> DELETE  /usuarios/{id} --> nao tem corpo
 */

import br.com.alura.forum.modelo.Estabelecimento;
import br.com.alura.forum.modelo.Produto;
import br.com.alura.forum.modelo.dto.EstabelecimentoDTO;
import br.com.alura.forum.modelo.dto.ProdutoDTO;
import br.com.alura.forum.modelo.mapper.EstabelecimentoMapper;
import br.com.alura.forum.modelo.mapper.ProdutoMapper;
import br.com.alura.forum.service.EstabelecimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/estabelecimentos")
@RestController
public class EstabelecimentoController {

    @Autowired
    EstabelecimentoService estabelecimentoService;

    @Autowired
    EstabelecimentoMapper estabelecimentoMapper;

    @Autowired
    ProdutoMapper produtoMapper;

    @GetMapping
    @Transactional
    public List<EstabelecimentoDTO> listarEstabelecimentos() {
        List<Estabelecimento> estabelecimentos = estabelecimentoService.listarEstabelecimentos();
        List<EstabelecimentoDTO> listaEstabelecimentosDTO = new ArrayList<>();
        List<ProdutoDTO> listaProdutosDTO = new ArrayList<>();
        for (Estabelecimento estabelecimento : estabelecimentos) {
            EstabelecimentoDTO estabelecimentoDTO = estabelecimentoMapper.converterEstabelecimentoParaDTO(estabelecimento);
            listaEstabelecimentosDTO.add(estabelecimentoDTO);
            estabelecimentoDTO.setProdutos(listaProdutosDTO);
        }
        return listaEstabelecimentosDTO;
    }

    @GetMapping("/{id}")
    @Transactional
    public EstabelecimentoDTO listarPorId(@PathVariable("id") Integer id) {
        Estabelecimento estabelecimento = estabelecimentoService.buscarEstabelecimentosId(id);
        List<Produto> produtos = estabelecimento.getProdutos();
        List<ProdutoDTO> listaProdutosDTO = new ArrayList<>();
        for (Produto produto : produtos) {
            ProdutoDTO produtoDTO = produtoMapper.converterParaDTOProduto(produto);
            listaProdutosDTO.add(produtoDTO);
        }
        EstabelecimentoDTO estabelecimentoDTO = estabelecimentoMapper.converterEstabelecimentoParaDTO(estabelecimento);
        estabelecimentoDTO.setProdutos(listaProdutosDTO);
        return estabelecimentoDTO;
    }

    @PostMapping
    @Transactional
    public EstabelecimentoDTO criar(@RequestBody @Valid EstabelecimentoDTO estabelecimentoDTO) {
        Estabelecimento estabelecimento = estabelecimentoMapper.converterParaEntidade(estabelecimentoDTO);
        Estabelecimento estabelecimentoCadastrado = estabelecimentoService.cadastrar(estabelecimento);
        EstabelecimentoDTO estabelecimentoCadastradoDTO = estabelecimentoMapper.converterEstabelecimentoParaDTO(estabelecimentoCadastrado);
        return estabelecimentoCadastradoDTO;
    }

    @PutMapping("/{id}")
    @Transactional
    public EstabelecimentoDTO atualizar(@PathVariable("id") Integer id, @RequestBody @Valid EstabelecimentoDTO estabelecimentoDTO) {
        Estabelecimento estabelecimento = estabelecimentoMapper.converterParaEntidade(estabelecimentoDTO);
        Estabelecimento atualizarEstabelecimento = estabelecimentoService.atualizar(estabelecimento, id);
        EstabelecimentoDTO atualizarEstabelecimentoDTO = estabelecimentoMapper.converterEstabelecimentoParaDTO(atualizarEstabelecimento);
        return atualizarEstabelecimentoDTO;
    }

    @DeleteMapping("/{id}")
    @Transactional
    public Estabelecimento deletar(@PathVariable("id") Integer id) {
        Estabelecimento estabelecimentoDeletado = estabelecimentoService.deletarEstabelecimentoId(id);
        return estabelecimentoDeletado;
    }

}
