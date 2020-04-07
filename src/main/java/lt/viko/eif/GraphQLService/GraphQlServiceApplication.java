package lt.viko.eif.GraphQLService;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class GraphQlServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphQlServiceApplication.class, args);
	}

	@Bean
	ApplicationRunner init(StorageService storageService) {
		return args -> {
			Stream.of("Pizza", "Spam", "Eggs", "Avocado").forEach(name -> {
				Storage storage = new Storage();
				storage.setName(name);
				storageService.saveStorage(storage);
			});
			storageService.getStorages().forEach(System.out::println);
		};
	}

}
