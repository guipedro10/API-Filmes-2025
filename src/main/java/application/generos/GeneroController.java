package application.generos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/generos")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @GetMapping
    public Iterable<GeneroDTO> getAll() {
        return generoService.getAll();
    }

    @GetMapping("/{id}")
    public GeneroDTO getOne(@PathVariable long id) {
        return generoService.getOne(id);
    }

    @PostMapping
    public GeneroDTO insert(@RequestBody GeneroInsertDTO dados) {
        return generoService.insert(dados);
    }

    @PutMapping("/{id}")
    public GeneroDTO update(@PathVariable long id, @RequestBody GeneroInsertDTO novosDados) {
        return generoService.update(id, novosDados);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable long id) {
        generoService.delete(id);
    }
}
