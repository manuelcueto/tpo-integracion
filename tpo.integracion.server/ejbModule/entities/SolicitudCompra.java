package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SOLICITUDES_COMPRA")
public class SolicitudCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idSolicitud;
	@OneToMany
	private List<Pedido> pedidos;
	
	private EstadoSolicitudCompra estado;
	
	public Estado getEstado(){
		return estado;	
	}
	
	public void setEstado(EstadoSolicitudCompra estado){
		this.estado = estado;	
	}
	
	public Long getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(Long idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

}
