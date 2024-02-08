package mx.edu.utez.recuperaElena.service.impl;

import mx.edu.utez.recuperaElena.model.dao.ClientesDao;
import mx.edu.utez.recuperaElena.model.dao.UsuariosDao;
import mx.edu.utez.recuperaElena.model.dto.ClientesDto;
import mx.edu.utez.recuperaElena.model.entity.ClientesBean;
import mx.edu.utez.recuperaElena.model.entity.UsuariosBean;
import mx.edu.utez.recuperaElena.service.IClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
//Gutiérrez Linares Elena Guadalupe 5A
@Service
public class ClientesImpl implements IClientes {
    @Autowired
    private ClientesDao clientesDao;
    @Autowired
    private UsuariosDao usuariosDao;
    @Transactional
    @Override
    public ClientesBean save(ClientesDto clientesDto) {

        ClientesBean branchBean = ClientesBean.builder().id_clientes(clientesDto.getId_clientes())
                .nombre(clientesDto.getNombre())
                .apellido_paterno(clientesDto.getApellido_paterno())
                .apellido_materno(clientesDto.getApellido_materno())
                .direccion(clientesDto.getDireccion())
                .contacto(clientesDto.getContacto())
                .build();
        return clientesDao.save(branchBean);
    }
    @Transactional(readOnly = true)
    @Override
    public ClientesBean findById(Integer id) {

        return clientesDao.findById(id).orElse(null);
    }
    @Transactional
    @Override
    public void delete(ClientesBean clientes) {
        clientesDao.delete(clientes);
    }
    @Override
    public List<ClientesBean> findAll() {
        return (List<ClientesBean>) clientesDao.findAll();

    }
}
