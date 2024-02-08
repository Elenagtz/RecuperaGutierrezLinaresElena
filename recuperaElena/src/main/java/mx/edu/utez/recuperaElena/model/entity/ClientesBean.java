package mx.edu.utez.recuperaElena.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

//Gutiérrez Linares Elena Guadalupe 5A
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "clientes")
public class ClientesBean {
    @Id
    @Column(name = "id_clientes",nullable = false)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id_clientes;

    @Column (name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "apellido_paterno", nullable = false)
    private String apellido_paterno;
     @Column(name = "apellido_materno")
    private String apellido_materno;
     @Column(name = "direccion")
    private  String direccion;
     @Column(name = "contacto")
    private String contacto;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JsonIgnore
    @JoinColumn (name = "usuarios_id")
    private UsuariosBean usuariosBean;
}
