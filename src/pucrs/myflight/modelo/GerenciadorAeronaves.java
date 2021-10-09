package pucrs.myflight.modelo;

import java.util.ArrayList;
import java.util.Collections;

public class GerenciadorAeronaves {
	private ArrayList<Aeronave> aeronaves;
	
	public GerenciadorAeronaves() {
		aeronaves = new ArrayList<>();
	}

	public void adicionar(Aeronave aviao){
		aeronaves.add(aviao);
	}

	public ArrayList<Aeronave> listarTodos() {
		return aeronaves;
	}

	public Aeronave busarPorCodigo(String cod) {
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
}
