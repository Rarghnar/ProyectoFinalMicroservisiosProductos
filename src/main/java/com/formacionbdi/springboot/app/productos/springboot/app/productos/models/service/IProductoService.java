package com.formacionbdi.springboot.app.productos.springboot.app.productos.models.service;

import java.util.List;

import com.formacionbdi.springboot.app.productos.springboot.app.productos.models.entity.Producto;

public interface IProductoService {
  
  public List<Producto> findAll();
  public List<Producto> findByTypeProduct();
  public List<Producto> findByRangeOfPrice();
  public List<Producto> findByname();
  public Producto findById(Long id);
}
