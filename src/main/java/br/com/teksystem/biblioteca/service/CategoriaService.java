package br.com.teksystem.biblioteca.service;

import br.com.teksystem.biblioteca.dto.CategoriaCadastroDTO;
import br.com.teksystem.biblioteca.dto.CategoriaExibicaoDTO;
import br.com.teksystem.biblioteca.model.Categoria;
import br.com.teksystem.biblioteca.repository.CategoriaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaExibicaoDTO salvarCategoria(CategoriaCadastroDTO categoriaCadastroDTO) {

        Categoria categoria = new Categoria();
        BeanUtils.copyProperties(categoriaCadastroDTO, categoria);

        Categoria categoriaSalva = categoriaRepository.save(categoria);
        return new CategoriaExibicaoDTO(categoriaSalva);
    }

    public List<CategoriaExibicaoDTO> listarCategorias(Long idCategoria) {
        return categoriaRepository
                .findAll()
                .stream()
                .map(CategoriaExibicaoDTO::new)
                .toList();
    }

    public Categoria alterarCategoria(Categoria categoria) {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(categoria.getIdCategoria());

        if (categoriaOptional.isPresent()) {
            return categoriaRepository.save(categoria);
        } else {
            throw new RuntimeException("A categoria não foi encontrada!");
        }
    }

    public String excluirCategoria(Long id) {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);

        if (categoriaOptional.isPresent()) {
            categoriaRepository.delete(categoriaOptional.get());
            return "A categoria foi excluída com êxito!";
        } else {
            throw new RuntimeException("A categoria não foi encontrada!");
        }
    }

    public Categoria alterarNomeCategoria(Long id, String nome) {

        Categoria categoriaExistente = categoriaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Livro não encontrado!"));

        categoriaExistente.setNome(nome);
        return categoriaRepository.save(categoriaExistente);
    }
}
