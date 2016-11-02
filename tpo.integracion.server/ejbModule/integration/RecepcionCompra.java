package integration;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Articulo;
import entities.Compra;
import entities.Pedido;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic") })
public class RecepcionCompra implements MessageListener {

	@PersistenceContext
	private EntityManager entityManager;

	public void onMessage(Message message) {
		TextMessage receivedMessage = (TextMessage) message;
		try {

			this.processMessage(receivedMessage.getText());
			// actualizar Stock de los articulos

		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void processMessage(String text) {
		Compra compra = Compra.fromJson(text);
		for (Pedido pedido : compra.getPedidos()) {
			Articulo art = this.entityManager.find(Articulo.class, pedido.getArticulo().getIdArticulo());
			art.agregarStock(pedido.getStock());
			this.entityManager.persist(art);
		}
		this.entityManager.persist(compra);
	}

}
