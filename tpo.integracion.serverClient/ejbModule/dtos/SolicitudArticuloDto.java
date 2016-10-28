package dtos;

import enums.Estado;

public class SolicitudArticuloDto {

	private Long idSolicitud;
	private ArticuloDto articulo;
	private Long stockSolicitado;
	private Estado estado;

	public Long getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(Long idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public ArticuloDto getArticulo() {
		return articulo;
	}

	public void setArticulo(ArticuloDto articulo) {
		this.articulo = articulo;
	}

	public Long getStockSolicitado() {
		return stockSolicitado;
	}

	public void setStockSolicitado(Long stockSolicitado) {
		this.stockSolicitado = stockSolicitado;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
