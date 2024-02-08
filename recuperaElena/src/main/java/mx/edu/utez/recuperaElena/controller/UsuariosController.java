package mx.edu.utez.recuperaElena.controller;


import mx.edu.utez.recuperaElena.model.dto.UsuariosDto;
import mx.edu.utez.recuperaElena.model.entity.UsuariosBean;
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
public class UsuariosController {
    @Autowired
    private IUsuarios usuariosService;

    @PostMapping("/usuarios")
    public UsuariosDto create (@RequestBody UsuariosDto usuariosDto){
        UsuariosBean usuariosBean = usuariosService.save(usuariosDto);
        return usuariosDto.builder()
                .nombre_usuario(usuariosBean.getNombre_usuario())
                .contra(usuariosBean.getContra())
                .status(usuariosBean.getStatus())
                .build();
    }

    @PutMapping("/usuarios")
    public UsuariosDto update (@RequestBody UsuariosDto usuariosDto) {
        UsuariosBean usuariosBean = usuariosService.save(usuariosDto);
        return usuariosDto.builder()
                .nombre_usuario(usuariosBean.getNombre_usuario())
                .contra(usuariosBean.getContra())
                .status(usuariosBean.getStatus())
                .build();

    }
    @DeleteMapping("/usuarios/{id}")
        public ResponseEntity<?> delete (@PathVariable Integer id){
            Map<String, Object> response = new HashMap<>();
            try {
                UsuariosBean usuariosBean = usuariosService.findById(id);
                usuariosService.delete(usuariosBean);
                return new ResponseEntity<>(usuariosBean, HttpStatus.NO_CONTENT);
            }catch (DataAccessException ex){
                response.put("msj", ex.getMessage());
                response.put("Persons",null);
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

            }
        }

    @GetMapping("/usuarios")
    public ResponseEntity<List<UsuariosBean>> showAll() {
        try {
            List<UsuariosBean> branches = usuariosService.findAll();
            if (!branches.isEmpty()) {
                return new ResponseEntity<>(branches, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (DataAccessException ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/usuarios/{id}")
    public UsuariosBean showById(@PathVariable Integer id){
        return usuariosService.findById(id);
    }
}

