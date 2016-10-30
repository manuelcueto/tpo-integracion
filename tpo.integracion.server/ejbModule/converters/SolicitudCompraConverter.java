package converters;

import dtos.SolicitudCompraDto;
import entities.SolicitudCompra;

public class SolicitudCompraConverter {

	public static SolicitudCompraDto toDto(SolicitudCompra compra) {
		SolicitudCompraDto dto = new SolicitudCompraDto();
		dto.setPedidos(PedidoConverter.toDtos(compra.getPedidos()));
		dto.setIdSolicitud(compra.getIdSolicitud());
		return dto;
	}
}
