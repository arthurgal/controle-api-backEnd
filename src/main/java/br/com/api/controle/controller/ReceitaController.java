package br.com.api.controle.controller;


import br.com.api.controle.model.Despesa;
import br.com.api.controle.model.Receita;
import br.com.api.controle.service.DespesaService;
import br.com.api.controle.service.ReceitaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/receita")
@CrossOrigin(origins = "http://localhost:8081")
public class ReceitaController {

    private ReceitaService service;

    public ReceitaController(ReceitaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> cria (@RequestBody Receita receita){
        return new ResponseEntity<>(service.criaReceita(receita), HttpStatus.CREATED);
    }

    @GetMapping("/soma")
    public ResponseEntity<?> soma (){
        return  new ResponseEntity<>(service.somaReceitas(), HttpStatus.CREATED);
    }
}
