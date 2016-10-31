package dtos;

public class ArticuloDto {

	private String nombre;
	private Long idArticulo;
	private String descripcion;
	private String marca;
	private Float precio;
	private String origen;
	private Long stock;
	private Integer ranking;
	private Date fecha;
	//DateFormat sfd = new SimpleDateFormat(" MM dd yyyy");
	private String categoria;
	public ArticuloDto() {
	}
	
	public String getJsonString () {
		JSONObject personObject = (JSONObject) Json.createObjectBuilder()
		.add("idArticulo", this.getIdArticulo())
		.add("descripcion", this.getDescripcion())
		.add("marca", this.getMarca())
		.add("precio", this.getPrecio())
		.add("origen", this.getOrigen())
		.add("stock", this.getStock())
		.add("ranking", this.getRanking())
		.add("fecha", this.getFecha())
		.add("categoria", this.getCategoria())
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
	public Long getIdArticulo() {
		return idArticulo;
	}
	public void setIdArticulo(Long idArticulo) {
		this.idArticulo = idArticulo;
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
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
}
