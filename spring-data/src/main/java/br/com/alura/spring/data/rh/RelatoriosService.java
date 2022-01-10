package br.com.alura.spring.data.rh;

import java.util.List;
import java.util.Scanner;
import org.springframework.stereotype.Service;

@Service
public class RelatoriosService {

  private Boolean system = true;

  private final CargoRepository cargoRepository;

  private final FuncionarioRepository funcionarioRepository;

  public RelatoriosService(CargoRepository cargoRepository,
      FuncionarioRepository funcionarioRepository) {
    super();
    this.cargoRepository = cargoRepository;
    this.funcionarioRepository = funcionarioRepository;
  }


  public void inicial(Scanner scanner) {

    while (system) {
      System.out.println("0 - Voltar");
      System.out.println("1 - Busca cargo por descrição:");
      System.out.println("2 - Listar funcionários:");

      int opcao = scanner.nextInt();
      if (opcao == 1)
        this.buscarPorNome(scanner);
      if (opcao == 2)
        this.pesquisaFuncionarioProjecao();

      system = (opcao != 0);
    }
  }


  private void buscarPorNome(Scanner scanner) {
    System.out.println("Qual nome deseja pesquisar");
    String cargo = scanner.next();
    List<Cargo> list = cargoRepository.buscarNativo(cargo);
    list.forEach(System.out::println);
  }

  private void pesquisaFuncionarioProjecao() {
    List<FuncionarioProjecao> list = funcionarioRepository.findFuncionarioSalario();
    list.forEach(f -> System.out.println(
        "Funcionário(id: " + f.getId() + "|Nome:" + f.getNome() + "|Salário:" + f.getSalario()));
  }

}
