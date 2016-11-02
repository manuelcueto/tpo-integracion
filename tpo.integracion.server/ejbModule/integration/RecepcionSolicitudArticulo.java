package integration;

import java.io.StringReader;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Articulo;
import entities.SolicitudArticulo;

/**
 * Message-Driven Bean implementation class for: RecepcionCompra
 */
@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic") })
public class RecepcionSolicitudArticulo implements MessageListener {

	@PersistenceContext
	private EntityManager persistenceManager;

	public RecepcionSolicitudArticulo() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see MessageListener#onMessage(Message)
	 */
	public void onMessage(Message message) {
		TextMessage receivedMessage = (TextMessage) message;
		try {
			String messageContent = receivedMessage.getText();
			this.processMessage(messageContent);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void processMessage(String json) {
		JsonReader reader = Json.createReader(new StringReader(json));
		JsonObject jsonObject = reader.readObject();
		Long despacho = new Long(jsonObject.getInt("idGrupo"));
		for (JsonValue art : jsonObject.getJsonArray("items")) {
			JsonObject info = Json.createReader(new StringReader(art.toString())).readObject();
			Articulo articulo = this.persistenceManager.find(Articulo.class, info.getString("codArticulo"));
			this.persistenceManager.persist(this.buildSolicitud(articulo, new Long(info.getInt("cantidad")), despacho));
		}
	}

	private SolicitudArticulo buildSolicitud(Articulo art, Long stockSolicitado, Long idDespacho) {
		SolicitudArticulo sol = new SolicitudArticulo();
		sol.setArticulo(art);
		sol.setStockSolicitado(stockSolicitado);
		sol.setIdDespacho(idDespacho);
		// sol.setEstado(Estado.PENDIENTE);
		sol.setEstado(null);
		return sol;
	}
}
