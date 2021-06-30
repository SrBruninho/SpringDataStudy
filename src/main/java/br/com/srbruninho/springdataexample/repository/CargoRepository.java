package br.com.srbruninho.springdataexample.repository;

import br.com.srbruninho.springdataexample.orm.Cargo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends CrudRepository<Cargo,Long> {
}
