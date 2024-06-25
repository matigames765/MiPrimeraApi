package com.example.miPrimeraApi.controllers;

import com.example.miPrimeraApi.entities.DetallePedido;
import com.example.miPrimeraApi.entities.Factura;
import com.example.miPrimeraApi.entities.Pedido;
import com.example.miPrimeraApi.repositories.PedidoRepository;
import com.example.miPrimeraApi.services.BaseService;
import com.example.miPrimeraApi.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController extends BaseController<Pedido,Long> {

    @Autowired
    private PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        super(pedidoService);
    }

    @GetMapping("/domicilio/{id}")
    public ResponseEntity<List<Pedido>> listarPorDomicilio(@PathVariable Long idDomicilio) throws Exception{
        List<Pedido> pedidos = pedidoService.listarPorDomicilio(idDomicilio);
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/sucursal/{id}")
    public ResponseEntity<List<Pedido>> listarPorSucursal(@PathVariable Long idSucursal) throws Exception{
        List<Pedido> pedidos = pedidoService.listarPorSucursal(idSucursal);
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/empleado/{id}")
    public ResponseEntity<List<Pedido>> listarPorEmpleado(@PathVariable Long idEmpleado) throws Exception{
        List<Pedido> pedidos = pedidoService.listarPorEmpleado(idEmpleado);
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<Pedido>> listarPorCliente(@PathVariable Long idCliente) throws Exception{
        List<Pedido> pedidos = pedidoService.listarPorCliente(idCliente);
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/factura/{id}")
    public Optional<Factura> mostrarFacturaPorPedido(@PathVariable Long idPedido) throws Exception{
        Factura factura = pedidoService.mostrarFacturaPorPedido(idPedido);
        return Optional.ofNullable(factura);
    }

    @PutMapping("/total")
    public Optional<Pedido> calcularTotal(@RequestBody Pedido pedido) throws Exception{
        Pedido pedido_aux = pedidoService.calcularTotalPedido(pedido);
        return Optional.ofNullable(pedido_aux);
    }
}
