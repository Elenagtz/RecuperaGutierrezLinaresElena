package mx.edu.utez.recuperaElena.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
//Gutiérrez Linares Elena Guadalupe 5A
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
@Table(name = "usuarios")
public class UsuariosBean {
    @Id
    @Column(name = "id_usuarios", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuarios;
    @Column(name = "nombre_usuario", nullable = false)
    private String nombre_usuario;
    @Column(name = "contra", nullable = false)
    private String contra;
    @Column (name = "status",nullable = false)
    private Boolean status;
    @JsonIgnore
    @OneToOne (mappedBy = "usuariosBean", cascade = CascadeType.ALL)
    private ClientesBean clientesBean;
}
