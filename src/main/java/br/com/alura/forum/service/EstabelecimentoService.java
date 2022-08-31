package br.com.alura.forum.service;

import br.com.alura.forum.modelo.Estabelecimento;
import br.com.alura.forum.repository.EstabelecimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstabelecimentoService {

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    public Estabelecimento cadastrar(Estabelecimento estabelecimento) {
        return estabelecimentoRepository.save(estabelecimento);
    }

    public Estabelecimento atualizar(Estabelecimento estabelecimento, Integer id) {
        Optional<Estabelecimento> estabelecimentoOpcional = estabelecimentoRepository.findById(id);
        if (estabelecimentoOpcional.isPresent()) {
            Estabelecimento estabelecimentoBd = estabelecimentoOpcional.get();
            estabelecimentoBd.setEndereco(estabelecimento.getEndereco());
            estabelecimentoBd.setNome(estabelecimento.getNome());
            estabelecimentoBd.setTelefone(estabelecimento.getTelefone());
            estabelecimentoBd.setEmail(estabelecimento.getEmail());
            Estabelecimento estabelecimentoSalvado = estabelecimentoRepository.save(estabelecimentoBd);
            return estabelecimentoSalvado;
        }
        return null;
    }

    public List<Estabelecimento> listarEstabelecimentos() {
        return estabelecimentoRepository.findAll();
    }

    public Estabelecimento buscarEstabelecimentosId(Integer id) {
        Optional<Estabelecimento> usuario = estabelecimentoRepository.findById(id);
        return usuario.get();
    }

    public Estabelecimento deletarEstabelecimentoId(Integer id) {
        Optional<Estabelecimento> estabelecimento = estabelecimentoRepository.findById(id);
        estabelecimentoRepository.deleteById(id);
        return estabelecimento.get();
    }

}
