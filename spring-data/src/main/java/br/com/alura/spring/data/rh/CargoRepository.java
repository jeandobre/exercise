package br.com.alura.spring.data.rh;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends PagingAndSortingRepository<Cargo, Integer> {

  // Derived query
  List<Cargo> findByDescricao(String descricao);

  List<Cargo> findByDescricaoLike(String descricao, Pageable pageable);

  List<Cargo> findByDescricaoEndingWith(String sufixo);

  List<Cargo> findByDescricaoStartingWith(String prefixo);

  // JPQL
  @Query("SELECT c FROM Cargo c WHERE c.descricao = :texto")
  List<Cargo> buscarPor(String texto);

  // Native query
  @Query(value = "SELECT * FROM cargos c WHERE c.descricao = :texto ORDER BY c.descricao DESC",
      nativeQuery = true)
  List<Cargo> buscarNativo(String texto);
}
