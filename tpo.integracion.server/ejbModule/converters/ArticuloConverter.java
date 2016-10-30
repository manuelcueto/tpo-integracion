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

	public static ArticuloDto toDto(Articulo articulo) {
		ArticuloDto dto = new ArticuloDto();
		dto.setDescripcion(articulo.getDescripcion());
		dto.setIdArticulo(articulo.getIdArticulo());
		dto.setNombre(articulo.getNombre());
		dto.setPrecio(articulo.getPrecio());
		dto.setStock(articulo.getStock());
		return dto;
	}

}
