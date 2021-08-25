package br.com.zupacademy.gabriel.casadocodigo.livro;

import br.com.zupacademy.gabriel.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.gabriel.casadocodigo.categoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<LivroDto> cadastrar(@RequestBody @Valid LivroForm form) {
        Livro livro = form.toEntity(autorRepository, categoriaRepository);
        this.livroRepository.save(livro);
        return ResponseEntity.ok(new LivroDto(livro));
    }

    @GetMapping
    public ResponseEntity<List<ListaLivroDto>> listarLivros() {
        List<Livro> livros = this.livroRepository.findAll();
        List<ListaLivroDto> listaLivros = ListaLivroDto.listaConverter(livros);

        return ResponseEntity.ok(listaLivros);
    }
}