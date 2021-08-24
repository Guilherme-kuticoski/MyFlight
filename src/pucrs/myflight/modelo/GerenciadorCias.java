package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorCias {
	private ArrayList<CiaAerea> empresas;
	
	public GerenciadorCias() {
		empresas = new ArrayList<>();
	}
	
	public void adicionar(CiaAerea cia){
		empresas.add(cia);
	}

	public ArrayList<CiaAerea> listarTodas() {
		return empresas;
	}

	public CiaAerea busarPorCodigo(String cod) {
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
}
