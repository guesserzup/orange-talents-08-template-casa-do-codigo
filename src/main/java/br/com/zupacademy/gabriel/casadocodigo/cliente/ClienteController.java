package br.com.zupacademy.gabriel.casadocodigo.cliente;

import br.com.zupacademy.gabriel.casadocodigo.estado.EstadoRepository;
import br.com.zupacademy.gabriel.casadocodigo.pais.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @PostMapping
    public ResponseEntity<ClienteDto> cadastrar(@RequestBody @Valid ClienteForm form) {
        Cliente cliente = form.toEntity(this.estadoRepository, this.paisRepository);
        clienteRepository.save(cliente);
        return ResponseEntity.ok(new ClienteDto(cliente));
    }
}