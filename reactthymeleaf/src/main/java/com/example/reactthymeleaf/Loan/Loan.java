package com.example.reactthymeleaf.Loan;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table
public class Loan {

    @Id
    private Integer id;

    @NotNull
    private BigDecimal commodityAmount;
}
