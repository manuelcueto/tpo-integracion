package dtos;

public class ArticuloDto {
	private String nombre;
	private Long codigo;
	private String descripcion;
	private String marca;
	private float precio;
	private String origen;
	private Long stock;
	
	public ArticuloDto() {
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
