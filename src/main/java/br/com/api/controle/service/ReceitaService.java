package br.com.api.controle.service;

import br.com.api.controle.exception.ControleException;
import br.com.api.controle.model.Receita;
import br.com.api.controle.repository.ReceitaRepository;
import org.springframework.stereotype.Service;

@Service
public class ReceitaService {

    private ReceitaRepository repository;

    public ReceitaService(ReceitaRepository repository) {
        this.repository = repository;
    }

    public Receita criaReceita(Receita receita){
        try {
            return repository.save(receita);
        }catch (Exception e){
            throw new ControleException("Valores invalidos");
        }
    }

    public Double somaReceita(){
        try {
            return repository.somaTotal();
        }catch (Exception e){
            return 0.0;
        }
    }

}
