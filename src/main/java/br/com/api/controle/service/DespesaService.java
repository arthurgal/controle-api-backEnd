package br.com.api.controle.service;

import br.com.api.controle.exception.ControleException;
import br.com.api.controle.model.Despesa;
import br.com.api.controle.repository.DespesaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DespesaService {

    private DespesaRepository repository;

    public DespesaService(DespesaRepository repository) {
        this.repository = repository;
    }

    public Iterable<Despesa> listaDespesas(){

        //var paginacao = PageRequest.of(pagina, qtd, Sort.Direction.ASC, ordencao);

        var listagem = repository.findAll();


        return listagem;
    }

    public Despesa criaDespesa(Despesa despesa){
        try {
             return repository.save(despesa);
        }catch (Exception e){
            throw new ControleException("Valores invalidos");
        }
    }

    public String deletaDespesa(Long id){
        try{
            var despesaById = repository.findById(id);
            repository.deleteById(despesaById.get().getId());
            return "Emprestimo com id: " + id + " Deletado";
        }catch (Exception e){
            throw new ControleException("NÃO ENCONTRADO OU VALORES NÃO VÁLIDO");
        }
    }

    public Double somaDespesa(){
        try {
            return repository.somaTotal();
        }catch (Exception e){
            return 0.0;
        }
    }

}
