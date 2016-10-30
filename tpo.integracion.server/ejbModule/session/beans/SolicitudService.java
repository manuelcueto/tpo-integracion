package session.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import converters.PedidoConverter;
import converters.SolicitudCompraConverter;
import dtos.PedidoDto;
import dtos.SolicitudArticuloDto;
import dtos.SolicitudCompraDto;
import entities.SolicitudCompra;

/**
 * Session Bean implementation class SolicitudService
 */
@Stateless
@LocalBean
public class SolicitudService implements SolicitudServiceLocal {

	@PersistenceContext
	private EntityManager entityManager;

	public SolicitudService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<SolicitudArticuloDto> getSolicitudesPendientes() {

		return entityManager.createQuery("select s from SolicitudArticulo s where s.estado = 'pendiente'")
				.getResultList();
	}

	@Override
	public SolicitudCompraDto crearSolicitudCompra(List<PedidoDto> pedidos) {
		SolicitudCompra compra = new SolicitudCompra();
		compra.setPedidos(PedidoConverter.fromDtos(pedidos));
		entityManager.persist(compra);
		SolicitudCompraDto dto = SolicitudCompraConverter.toDto(compra);
		this.notificarFabrica(dto);
		return dto;
	}

	private void notificarFabrica(SolicitudCompraDto solicitud) {

	}

}
