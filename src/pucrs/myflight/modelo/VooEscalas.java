package pucrs.myflight.modelo;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.Duration;

public class VooEscalas extends Voo{
    private ArrayList<Rota> rotas;

    public VooEscalas(LocalDateTime dh) {
        super(dh);
        this.rotas = new ArrayList<>();
    }

    public void adicionarRota(Rota rota) {
        rotas.add(rota);
    }

    public Duration getDuracao() {
        if(rotas.isEmpty()) { return null; }

        Duration duracao = Duration.ZERO;
        for(Rota rota : rotas) {
            double distancia = Geo.distancia(
                                    rota.getOrigem().getLocal(), 
                                    rota.getDestino().getLocal()
                                );
            double tempo  = distancia/805;
            duracao = duracao.plus(Duration.ofHours((long)tempo));
            duracao = duracao.plusMinutes(30);
        }

        return duracao;
    }

    public Rota getRota() {
        if(rotas.isEmpty()) { return null; }

        return rotas.get(0);
    }

    public ArrayList<Rota> getRotas() {
        return rotas;
    }

    @Override
    public String toString() {
        StringBuilder todasRotas = new StringBuilder();
        for(Rota rota: rotas) {
            todasRotas.append(rota);
            todasRotas.append("\n");
        }
        return super.toString() + "->\n" + todasRotas + getDuracao().getSeconds()/60;
    }
}
