package com.formacionbdi.springboot.app.productos.springboot.app.productos.models.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name = "productos")
public class Producto implements Serializable {
  
  /* @GeneratedValue(strategy = GenerationType.IDENTITY) */
  @Id
  private Long id;
  
  @Column(name = "type_product")
  private String typeProduct;

  @Column(name = "name_product")
  private String nameProduct;

  private Double price;
  
  @Transient
  private Integer port;
  
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getTypeProduct() {
    return typeProduct;
  }
  public void setTypeProduct(String typeProduct) {
    this.typeProduct = typeProduct;
  }
  public String getNameProduct() {
    return nameProduct;
  }
  public void setNameProduct(String nameProduct) {
    this.nameProduct = nameProduct;
  }
  public Double getPrice() {
    return price;
  }
  public void setPrice(Double price) {
    this.price = price;
  }
  public Integer getPort() {
    return port;
  }
  public void setPort(Integer port) {
    this.port = port;
  }

  private static final long serialVersionUID = 1285454306356845809L;
}
