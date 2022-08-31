package br.com.alura.forum.modelo.mapper;

import br.com.alura.forum.modelo.Usuario;
import br.com.alura.forum.modelo.dto.UsuarioDTO;
import org.springframework.stereotype.Component;
//topico form como dto e conversor ao mesmo temo, separei
@Component
public class UsuarioMapper {

    public Usuario converterParaEntidade(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setId(usuarioDTO.getId());
        usuario.setNome(usuarioDTO.getNome());
        usuario.setTelefone(usuarioDTO.getTelefone());
        usuario.setEndereco(new EnderecoMapper().converterParaEntidade(usuarioDTO.getEndereco()));
        return usuario;
    }

    public UsuarioDTO converterParaDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setNome(usuario.getNome());
        usuarioDTO.setTelefone(usuario.getTelefone());
        usuarioDTO.setEndereco(new EnderecoMapper().converterParaDTO(usuario.getEndereco()));
        return usuarioDTO;
    }
}
