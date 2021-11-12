package pucrs.myflight.modelo;

import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

import java.nio.charset.Charset;

import java.util.ArrayList;
import java.util.Collections;

public class GerenciadorAeronaves {
	private static ArrayList<Aeronave> aeronaves;
	
	public GerenciadorAeronaves() {
		aeronaves = new ArrayList<>();
	}

	public void adicionar(Aeronave aviao){
		aeronaves.add(aviao);
	}

	public ArrayList<Aeronave> listarTodos() {
		return aeronaves;
	}

	public static Aeronave busarPorCodigo(String cod) {
		for(Aeronave arnv : aeronaves){
			if (cod.equals(arnv.getCodigo())){
				return arnv;
			}
		}

		return null;
	}

	public void ordenaDescricao() {
        Collections.sort(aeronaves);
    }

	public void carregarDados() {
		Path path1 = Paths.get("dados/equipment.dat");
		try (BufferedReader reader = Files.newBufferedReader(path1, Charset.forName("utf8"))) {
			String line = null;
			line =  reader.readLine();
			while ((line = reader.readLine()) != null) {
				String[] dados = line.split(";");

				String codigo = dados[0];
				String descricao = dados[1];
				int capacidade = Integer.parseInt(dados[2].replace("\r", ""));

				Aeronave aviao = new Aeronave(codigo, descricao, capacidade);
				this.adicionar(aviao);
			}
		} catch (IOException e) {
			System.err.format("Erro de E/S: %s%n", e);
		}
	}

	@Override
	public String toString(){
        StringBuilder aux = new StringBuilder("\n10 primerias Aeronaves\n\n");
		for(int i=0; i<10; i++){
			if(i > aeronaves.size()) {break;}
			aux.append( aeronaves.get(i).getCodigo() + "\n");
		}

        return aux.toString();
	}
}
