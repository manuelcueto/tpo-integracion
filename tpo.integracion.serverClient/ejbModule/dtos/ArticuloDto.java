package dtos;

public class ArticuloDto {
String nombre;
	Long codigo;
	String descripcion;
	String marca;
	float precio;
	String origen;
	Long stock;
	
	public ArticuloDto(String nombre, Long codigo, String descripcion, String marca, float precio, String origen, Long stock) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.marca = marca;
		this.precio = precio;
		this.origen = origen;
		this.stock = stock;
	}
	
	public String getJsonString () {
		JSONObject personObject = (JSONObject) Json.createObjectBuilder()
		.add("codigo", this.getCodigo())
		.add("descripcion", this.getDescripcion())
		.add("marca", this.getMarca())
		.add("precio", this.getPrecio())
		.add("origen", this.getOrigen())
		.add("stock", this.getStock())
		.build();
		StringWriter stringWriter = new StringWriter();
		JsonWriter writer = Json.createWriter(stringWriter);
		writer.writeObject((JsonObject) personObject);
		writer.close();
		return stringWriter.getBuffer().toString();
	}
	public Long getStock() {
		return stock;
	}
	public void setStock(Long stock) {
		this.stock = stock;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
}
