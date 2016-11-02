package entities;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "articulos")
public class Articulo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idArticulo;
	private Float precio;
	private String nombre;
	private String descripcion;
	private Long stock;

	public Long getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(Long idArticulo) {
		this.idArticulo = idArticulo;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	public static Articulo fromJson(String json) {
		JsonReader reader = Json.createReader(new StringReader(json));
		JsonObject jsonObject = reader.readObject();
		Articulo articulo = new Articulo();
		articulo.setIdArticulo(new Long(jsonObject.getInt("idArticulo")));
		articulo.setDescripcion(jsonObject.getString("descripcion"));
		articulo.setNombre(jsonObject.getString("nombre"));
		articulo.setPrecio(new Float(jsonObject.getInt("precio")));
		articulo.setStock(new Long(jsonObject.getInt("stock")));
		return articulo;
	}

	public void agregarStock(Long stock) {
		this.stock += stock;
	}

}
