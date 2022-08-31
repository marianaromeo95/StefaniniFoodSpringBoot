package br.com.alura.forum.controller;

/*
C- criar um usuario  --> POST /usuarios --> JSON com os dados do usuarios
R- listar todos usuarios --> GET /usuarios --> nao tem corpo
R- ler só um usuario --> GET /usuarios/{id} --> nao tem corpo
U- edita/atualiza um usuario --> PUT /usuarios/{id} -->  JSON com os novos dados dos usuarios
D- deleta um usuario --> DELETE  /usuarios/{id} --> nao tem corpo
 */

import br.com.alura.forum.modelo.Usuario;
import br.com.alura.forum.modelo.dto.UsuarioDTO;
import br.com.alura.forum.modelo.mapper.UsuarioMapper;
import br.com.alura.forum.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/usuarios")
@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    UsuarioMapper usuarioMapper;

    @PostMapping
    @Transactional
    public UsuarioDTO criar(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.converterParaEntidade(usuarioDTO);
        Usuario usuarioCadastrado = usuarioService.cadastrar(usuario);
        UsuarioDTO usuarioCadastradoDTO = usuarioMapper.converterParaDTO(usuarioCadastrado);
        return usuarioCadastradoDTO;
    }

    @GetMapping
    @Transactional
    public List<UsuarioDTO> listar() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        List<UsuarioDTO> listaUsuariosDTO = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            UsuarioDTO usuarioDTO = usuarioMapper.converterParaDTO(usuario);
            listaUsuariosDTO.add(usuarioDTO);
        }

        return listaUsuariosDTO;
    }

    @GetMapping("/{id}")
    @Transactional
        public UsuarioDTO listarPorId(@PathVariable("id") Integer id) {
        Usuario usuarioId = usuarioService.buscarUsuarioId(id);
        UsuarioDTO usuarioDTO = usuarioMapper.converterParaDTO(usuarioId);
        return usuarioDTO;
    }

    @PutMapping("/{id}")
    @Transactional
    public UsuarioDTO atualizar(@PathVariable("id") Integer id, @RequestBody @Valid UsuarioDTO usuarioDTO) {
       Usuario usuario = usuarioMapper.converterParaEntidade(usuarioDTO);
       Usuario atualizarUsuario = usuarioService.atualizar(usuario, id);
       UsuarioDTO atualizarUsuarioDTO = usuarioMapper.converterParaDTO(atualizarUsuario);
       return atualizarUsuarioDTO;
    }

    @DeleteMapping("/{id}")
    @Transactional
    public Usuario deletar(@PathVariable("id") Integer id) {
       Usuario usuarioDeletado = usuarioService.deletarUsuarioId(id);
        return usuarioDeletado;
    }

}
