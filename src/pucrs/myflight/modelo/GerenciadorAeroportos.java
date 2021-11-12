package pucrs.myflight.modelo;

import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

import java.nio.charset.Charset;

import java.util.ArrayList;
import java.util.Collections;

public class GerenciadorAeroportos {
    private static ArrayList<Aeroporto> aeroportos;
	
	public GerenciadorAeroportos() {
		aeroportos = new ArrayList<>();
	}

	public void adicionar(Aeroporto aero){
		aeroportos.add(aero);
	}

	public ArrayList<Aeroporto> listarTodos() {
		return aeroportos;
	}

	public static Aeroporto busarPorCodigo(String cod) {
		for(Aeroporto aero : aeroportos){
			if (cod.equals(aero.getCodigo())){
				return aero;
			}
		}

		return null;
	}

	public void ordenaPorNome() {
        Collections.sort(aeroportos);
    }

	public void carregarDados() {
		Path path1 = Paths.get("dados/airports.dat");
		try (BufferedReader reader = Files.newBufferedReader(path1, Charset.forName("utf8"))) {
			String line = null;
			line =  reader.readLine();
			while ((line = reader.readLine()) != null) {
				String[] dados = line.split(";");

				String codigo = dados[0];
				Double latitude = Double.parseDouble(dados[1]);
				Double longitude = Double.parseDouble(dados[2]);
				String nome = dados[3];

				Aeroporto aeroporto = new Aeroporto(
										codigo, nome, new Geo(latitude, longitude)
									  );
				adicionar(aeroporto);
			}
		} catch (IOException e) {
			System.err.format("Erro de E/S: %s%n", e);
		}
	}

	@Override
	public String toString(){
        StringBuilder aux = new StringBuilder("\n10 primerios Aeroportos\n\n");
		for(int i=0; i<10; i++){
			if(i > aeroportos.size()) {break;}
			aux.append( aeroportos.get(i).getCodigo() + "\n");
		}

        return aux.toString();
	}
}
