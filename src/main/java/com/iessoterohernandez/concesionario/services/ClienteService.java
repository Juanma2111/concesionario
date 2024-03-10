package com.iessoterohernandez.concesionario.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iessoterohernandez.concesionario.exceptions.ClienteException;
import com.iessoterohernandez.concesionario.exceptions.PruebaException;
import com.iessoterohernandez.concesionario.models.Cliente;
import com.iessoterohernandez.concesionario.models.Prueba;
import com.iessoterohernandez.concesionario.models.Vehiculo;
import com.iessoterohernandez.concesionario.repositories.ClienteRepository;
import com.iessoterohernandez.concesionario.repositories.PruebaRepository;
import com.iessoterohernandez.concesionario.repositories.VehiculoRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private PruebaRepository pruebaRepository;
    @Autowired
    private VehiculoRepository vehiculoRepository;

    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    public Cliente getClienteByNIF(String nif) throws ClienteException {
        return clienteRepository.findByNif(nif)
                .orElseThrow(() -> new ClienteException("No se encontró el cliente con NIF: " + nif));
    }
    
    public void deleteCliente(String nif) throws ClienteException {
        Cliente cliente = getClienteByNIF(nif);

        Integer cantidadPruebas = clienteRepository.pruebasByClienteId(cliente.getId());
        if (cantidadPruebas > 0) {
            throw new ClienteException("El cliente con NIF: " + nif + " tiene pruebas realizadas");
        }
        clienteRepository.delete(cliente);
    }

    public Cliente createCliente(Cliente cliente) throws ClienteException {
        if (clienteRepository.existsByNif(cliente.getNif())) {
            throw new ClienteException("Ya existe un cliente con el NIF: " + cliente.getNif());
        }
        return clienteRepository.save(cliente);
    }

    public Cliente updateCliente(Long id, String nif, String nombre, String apellidos, String telefono, String email, Date fecha) throws ClienteException {
        Cliente cliente = clienteRepository.findById(id)
            .orElseThrow(() -> new ClienteException("No existe el cliente con ID: " + id));
    
        cliente.setNif(nif);
        cliente.setNombre(nombre);
        cliente.setApellidos(apellidos);
        cliente.setTelefono(telefono);
        cliente.setEmail(email);
        cliente.setFechaAlta(fecha);

        return clienteRepository.save(cliente);
    }

    public Prueba solicitarPrueba(Long clienteId, Long vehiculoId, Date fechaHora) throws PruebaException {
        Cliente cliente = clienteRepository.findById(clienteId)
            .orElseThrow(() -> new PruebaException("Cliente no encontrado"));
        Vehiculo vehiculo = vehiculoRepository.findById(vehiculoId)
            .orElseThrow(() -> new PruebaException("Vehículo no encontrado"));
        
        Date ahora = new Date();
        if (fechaHora.before(ahora)) {
            throw new ClienteException("La fecha de la prueba debe ser futura.");
        }

        Prueba nuevaPrueba = new Prueba(cliente, vehiculo, fechaHora, false);
        return pruebaRepository.save(nuevaPrueba);
    }

    public Prueba realizarPrueba(Long clienteId, Long vehiculoId, Date fechaHora) throws PruebaException {
        Prueba prueba = pruebaRepository.findByClienteIdAndVehiculoIdAndFechaHora(clienteId, vehiculoId, fechaHora)
                .orElseThrow(() -> new PruebaException("Prueba no encontrada"));
        prueba.setRealizada(true);
        return pruebaRepository.save(prueba);
    }
}
