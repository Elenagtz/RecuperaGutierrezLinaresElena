package mx.edu.utez.recuperaElena.service;

import mx.edu.utez.recuperaElena.model.dto.ClientesDto;
import mx.edu.utez.recuperaElena.model.entity.ClientesBean;

import java.util.List;
//Gutiérrez Linares Elena Guadalupe 5A
public interface IClientes {
    ClientesBean save(ClientesDto clientesDto);
    ClientesBean findById(Integer id);
    void delete(ClientesBean clientes);

    public List<ClientesBean> findAll();

}
