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

		return null;
	}

	@Override
	public void modificarStock(List<ArticuloDto> dtos) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ArticuloDto> listarArticulos() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	private void notificarCreacion() {

	}

}
