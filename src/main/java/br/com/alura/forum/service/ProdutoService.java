package br.com.alura.forum.service;

import br.com.alura.forum.modelo.Produto;
import br.com.alura.forum.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto cadastrarProduto(Produto produto) {

        return produtoRepository.save(produto);
    }

    public Produto atualizar(Produto produto, Integer id) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        if (produtoOptional.isPresent()) {
            Produto produtoBanco = produtoOptional.get();
            produtoBanco.setNome(produto.getNome());
            produtoBanco.setPreco(produto.getPreco());
            produtoBanco.setEstabelecimento(produto.getEstabelecimento());
            Produto usuarioSalvado = produtoRepository.save(produtoBanco);
            return usuarioSalvado;
        }
        return null;
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto buscarProdutosId(Integer id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.get();
    }

    @Transactional
    public Produto deletarProdutoId(Integer id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        produtoRepository.deleteById(id);
        produtoRepository.flush();
        return produto.get();
    }
}
