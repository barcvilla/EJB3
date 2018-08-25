/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.actionbazaar.businesslogic;

import com.actionbazaar.beans.Bid;
import javax.ejb.Local;

/**
 *
 * @author PC
 */
@Local
public interface BidService {
    public void addBid(Bid bid);
}
