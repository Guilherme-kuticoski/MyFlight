package pucrs.myflight.consoleApp;

import java.time.LocalDateTime;

import pucrs.myflight.modelo.*;

public class App {

	public static void main(String[] args) {
		CiaAerea ltm = new CiaAerea("jj", "LATAM Linhas Aéreas");
		CiaAerea gol = new CiaAerea("G3", "Gol Linhas Aéreas SA");
		CiaAerea tap = new CiaAerea("TP", "TAP Portugal");
		CiaAerea azul = new CiaAerea("AD", "Azul Linhas Aéreas");

		Aeronave aero1 = new Aeronave("733", "Boeing 737-300", 140);
		Aeronave aero2 = new Aeronave("73G", "Boeing 737-700", 126);
		Aeronave aero3 = new Aeronave("380", "Airbus Industrie A380", 644);
		Aeronave aero4 = new Aeronave("764", "Boeing 767-400", 304);

		Aeroporto poa = new Aeroporto("POA", "Salgado Filho Intl Apt", new Geo(-29.9939, -51.1711));
		Aeroporto gru = new Aeroporto("GRU", "São Paulo Guarulhos Intl Apt", new Geo(-23.4356, -46.4731));
		Aeroporto lis = new Aeroporto("LIS", "Lisbon", new Geo(38.7742, -9.1342));
		Aeroporto mia = new Aeroporto("MIA", "Miami International Apt", new Geo(25.7933, -80.2906));
		
		Rota rota1 = new Rota(gol, gru, poa, aero1);
		Rota rota2 = new Rota(gol, poa, gru, aero1);
		Rota rota3 = new Rota(tap, mia, lis, aero4);
		Rota rota4 = new Rota(ltm, gru, mia, aero3);
		Rota rota5 = new Rota(azul, mia, lis, aero2);

		LocalDateTime datahora1 = LocalDateTime.of(2016, 8, 10, 8, 0);
		VooDireto voo1 = new VooDireto(datahora1, rota1);
		System.out.println("Duração em minutos voo1: " + voo1.getDuracao().getSeconds()/60);

		LocalDateTime datahora2 = LocalDateTime.of(2016, 8, 10, 8, 0);
		VooEscalas voo2 = new VooEscalas(datahora2);
		voo2.adicionarRota(rota2);
		voo2.adicionarRota(rota1);
		voo2.adicionarRota(rota2);
		voo2.adicionarRota(rota4);
		
		System.out.println("Duração em minutos voo2: " + voo2.getDuracao().getSeconds()/60);
		System.out.println(voo1);
		System.out.println(voo2);
	}
}
