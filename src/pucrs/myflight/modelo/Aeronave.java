package pucrs.myflight.modelo;

public class Aeronave implements Contavel, Comparable<Aeronave> {
	private static int totalAeronaves = 0;
	private String codigo;
	private String descricao;
	private int capacidade;
	
	public Aeronave(String codigo, String descricao, int capacidade) {
		totalAeronaves++;
		this.codigo = codigo;
		this.descricao = descricao;
		this.capacidade = capacidade;
	}

	public int contar() {
		return totalAeronaves;
	}

	public int compareTo(Aeronave outra) {
		return descricao.compareTo(outra.descricao);
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public int getCapacidade() {
		return capacidade;
	}
}
