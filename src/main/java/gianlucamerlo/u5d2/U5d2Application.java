package gianlucamerlo.u5d2;

import gianlucamerlo.u5d2.entities.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication

public class U5d2Application {

	public static void main(String[] args) {
		var context = SpringApplication.run(U5d2Application.class, args);

		Menu m = context.getBean(Menu.class);
		m.printMenu();


	}
}
