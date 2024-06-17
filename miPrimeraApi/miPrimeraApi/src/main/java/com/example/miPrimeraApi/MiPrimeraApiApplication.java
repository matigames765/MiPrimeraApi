package com.example.miPrimeraApi;

import com.example.miPrimeraApi.entities.*;
import com.example.miPrimeraApi.entities.enums.*;
import com.example.miPrimeraApi.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;


@SpringBootApplication
public class MiPrimeraApiApplication {

	@Autowired
	private ImagenRepository imagenRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ArticuloInsumoRepository articuloInsumoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private DetallePedidoRepository detallePedidoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private DomicilioRepository domicilioRepository;

	@Autowired
	private PaisRepository paisRepository;

	@Autowired
	private ProvinciaRepository provinciaRepository;

	@Autowired
	private LocalidadRepository localidadRepository;

	@Autowired
	private SucursalRepository sucursalRepository;

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private PromocionRepository promocionRepository;

	@Autowired
	private FacturaRepository facturaRepository;

	@Autowired
	private UnidadMedidaRepository unidadMedidaRepository;

	@Autowired
	private ArticuloManufacturadoRepository articuloManufacturadoRepository;

	@Autowired
	private ArticuloManufacturadoDetalleRepository articuloManufacturadoDetalleRepository;

	@Autowired
	private PromocionDetalleRepository promocionDetalleRepository;

	public static void main(String[] args) {
		SpringApplication.run(MiPrimeraApiApplication.class, args);
		System.out.println("Servidor iniciado.");
	}

	@Bean
	@Transactional
	CommandLineRunner init(ImagenRepository imagenRepository, UsuarioRepository usuarioRepository,
						   EmpleadoRepository empleadoRepository, ClienteRepository clienteRepository,
						   ArticuloInsumoRepository articuloInsumoRepository,
						   CategoriaRepository categoriaRepository, PedidoRepository pedidoRepository,
						   DomicilioRepository domicilioRepository,PaisRepository paisRepository,
						   ProvinciaRepository provinciaRepository, LocalidadRepository localidadRepository,
						   SucursalRepository sucursalRepository, EmpresaRepository empresaRepository,
						   PromocionRepository promocionRepository, FacturaRepository facturaRepository,
						   DetallePedidoRepository detallePedidoRepository,
						   UnidadMedidaRepository unidadMedidaRepository,
						   ArticuloManufacturadoRepository articuloManufacturadoRepository,
						   ArticuloManufacturadoDetalleRepository articuloManufacturadoDetalleRepository,
						   PromocionDetalleRepository promocionDetalleRepository){
		return args -> {
			Imagen img1 = Imagen.builder().denominacion("Imagen 1").build();
			imagenRepository.save(img1);

			Imagen img2 = Imagen.builder().denominacion("Imagen 2").build();
			imagenRepository.save(img2);

			Usuario user = Usuario.builder().auth0Id("passs").userName("user").build();
			usuarioRepository.save(user);

			Usuario user2 = Usuario.builder().auth0Id("pass").userName("user2").build();
			usuarioRepository.save(user2);

			Empleado em1 = Empleado.builder().rolEmpleado(Rol.CAJERO).build();
			em1.setNombre("Matías");
			em1.setApellido("Games");
			em1.setTelefono("123456");
			em1.setEmail("empleado1@gmail.com");
			em1.setFechaNacimiento(LocalDate.of(1992, 5, 27));
			em1.setImagenEmpleado(img1);
			em1.setUsuarioEmpleado(user);
			empleadoRepository.save(em1);

			Cliente client1 = Cliente.builder().rolCliente(Rol.CLIENTE).build();
			client1.setNombre("Juan");
			client1.setApellido("Gonzales");
			client1.setTelefono("234578");
			client1.setEmail("cliente1@gmail.com");
			client1.setFechaNacimiento(LocalDate.of(1995,4,15));
			client1.setImagenCliente(img2);
			client1.setUsuarioCliente(user2);
			clienteRepository.save(client1);

			Categoria categoriaHija = Categoria.builder().denominacion("helados").build();
			Categoria categoriaPadre = Categoria.builder().denominacion("postres").build();
			categoriaRepository.save(categoriaPadre);
			categoriaHija.setCategoriaPadre(categoriaPadre);
			categoriaRepository.save(categoriaHija);

			Imagen imagen1ArticuloInsumo = Imagen.builder().denominacion("Imagen 1 articulo insumo").build();
			Imagen imagen2ArticuloInsumo = Imagen.builder().denominacion("Imagen 2 Articulo insumo").build();
			imagenRepository.save(imagen1ArticuloInsumo);
			imagenRepository.save(imagen2ArticuloInsumo);

			Set<Imagen> imagenesArticulos = new HashSet<Imagen>();
			imagenesArticulos.add(imagen1ArticuloInsumo);
			imagenesArticulos.add(imagen2ArticuloInsumo);

			Categoria categoriaInsumo = Categoria.builder().denominacion("insumos comidas saladas y dulces").build();
			categoriaRepository.save(categoriaInsumo);

			UnidadMedida unidadMedidaArticulos = UnidadMedida.builder().denominacion("kg").build();
			unidadMedidaRepository.save(unidadMedidaArticulos);

			ArticuloInsumo articuloInsumo = ArticuloInsumo.builder().denominacion("Harina de trigo").build();
			articuloInsumo.setPrecioVenta(10.5);
			articuloInsumo.setImagenesArticulos(imagenesArticulos);
			articuloInsumo.setCategoria(categoriaInsumo);
			articuloInsumo.setUnidadMedida(unidadMedidaArticulos);
			articuloInsumo.setPrecioCompra(4.3);
			articuloInsumo.setStockActual(50);
			articuloInsumo.setStockMaximo(90);
			articuloInsumo.setEsParaElaborar(true);
			articuloInsumoRepository.save(articuloInsumo);
			imagenesArticulos.clear();

			Imagen imagen1ArticuloManufacturado = Imagen.builder().denominacion("Imagen 1 articulo manufacturado").build();
			Imagen imagen2ArticuloManufacturado = Imagen.builder().denominacion("Imagen 2 Articulo manufacturado").build();
			imagenRepository.save(imagen1ArticuloManufacturado);
			imagenRepository.save(imagen2ArticuloManufacturado);

			imagenesArticulos.add(imagen1ArticuloManufacturado);
			imagenesArticulos.add(imagen2ArticuloManufacturado);

			Categoria categoriaSucursal1 = Categoria.builder().denominacion("cervezas").build();
			Categoria categoriaSucursal2 = Categoria.builder().denominacion("platos salados").build();
			categoriaRepository.save(categoriaSucursal1);
			categoriaRepository.save(categoriaSucursal2);

			Set<Categoria> categoriasSucursal = new HashSet<Categoria>();
			categoriasSucursal.add(categoriaSucursal1);
			categoriasSucursal.add(categoriaSucursal2);

			ArticuloManufacturado articuloManufacturado = ArticuloManufacturado.builder().denominacion("Pizza Margarita").build();
			articuloManufacturado.setPrecioVenta(40.3);
			articuloManufacturado.setImagenesArticulos(imagenesArticulos);
			articuloManufacturado.setCategoria(categoriaSucursal2);
			articuloManufacturado.setUnidadMedida(unidadMedidaArticulos);
			articuloManufacturado.setDescripcion("Pizza clásica italiana con base de tomate, mozzarella fresca y hojas de albahaca.");
			articuloManufacturado.setTiempoEstimadoMinutos(40);
			articuloManufacturado.setPreparacion("Extender la masa, añadir salsa de tomate, mozzarella y albahaca. Hornear hasta que el queso se derrita y la masa esté dorada.");
			articuloManufacturadoRepository.save(articuloManufacturado);

			ArticuloManufacturadoDetalle articuloManufacturadoDetalle = ArticuloManufacturadoDetalle.builder().cantidad(3).build();
			articuloManufacturadoDetalle.setArticuloManufacturado(articuloManufacturado);
			articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetalle);

			Pais pais = Pais.builder().nombre("Argentina").build();
			paisRepository.save(pais);

			Provincia provincia = Provincia.builder().nombre("Mendoza").build();
			provincia.setPais(pais);
			provinciaRepository.save(provincia);

			Localidad localidad = Localidad.builder().nombre("Lujan").build();
			localidad.setProvincia(provincia);
			localidadRepository.save(localidad);

			Domicilio domicilioSucursal = Domicilio.builder().calle("Italia").numero(456).cp(6070).build();
			domicilioSucursal.setLocalidad(localidad);
			domicilioRepository.save(domicilioSucursal);


			Empresa empresa = Empresa.builder().nombre("Buen sabor").razonSocial("Buen sabor S.A").cuil(65432198).build();
			empresaRepository.save(empresa);

			Imagen imgPromocion11 = Imagen.builder().denominacion("Imagen 1 promocion 1").build();
			Imagen imgPromocion12 = Imagen.builder().denominacion("Imagen 2 promocion 1").build();
			imagenRepository.save(imgPromocion11);
			imagenRepository.save(imgPromocion12);

			Promocion promocion = Promocion.builder().denominacion("Pizza Margarita a mitad de precio").build();
			promocion.setFechaDesde(LocalDate.of(2024,5,15));
			promocion.setFechaHasta(LocalDate.of(2024,6,15));
			promocion.setHoraDesde(LocalTime.of(12,0));
			promocion.setHoraHasta(LocalTime.of(16,0));
			promocion.setDescripcionDescuento("Disfruta de nuestra rica pizza margarita a un 50% de descuento!");
			promocion.setPrecioPromocional(55.0);
			promocion.setTipoPromocion(TipoPromocion.PROMOCION);
			Set<Imagen> imagenesPromocion = new HashSet<Imagen>();
			imagenesPromocion.add(imgPromocion11);
			imagenesPromocion.add(imgPromocion12);
			promocion.setImagenesPromociones(imagenesPromocion);
			promocionRepository.save(promocion);

			PromocionDetalle promocion1Detalle = PromocionDetalle.builder().cantidad(2).build();
			promocion1Detalle.setArticulo(articuloManufacturado);
			promocion1Detalle.setPromocion(promocion);
			promocionDetalleRepository.save(promocion1Detalle);

			Imagen imgPromocion21 = Imagen.builder().denominacion("Imagen 1 promocion 2").build();
			Imagen imgPromocion22 = Imagen.builder().denominacion("Imagen 2 promocion 2").build();
			imagenRepository.save(imgPromocion21);
			imagenRepository.save(imgPromocion22);

			Promocion promocion2 = Promocion.builder().denominacion("Happy Hour en cervezas").build();
			promocion2.setFechaDesde(LocalDate.of(2024,1,1));
			promocion2.setFechaHasta(LocalDate.of(2024,3,1));
			promocion2.setHoraDesde(LocalTime.of(20,0));
			promocion2.setHoraHasta(LocalTime.of(22,0));
			promocion2.setDescripcionDescuento("Happy hour en cervezas (2 x 1) desde las 20:00 hasta las 22:00");
			promocion2.setTipoPromocion(TipoPromocion.HAPPYHOUR);
			Set<Imagen> imagenesPromocion2 = new HashSet<Imagen>();
			imagenesPromocion2.add(imgPromocion21);
			imagenesPromocion2.add(imgPromocion22);
			promocion2.setImagenesPromociones(imagenesPromocion2);
			promocionRepository.save(promocion2);

			Set<Promocion> promocionesSucursal = new HashSet<Promocion>();
			promocionesSucursal.add(promocion);
			promocionesSucursal.add(promocion2);

			Sucursal sucursal = Sucursal.builder().nombre("Buen Sabor Godoy Cruz").build();
			sucursal.setHorarioApertura(LocalTime.of(12,0));
			sucursal.setHorarioCierre(LocalTime.of(1,0));
			sucursal.setCasaMatriz(true);
			sucursal.setEmpresa(empresa);
			sucursal.setDomicilio(domicilioSucursal);
			sucursal.setPromociones(promocionesSucursal);
			sucursal.setCategorias(categoriasSucursal);
			sucursalRepository.save(sucursal);

			Factura facturaPedido = Factura.builder().fechaFacturacion(LocalDate.of(2024,5,12)).build();
			facturaPedido.setMpPaymentId(2345678);
			facturaPedido.setMpMerchantOrderId(78945612);
			facturaPedido.setMpPreferenceId("12345678-abcd-1234-abcd-1234567890ab");
			facturaPedido.setMpPaymentType("Dinero en cuenta");
			facturaPedido.setFormaPago(FormaPago.MERCADOPAGO);
			facturaPedido.setTotalVenta(120.9);
			facturaRepository.save(facturaPedido);

			Pedido pedido = Pedido.builder().horaEstimadaFinalizacion(LocalTime.of(13,30)).build();
			pedido.setTotal(120.9);
			pedido.setTotalCosto(54.0);
			pedido.setEstado(Estado.PREPARACION);
			pedido.setTipoEnvio(TipoEnvio.TAKEAWAY);
			pedido.setFormaPago(FormaPago.MERCADOPAGO);
			pedido.setFechaPedido(LocalDate.of(2024,2,15));
			pedido.setDomicilio(domicilioSucursal);
			pedido.setSucursal(sucursal);
			pedido.setEmpleado(em1);
			pedido.setCliente(client1);
			pedido.setFactura(facturaPedido);
			pedidoRepository.save(pedido);

			DetallePedido detallePedido = DetallePedido.builder().cantidad(3).build();
			detallePedido.setSubTotal(40.3);
			detallePedido.setArticulo(articuloManufacturado);
			detallePedido.setPedido(pedido);
			detallePedidoRepository.save(detallePedido);
		};
	}

}
