package converters;

import java.util.ArrayList;
import java.util.List;

import dtos.PedidoDto;
import entities.Pedido;

public class PedidoConverter {

	public static Pedido fromDto(PedidoDto dto) {
		Pedido pedido = new Pedido();
		pedido.setIdPedido(dto.getIdPedido());
		pedido.setArticulo(ArticuloConverter.fromDto(dto.getArticulo()));
		pedido.setStock(dto.getStock());
		return pedido;
	}

	public static List<Pedido> fromDtos(List<PedidoDto> dtos) {
		List<Pedido> pedidos = new ArrayList<Pedido>();
		for (PedidoDto dto : dtos) {
			pedidos.add(fromDto(dto));
		}
		return pedidos;
	}

	public static List<PedidoDto> toDtos(List<Pedido> pedidos) {
		List<PedidoDto> dtos = new ArrayList<PedidoDto>();
		for (Pedido pedido : pedidos) {
			dtos.add(toDto(pedido));
		}
		return dtos;
	}

	public static PedidoDto toDto(Pedido pedido) {
		PedidoDto dto = new PedidoDto();
		dto.setIdPedido(pedido.getIdPedido());
		dto.setArticulo(ArticuloConverter.toDto(pedido.getArticulo()));
		dto.setStock(pedido.getStock());
		return dto;
	}

}
