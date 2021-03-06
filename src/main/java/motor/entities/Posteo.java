
package motor.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import motor.commons.dal.DalEntity;

@Entity
@Table(name = "posteos")
@IdClass(PosteoPK.class)

@NamedQueries(
    {
        @NamedQuery(name = "Posteo.findByFilter", query = "SELECT p.tf, t.nombre, t.max_tf, t.idf, d.nombreDoc, d.titulo FROM Posteo p"
                                                        + " JOIN Termino t"
                                                        + " JOIN Documento d"
                                                        + " WHERE t.id_termino = p.id_termino AND d.id_documento = p.id_documento AND t.nombre = :nombre"),
   })
public class Posteo implements Serializable, DalEntity 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id_documento")
    private Long id_documento;
    
    @Id
    @Column(name = "id_termino")
    private Long id_termino;

    @Column(name = "tf")
    private int tf;

    public Posteo() 
    {
        
    }

    public Posteo(Long id_documento, Long id_termino, int tf) {
        this.id_documento = id_documento;
        this.id_termino = id_termino;
        this.tf = tf;
    }
    public Posteo (Long id_documento, int tf)
    {
        this.id_documento = id_documento;
        this.tf = tf;
    }

    public Long getId_documento() {
        return id_documento;
    }

    public Long getId_termino() {
        return id_termino;
    }

    public int getTf() {
        return tf;
    }

    public void setId_documento(Long id_documento) {
        this.id_documento = id_documento;
    }

    public void setId_termino(Long id_termino) {
        this.id_termino = id_termino;
    }

    public void setTf(int tf) {
        this.tf = tf;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id_documento);
        hash = 23 * hash + Objects.hashCode(this.id_termino);
        hash = 23 * hash + this.tf;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Posteo other = (Posteo) obj;
        if (this.tf != other.tf) {
            return false;
        }
        if (!Objects.equals(this.id_documento, other.id_documento)) {
            return false;
        }
        if (!Objects.equals(this.id_termino, other.id_termino)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Posteo{" + "id_documento=" + id_documento + ", id_termino=" + id_termino + ", tf=" + tf + '}';
    }
}