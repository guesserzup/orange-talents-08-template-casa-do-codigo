package br.com.zupacademy.gabriel.casadocodigo.validacao;

import br.com.zupacademy.gabriel.casadocodigo.cliente.ClienteForm;
import br.com.zupacademy.gabriel.casadocodigo.estado.Estado;
import br.com.zupacademy.gabriel.casadocodigo.estado.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

@Component
public class ValidaPaisComEstado implements Validator {
    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return ClienteForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }
        ClienteForm form = (ClienteForm) target;
        List<Estado> listaEstados = estadoRepository.findAllByPaisId(form.getIdPais());
        if (listaEstados.isEmpty()) {
            return;
        }
        if (form.getIdEstado() == null) {
            errors.rejectValue("idEstado", "Vazio.ClienteForm.estado", "");
            return;
        }
        if (listaEstados.contains(estadoRepository.getById(form.getIdEstado()))) {
            return;
        }
        errors.rejectValue("idEstado", "NaoPertence.ClienteForm.estado", "");
    }
}
