package br.com.teksystem.biblioteca.service;

import br.com.teksystem.biblioteca.dto.LivroCadastroDTO;
import br.com.teksystem.biblioteca.dto.LivroExibicaoDTO;
import br.com.teksystem.biblioteca.model.Livro;
import br.com.teksystem.biblioteca.repository.LivroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public LivroExibicaoDTO salvarLivro(LivroCadastroDTO livroCadastroDTO) {

        Livro livro = new Livro();
        BeanUtils.copyProperties(livroCadastroDTO, livro);

        Livro livroSalvo = livroRepository.save(livro);
        return new LivroExibicaoDTO(livroSalvo);
    }

}
