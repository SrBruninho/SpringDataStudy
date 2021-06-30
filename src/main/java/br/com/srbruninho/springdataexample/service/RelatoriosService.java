package br.com.srbruninho.springdataexample.service;

import br.com.srbruninho.springdataexample.orm.Cargo;
import br.com.srbruninho.springdataexample.orm.Funcionario;
import br.com.srbruninho.springdataexample.orm.FuncionarioProjecao;
import br.com.srbruninho.springdataexample.repository.CargoRepository;
import br.com.srbruninho.springdataexample.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class RelatoriosService {

    private Boolean system = true;

    private final FuncionarioRepository funcionarioRepository;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public RelatoriosService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void inicial(Scanner scanner) {
        while (system) {
            System.out.println("Qual acao de cargo deseja executar");
            System.out.println("0 - Sair");
            System.out.println("1 - Buscar Funcionario por Nome");

            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    buscaFuncionarioDataContratacao(scanner);
                    break;
                case 2:
                    buscaFuncionarioNomeSalarioMaiorData(scanner);
                    break;
                case 3:
                    buscaFuncionarioDataContratacao(scanner);
                    break;
                case 4:
                    pesquisaFuncionarioSalario();
                    break;
                default:
                    system = false;
                    break;
            }
        }
    }

    private void buscarFuncionarioNome(Scanner scanner) {
        System.out.println(" Qual Nome deseja pesquisar? ");
        String nome = scanner.next();

        List<Funcionario> funcionarioList = funcionarioRepository.findByNome(nome);
        funcionarioList.forEach(System.out::println);
    }

    private void buscaFuncionarioNomeSalarioMaiorData(Scanner scanner) {

        System.out.println(" Qual nome deseja pesquisar? ");
        String nome = scanner.next();

        System.out.println(" Qual data deseja pesquisar? ");
        String data = scanner.next();
        LocalDate localDate = LocalDate.parse(data, formatter);


        System.out.println(" Qual salario deseja pesquisar? ");
        Double salario = scanner.nextDouble();

        List<Funcionario> funcionarioList = funcionarioRepository.findNomeDataContratacaoSalarioMaior(nome, salario, localDate);
        funcionarioList.forEach(System.out::println);
    }

    private void buscaFuncionarioDataContratacao(Scanner scanner) {

        System.out.println(" Qual data deseja pesquisar? ");
        String data = scanner.next();
        LocalDate localDate = LocalDate.parse(data, formatter);

        List<Funcionario> funcionarioList = funcionarioRepository.findDataContratacaoMaior(localDate);
        funcionarioList.forEach(System.out::println);
    }

    private void pesquisaFuncionarioSalario() {
        List<FuncionarioProjecao> projecaoList = funcionarioRepository.findFuncionarioSalario();

        projecaoList.forEach(
                funcionario ->
                        System.out.println("Funcionario id: " + funcionario.getId()
                                + " | Nome: " + funcionario.getNome()
                                + " | Salário: " + funcionario.getSalario()
                        )
        );
    }
}
