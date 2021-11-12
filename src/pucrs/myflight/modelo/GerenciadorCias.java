package pucrs.myflight.modelo;

import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

import java.nio.charset.Charset;

import java.util.ArrayList;

public class GerenciadorCias {
	private static ArrayList<CiaAerea> empresas;
	
	public GerenciadorCias() {
		empresas = new ArrayList<>();
	}
	
	public void adicionar(CiaAerea cia){
		empresas.add(cia);
	}

	public ArrayList<CiaAerea> listarTodas() {
		return empresas;
	}

	public static CiaAerea busarPorCodigo(String cod) {
		for(CiaAerea cia : empresas){
			if (cod.equals(cia.getCodigo())){
				return cia;
			}
		}

		return null;
	}

	public CiaAerea busarPorNome(String nome) {
		for(CiaAerea cia : empresas){
			if (nome.equals(cia.getNome())){
				return cia;
			}
		}

		return null;
	}

	public void carregarDados() {
		Path path1 = Paths.get("dados/airlines.dat");
		try (BufferedReader reader = Files.newBufferedReader(path1, Charset.forName("utf8"))) {
			String line = null;
			line =  reader.readLine();
			while ((line = reader.readLine()) != null) {
				String[] dados = line.split(";");

				String codigo = dados[0];
				String nome = dados[1];

				CiaAerea cia = new CiaAerea(codigo, nome);
				adicionar(cia);
			}
		} catch (IOException e) {
			System.err.format("Erro de E/S: %s%n", e);
		}
	}

	@Override
	public String toString(){
        StringBuilder aux = new StringBuilder("\n10 primerias Companhias\n\n");
		for(int i=0; i<10; i++){
			if(i > empresas.size()) {break;}
			aux.append( empresas.get(i).getCodigo() + "\n");
		}

        return aux.toString();
	}
}
