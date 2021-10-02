package br.com.basis.sgt.service;

import br.com.basis.sgt.domain.Tarefa;
import br.com.basis.sgt.repository.TarefaRepository;
import br.com.basis.sgt.service.dto.DropDownDTO;
import br.com.basis.sgt.service.dto.TarefaDTO;
import br.com.basis.sgt.service.error.TarefaNaoEncontradaException;
import br.com.basis.sgt.service.mapper.TarefaMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TarefaService {
    private final TarefaRepository tarefaRepository;
    private final TarefaMapper tarefaMapper;

    public List<TarefaDTO> obterTodos(String titulo) {

        if (titulo != null && !titulo.isEmpty()) {
            return tarefaMapper.toDto(tarefaRepository.encontarTodosPorTitulo(titulo));
        }

        return tarefaMapper.toDto(tarefaRepository.findAll());
    }

    public TarefaDTO obterPorId(Long id) {
        Tarefa tarefa = verificarSeExiste(id);
        return tarefaMapper.toDto(tarefa);
    }

    public TarefaDTO salvar(TarefaDTO tarefaDTO) {
        Tarefa tarefa = tarefaMapper.toEntity(tarefaDTO);
        Tarefa tarefaSalva = tarefaRepository.save(tarefa);
        return tarefaMapper.toDto(tarefaSalva);
    }

    public void deletarPorId(Long id) {
        verificarSeExiste(id);
        tarefaRepository.deleteById(id);
    }

    public List<DropDownDTO> findAllSelect() {

        return tarefaRepository.getAllTarefaDropDown();

    }

    //    Inserido
    private Tarefa verificarSeExiste(Long id) throws TarefaNaoEncontradaException {
        return tarefaRepository.findById(id)
                .orElseThrow(() -> new TarefaNaoEncontradaException(id));
    }
}
