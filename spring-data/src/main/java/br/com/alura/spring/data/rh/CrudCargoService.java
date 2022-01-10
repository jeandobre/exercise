package br.com.alura.spring.data.rh;

import java.util.Scanner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CrudCargoService {

  private final CargoRepository repository;
  private Boolean system = true;

  public CrudCargoService(CargoRepository repository) {
    super();
    this.repository = repository;
  }

  public void inicial(Scanner scanner) {

    while (system) {
      System.out.println("0 - Voltar");
      System.out.println("1 - Novo cargo");
      System.out.println("2 - Alterar cargo");
      System.out.println("3 - Listar cargos");
      int opcao = scanner.nextInt();
      if (opcao == 1)
        this.salvar(scanner);
      if (opcao == 2)
        this.atualizar(scanner);
      if (opcao == 3)
        this.listar(scanner);

      system = (opcao != 0);
    }

    this.salvar(scanner);
  }

  private void salvar(Scanner scanner) {
    System.out.println("Descrição do cargo");
    String descricao = scanner.next();

    Cargo cargo = new Cargo();
    cargo.setDescricao(descricao);

    this.repository.save(cargo);
  }

  private void atualizar(Scanner scanner) {
    System.out.println("Id do registro: ");
    int id = scanner.nextInt();
    System.out.println("Descrição do cargo:");
    String descricao = scanner.next();

    Cargo cargo = new Cargo();
    cargo.setId(id);
    cargo.setDescricao(descricao);

    this.repository.save(cargo);
  }

  private void listar(Scanner scanner) {
    System.out.println("Qual página você deseja visualizar:");
    Integer page = scanner.nextInt();

    Pageable pageable = PageRequest.of(page, 5, Sort.by(Sort.Direction.DESC, "descricao"));

    Page<Cargo> cargos = repository.findAll(pageable);

    System.out.println(cargos);
    System.out.println("Página atual: " + cargos.getNumber());
    System.out.println("Total elemento: " + cargos.getTotalElements());
    cargos.forEach(cargo -> System.out.println(cargo));
  }
}
