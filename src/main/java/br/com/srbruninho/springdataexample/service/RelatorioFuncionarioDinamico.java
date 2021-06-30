package br.com.srbruninho.springdataexample.service;

import br.com.srbruninho.springdataexample.orm.Funcionario;
import br.com.srbruninho.springdataexample.repository.FuncionarioRepository;
import br.com.srbruninho.springdataexample.specification.SpecificationFuncionario;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Service
public class RelatorioFuncionarioDinamico {

    private final FuncionarioRepository _funcionarioRepository;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public RelatorioFuncionarioDinamico(FuncionarioRepository funcionarioRepository) {
        this._funcionarioRepository = funcionarioRepository;
    }

    public void inicial(Scanner scanner) {
        System.out.println("Digite o nome");

        String nomeString = scanner.next();

        if (nomeString.equalsIgnoreCase("NULL"))
            nomeString = null;

        List<Funcionario> funcionarioList = _funcionarioRepository
                .findAll(Specification.where(SpecificationFuncionario.nome(nomeString)));
    }
}
