package br.com.basis.sgt.web.rest;

import br.com.basis.sgt.service.TarefaService;
import br.com.basis.sgt.service.dto.DropDownDTO;
import br.com.basis.sgt.service.dto.TarefaDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/api/tarefas")
public class TarefaResource {
    private final TarefaService tarefaService;

    @GetMapping
    public ResponseEntity<List<TarefaDTO>> obterTodos(@RequestParam(value = "titulo", required = false) String titulo) {
        return ResponseEntity.ok(tarefaService.obterTodos(titulo));
    }

    @PostMapping
    public ResponseEntity<TarefaDTO> salvar(@RequestBody TarefaDTO tarefa) {
        return ResponseEntity.ok(tarefaService.salvar(tarefa));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TarefaDTO> update(@PathVariable("id") Long id, @RequestBody TarefaDTO dto) {
        dto.setId(id);
        dto = tarefaService.salvar(dto);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaDTO> obterPorId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(tarefaService.obterPorId(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable("id") Long id) {
        tarefaService.deletarPorId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/select")
    public ResponseEntity<List<DropDownDTO>> findAllSelect() {
        List<DropDownDTO> dropResponsavel = tarefaService.findAllSelect();
        return new ResponseEntity<>(dropResponsavel, HttpStatus.OK);
    }

}
