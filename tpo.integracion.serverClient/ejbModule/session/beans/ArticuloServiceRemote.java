package session.beans;

import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.Remote;

import dtos.ArticuloDto;

@Remote
public interface ArticuloServiceRemote {

	public ArticuloDto crearArticulo(ArticuloDto dto) throws RemoteException;

	public void modificarStock(List<ArticuloDto> dtos) throws RemoteException;

	public List<ArticuloDto> listarArticulos() throws RemoteException;

}
