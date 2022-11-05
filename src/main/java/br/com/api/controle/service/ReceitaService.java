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

    public Double somaReceitas(){
        double soma = 0;
        try{
            var pegaTodasReceitas = repository.findAll();
            for (Receita receita : pegaTodasReceitas){
                soma += receita.getValor();
            }
            return soma;
        }catch (Exception e){
            throw new ControleException("Não foi possivel achar uma soma");
        }
    }

}
