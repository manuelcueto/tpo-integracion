package dtos;

import java.util.List;

public class SolicitudCompraDto {

	private List<PedidoDto> pedidos;
	private Long idSolicitud;

	public List<PedidoDto> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidoDto> pedidos) {
		this.pedidos = pedidos;
	}

	public void setIdSolicitud(Long idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

}
