package br.com.api.controle.repository;


import br.com.api.controle.model.Receita;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaRepository extends CrudRepository<Receita, Long> {

    @Query(value = "SELECT sum(valor) FROM controle.receita", nativeQuery = true)
    Double somaTotal ();
}
