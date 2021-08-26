package br.com.zupacademy.gabriel.casadocodigo.estado;

import br.com.zupacademy.gabriel.casadocodigo.validacao.ValidaEstadoDuplicado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    EstadoRepository estadoRepository;

    @Autowired
    ValidaEstadoDuplicado validaEstadoDuplicado;

    @PersistenceContext
    private EntityManager em;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(validaEstadoDuplicado);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> adicionar(@RequestBody @Valid EstadoForm form) {
        Estado estado = form.converterEmModelo(em);
        estadoRepository.save(estado);

        return ResponseEntity.ok().build();
    }

}
