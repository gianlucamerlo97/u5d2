package gianlucamerlo.u5d2.entities;

import gianlucamerlo.u5d2.enums.StatoOrdine;
import gianlucamerlo.u5d2.enums.StatoTavolo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class RunnerOrdine implements CommandLineRunner {

    private final Menu menu;

    @Value("${costo.coperto}")
    private double costoCoperto;

    public RunnerOrdine(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void run(String... args) throws Exception {
        // Creo un tavolo
        Tavolo tavolo = new Tavolo(1, 4, StatoTavolo.ORDINATO);

        // Prendo la prima pizza e la prima bevanda dal menu
        List<Item> elementiOrdine = new ArrayList<>();
        elementiOrdine.add(menu.getPizzaList().get(0));  // Supponiamo sia Pizza Margherita
        elementiOrdine.add(menu.getDrinkList().get(0));  // Supponiamo sia Lemonade

        // Creo l'ordine
        Ordine ordine = new Ordine(
                1,StatoOrdine.PRONTO,3, LocalDateTime.now(),elementiOrdine,costoCoperto
        );

        // Stampo i dettagli dell’ordine
        System.out.println("Ordine creato: " + ordine);
        System.out.println("Importo totale ordine: €" + ordine.calculateTotal());
    }
}
