/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apress.ejb.chapter02;

import javax.ejb.Local;

/**
 *
 * @author PC
 */
@Local
public interface ShoppingCartLocal {
    public void addWineItem(String wine);
    public void removeWineItem(String wine);
    
}
