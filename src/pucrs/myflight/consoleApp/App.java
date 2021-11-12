package pucrs.myflight.consoleApp;

import pucrs.myflight.modelo.*;

public class App {
	public static void main(String[] args) {
		GerenciadorAeronaves aeronaves = new GerenciadorAeronaves();
		GerenciadorCias empresas = new GerenciadorCias();
		GerenciadorAeroportos aeroportos = new GerenciadorAeroportos();
		GerenciadorRotas rotas = new GerenciadorRotas();

		aeronaves.carregarDados();
		System.out.println(aeronaves);

		empresas.carregarDados();
		System.out.println(empresas);

		aeroportos.carregarDados();
		System.out.println(aeroportos);

		rotas.carregarDados();
		System.out.println(rotas);
	}
}
