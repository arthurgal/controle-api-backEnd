package br.com.api.controle.repository;

import br.com.api.controle.model.Despesa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DespesaRepository extends CrudRepository<Despesa, Long> {

    @Query(value = "SELECT sum(valor) FROM controle.despesa", nativeQuery = true)
    long somaTotal ();
}
