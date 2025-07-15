package gianlucamerlo.u5d2.entities;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RunnerOrdine implements CommandLineRunner {

    @Value("${costo.coperto}")
    private double coverageCost;

    @Override
    public void run(String... args) throws Exception {

    }
}
