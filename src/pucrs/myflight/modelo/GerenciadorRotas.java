package pucrs.myflight.modelo;

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
}
