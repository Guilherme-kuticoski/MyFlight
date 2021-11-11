package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public class Voo {
	
	public enum Status { CONFIRMADO, ATRASADO, CANCELADO }
	
	private LocalDateTime datahora;
	private Duration duracao;
	private Rota rota;
	private Status status;
	
	public Voo(Rota rota, LocalDateTime datahora, Duration duracao, Status status) {
		this.rota = rota;
		this.datahora = datahora;
		this.duracao = duracao;
		this.status = status; // default é confirmado
	}
	
	public Voo(Rota rota, LocalDateTime datahora, Duration duracao) {
		this(rota, datahora, duracao, Status.CONFIRMADO);
	}

	public Voo(Rota rota, Duration duracao) {
		this(rota, LocalDateTime.of(2016, 8, 12, 12, 0), duracao, Status.CONFIRMADO);
	}
	
	public Rota getRota() {
		return rota;
	}
	
	public LocalDateTime getDatahora() {
		return datahora;
	}
	
	public Duration getDuracao() {
		return duracao;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status novo) {
		this.status = novo;
	}

	public String toString() {
		return status + " " + datahora + "("+duracao+") " + "("+rota+")";
	 }
}
