package dtos;

import java.util.List;

public class CompraDto {

	private Long idCompra;
	private List<PedidoDto> pedidos;

	public Long getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Long idCompra) {
		this.idCompra = idCompra;
	}

	public List<PedidoDto> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidoDto> pedidos) {
		this.pedidos = pedidos;
	}

}
