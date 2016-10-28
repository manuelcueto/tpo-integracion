package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import enums.Estado;

@Entity
@Table(name = "solicitudes")
public class SolicitudArticulo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idSolicitud;
	@OneToOne
	private Articulo articulo;
	private Long stockSolicitado;
	private Estado estado;
}
