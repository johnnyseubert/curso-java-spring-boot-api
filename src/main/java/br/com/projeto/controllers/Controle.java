package br.com.projeto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.models.Pessoa;
import br.com.projeto.repositories.PessoaRepositorio;

// diz que vai controller rotas
@RestController
public class Controle {

   // Permite que eu use o repositorio sem precisar instanciar
   @Autowired
   private PessoaRepositorio acao;

   @GetMapping("/pessoa")
   public List<Pessoa> Cadastrar() {
      return acao.findAll();
   }

   @GetMapping("/pessoa/{codigo}")
   public Pessoa Cadastrar(@PathVariable int codigo) {
      return acao.findByCodigo(codigo);
   }

   // Recuperar dados do body e salvar no banco
   @PostMapping("/pessoa")
   public Pessoa Cadastrar(@RequestBody Pessoa pes) {
      return acao.save(pes);
   }

   @PutMapping("/pessoa/{codigo}")
   public Pessoa Atualizar(@RequestBody Pessoa pes, @PathVariable int codigo) {
      pes.setCodigo(codigo);
      return acao.save(pes);
   }

   @DeleteMapping("/pessoa/{codigo}")
   public void Excluir(@PathVariable int codigo) {
      Pessoa pes = acao.findByCodigo(codigo);
      acao.deleteById(pes.getCodigo());
   }

   // Count
   @GetMapping("/pessoa/quantidade")
   public long Quantidade() {
      return acao.count();
   }

   // Ordenar
   @GetMapping("/pessoa/ordenar")
   public List<Pessoa> OrdenarNomes() {
      return acao.findByOrderByNome();
   }

   // Buscar = nome
   @GetMapping("/pessoa/nome/{nome}")
   public List<Pessoa> BuscarPeloNome(@PathVariable String nome) {
      return acao.findByNomeOrderByIdade(nome);
   }

   // Buscar Like o nome
   @GetMapping("/pessoa/contemNome/{nome}")
   public List<Pessoa> BuscarContendoNome(@PathVariable String nome) {
      return acao.findByNomeContaining(nome);
   }

   // Começa com o nome
   @GetMapping("/pessoa/comecaNome/{nome}")
   public List<Pessoa> BuscarComecandoNome(@PathVariable String nome) {
      return acao.findByNomeStartsWith(nome);
   }

   // Começa com o nome
   @GetMapping("/pessoa/terminaNome/{nome}")
   public List<Pessoa> BuscarTerminandoNome(@PathVariable String nome) {
      return acao.findByNomeEndsWith(nome);
   }

   // Soma de idades
   @GetMapping("/pessoa/somaIdades")
   public int SomaIdades() {
      return acao.somaIdades();
   }

   // Idade maior ou igual
   @GetMapping("/pessoa/maiorIgual/{idade}")
   public List<Pessoa> MaiorIgual(@PathVariable int idade) {
      return acao.idadeMaiorIgual(idade);
   }
}
