import java.time.LocalDateTime;

public class Movimintos {
	private LocalDateTime fechaHora;
	private Cliente cliente;
	private String detalle;

	public Movimintos(LocalDateTime fechaHora, Cliente cliente, String detalle) {
		super();
		this.fechaHora = fechaHora;
		this.cliente = cliente;
		this.detalle = detalle;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	@Override
	public String toString() {
		return "Movimintos [fechaHora=" + fechaHora + ", cliente=" + cliente + ", detalle=" + detalle + "]";
	}

}
