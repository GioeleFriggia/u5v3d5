package gioelefriggia.u5v3d5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"gioelefriggia.u5v3d5.model"})
public class U5v3d5Application {

	public static void main(String[] args) {
		SpringApplication.run(U5v3d5Application.class, args);
	}

}
