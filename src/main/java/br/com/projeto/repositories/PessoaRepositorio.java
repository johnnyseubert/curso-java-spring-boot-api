package br.com.projeto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.projeto.models.Pessoa;

public interface PessoaRepositorio extends CrudRepository<Pessoa, Integer> {

   List<Pessoa> findAll();

   Pessoa findByCodigo(int codigo);

   List<Pessoa> findByOrderByNome();

   List<Pessoa> findByNomeOrderByIdade(String nome);

   List<Pessoa> findByNomeContaining(String nome);

   List<Pessoa> findByNomeStartsWith(String nome);

   List<Pessoa> findByNomeEndsWith(String nome);

   @Query(value = "SELECT SUM(idade) FROM pessoas", nativeQuery = true)
   int somaIdades();

   @Query(value = "SELECT * FROM pessoas WHERE idade >= :idade", nativeQuery = true)
   List<Pessoa> idadeMaiorIgual(int idade);

}
