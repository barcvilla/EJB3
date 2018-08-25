/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apress.ejb.chapter02;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 * Session Bean que llevara un registro de los items adicionados por el usuario al carrito de compras y sus respectivas cantidades
 * @author PC
 */
@Stateful(name = "ShoppingCart")
public class ShoppingCartBean implements ShoppingCartLocal, ShoppingCartRemote{
    
    private ArrayList cartItems;
    
    public ShoppingCartBean(){}

    public ArrayList getCartItems() {
        return cartItems;
    }

    public void setCartItems(ArrayList cartItems) {
        this.cartItems = cartItems;
    }

    @Override
    public void addWineItem(String wine) {
        cartItems.add(wine);
    }

    @Override
    public void removeWineItem(String wine) {
        cartItems.remove(wine);
    }
    
    /** LIFECYCLE CALLBACKS **/
    /**
     * Stateful session beans soportan callback events
     * @PostConstruct, @PreDestroy, @PreActivate, @PrePassivate
     */
    @PostConstruct
    public void initialize()
    {
        cartItems = new ArrayList();
    }
    
    /**
     * @PreDestro ocurre despues de que cualquier metodo con la anotacion @Remove haya sido completada. El metodo exit() escribe el 
     * array cartItems en la BD
     */
    @PreDestroy
    public void exit()
    {
        // la lista de items en la base de datos
        System.out.println("Lista de item guadada en la BD");
    }
    
    /**
     * La anotacion @Remove es un metodo muy util del ciclo de vida para un stateful session bean. Cuando un metodo con la anotacion @Remove es llamado
     * el contenedor removera la instancia del session bean del pool de objetos luego que el metodo haya sido ejecutado
     */
    @Remove
    public void stopSession()
    {
        // el cuerpo del metodo puede ser vacio.
        System.out.println("From stopSession method with @Remove annotation");
    }
}
