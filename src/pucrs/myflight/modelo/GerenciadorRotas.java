package pucrs.myflight.modelo;

import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

import java.nio.charset.Charset;

import java.util.ArrayList;
import java.util.Collections;

public class GerenciadorRotas {
    private ArrayList<Rota> rotas;
	
	public GerenciadorRotas() {
		rotas = new ArrayList<>();
	}

	public void adicionar(Rota rota){
		rotas.add(rota);
	}

	public ArrayList<Rota> listarTodas() {
		return rotas;
	}

	public Rota busarPorOrigem(Aeroporto orig) {
		for(Rota rota : rotas){
			if (rota.getOrigem() == orig){
				return rota;
			}
		}

		return null;
	}

	public void ordenaPorNomeCia() {
        Collections.sort(rotas);
    }

	public void carregarDados() {
		Path path1 = Paths.get("dados/routes.dat");
		try (BufferedReader reader = Files.newBufferedReader(path1, Charset.forName("utf8"))) {
			String line = null;
			line =  reader.readLine();
			while ((line = reader.readLine()) != null) {
				String[] dados = line.split(";");

				CiaAerea cia = GerenciadorCias.busarPorCodigo(dados[0]);
				Aeroporto origem = GerenciadorAeroportos.busarPorCodigo(dados[1]);
				Aeroporto destino = GerenciadorAeroportos.busarPorCodigo(dados[2]);

				String[] aeronaves = dados[5].split(" ");
				for(String aeronave: aeronaves){
					Aeronave arnv = GerenciadorAeronaves.busarPorCodigo(aeronave);

					Rota rota = new Rota(cia, origem, destino, arnv);
					adicionar(rota);
				}
			}
		} catch (IOException e) {
			System.err.format("Erro de E/S: %s%n", e);
		}
	}

	@Override
	public String toString(){
        StringBuilder aux = new StringBuilder("\n10 primerias Rotas\n\n");

		for(int i=0; i<10; i++){
			if(i > rotas.size()) {break;}
			
			Rota rota = rotas.get(i);
			aux.append( 
				rota.getCia().getCodigo() + " -> " +
				rota.getOrigem().getCodigo() + " -> " +
				rota.getDestino().getCodigo() + " -> " +
				rota.getAeronave().getCodigo() + "\n"
			);
		}

        return aux.toString();
	}
}
