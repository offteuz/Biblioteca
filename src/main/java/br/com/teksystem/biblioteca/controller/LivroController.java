package br.com.teksystem.biblioteca.controller;

import br.com.teksystem.biblioteca.dto.LivroCadastroDTO;
import br.com.teksystem.biblioteca.dto.LivroExibicaoDTO;
import br.com.teksystem.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping("/livros")
    @ResponseStatus(HttpStatus.CREATED)
    public LivroExibicaoDTO salvar(
            @RequestBody LivroCadastroDTO livro) {
        return livroService.salvarLivro(livro);
    }
}
