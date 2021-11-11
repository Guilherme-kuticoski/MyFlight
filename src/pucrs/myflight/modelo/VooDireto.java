package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public class VooDireto extends Voo{
    private Rota rota;

    public VooDireto(LocalDateTime dh, Rota rota) {
        super(dh);
        this.rota = rota;    
    }

    public Duration getDuracao() {
        double distancia = Geo.distancia(rota.getOrigem().getLocal(), 
                                         rota.getDestino().getLocal());
        double tempo = (distancia/805);
        Duration duracao = Duration.ofHours((long)tempo);
        return duracao.plusMinutes(30);
    }

    public Rota getRota() {
        return this.rota;
    }

    @Override
    public String toString() {
        return super.toString() + " -> " + rota + getDuracao().getSeconds()/60 + " Minutos";
    }
}
