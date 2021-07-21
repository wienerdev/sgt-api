package br.com.basis.sgt2.resources;

import br.com.basis.sgt2.dto.UserDTO;
import br.com.basis.sgt2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping(value = "/api/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<Page<UserDTO>> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

        Page<UserDTO> list = service.findByAllPaged(pageRequest);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        UserDTO obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
     public ResponseEntity<UserDTO> insert(@RequestBody UserDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(dto.getIdUser()).toUri();
        return ResponseEntity.created(uri).body(dto);
     }

     @PutMapping(value = "/{id}")
     public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody UserDTO dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
     }

     @DeleteMapping(value = "/{id}")
     public ResponseEntity<UserDTO> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
     }

}