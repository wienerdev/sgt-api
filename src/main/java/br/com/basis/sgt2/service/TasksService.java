package br.com.basis.sgt2.service;

import br.com.basis.sgt2.dto.TasksDTO;
import br.com.basis.sgt2.dto.mapper.TasksMapper;
import br.com.basis.sgt2.entities.Tasks;
import br.com.basis.sgt2.repositories.TasksRepository;
import br.com.basis.sgt2.service.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TasksService {

    private final TasksRepository tasksRepository;
    private final TasksMapper tasksMapper;

    public List<TasksDTO> findAll() {
        return tasksMapper.toDto(tasksRepository.findAll());
    }

    public List<TasksDTO> findByTitle(String title) {
        if (title != null && !title.isEmpty()) {
            return tasksMapper.toDto(tasksRepository.findByTitle(title));
        }
        throw new EntityNotFoundException();
    }

    public TasksDTO findById(Long id) {
        Tasks tasks = tasksRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return tasksMapper.toDto(tasks);
    }

    public TasksDTO save(TasksDTO tasksDTO) {
        Tasks tasks = tasksMapper.toEntity(tasksDTO);
        Tasks saveTasks = tasksRepository.save(tasks);
        return tasksMapper.toDto(saveTasks);
    }

    public void deleteById(Long id) {
        tasksRepository.deleteById(id);
    }

}
