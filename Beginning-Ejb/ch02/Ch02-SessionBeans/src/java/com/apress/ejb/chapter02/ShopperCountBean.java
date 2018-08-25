/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apress.ejb.chapter02;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * Cuando multiples Singleton Session Bean son requeridos dentro de la aplicacion, la aplicacion podria requerir que ellos deben ser
 * inicializados en una secuencia determinada. La anotacion @DependsOn declara que el Session Bean Singleton tiene una dependencia sobre
 * otro Singleton Session Bean
 * @author PC
 */
@Singleton(name = "ShopperCount")
@Startup // indicamos que el contenedor debe inicializar el singleton bean  durante la secuencia de Startup de la aplicacion
public class ShopperCountBean {
    private int shopperCounter;
    
    // increment number of shopper counter
    public void incrementShopperCount()
    {
        shopperCounter++;
    }
    
    // return number of shopper
    public int getShopperCount()
    {
        return shopperCounter;
    }
    
    //reset counter
    public void resetCounter()
    {
        shopperCounter = 0;
    }
    
    /**
     * Lifecycle Callback Methods
     * Session beans Singleton soporta callback para construction y destruction.
     */
    @PostConstruct // este callback ocurre luego que el contenedor ejb ha instanciado el bean y aplicado cualquier dependecy injection y antes de la llamada de cualquier metodo de negocio del bean
    public void applicationStartup()
    {
        System.out.println("Desde el metodo applicationStartup()");
        resetCounter();
    }
    
    @PreDestroy //ocurre durante el shutdown de la app. Considera la relacion aplicada entre singleton session bean basados en la anotacion @DependsOn
    public void applicationShutDown()
    {
        System.out.println("Desde el metodo applicationShutDown");
    }
}
