package dtos;

public class PedidoDto {

	private Long idPedido;

	private ArticuloDto articulo;
	private Long stock;

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public ArticuloDto getArticulo() {
		return articulo;
	}

	public void setArticulo(ArticuloDto articulo) {
		this.articulo = articulo;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

}
