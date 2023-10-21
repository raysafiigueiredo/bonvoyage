package model;

import java.util.Date;

public class Reservation {
	private int id_reserva;
	private Package pacote;
	private Destination destino;
	private Passenger passageiro;
	private Date data;
	private String checkin;
	private String checkout;
	private String pagamento;
	private float total;
	private boolean status;

	public Reservation() {
		super();
	}

	public Reservation(int id_reserva, Package pacote, Destination destino, Passenger passageiro, Date data,
			String checkin, String checkout, String pagamento, float total, boolean status) {
		super();
		this.id_reserva = id_reserva;
		this.pacote = pacote;
		this.destino = destino;
		this.passageiro = passageiro;
		this.data = data;
		this.checkin = checkin;
		this.checkout = checkout;
		this.pagamento = pagamento;
		this.total = total;
		this.status = status;
	}

	public int getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(int value) {
		this.id_reserva = value;
	}

	public Package getPacote() {
		return pacote;
	}

	public void setPacote(Package value) {
		this.pacote = value;
	}

	public Destination getDestino() {
		return destino;
	}

	public void setDestino(Destination value) {
		this.destino = value;
	}

	public Passenger getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(Passenger value) {
		this.passageiro = value;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date value) {
		this.data = value;
	}

	public String getCheckin() {
		return checkin;
	}

	public void setCheckin(String value) {
		this.checkin = value;
	}

	public String getCheckout() {
		return checkout;
	}

	public void setCheckout(String value) {
		this.checkout = value;
	}

	public String getPagamento() {
		return pagamento;
	}

	public void setPagamento(String value) {
		this.pagamento = value;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float value) {
		this.total = value;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean value) {
		this.status = value;
	}

	@Override
	public String toString() {
		return "Reservation [id_reserva=" + id_reserva + ", pacote=" + pacote + ", destino=" + destino + ", passageiro="
				+ passageiro + ", data=" + data + ", checkin=" + checkin + ", checkout=" + checkout
				+ ", pagamento=" + pagamento + ", total=" + total + ", status=" + status + "]";
	}

}