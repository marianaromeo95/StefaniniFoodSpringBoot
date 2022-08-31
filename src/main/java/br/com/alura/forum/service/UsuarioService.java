package br.com.alura.forum.service;

import br.com.alura.forum.modelo.Usuario;

import br.com.alura.forum.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastrar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizar(Usuario usuario, Integer id) {
        Optional<Usuario> usuarioOpcional = usuarioRepository.findById(id);
        if (usuarioOpcional.isPresent()) {
            Usuario usuarioBanco = usuarioOpcional.get();
            usuarioBanco.setEndereco(usuario.getEndereco());
            usuarioBanco.setNome(usuario.getNome());
            usuarioBanco.setTelefone(usuario.getTelefone());
            usuarioBanco.setEmail(usuario.getEmail());
            Usuario usuarioSalvado = usuarioRepository.save(usuarioBanco);
            return usuarioSalvado;
        }
        return null;
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarUsuarioId(Integer id) {
       Optional<Usuario> usuario = usuarioRepository.findById(id);
       return usuario.get();
    }

    public Usuario deletarUsuarioId(Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        usuarioRepository.deleteById(id);
        return usuario.get();
    }


}
