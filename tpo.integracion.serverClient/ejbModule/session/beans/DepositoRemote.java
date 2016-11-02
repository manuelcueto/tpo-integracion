package session.beans;

import javax.ejb.Remote;

@Remote
public interface DepositoRemote extends ArticuloServiceRemote, SolicitudServiceLocal {

}
