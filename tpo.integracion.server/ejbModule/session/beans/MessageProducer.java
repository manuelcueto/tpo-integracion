package session.beans;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

/**
 * Session Bean implementation class MessageProductor
 */
@Singleton
@LocalBean
public class MessageProducer implements MessageProductorLocal {

	/**
	 * Default constructor.
	 */
	public MessageProducer() {

	}

}
