package br.com.basis.sgt2.resource;

import br.com.basis.sgt2.dto.TasksDTO;
import br.com.basis.sgt2.service.TasksService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;


import java.util.List;

@RestController
@RequestMapping("/api/task")
@RequiredArgsConstructor
public class TasksResource {

    private final TasksService tasksService;

    @GetMapping
    public ResponseEntity<List<TasksDTO>> findAll() {
        return new ResponseEntity<>(tasksService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "title")
    public ResponseEntity<List<TasksDTO>> findByTitle(@RequestParam("title") String title) {
        return new ResponseEntity<>(tasksService.findByTitle(title), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TasksDTO> save(@RequestBody TasksDTO tasksDTO) {
        return ResponseEntity.ok(tasksService.save(tasksDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TasksDTO> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(tasksService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        tasksService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
