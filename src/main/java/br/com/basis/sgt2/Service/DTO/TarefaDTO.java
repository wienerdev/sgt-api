package br.com.basis.sgt2.Service.DTO;

import br.com.basis.sgt2.Domain.Enums.Status;
import br.com.basis.sgt2.Domain.Responsavel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TarefaDTO {

        private Long id;
        private LocalDate dataInicio;
        private LocalDate terminoPrevisto;
        private int horasEfetivas;
        private Status status;
        private List<ComentarioDTO> comentario;
        private ResponsavelDTO responsavel;
}
