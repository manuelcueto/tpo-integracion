package session.beans;

import java.util.List;

import javax.ejb.Local;

import dtos.PedidoDto;
import dtos.SolicitudArticuloDto;
import dtos.SolicitudCompraDto;

@Local
public interface SolicitudServiceLocal {

	public List<SolicitudArticuloDto> getSolicitudesPendientes();

	public SolicitudCompraDto crearSolicitudCompra(List<PedidoDto> pedidos);

}
