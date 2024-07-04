package br.com.teksystem.biblioteca.controller;

import br.com.teksystem.biblioteca.dto.CategoriaCadastroDTO;
import br.com.teksystem.biblioteca.dto.CategoriaExibicaoDTO;
import br.com.teksystem.biblioteca.model.Categoria;
import br.com.teksystem.biblioteca.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("/categorias")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoriaExibicaoDTO salvar(
            @RequestBody CategoriaCadastroDTO categoria) {
        return categoriaService.salvarCategoria(categoria);
    }

    @GetMapping("/categorias/{idCategoria}")
    @ResponseStatus(HttpStatus.OK)
    public List<CategoriaExibicaoDTO> listarTodos(
            @PathVariable Long idCategoria) {
        return categoriaService.listarCategorias(idCategoria);
    }

    @PutMapping("/categorias")
    @ResponseStatus(HttpStatus.OK)
    public Categoria atualizar(
            @RequestBody Categoria categoria) {
        return categoriaService.alterarCategoria(categoria);
    }

    @DeleteMapping("/categorias/{idCategoria}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> excluir(
            @PathVariable Long idCategoria) {
        String mensagem = categoriaService.excluirCategoria(idCategoria);
        return ResponseEntity.ok(mensagem);
    }

}