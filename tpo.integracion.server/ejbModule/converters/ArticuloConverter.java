package converters;

import dtos.ArticuloDto;
import entities.Articulo;

public class ArticuloConverter {

	public static Articulo fromDto(ArticuloDto dto) {
		Articulo result = new Articulo();
		result.setDescripcion(dto.getDescripcion());
		result.setIdArticulo(dto.getIdArticulo());
		result.setNombre(dto.getNombre());
		result.setPrecio(dto.getPrecio());
		result.setStock(dto.getStock());
		return result;
	}

}
