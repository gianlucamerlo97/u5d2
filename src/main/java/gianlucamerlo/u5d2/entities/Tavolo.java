package gianlucamerlo.u5d2.entities;

import gianlucamerlo.u5d2.enums.StatoTavolo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tavolo {
    private int number;
    private int numberMaxCovered;
    private StatoTavolo tavolo;

    public Tavolo(int number, int numberMaxCovered, StatoTavolo tavolo) {
        this.number = number;
        this.numberMaxCovered = numberMaxCovered;
        this.tavolo = tavolo;
    }

    @Override
    public String toString() {
        return "Tavolo{" +
                "number=" + number +
                ", numberMaxCovered=" + numberMaxCovered +
                ", tavolo=" + tavolo +
                '}';
    }
}
