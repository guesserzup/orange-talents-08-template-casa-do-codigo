package br.com.zupacademy.gabriel.casadocodigo.validacao;

import br.com.zupacademy.gabriel.casadocodigo.estado.EstadoForm;
import br.com.zupacademy.gabriel.casadocodigo.estado.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ValidaEstadoDuplicado implements Validator {

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return EstadoForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        if (errors.hasErrors()) { return; }

        EstadoForm formEstado = (EstadoForm) target;

        if (estadoRepository.findByNomeAndPaisId(formEstado.getNome(), formEstado.getPaisId()).isPresent()) {
            throw new ExceptionRegra(new ErroDeFormularioDto("paisId", "Já existe esse estado cadastrado nesse país."));
        }
    }
}
