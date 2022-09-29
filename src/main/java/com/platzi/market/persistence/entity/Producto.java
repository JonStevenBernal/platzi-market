package com.platzi.market.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity // Mapeo de la tabla de la BD define la arquitectura
@Table(name = "productos") // Nombre de la tabla de referencia
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    private String nombre;

    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "codigo_barras")
    private String codigoBarras;

    @Column(name = "precio_venta")
    private Double precioVenta;

    @Column(name = "cantidad_stock")
    private Integer cantidadStock;

    private Boolean estado;

    @ManyToOne // De muchos a uno
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false) //No se borra ni se actualiza una nueva categoria, Recupera a que categoria pertenece un producto
    private Categoria categoria;
}
