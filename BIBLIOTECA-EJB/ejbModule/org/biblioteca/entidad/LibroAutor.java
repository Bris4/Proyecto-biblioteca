package org.biblioteca.entidad;
import java.io.Serializable;
import javax.persistence.*;
@Entity 
@Table(name="libros_autores")
public class LibroAutor implements Serializable {
private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="lau_codigo")
private Integer codigo;

public void setCodigo(Integer codigo) {
	this.codigo = codigo;
}
@ManyToOne 
 @JoinColumn(name="lau_autor")
private Autor autor;
 @ManyToOne 
 @JoinColumn(name="lau_libro")
private Libro libro;
public LibroAutor() {
	libro= new Libro();
	autor=new Autor();
}
public Autor getAutor() {
 return this.autor;
}
public void setAutor(Autor autor) {
 this.autor = autor;
}
public Libro getLibro() {
 return this.libro;
}
public void setLibro(Libro libro) {
 this.libro = libro;
}
public Integer getCodigo() {
	return codigo;
}
}