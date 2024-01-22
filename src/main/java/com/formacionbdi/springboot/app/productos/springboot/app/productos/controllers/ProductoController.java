package com.formacionbdi.springboot.app.productos.springboot.app.productos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.productos.springboot.app.productos.models.entity.Producto;
import com.formacionbdi.springboot.app.productos.springboot.app.productos.models.service.IProductoService;


@RestController
public class ProductoController {

  @Autowired
  private Environment env;

  @Value("${server.port}")
  private Integer port;
  
  @Autowired
  private IProductoService productoService;

  @GetMapping("/listar")
  public List<Producto> listar() {
    return productoService.findAll().stream().map(producto -> {
      //producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
      producto.setPort(port);
      return producto;
    }).collect(Collectors.toList());
  }

  @GetMapping("/listar/{typeProduct}")
  public List<Producto> listarTypeProduct(@PathVariable String typeProduct) {
    return productoService.findAll().stream()
      .filter(producto -> producto.getTypeProduct().equalsIgnoreCase(typeProduct))
      .peek(producto -> producto.setPort(port))
      .collect(Collectors.toList());
  }

  @GetMapping("/listar/precio/{price}")
  public List<Producto> listarRangeOfPrice(@PathVariable Double price) {
    return productoService.findAll().stream()
      .filter(producto -> producto.getPrice() > price)
      .peek(producto -> producto.setPort(port))
      .collect(Collectors.toList());
  }

  @GetMapping("/listar/byName/{name}")
  public List<Producto> listarByName(@PathVariable String name) {
    return productoService.findAll().stream()
      .filter(producto -> producto.getNameProduct().toLowerCase().contains(name.toLowerCase()))
      .peek(producto -> producto.setPort(port))
      .collect(Collectors.toList());
  }

  @GetMapping("/ver/{id}")
  public Producto detalle(@PathVariable Long id) {
    Producto producto = productoService.findById(id);
    //producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
    producto.setPort(port);
    return producto;
  }
  
}
