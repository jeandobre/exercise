package br.com.alura.spring.data.rh;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "funcionarios")
public class Funcionario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public LocalDate getDataContratacao() {
    return dataContratacao;
  }

  public void setDataContratacao(LocalDate dataContratacao) {
    this.dataContratacao = dataContratacao;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public Double getSalario() {
    return salario;
  }

  public void setSalario(Double salario) {
    this.salario = salario;
  }

  public Cargo getCargo() {
    return cargo;
  }

  public void setCargo(Cargo cargo) {
    this.cargo = cargo;
  }

  @Column(length = 180)
  private String nome;

  private LocalDate dataContratacao;

  private String cpf;

  private Double salario;

  @ManyToOne
  @JoinColumn(name = "cargo_id", nullable = false)
  private Cargo cargo;

  @Override
  public String toString() {
    return "#" + id + " - " + nome + "|" + cpf;
  }



}
