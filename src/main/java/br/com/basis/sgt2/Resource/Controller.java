package br.com.basis.sgt2.Resource;


import br.com.basis.sgt2.Domain.Tarefa;
import br.com.basis.sgt2.Service.DTO.TarefaDTO;
import br.com.basis.sgt2.Service.TarefaServices;
import br.com.basis.sgt2.repository.TarefasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")//("/api/tarefas")
public class Controller {
@Autowired
TarefasRepository tarefasRepository;

@GetMapping("/tarefas")
    public ResponseEntity
    public List<Tarefa> listarProdutos(){
    return tarefasRepository.findAll();
}

    @GetMapping
    public ResponseEntity<List<TarefaDTO>> obterTodos(@RequestParam("titulo") String titulo) {
        return new ResponseEntity<>(TarefaServices.obterTodos(titulo), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TarefaDTO> criarTarefa(@RequestBody TarefaDTO tarefa) {
        return ResponseEntity.ok(TarefaServices.salvar(tarefa));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaDTO> obterPorId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(TarefaServices.obterPorId(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable("id") Long id) {
        TarefaServices.deletarPorId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
