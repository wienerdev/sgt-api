package br.com.basis.sgt.service;

import br.com.basis.sgt.domain.TipoTarefa;
import br.com.basis.sgt.repository.TarefaRepository;
import br.com.basis.sgt.repository.TipoTarefaRepository;
import br.com.basis.sgt.service.dto.DropDownDTO;
import br.com.basis.sgt.service.dto.TipoTarefaDTO;
import br.com.basis.sgt.service.error.TipoTarefaNaoEncontradaException;
import br.com.basis.sgt.service.mapper.TipoTarefaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional

public class TipoTarefaService {

    private final TipoTarefaRepository tipoTarefaRepository;
    private final TipoTarefaMapper tipoTarefaMapper;


    public TipoTarefaService(TipoTarefaMapper tipoTarefaMapper, TipoTarefaRepository tipoTarefaRepository) {
        this.tipoTarefaMapper = tipoTarefaMapper;
        this.tipoTarefaRepository = tipoTarefaRepository;

    }

    public List<TipoTarefaDTO> obterTodos(String descricao) {

        if (descricao != null && !descricao.isEmpty()) {
            return tipoTarefaMapper.toDto(tipoTarefaRepository.encontarTodosDescricao(descricao));
        }

        return tipoTarefaMapper.toDto(tipoTarefaRepository.findAll());
    }

    public TipoTarefaDTO obterPorId(Long id) {
        TipoTarefa tipoTarefa = verificarSeExiste(id);
        return tipoTarefaMapper.toDto(tipoTarefa);
    }

    public TipoTarefaDTO salvar(TipoTarefaDTO tipoTarefaDTO) {
        TipoTarefa tipoTarefa = tipoTarefaMapper.toEntity(tipoTarefaDTO);
        TipoTarefa tipoTarefaSalva = tipoTarefaRepository.save(tipoTarefa);
        return tipoTarefaMapper.toDto(tipoTarefaSalva);
    }

    public void deletarPorId(Long id) {
        verificarSeExiste(id);
        tipoTarefaRepository.deleteById(id);
    }

    public List<DropDownDTO> findAllSelect() {

        return tipoTarefaRepository.getAllTipoTarefaDropDown();

    }

    //    Inserido
    private TipoTarefa verificarSeExiste(Long id) throws TipoTarefaNaoEncontradaException {
        return tipoTarefaRepository.findById(id)
                .orElseThrow(() -> new TipoTarefaNaoEncontradaException(id));
    }

}
