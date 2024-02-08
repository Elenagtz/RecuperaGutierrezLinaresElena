package mx.edu.utez.recuperaElena.service.impl;

import mx.edu.utez.recuperaElena.model.dao.UsuariosDao;
import mx.edu.utez.recuperaElena.model.dto.ClientesDto;
import mx.edu.utez.recuperaElena.model.dto.UsuariosDto;
import mx.edu.utez.recuperaElena.model.entity.ClientesBean;
import mx.edu.utez.recuperaElena.model.entity.UsuariosBean;
import mx.edu.utez.recuperaElena.service.IUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
//Gutiérrez Linares Elena Guadalupe 5A
@Service
public class UsuariosImpl implements IUsuarios {
    private String generarPassword() {
        String letrasMayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String letrasMinusculas = letrasMayusculas.toLowerCase();
        String numeros = "0123456789";
        String caracteresEspeciales = "!@#$%^&*()_+-=[]{}|;:,.<>?";

        String caracteres = letrasMayusculas + letrasMinusculas + numeros + caracteresEspeciales;
        Random random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(caracteres.length());
            sb.append(caracteres.charAt(index));
        }

        return sb.toString();
    }


    @Autowired
    private UsuariosDao usuariosDao;
    @Transactional
    @Override
    public UsuariosBean save(UsuariosDto usuariosDto) {
        if (usuariosDto.getContra() == null || usuariosDto.getContra().isEmpty()) {
            usuariosDto.setContra(generarPassword());
        }
        usuariosDto.setStatus(true);
        UsuariosBean usuariosBean = UsuariosBean.builder().id_usuarios(usuariosDto.getId_usuarios())
                .nombre_usuario(usuariosDto.getNombre_usuario())
                .contra(usuariosDto.getContra())
                .status(usuariosDto.getStatus())
                .build();
        return usuariosDao.save(usuariosBean);
    }
    @Transactional(readOnly = true)
    @Override
    public UsuariosBean findById(Integer id) {

        return usuariosDao.findById(id).orElse(null);
    }
    @Transactional
    @Override
    public void delete(UsuariosBean usuarios) {
        usuariosDao.delete(usuarios);
    }
    @Override
    public List<UsuariosBean> findAll() {
        return (List<UsuariosBean>) usuariosDao.findAll();

    }
}
