package br.com.api.controle.controller;

import br.com.api.controle.model.Despesa;
import br.com.api.controle.service.DespesaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/despesa")
@CrossOrigin(origins = "http://localhost:8081")
public class DespesaController {

    private DespesaService service;

    public DespesaController(DespesaService service) {
        this.service = service;
    }

    @GetMapping

    public ResponseEntity<?> lista (){
        return ResponseEntity.ok(service.listaDespesas());
    }

    @PostMapping
    public ResponseEntity<?> cria (@RequestBody Despesa despesa){
            return new ResponseEntity<>(service.criaDespesa(despesa), HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<?> deleta(@RequestParam Long id){
        return new ResponseEntity<>(service.deletaDespesa(id), HttpStatus.OK);
    }

    @GetMapping("/soma")
    public ResponseEntity<?> soma(){
        return new ResponseEntity<>(service.calculoSomaDasDespesas(), HttpStatus.OK);
    }
}
