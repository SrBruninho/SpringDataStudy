package br.com.srbruninho.springdataexample;

import br.com.srbruninho.springdataexample.orm.Cargo;
import br.com.srbruninho.springdataexample.repository.CargoRepository;
import br.com.srbruninho.springdataexample.service.CrudCargoService;
import br.com.srbruninho.springdataexample.service.CrudFuncionarioService;
import br.com.srbruninho.springdataexample.service.CrudUnidadeTrabalhoService;
import br.com.srbruninho.springdataexample.service.RelatoriosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataExampleApplication implements CommandLineRunner {

    @Autowired
    private CrudCargoService _cargoService;
    @Autowired
    private CrudFuncionarioService _funcionarioService;
    @Autowired
    private CrudUnidadeTrabalhoService _unidadeTrabalhoService;
    @Autowired
    private RelatoriosService _relatorioService;


    private boolean _system = true;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner l_scanner = new Scanner(System.in);

        while (_system) {
            System.out.println("Opção");
            System.out.println("0 - Sair ");
            System.out.println("1 - Cargo ");
            System.out.println("2 - Atualizar Cargo ");
            System.out.println("3 - Unidade Trabalho ");
            System.out.println("4 - Relatorios");
            System.out.println("5 - Funcionários");
            System.out.println("6 - PEsquisa funcionario salario");

            int acao = l_scanner.nextInt();

            switch (acao) {
                case 1:
                    _cargoService.salvar(l_scanner);
                    break;
                case 2:
                    System.out.println("Digite o ID para atualizar");
                    Long l_id = l_scanner.nextLong();

                    _cargoService.atualizarCargo(l_scanner, l_id);
                    break;
                case 3:
                    _unidadeTrabalhoService.inicial(l_scanner);
                    break;
                case 4:
                    _relatorioService.inicial(l_scanner);
                    break;
                case 5:
                    _funcionarioService.inicial(l_scanner);
                    break;
                default:
                    _system = false;
                    break;

            }
        }
    }
}
