package com.platzi.market.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.number.money.MonetaryAmountFormatter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "compras_productos")
public class ComprasProducto {
    @EmbeddedId // Clave primaria compuesta dada por otra clase
    private ComprasProductoPK id;

    private Integer cantidad;
    private BigDecimal total;
    private Boolean estado;

    @ManyToOne
    @MapsId("idCompra")
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto producto;

}
