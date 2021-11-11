package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class VooVariasEscalas extends Voo
{
    private ArrayList<Rota> rotas;

    public VooVariasEscalas(Rota rotaInicial, LocalDateTime datahora, Duration duracao) {
        super(rotaInicial, datahora, duracao);
        this.rotas = new ArrayList<>();
        this.rotas.add(rotaInicial);
    }

    public void adicionarRota(Rota rota){
        rotas.add(rota);
    }

    public ArrayList<Rota> getRotas() {
        return rotas;
    }

    @Override
    public String toString() {
        StringBuilder todasRotas = new StringBuilder();
        for(Rota rota: rotas) {
            todasRotas.append(rota);
        }
        return super.toString() + " -> " + todasRotas;
    }
}