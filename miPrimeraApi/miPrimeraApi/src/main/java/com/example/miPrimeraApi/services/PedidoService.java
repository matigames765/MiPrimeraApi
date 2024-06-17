package com.example.miPrimeraApi.services;

import com.example.miPrimeraApi.entities.DetallePedido;
import com.example.miPrimeraApi.entities.Pedido;
import com.example.miPrimeraApi.repositories.BaseRepository;
import com.example.miPrimeraApi.repositories.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService extends BaseService<Pedido, Long>{

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private DetallePedidoService detallePedidoService;

    public PedidoService(PedidoRepository pedidoRepository) {
        super(pedidoRepository);
    }

    @Transactional
    public List<Pedido> listarPorDomicilio(Long idDomicilio) throws Exception{
        try{
            return pedidoRepository.findAllByDomicilio_Id(idDomicilio);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<Pedido> listarPorSucursal(Long idSucursal) throws Exception{
        try{
            return pedidoRepository.findAllBySucursal_Id(idSucursal);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<Pedido> listarPorEmpleado(Long idEmpleado) throws Exception{
        try{
            return pedidoRepository.findAllByEmpleado_Id(idEmpleado);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<Pedido> listarPorCliente(Long idCliente) throws Exception{
        try{
            return pedidoRepository.findAllByCliente_Id(idCliente);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Pedido calcularTotalPedido(Pedido pedido) throws Exception{
        try{
            List<DetallePedido> detallesPedidos = detallePedidoService.listarPorPedido(pedido.getId());
            Double total = 0.0;
            if (detallesPedidos != null && !detallesPedidos.isEmpty()){

                for (int i = 0; i < detallesPedidos.toArray().length; i++){
                    total += detallesPedidos.get(i).getSubTotal();
                }

            }

            pedido.setTotal(total);
            return pedidoRepository.save(pedido);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Pedido actualizar(Pedido pedido) throws Exception {
        try{
            calcularTotalPedido(pedido);
            return pedidoRepository.save(pedido);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
