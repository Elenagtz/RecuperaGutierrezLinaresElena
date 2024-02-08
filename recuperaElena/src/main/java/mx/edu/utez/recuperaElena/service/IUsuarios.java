package mx.edu.utez.recuperaElena.service;

import mx.edu.utez.recuperaElena.model.dto.UsuariosDto;
import mx.edu.utez.recuperaElena.model.entity.UsuariosBean;

import java.util.List;
//Gutiérrez Linares Elena Guadalupe 5A
public interface IUsuarios {
    UsuariosBean save(UsuariosDto usuariosDto);
    UsuariosBean findById(Integer id);
    void delete(UsuariosBean usuarios);

    public List<UsuariosBean> findAll();


}
