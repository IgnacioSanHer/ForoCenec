/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteClases;

import java.util.Date;

/**
 *
 * @author alumno
 */
public class Comentario {
    String usuario;
    String hora;
    Date fecha;
    String comentario;

    public Comentario(String usuario, String hora, Date fecha, String comentario) {
        this.usuario = usuario;
        this.hora = hora;
        this.fecha = fecha;
        this.comentario = comentario;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getHora() {
        return hora;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getComentario() {
        return comentario;
    }
    
}
