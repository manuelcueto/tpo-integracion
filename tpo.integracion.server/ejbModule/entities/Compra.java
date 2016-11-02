package entities;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "compras")
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCompra;

	@OneToMany
	private List<Pedido> pedidos;

	public Long getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Long idCompra) {
		this.idCompra = idCompra;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public static Compra fromJson(String json) {
		JsonReader reader = Json.createReader(new StringReader(json));
		JsonObject jsonObject = reader.readObject();

		Compra compra = new Compra();
		compra.setIdCompra(new Long(jsonObject.getInt("idCompra")));
		JsonArray pedidos = jsonObject.getJsonArray("pedidos");
		List<Pedido> pedidosObjeto = new ArrayList<Pedido>();
		for (JsonValue jsonValue : pedidos) {
			pedidosObjeto.add(Pedido.fromJson(jsonValue.toString()));
		}
		compra.setPedidos(pedidosObjeto);
		return compra;
	}

}
