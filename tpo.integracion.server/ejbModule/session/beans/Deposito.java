package session.beans;

import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import dtos.ArticuloDto;
import dtos.PedidoDto;
import dtos.SolicitudArticuloDto;
import dtos.SolicitudCompraDto;

/**
 * Session Bean implementation class Deposito
 */
@Stateless
@LocalBean
@Path("/deposito")
public class Deposito implements DepositoRemote {

	@Inject
	private ArticuloService articuloService;
	@Inject
	private SolicitudService solicitudService;

	/**
	 * Default constructor.
	 */
	public Deposito() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@POST
	@Path("/articulos")
	public ArticuloDto crearArticulo(ArticuloDto dto) throws RemoteException {
		return this.articuloService.crearArticulo(dto);
	}

	@Override
	@PUT
	@Path("/articulos")
	public void modificarStock(List<ArticuloDto> dtos) throws RemoteException {
		this.articuloService.modificarStock(dtos);
	}

	@Override
	@GET
	@Path("/articulos")
	public List<ArticuloDto> listarArticulos() throws RemoteException {
		return this.articuloService.listarArticulos();
	}

	@Override
	@GET
	@Path("/solicitudes")
	public List<SolicitudArticuloDto> getSolicitudesPendientes() {
		return this.solicitudService.getSolicitudesPendientes();
	}

	@Override
	@POST
	@Path("/compras")
	public SolicitudCompraDto crearSolicitudCompra(List<PedidoDto> pedidos) {
		return this.solicitudService.crearSolicitudCompra(pedidos);
	}

}
