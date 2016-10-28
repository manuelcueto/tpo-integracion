package integration;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import entities.Pedido;

/**
 * Message-Driven Bean implementation class for: RecepcionCompra
 */
@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic") })
public class RecepcionCompra implements MessageListener {

	/**
	 * Default constructor.
	 */
	public RecepcionCompra() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see MessageListener#onMessage(Message)
	 */
	public void onMessage(Message message) {
		ObjectMessage receivedMessage = (ObjectMessage) message;
		try {
			Pedido pedido = receivedMessage.getBody(Pedido.class);
			// llamar al PersistenceManager(debería estar en un session
			// bean(posiblemente singleton)) y actualizar stock de los articulos
			// dentro del stockX
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
