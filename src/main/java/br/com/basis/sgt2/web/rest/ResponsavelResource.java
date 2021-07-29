package br.com.basis.sgt2.web.rest;



import br.com.basis.sgt2.Service.DTO.ResponsavelDTO;
import br.com.basis.sgt2.Service.ResponsavelServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api")
@RestController
@RequiredArgsConstructor
public class ResponsavelResource {

   private final ResponsavelServices responsavelServices;

   @GetMapping("/responsavel")
    public ResponseEntity<List<ResponsavelDTO>> exibirResponsaveis(){
       return ResponseEntity.ok(responsavelServices.obterTodos());
    }

    @GetMapping("/responsavel/{id}")
    public ResponseEntity<ResponsavelDTO> exibirPorId(@PathVariable("id") long id){
       return new ResponseEntity<>(responsavelServices.obterPorId(id),HttpStatus.OK);
    }

    @PostMapping("/responsavel")
    public ResponseEntity<ResponsavelDTO> novoResponsavel(@RequestBody ResponsavelDTO responsavel){

       return ResponseEntity.ok(responsavelServices.salvar(responsavel));
    }

    @PutMapping("/responsavel")
    public ResponseEntity<ResponsavelDTO> atualizarResponsavel(@RequestBody ResponsavelDTO responsavel){

       return ResponseEntity.ok(responsavelServices.atualizar(responsavel));
    }
    @DeleteMapping("/responsavel/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") long id){
       responsavelServices.deletarResponsavel(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
