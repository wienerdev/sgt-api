package br.com.basis.sgt2.web.rest;


import br.com.basis.sgt2.Service.DTO.TarefaDTO;
import br.com.basis.sgt2.Service.TarefaServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")//("/api/tarefas")
@RequiredArgsConstructor
public class TarefaResouce {

    private final TarefaServices tarefaServices;

    @GetMapping("/tarefas")
    public ResponseEntity<List<TarefaDTO>> listarProdutos(){
        return ResponseEntity.ok(tarefaServices.obterTodos());
}
    @PostMapping("/tarefas")
    public ResponseEntity<TarefaDTO> criarTarefa(@RequestBody TarefaDTO tarefa) {
        return ResponseEntity.ok(tarefaServices.salvar(tarefa));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaDTO> obterPorId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(tarefaServices.obterPorId(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<TarefaDTO> atualizarTarefa(@RequestBody TarefaDTO tarefa){
        return ResponseEntity.ok(tarefaServices.atualizar(tarefa));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable("id") Long id) {
        tarefaServices.deletarPorId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
