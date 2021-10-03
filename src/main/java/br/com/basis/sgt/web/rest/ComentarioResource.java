package br.com.basis.sgt.web.rest;

import br.com.basis.sgt.service.ComentarioService;
import br.com.basis.sgt.service.dto.ComentarioDTO;
import br.com.basis.sgt.service.dto.DropDownDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/api/comentario")
public class ComentarioResource {
    private final ComentarioService comentarioService;

    @GetMapping
    public ResponseEntity<List<ComentarioDTO>> obterTodos(@RequestParam(value = "descricao", required = false) String descricao) {
        return new ResponseEntity<>(comentarioService.obterTodos(descricao), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ComentarioDTO> criarComentario(@RequestBody ComentarioDTO comentarioDTO) {
        return ResponseEntity.ok(comentarioService.criarComentario(comentarioDTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ComentarioDTO> update(@PathVariable("id") Long id, @RequestBody ComentarioDTO dto) {
        dto.setId(id);
        dto = comentarioService.criarComentario(dto);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComentarioDTO> obterPorId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(comentarioService.obterPorId(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable("id") Long id) {
        comentarioService.deletarPorId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/select")
    public ResponseEntity<List<DropDownDTO>> findAllSelect() {
        List<DropDownDTO> dropResponsavel = comentarioService.findAllSelect();
        return new ResponseEntity<>(dropResponsavel, HttpStatus.OK);
    }
}



