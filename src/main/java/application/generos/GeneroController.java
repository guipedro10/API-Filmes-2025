package application.generos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generos")
public class GeneroController {

    @Autowired
    private GeneroRepository repository;

    @GetMapping
    public List<Genero> listarTodos() {
        return repository.findAll();
    }

    @PostMapping
    public Genero criarGenero(@RequestBody Genero genero) {
        return repository.save(genero);
    }

    @GetMapping("/{id}")
    public Genero buscarPorId(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Genero atualizarGenero(@PathVariable Long id, @RequestBody Genero generoAtualizado) {
        return repository.findById(id).map(genero -> {
            genero.setNome(generoAtualizado.getNome());
            return repository.save(genero);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletarGenero(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
