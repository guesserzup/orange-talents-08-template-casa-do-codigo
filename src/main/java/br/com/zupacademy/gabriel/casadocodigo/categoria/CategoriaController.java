package br.com.zupacademy.gabriel.casadocodigo.categoria;

import br.com.zupacademy.gabriel.casadocodigo.validacao.ValidaCategoriaDuplicada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    private ValidaCategoriaDuplicada validaCategoriaDuplicada;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(validaCategoriaDuplicada);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CategoriaDto> cadastrar(@RequestBody @Valid CategoriaForm form) {
        Categoria categoria = form.converter();
        categoriaRepository.save(categoria);

        return ResponseEntity.ok(new CategoriaDto(categoria));
    }

}
