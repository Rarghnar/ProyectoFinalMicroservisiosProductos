package com.formacionbdi.springboot.app.productos.springboot.app.productos.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionbdi.springboot.app.productos.springboot.app.productos.models.dao.ProductoDao;
import com.formacionbdi.springboot.app.productos.springboot.app.productos.models.entity.Producto;

@Service
public class ProductoServiceImpl implements IProductoService {

  @Autowired
  private ProductoDao productoDao;

  @Override
  @Transactional(readOnly = true)
  public List<Producto> findAll() {
    return (List<Producto>) productoDao.findAll();
  }

  @Override
  public List<Producto> findByTypeProduct() {
    return (List<Producto>) productoDao.findAll();
  }

  @Override
  public List<Producto> findByRangeOfPrice() {
    return (List<Producto>) productoDao.findAll();
  }

  @Override
  public List<Producto> findByname() {
    return (List<Producto>) productoDao.findAll();
  }

  @Override
  public Producto findById(Long id) {
    return productoDao.findById(id).orElse(null);
  }

  @Override
  public void saveProduct(Producto producto) {
    productoDao.save(producto);
  }
  
}
