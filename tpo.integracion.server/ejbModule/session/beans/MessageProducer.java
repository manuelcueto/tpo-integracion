package session.beans;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.eclipsesource.json.JsonObject;

import dtos.ArticuloDto;

/**
 * Session Bean implementation class MessageProductor
 */
@Singleton
@LocalBean
public class MessageProducer implements MessageProductorLocal {

	private Context context;

	private ConnectionFactory connectionFactory;

	/**
	 * Default constructor.
	 * 
	 * @throws NamingException
	 * @throws JMSException
	 */
	private MessageProducer() throws NamingException, JMSException {
		this.context = new InitialContext();
		String connectionFactoryString = "jms/RemoteConnectionFactory";
		this.connectionFactory = (ConnectionFactory) context.lookup(connectionFactoryString);
	}

	private Session createSession() throws JMSException {
		Connection connection = this.connectionFactory.createConnection("user1", "usuario1");
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		connection.start();
		return session;
	}

	public TextMessage createTextMessage(ArticuloDto dto) throws JMSException {
		Session session = this.createSession();
		TextMessage message = session.createTextMessage();
		JsonObject json = new JsonObject();
		json.add("nombre", dto.getNombre());
		json.add("descripcion", dto.getDescripcion());
		json.add("precio", dto.getPrecio());
		json.add("stock", dto.getStock());
		json.add("idArticulo", dto.getIdArticulo());
		message.setText(json.toString());
		return message;
	}

}
