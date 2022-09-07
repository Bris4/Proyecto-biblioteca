package org.biblioteca.entidad;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="autores")
public class Autor implements Serializable {
private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="aut_codigo")
private Integer codigo;
@Column(name="aut_nombre")
private String nombre;
@Column(name="aut_foto")
private byte[] foto;
public Autor() {
}
public Integer getCodigo() {
return this.codigo;
}
public void setCodigo(Integer codigo) {
this.codigo = codigo;
}
public String getNombre() {
return this.nombre;
}
public void setNombre(String nombre) {
this.nombre = nombre;
}

public byte[] getFoto() {
	return foto;
}
public void setFoto(byte[] foto) {
	this.foto = foto;
}
}
