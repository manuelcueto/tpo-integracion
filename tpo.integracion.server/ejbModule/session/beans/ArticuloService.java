package session.beans;

import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import converters.ArticuloConverter;
import dtos.ArticuloDto;
import entities.Articulo;

/**
 * Session Bean implementation class ArticuloService
 */
@Stateless
@LocalBean
public class ArticuloService implements ArticuloServiceRemote {

	/**
	 * Default constructor.
	 */

	@PersistenceContext
	private EntityManager entityManager;

	public ArticuloService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArticuloDto crearArticulo(ArticuloDto dto) throws RemoteException {

		Articulo articulo = ArticuloConverter.fromDto(dto);
		entityManager.persist(articulo);
		dto.setIdArticulo(articulo.getIdArticulo());
		this.notificarCreacion(dto);
		return dto;
	}

	@Override
	public void modificarStock(List<ArticuloDto> dtos) throws RemoteException {
		for (ArticuloDto articuloDto : dtos) {
			Articulo articulo = entityManager.find(Articulo.class, articuloDto.getIdArticulo());
			articulo.setStock(articuloDto.getStock());
			entityManager.merge(articulo);
		}

	}

	@Override
	public List<ArticuloDto> listarArticulos() throws RemoteException {
		return entityManager.createQuery("Select a from Articulo a").getResultList();
	}

	private void notificarCreacion(ArticuloDto articulo) {

	}

}
