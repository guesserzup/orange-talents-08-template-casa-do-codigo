package br.com.zupacademy.gabriel.casadocodigo.validacao;

import br.com.zupacademy.gabriel.casadocodigo.autor.AutorForm;
import br.com.zupacademy.gabriel.casadocodigo.autor.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ValidaEmailDuplicadoAutor implements Validator {

    @Autowired
    AutorRepository autorRepository;


    @Override
    public boolean supports(Class<?> clazz) {
        return AutorForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        AutorForm requisicao = (AutorForm) target;

        if (autorRepository.findByEmail(requisicao.getEmail()).isPresent()) {
            errors.rejectValue("email",
                    "NotDuplicated.AutorForm.email");
        }
    }
}
