package mx.edu.utez.recuperaElena.model.dto;


import lombok.*;
//Gutiérrez Linares Elena Guadalupe 5A
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UsuariosDto {
    private Integer id_usuarios;
    private String nombre_usuario;
    private String contra;
    private Boolean status;
}
