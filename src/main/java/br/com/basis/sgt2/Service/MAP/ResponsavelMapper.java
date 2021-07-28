package br.com.basis.sgt2.Service.MAP;

import br.com.basis.sgt2.Domain.Responsavel;
import br.com.basis.sgt2.Service.DTO.ResponsavelDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResponsavelMapper extends EntityMapper<ResponsavelDTO, Responsavel> {
}
