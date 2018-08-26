/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apress.ejb.ch03.domain.listing_3_02;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Convertimos un JavaBean en un Entity adicionando a nivel clase @Entity y @Id para indicar el indice de la entidad.
 * @Id identifica a customerId como llave primaria para la Entidad.El valor del identificador debe ser unico sobre todas las instancias
 * de entidad de tipo Customer. En el caso que la llave primaria incluye multiples columnas en la tabla, una clave primaria compuesta 
 * es requerida y los campos @Id debe ser reemplazados por un solo campo con la anotacion @EmbeddedId
 * Implementamos la interface Serializable para hacer la clase compatible con cliente remotos.
 * Todas las clase que no son marcadas como entidad son ignoradas por el proveedo de persistencia durante el despliegue
 * @author PC
 */
@Entity
public class Customer implements Serializable{
    @Id
    private int customerId;
    private String  name;
    
    public Customer(){}

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
