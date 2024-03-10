package com.iessoterohernandez.concesionario;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// import org.springframework.context.ApplicationContext;
// import org.springframework.context.annotation.Bean;
// import org.springframework.boot.CommandLineRunner;
// import com.iessoterohernandez.concesionario.models.Cliente;
// import com.iessoterohernandez.concesionario.models.Concesionario;
// import com.iessoterohernandez.concesionario.models.Prueba;
// import com.iessoterohernandez.concesionario.models.Vehiculo;
// import com.iessoterohernandez.concesionario.repositories.ClienteRepository;
// import com.iessoterohernandez.concesionario.repositories.ConcesionarioRepository;
// import com.iessoterohernandez.concesionario.repositories.PruebaRepository;
// import com.iessoterohernandez.concesionario.repositories.VehiculoRepository;

@SpringBootApplication
public class ConcesionarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConcesionarioApplication.class, args);
	}

	// @Bean
	// public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	// 	return args -> {

	// 		ConcesionarioRepository concesionarioRepository = ctx.getBean(ConcesionarioRepository.class);
	// 		Concesionario nuevoConcesionario = new Concesionario(
	// 			"Yamaha", 
	// 			"123 Calle", 
	// 			"yamaha@correo.com", 
	// 			"9-18", 
	// 			"123456789", 
	// 			2000);
	// 		concesionarioRepository.save(nuevoConcesionario);

	// 		ClienteRepository clienteRepository = ctx.getBean(ClienteRepository.class);
	// 		Cliente nuevoCliente = new Cliente(
	// 			"12345678A", 
	// 			"Paco", 
	// 			"Alberdi Romero", 
	// 			"654321789", 
	// 			"pacoar@correo.com",
	// 			new Date());
	// 		clienteRepository.save(nuevoCliente);
			
			// VehiculoRepository vehiculoRepository = ctx.getBean(VehiculoRepository.class);
			// Vehiculo nuevoVehiculo = new Vehiculo(
			// 	"12341GHG332123V1",
			// 	"9876DDD",
			// 	"Yamaha",
			// 	"Mantis",
			// 	105,
			// 	130,
			// 	13249.99,
			// 	2012
			// );
			// vehiculoRepository.save(nuevoVehiculo);


	// 		PruebaRepository pruebaRepository = ctx.getBean(PruebaRepository.class);
	// 		Prueba nuevoPrueba = new Prueba(
	// 			nuevoCliente,
	// 			nuevoVehiculo,
	// 			new Date(),
	// 			true
	// 		);
	// 		pruebaRepository.save(nuevoPrueba);
	// 	};

		// };

// }
}