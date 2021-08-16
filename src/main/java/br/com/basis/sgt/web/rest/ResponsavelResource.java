package br.com.basis.sgt.web.rest;

import br.com.basis.sgt.service.ResponsavelService;
import br.com.basis.sgt.service.dto.DropDownDTO;
import br.com.basis.sgt.service.dto.ResponsavelDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/api/responsavel")


public class ResponsavelResource {
    private final ResponsavelService responsavelService;

    public ResponsavelResource(ResponsavelService responsavelService) {
        this.responsavelService = responsavelService;
    }

    /**
     * Busca todos os setores através
     *
     * @param setor
     * @return
     */
    @GetMapping
    public ResponseEntity<List<ResponsavelDTO>> obterTodos(@RequestParam(value = "setor", required = false) String setor) {
        return new ResponseEntity<>(responsavelService.obterTodos(setor), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponsavelDTO> criarResponsavel(@RequestBody ResponsavelDTO responsavel) {
        return ResponseEntity.ok(responsavelService.salvar(responsavel));
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<ResponsavelDTO> update(@PathVariable Long id, @RequestBody  ResponsavelDTO dto){
        dto.setId(id);
        dto = responsavelService.salvar(dto);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponsavelDTO> obterPorId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(responsavelService.obterPorId(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable("id") Long id) {
        responsavelService.deletarPorId(id);
        return ResponseEntity.noContent().build();

    }
    @GetMapping("/select")
    public  ResponseEntity<List<DropDownDTO>> findAllSelect(){
        List<DropDownDTO> dropResponsavel = responsavelService.findAllSelect();
        return new ResponseEntity<>(dropResponsavel,HttpStatus.OK);
    }

}
