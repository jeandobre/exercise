package br.com.alura.spring.data.rh;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import br.com.alura.spring.data.specification.FuncionarioSpec;

@Service
public class RelatorioFuncionarioDinamico {

  private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  private final FuncionarioRepository funcionarioRepository;

  public RelatorioFuncionarioDinamico(FuncionarioRepository funcionarioRepository) {
    super();
    this.funcionarioRepository = funcionarioRepository;
  }

  public void inicial(Scanner scanner) {
    System.out.println("Please, type a name: ");
    String nome = scanner.next();
    if (nome.equalsIgnoreCase("NULL"))
      nome = null;

    System.out.println("Please, type a cpf: ");
    String cpf = scanner.next();
    if (cpf.equalsIgnoreCase("NULL"))
      cpf = null;

    System.out.println("Please, type a salary: ");
    Double salario = scanner.nextDouble();
    if (salario == 0)
      salario = null;

    System.out.println("Please, type a date: ");
    String data = scanner.next();
    LocalDate dataContratacao = null;
    if (!data.equalsIgnoreCase("NULL"))
      dataContratacao = LocalDate.parse(data, formatter);

    List<Funcionario> funcionarios = funcionarioRepository.findAll(Specification
        .where(FuncionarioSpec.nome(nome)).or(FuncionarioSpec.cpf(cpf))
        .or(FuncionarioSpec.salario(salario)).or(FuncionarioSpec.dataContratacao(dataContratacao)));

    funcionarios.forEach(System.out::println);
  }

}
