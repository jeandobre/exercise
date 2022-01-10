package br.com.alura.spring.data.rh;

import java.util.List;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Integer>,
    JpaSpecificationExecutor<Funcionario> {

  @Query(value = "SELECT f.id, f.nome, f.salario FROM funcionarios f", nativeQuery = true)
  List<FuncionarioProjecao> findFuncionarioSalario();
}
