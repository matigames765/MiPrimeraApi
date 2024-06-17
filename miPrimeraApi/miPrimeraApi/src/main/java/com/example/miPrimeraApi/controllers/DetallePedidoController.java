package com.example.miPrimeraApi.controllers;

import com.example.miPrimeraApi.entities.DetallePedido;
import com.example.miPrimeraApi.services.BaseService;
import com.example.miPrimeraApi.services.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/detalles_pedidos")
public class DetallePedidoController extends BaseController<DetallePedido,Long>{

    @Autowired
    private DetallePedidoService detallePedidoService;

    public DetallePedidoController(DetallePedidoService detallePedidoService) {
        super(detallePedidoService);
    }

    @GetMapping("/pedido/{id}")
    public ResponseEntity<List<DetallePedido>> listarPorPedido(@PathVariable Long idPedido) throws Exception{
        List<DetallePedido> detallesPedidos = detallePedidoService.listarPorPedido(idPedido);
        return ResponseEntity.ok(detallesPedidos);
    }

    @GetMapping("/articulo/{id}")
    public ResponseEntity<List<DetallePedido>> listarPorArticulo(@PathVariable Long idArticulo) throws Exception{
        List<DetallePedido> detallesPedidos = detallePedidoService.listarPorArticulo(idArticulo);
        return ResponseEntity.ok(detallesPedidos);
    }
}
