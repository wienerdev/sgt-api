package br.com.basis.sgt2.Service.DTO;

import br.com.basis.sgt2.Domain.Enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TarefaDTO {




        private Long id;
        private String dataInicio;
        private String terminoPrevisto;
        private String horasEfetivas;
        private Status status;
        private List<ComentarioDTO> comentario;


}
