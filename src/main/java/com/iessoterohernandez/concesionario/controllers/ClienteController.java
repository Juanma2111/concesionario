package com.iessoterohernandez.concesionario.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iessoterohernandez.concesionario.exceptions.ClienteException;
import com.iessoterohernandez.concesionario.exceptions.PruebaException;
import com.iessoterohernandez.concesionario.models.Cliente;
import com.iessoterohernandez.concesionario.services.ClienteService;

@RestController
@RequestMapping("/clients")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClients() {
        List<Cliente> clientes = clienteService.getClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{nif}")
    public ResponseEntity<Cliente> getClientByNif(@PathVariable String nif) throws ClienteException {
        Cliente cliente = clienteService.getClienteByNIF(nif);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{nif}")
    public ResponseEntity<Void> deleteClientByNif(@PathVariable String nif) throws ClienteException {
        clienteService.deleteCliente(nif);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Cliente> addClient(@RequestBody Cliente cliente) throws ClienteException {
        Cliente nuevoCliente = clienteService.createCliente(cliente);
        return ResponseEntity.ok(nuevoCliente);
    }

    @PostMapping("/{idCliente}/{idVehiculo}/{dia}/{mes}/{año}/{hora}/{minuto}")
    public ResponseEntity<Void> scheduleTestDrive(@PathVariable Long idCliente,
                                                   @PathVariable Long idVehiculo,
                                                   @PathVariable int dia,
                                                   @PathVariable int mes,
                                                   @PathVariable int año,
                                                   @PathVariable int hora,
                                                   @PathVariable int minuto) throws ClienteException {
        Date fechaHora = new Date(año - 1900, mes - 1, dia, hora, minuto);
        clienteService.solicitarPrueba(idCliente, idVehiculo, fechaHora);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Cliente> updateClient(@RequestBody Cliente cliente) throws PruebaException {
        Cliente clienteActualizado = clienteService.updateCliente(
            cliente.getId(),
            cliente.getNif(),
            cliente.getNombre(),
            cliente.getApellidos(),
            cliente.getTelefono(),
            cliente.getEmail(),
            cliente.getFechaAlta());
        return ResponseEntity.ok(clienteActualizado);
    }

    @PutMapping("/{idCliente}/{idVehiculo}/{dia}/{mes}/{año}/{hora}/{minuto}")
    public ResponseEntity<Void> performTestDrive(@PathVariable Long idCliente,
                                                  @PathVariable Long idVehiculo,
                                                  @PathVariable int dia,
                                                  @PathVariable int mes,
                                                  @PathVariable int año,
                                                  @PathVariable int hora,
                                                  @PathVariable int minuto) throws PruebaException {
        Date fechaHora = new Date(año - 1900, mes - 1, dia, hora, minuto);
        clienteService.realizarPrueba(idCliente, idVehiculo, fechaHora);
        return ResponseEntity.ok().build();
    }
}
