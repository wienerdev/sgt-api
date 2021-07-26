package br.com.basis.sgt2.Resource;


import br.com.basis.sgt2.Domain.Tarefa;
import br.com.basis.sgt2.repository.TarefasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")//("/api/tarefas")
public class Controller {
@Autowired
TarefasRepository tarefasRepository;

@GetMapping("/tarefas")
    public List<Tarefa> listarProdutos(){
    return tarefasRepository.findAll();
}

    @GetMapping("/tarefas/{id}")
    public Tarefa tarefaEsp(@PathVariable(value = "id")long id){
        return tarefasRepository.findById(id);
    }
    @PostMapping("/tarefas")
    public Tarefa salvarTarefa(@RequestBody Tarefa tarefa){

    return tarefasRepository.save(tarefa);
    }
    @DeleteMapping("/tarefas")
    public void deletarTarefa(@RequestBody Tarefa tarefa){

        tarefasRepository.delete(tarefa);
    }
    @PutMapping("/tarefas")
    public Tarefa atualizarTarefa(@RequestBody Tarefa tarefa){
        return tarefasRepository.save(tarefa);
    }

}
