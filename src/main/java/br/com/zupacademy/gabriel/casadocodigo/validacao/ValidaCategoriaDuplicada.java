package br.com.zupacademy.gabriel.casadocodigo.validacao;

import br.com.zupacademy.gabriel.casadocodigo.autor.AutorForm;
import br.com.zupacademy.gabriel.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.gabriel.casadocodigo.categoria.CategoriaForm;
import br.com.zupacademy.gabriel.casadocodigo.categoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ValidaCategoriaDuplicada implements Validator {

    @Autowired
    CategoriaRepository categoriaRepository;


    @Override
    public boolean supports(Class<?> clazz) {
        return CategoriaForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        CategoriaForm requisicao = (CategoriaForm) target;

        if (categoriaRepository.findByNome(requisicao.getNome()).isPresent()) {
            errors.rejectValue("nome",
                    "NotDuplicated.CategoriaForm.nome");
        }
    }
}
