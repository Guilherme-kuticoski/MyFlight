package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public abstract class Voo {
    public enum Status { CONFIRMADO, ATRASADO, CANCELADO }; 

    private LocalDateTime datahora;
    private Status status;

    // Construtor
    public Voo(LocalDateTime dh) {
       this.datahora = dh;
       this.status = Status.CONFIRMADO;
    }

    public LocalDateTime getDataHora() { return datahora; }

    public abstract Rota getRota();
    public abstract Duration getDuracao();  
    
    @Override
    public String toString() {
       return status + " " + datahora;
    }
}
