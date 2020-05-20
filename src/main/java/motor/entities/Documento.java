/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motor.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import javax.persistence.*;
import motor.commons.dal.DalEntity;


/**
 *
 * @author nacho
 */
@Entity 
@Table(name = "documentos")
public class Documento implements Serializable, DalEntity
{
    // Definición de atributos y persistencia con BD...
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_documento;
    
    @Column(name = "nombre")
    private String nombreDoc;
    
    
    private HashSet<Posteo> documentoSet;
    
    
    // Constructores
    public Documento()
    {
        
    }

    public Documento(long id_documento, String nombreDoc, HashSet<Posteo> documentoSet) 
    {
        this.id_documento = id_documento;
        this.nombreDoc = nombreDoc;
        this.documentoSet = documentoSet;
    }
    
    public Documento(long id_documento, String nombreDoc) 
    {
        this.id_documento = id_documento;
        this.nombreDoc = nombreDoc;
        this.documentoSet = new HashSet<>();
    }

    // Getter y setters
    public long getId_documento() {
        return id_documento;
    }

    public String getNombreDoc() {
        return nombreDoc;
    }

    public HashSet<Posteo> getDocumentoSet() {
        return documentoSet;
    }

    public void setId_documento(long id_documento) {
        this.id_documento = id_documento;
    }

    public void setNombreDoc(String nombreDoc) {
        this.nombreDoc = nombreDoc;
    }

    public void setDocumentoSet(HashSet<Posteo> documentoSet) {
        this.documentoSet = documentoSet;
    }

    // To string
    @Override
    public String toString() {
        return "Documento{" + "id_documento=" + id_documento + ", nombreDoc=" + nombreDoc + ", documentoSet=" + documentoSet + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (int) (this.id_documento ^ (this.id_documento >>> 32));
        hash = 29 * hash + Objects.hashCode(this.nombreDoc);
        hash = 29 * hash + Objects.hashCode(this.documentoSet);
        return hash;
    }
    
    // Equals
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
        final Documento other = (Documento) obj;
        if (this.id_documento != other.id_documento) {
            return false;
        }
        if (!Objects.equals(this.nombreDoc, other.nombreDoc)) {
            return false;
        }
        if (!Objects.equals(this.documentoSet, other.documentoSet)) {
            return false;
        }
        return true;
    }

    // Clone
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    


    
    

    
    
    
    
}
