package mx.edu.utez.recuperaElena.controller;


import mx.edu.utez.recuperaElena.model.dto.ClientesDto;
import mx.edu.utez.recuperaElena.model.entity.ClientesBean;
import mx.edu.utez.recuperaElena.service.IClientes;
import mx.edu.utez.recuperaElena.service.IUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
//Gutiérrez Linares Elena Guadalupe 5A
@RestController
@RequestMapping("/api/v1")
public class ClientesController {
    @Autowired
    private IClientes clientesService;

    @PostMapping("/clientes")
    public ClientesDto create (@RequestBody ClientesDto clientesDto){
        ClientesBean clientesBean = clientesService.save(clientesDto);
        return clientesDto.builder()
                .id_clientes(clientesBean.getId_clientes())
                .nombre(clientesBean.getNombre())
                .apellido_paterno(clientesBean.getApellido_paterno())
                .apellido_materno(clientesBean.getApellido_materno())
                .direccion(clientesBean.getDireccion())
                .contacto(clientesBean.getContacto())
                .build();
    }

    @PutMapping("/clientes")
    public ClientesDto update (@RequestBody ClientesDto clientesDto){
        ClientesBean clientesBean = clientesService.save(clientesDto);
        return clientesDto.builder()
                .id_clientes(clientesBean.getId_clientes())
                .nombre(clientesBean.getNombre())
                .apellido_paterno(clientesBean.getApellido_paterno())
                .apellido_materno(clientesBean.getApellido_materno())
                .direccion(clientesBean.getDireccion())
                .contacto(clientesBean.getContacto())
                .build();
    }


    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<?> delete (@PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();
        try {
            ClientesBean clientesServiceById = clientesService.findById(id);
            clientesService.delete(clientesServiceById);
            return new ResponseEntity<>(clientesServiceById, HttpStatus.NO_CONTENT);
        }catch (DataAccessException ex){
            response.put("msj", ex.getMessage());
            response.put("Persons",null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/clientes")
    public ResponseEntity<List<ClientesBean>> showAll() {
        try {
            List<ClientesBean> clientes = clientesService.findAll();
            if (!clientes.isEmpty()) {
                return new ResponseEntity<>(clientes, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (DataAccessException ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/clientes/{id}")
    public ClientesBean showById(@PathVariable Integer id){
        return clientesService.findById(id);
    }
}


