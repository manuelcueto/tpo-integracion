package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import enums.Estado;

@Entity
@Table(name = "solicitudes")
public class SolicitudArticulo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idSolicitud;
	@OneToOne
	private Articulo articulo;
	private Long idDespacho;
	private Long stockSolicitado;
	private Estado estado;

	public Long getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(Long idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
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

	public Long getIdDespacho() {
		return idDespacho;
	}

	public void setIdDespacho(Long idDespacho) {
		this.idDespacho = idDespacho;
	}

}
