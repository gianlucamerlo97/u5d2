package gianlucamerlo.u5d2.entities;

import gianlucamerlo.u5d2.enums.StatoOrdine;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Ordine {
    private int numberOrder;
    private StatoOrdine statoOrdine;
    private int numberCovered;
    private LocalDateTime acquisitionTime;
    private List<Item> elements;
    private double coverageCost;

    public Ordine(int numberOrder, StatoOrdine statoOrdine, int numberCovered, LocalDateTime acquisitionTime, List<Item> elements, double coverageCost) {
        this.numberOrder = numberOrder;
        this.statoOrdine = statoOrdine;
        this.numberCovered = numberCovered;
        this.acquisitionTime = acquisitionTime;
        this.elements = elements;
        this.coverageCost = coverageCost;
    }

    public double calculateTotal()
    {
        double total=0.0;
        if(elements!=null)
        {
            for (int i=0;i<elements.size();i++)
            {
                total+=elements.get(i).getPrice();
            }
        }total+=numberCovered*coverageCost;
        return total;
    }

    @Override
    public String toString() {
        return "Ordine{" +
                "numberOrder=" + numberOrder +
                ", statoOrdine=" + statoOrdine +
                ", numberCovered=" + numberCovered +
                ", acquisitionTime=" + acquisitionTime +
                ", elements=" + elements +
                ", coverageCost=" + coverageCost +
                '}';
    }
}
