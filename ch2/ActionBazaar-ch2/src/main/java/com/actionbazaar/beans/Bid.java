/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.actionbazaar.beans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author PC
 */
@Named(value = "bid")
@RequestScoped
public class Bid {

    /**
     * Creates a new instance of Bid
     */
    public Bid() {
    }
    
}
