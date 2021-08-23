package br.com.zupacademy.gabriel.casadocodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RequestMapping("/autores")
@RestController
public class AutorController {

    @Autowired
    AutorRepository autorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<AutorDto> cadastrar(@RequestBody @Valid AutorForm form) {
        Autor autor = form.converter();
        autorRepository.save(autor);

        return ResponseEntity.ok(new AutorDto(autor));
    }

}
