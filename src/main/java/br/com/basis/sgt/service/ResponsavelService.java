package br.com.basis.sgt.service;

import br.com.basis.sgt.domain.Responsavel;
import br.com.basis.sgt.repository.ResponsavelRepository;
import br.com.basis.sgt.service.dto.DropDownDTO;
import br.com.basis.sgt.service.dto.ResponsavelDTO;
import br.com.basis.sgt.service.error.ResponsavelNaoEncontradaException;
import br.com.basis.sgt.service.mapper.ResponsavelMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ResponsavelService {
    private final ResponsavelRepository responsavelRepository;
    private final ResponsavelMapper responsavelMapper;

    public List<ResponsavelDTO> obterTodos(String setor) {

        if (setor != null && !setor.isEmpty()) {
            return responsavelMapper.toDto(responsavelRepository.encontarTodosPorSetor(setor));
        }
        return responsavelMapper.toDto(responsavelRepository.findAll());
    }

    public ResponsavelDTO salvar(ResponsavelDTO responsavelDTO) {
        Responsavel responsavel = responsavelMapper.toEntity(responsavelDTO);
        Responsavel responsavelSalva = responsavelRepository.save(responsavel);
        return responsavelMapper.toDto(responsavelSalva);
    }

    public List<DropDownDTO> findAllSelect() {

        return responsavelRepository.getAllResponsaveisDropDown();
    }

    //    Alterado
    public ResponsavelDTO obterPorId(Long id) {
        Responsavel responsavel = verificarSeExiste(id);
        return responsavelMapper.toDto(responsavel);
    }

    public void deletarPorId(Long id) {
        verificarSeExiste(id);
        responsavelRepository.deleteById(id);
    }

    //    Inserido
    private Responsavel verificarSeExiste(Long id) throws ResponsavelNaoEncontradaException {
        return responsavelRepository.findById(id)
                .orElseThrow(() -> new ResponsavelNaoEncontradaException(id));
    }


}
