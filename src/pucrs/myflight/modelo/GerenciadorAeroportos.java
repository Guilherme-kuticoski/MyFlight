package pucrs.myflight.modelo;

import java.util.ArrayList;
import java.util.Collections;

public class GerenciadorAeroportos {
    private ArrayList<Aeroporto> aeroportos;
	
	public GerenciadorAeroportos() {
		aeroportos = new ArrayList<>();
	}

	public void adicionar(Aeroporto aero){
		aeroportos.add(aero);
	}

	public ArrayList<Aeroporto> listarTodos() {
		return aeroportos;
	}

	public Aeroporto busarPorCodigo(String cod) {
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
}
