package pucrs.myflight.consoleApp;

import java.time.LocalDateTime;
import java.time.Duration;

import pucrs.myflight.modelo.*;
import pucrs.myflight.modelo.Voo.Status;

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
		Duration duracao1 = Duration.ofMinutes(90);
		Voo voo1 = new Voo(rota1, datahora1, duracao1, Status.ATRASADO);

		Duration duracao2 = Duration.ofMinutes(120);
		Voo voo2 = new Voo(rota2, datahora1, duracao1);

		LocalDateTime datahora2 = LocalDateTime.of(2016, 8, 15, 12, 0);
		Voo voo3 = new Voo(rota3, datahora2, duracao2, Status.CANCELADO);

		Voo voo4 = new Voo(rota4, datahora2, duracao1);
		Voo voo5 = new Voo(rota5, duracao2);

		voo4.setStatus(Status.CANCELADO);

		double dis = Geo.distancia(poa.getLocal(), lis.getLocal());
		System.out.println(dis);

		Geo geoPoa = new Geo(-29.9939, -51.1711);
		System.out.println(geoPoa.distancia(lis.getLocal()));
	
		System.out.println("\n\nTotal de empresas: " + CiaAerea.getTotalCias());
	}
}
