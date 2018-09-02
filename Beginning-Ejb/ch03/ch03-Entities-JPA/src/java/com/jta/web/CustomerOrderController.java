/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jta.web;

import com.jta.entities.Customer;
import com.jta.entities.CustomerOrder;
import com.jta.service.CustomerOrderServiceLocal;
import com.jta.service.CustomerServiceLocal;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author PC
 */
@WebServlet(name = "CustomerOrderController", urlPatterns = {"/CustomerOrderController"})
public class CustomerOrderController extends HttpServlet {
    
    private static final long serialVersionUID = 2L;
    static Logger log = LogManager.getRootLogger();
    
    @EJB
    CustomerOrderServiceLocal customerOrderServiceLocal;
    
    @EJB
    CustomerServiceLocal customerServiceLocal;
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        String customerId = request.getParameter("customer");
        
        Customer customer = new Customer(Integer.valueOf(customerId));
        
        if(accion != null && accion.equals("verPedidos"))
        {
            List<CustomerOrder> customerOrders = customerOrderServiceLocal.getCustomerOrderFindById(customer);
            Customer customerTitle = customerServiceLocal.findCustomerById(customer);
            
            request.setAttribute("customerOrders", customerOrders);
            request.setAttribute("title", customerTitle);
            request.getRequestDispatcher("customerOrders.jsp").forward(request, response);
            
            //List<CustomerOrder> customerOrders =  customerOrderServiceLocal.getAllOrdersByCustomerId(customer);
            //Customer customerTitle = customerServiceLocal.findCustomerById(customer);
            
            /**
            request.setAttribute("customer", customerTitle);
            
            */
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
