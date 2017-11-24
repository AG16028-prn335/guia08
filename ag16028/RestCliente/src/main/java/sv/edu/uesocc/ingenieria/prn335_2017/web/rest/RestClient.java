/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2017.web.rest;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.definiciones.Rol;

/**
 * Jersey REST client generated for REST resource:RolRest [rol]<br>
 * USAGE:
 * <pre>
 *        RestClient client = new RestClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author usuario
 */
@Named
@ViewScoped
public class RestClient implements Serializable{
    private  List<Rol>  salida;

    public List<Rol> getSalida() {
        return salida;
    }

    public void setSalida(List<Rol> salida) {
        this.salida = salida;
    }
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/guia07/web";

    public RestClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("rol");
    }

    public List<Rol> findRange(int pagesize, int first) {
    List salida=null;
        try {
            WebTarget resource = client.target(BASE_URI).queryParam("first",first).queryParam("pagesize", pagesize);
            salida=resource.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Rol>>(){});
        } catch (Exception e) {
        }
        return salida;
    }

    public Rol findById(int id) {
        Rol rol;
        try {
           WebTarget resource = webTarget.path("{id}").resolveTemplate("id", id);
               return rol=resource.request(MediaType.APPLICATION_JSON).get(Rol.class);
        } catch (Exception e) {
            System.out.println("ERROR: "+e);
        }
       return null;
    }

    public List<Rol> findAll() {
       List<Rol> salida=null;
        try {
            WebTarget resource = client.target(BASE_URI).path("findall");
        salida=resource.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Rol>>(){});
        } catch (Exception e) {
            System.out.println("ERROR: "+e);
        }
       return salida; 
    }
    
    public List<Rol> filtrado(){
        List<Rol> salida=null;
        try {
            WebTarget resoruce=client.target(BASE_URI).path("filt");
        } catch (Exception e) {
        }
       return salida;
    }
    
     @PostConstruct
    public void init (){
        salida = findAll();
    }
    public void close() {
        client.close();
    }
    
}
