package br.com.alura.spring.data;

import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.alura.spring.data.rh.CrudCargoService;
import br.com.alura.spring.data.rh.RelatorioFuncionarioDinamico;
import br.com.alura.spring.data.rh.RelatoriosService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

  private Boolean system = true;
  private final CrudCargoService service;
  private final RelatoriosService relatorioService;

  @Autowired
  private RelatorioFuncionarioDinamico relatorioFuncionarioDinamico;

  public SpringDataApplication(CrudCargoService service, RelatoriosService relatorioService) {
    super();
    this.service = service;
    this.relatorioService = relatorioService;
  }

  public static void main(String[] args) {
    SpringApplication.run(SpringDataApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    Scanner scanner = new Scanner(System.in);

    while (system) {
      System.out.println("Qual ação você quer executar");
      System.out.println("0 - Sair");
      System.out.println("1 - Cargo");
      System.out.println("2 - Relatórios de cargo");
      System.out.println("3 - Relatórios de funcionários");

      int action = scanner.nextInt();
      if (action == 1) {
        service.inicial(scanner);
      } else if (action == 2) {
        relatorioService.inicial(scanner);
      } else if (action == 3) {
        relatorioFuncionarioDinamico.inicial(scanner);
      }
      system = (action != 0);
    }

  }

}
