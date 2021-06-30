package br.com.srbruninho.springdataexample.service;

import br.com.srbruninho.springdataexample.orm.Cargo;
import br.com.srbruninho.springdataexample.orm.Funcionario;
import br.com.srbruninho.springdataexample.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class CrudCargoService {

    @Autowired
    private CargoRepository _cargoRepository;

    public void inicial(Scanner p_scanner) {

    }

    public void atualizarCargo(Scanner p_scanner, Long p_id) {
        Optional<Cargo> l_optionalCargo = _cargoRepository.findById(p_id);

        if (l_optionalCargo.isPresent()) {
            System.out.println("Nova descrição do cargo");
            String descricao = p_scanner.next();
            Cargo l_cargo = l_optionalCargo.get();

            l_cargo.setDescricao(descricao);
            _cargoRepository.save(l_cargo);
            System.out.println(" Cargo atualizado com sucesso !");

        } else {
            System.out.println(" Cargo não encontrado !");
        }

    }

    public void salvar(Scanner p_scanner) {
        System.out.println("Descrição do cargo");
        String descricao = p_scanner.next();

        Cargo l_cargo = new Cargo();
        l_cargo.setDescricao(descricao);

        _cargoRepository.save(l_cargo);
        System.out.println("Salvo com sucesso ! ");

    }


}
