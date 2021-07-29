package br.com.basis.sgt2.Service;


import br.com.basis.sgt2.Domain.Responsavel;
import br.com.basis.sgt2.Service.DTO.ResponsavelDTO;
import br.com.basis.sgt2.Service.MAP.ResponsavelMapper;
import br.com.basis.sgt2.repository.ResponsavelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class ResponsavelServices {

    private final ResponsavelRepository responsavelRepository;
    private final ResponsavelMapper responsavelMapper;


    public List<ResponsavelDTO> obterTodos(){
        return responsavelMapper.toDTO(responsavelRepository.findAll());
    }

    public ResponsavelDTO obterPorId(long id){
        Responsavel responsavel = responsavelRepository.findById(id).orElse(null);
        return responsavelMapper.toDTO(responsavel);
    }


    public ResponsavelDTO salvar(ResponsavelDTO responsavelDTO){
//        responsavelDTO.setId(null);
        Responsavel responsavel = responsavelMapper.toEntity(responsavelDTO);
        Responsavel responsavelSalvar = responsavelRepository.save(responsavel);
        return responsavelMapper.toDTO(responsavelSalvar);

    }
    public ResponsavelDTO atualizar(ResponsavelDTO responsavelDTO){
        Responsavel responsavel = responsavelMapper.toEntity((responsavelDTO));
        Responsavel atualizarResponsavel = responsavelRepository.save(responsavel);
        return responsavelMapper.toDTO(atualizarResponsavel);


    }
    public void deletarResponsavel(Long id){
        responsavelRepository.deleteById(id);
    }


}
