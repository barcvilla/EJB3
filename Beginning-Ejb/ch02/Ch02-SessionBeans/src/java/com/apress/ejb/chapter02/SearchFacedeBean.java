/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apress.ejb.chapter02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author PC
 */
@Stateless
public class SearchFacedeBean implements SearchFacadeLocal, SearchFacadeRemote{

    HashMap<String, String> countryMap = new HashMap<String, String>();

    public SearchFacedeBean(){}
    
    @Override
    public List wineSearch(String wineType)
    {
        List wineList = new ArrayList<>();
        if(wineType.equals("Red"))
        {
            wineList.add("Bordeux");
            wineList.add("Merlot");
            wineList.add("Pinot Noir");
        }
        else if(wineType.equals("White"))
        {
            wineList.add("Chardonnar");
        }
        
        return wineList;
    }
    
    /**
     * @PostConstruct ocurre luego que la instancia del bean ha sido instanciado en el contenedor EJB. PostConstruct ocurre luego de aplicarse
     * cualquier Injection y antes de que el primer metodo de negocio en el bean sea llamado
     */
    @PostConstruct // Inicializamos una lista de paises productores de vinos, lo ideal seria llamar esta informacion de una BD
    public void initializeCountryWineList()
    {
        countryMap.put("Australia", "Sauvignon Blank");
        countryMap.put("Australia", "Grenache");
        countryMap.put("France", "Gewurztraminer");
        countryMap.put("France", "Bordeaux");
    }
    
    /**
     * @PreDestroy ocurre antes de que el Contenedor EJB destruya un inutilizado o expirada la instancia de un Bean desde el object pool. Este
     * Callback puede ser utilizado para cerrar algun connection pool que haya sido creado con inyeccion de dependencia y tambien liberar cualquier
     * otro recurso
     */
    @PreDestroy
    public void destroyWineList()
    {
        countryMap.clear();
    }
    
    @AroundInvoke
    public Object TimerLog(InvocationContext ctx) throws Exception
    {
        String beansClassName = ctx.getClass().getName();
        String businessMethodName = ctx.getMethod().getName();
        String target =  beansClassName + "." + businessMethodName;
        long startTime = System.currentTimeMillis();
        System.out.println("Invocando..." + target);
        try
        {
            return ctx.proceed();
        }
        finally
        {
            System.out.println("Saliendo..." + target);
            long totalTime = System.currentTimeMillis() - startTime;
            System.out.println("Business method: " + businessMethodName + " in " + beansClassName + " take " + totalTime + " ms to execute");
        }
    }
    
}
