/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apress.ejb.chapter02;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC
 */
@Local
public interface SearchFacadeLocal {
    public List wineSearch(String wineType);
}
