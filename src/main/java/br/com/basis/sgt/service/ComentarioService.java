package br.com.basis.sgt.service;

import br.com.basis.sgt.domain.Comentario;
import br.com.basis.sgt.repository.ComentarioRepository;
import br.com.basis.sgt.service.dto.ComentarioDTO;
import br.com.basis.sgt.service.dto.DropDownDTO;
import br.com.basis.sgt.service.error.ComentarioNaoEncontradaException;
import br.com.basis.sgt.service.mapper.ComentarioMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ComentarioService {
    private final ComentarioRepository comentarioRepository;
    private final ComentarioMapper comentarioMapper;

    public List<ComentarioDTO> obterTodos(String descricao) {

        if (descricao != null && !descricao.isEmpty()) {
            return comentarioMapper.toDto(comentarioRepository.encontarTodosPorDescricao(descricao));
        }

        return comentarioMapper.toDto(comentarioRepository.findAll());
    }

    public ComentarioDTO criarComentario(ComentarioDTO comentarioDTO) {
        Comentario comentario = comentarioMapper.toEntity(comentarioDTO);
        Comentario comentarioSalva = comentarioRepository.save(comentario);
        return comentarioMapper.toDto(comentarioSalva);
    }

    //    Alterado
    public ComentarioDTO obterPorId(Long id) {
        Comentario comentario = verificarSeExiste(id);
        return comentarioMapper.toDto(comentario);
    }

    //    Alterado
    public void deletarPorId(Long id) {
        verificarSeExiste(id);
        comentarioRepository.deleteById(id);
    }

    public List<DropDownDTO> findAllSelect() {

        return comentarioRepository.getAllComentarioDropDown();

    }

    //    Inserido
    private Comentario verificarSeExiste(Long id) throws ComentarioNaoEncontradaException {
        return comentarioRepository.findById(id)
                .orElseThrow(() -> new ComentarioNaoEncontradaException(id));
    }


}