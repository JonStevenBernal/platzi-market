package com.platzi.market.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.number.money.MonetaryAmountFormatter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "compras_productos")
public class ComprasProducto {
    @Embedded // Clave primaria compuesta dada por otra clase
    private ComprasProductoPK id;

    private Integer cantidad;

    private BigDecimal total;

    private Boolean estado;
}
