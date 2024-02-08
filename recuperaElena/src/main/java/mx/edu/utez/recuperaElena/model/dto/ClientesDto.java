package mx.edu.utez.recuperaElena.model.dto;

import lombok.*;
//Gutiérrez Linares Elena Guadalupe 5A
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClientesDto {
    private Integer id_clientes;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private  String direccion;
    private String contacto;
    private Integer usuarios_id;
}
