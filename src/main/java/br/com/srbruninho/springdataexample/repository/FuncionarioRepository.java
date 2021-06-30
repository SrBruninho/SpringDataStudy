package br.com.srbruninho.springdataexample.repository;

import br.com.srbruninho.springdataexample.orm.Funcionario;
import br.com.srbruninho.springdataexample.orm.FuncionarioProjecao;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Integer>,
        JpaSpecificationExecutor<Funcionario> {

    List<Funcionario> findByNome(String nome);

    @Query("SELECT f FROM Funcionario f WHERE f.nome = ?1 AND f.salario >= ?2 " +
            "AND f.dataContratacao = ?3 ")
    List<Funcionario> findNomeDataContratacaoSalarioMaior(String name, Double salario, LocalDate data);

    @Query(value = "SELECT * FROM FUNCIONARIOS FUNC WHERE FUNC.DATA_CONTRATACAO >= :data",
            nativeQuery = true)
    List<Funcionario> findDataContratacaoMaior(LocalDate data);

    @Query(value = " SELECT f.id, f.nome, f.salario FROM funcionarios f",
            nativeQuery = true)
    List<FuncionarioProjecao> findFuncionarioSalario();

}
