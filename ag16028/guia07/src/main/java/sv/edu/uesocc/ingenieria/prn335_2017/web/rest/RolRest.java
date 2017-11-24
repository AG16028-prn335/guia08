/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2017.web.rest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.acceso.RolFacadeLocal;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.definiciones.Rol;

/**
 *
 * @author gonzalez
 */
@Path("rol")
public class RolRest implements Serializable{
    
    
    @EJB
    private RolFacadeLocal rolfLocal;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Rol> findAll(){
        List salida =null;
        try {
            if (rolfLocal!=null) {
          salida=rolfLocal.findAll();
            }
        } catch (Exception e) {
            System.out.println("ERROR");
        }finally{
            if(salida==null){
                salida=new ArrayList();
            }
        }
        return salida;
   }
    
    @GET
    @Path("findrange")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Rol> findRange(
            @DefaultValue("0") @QueryParam("first")int primero,
            @DefaultValue("5") @QueryParam("pagesize")int tamanio){
        List salida =null;
        try {
            if (rolfLocal!=null) {
          salida=rolfLocal.findRange(primero, tamanio);
            }
        } catch (Exception e) {
            System.out.println("ERROR");
        }finally{
            if(salida==null){
                salida=new ArrayList();
            }
        }
        return salida;
   }

    @GET 
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Rol findById(@PathParam("id") Integer id){
        try {
            return rolfLocal.find(id);
        } catch (Exception e) {
            System.out.println("ERROR: "+e);
        }
        return new Rol();
    }


}
