/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2017.web.controladores;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.acceso.GenericFacadeLocal;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.acceso.RolFacadeLocal;
import org.primefaces.event.SelectEvent;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.definiciones.Rol;

/**
 *
 * @author gonzalez
 */
@Named(value = "rolBean")
@ViewScoped
public class RolBean extends GenericManagedBean<Rol> implements Serializable {

    public RolBean() {

    }
    @EJB
    RolFacadeLocal Rolfc;
    Rol rol;
    boolean mostrar = false, crudBtns = true;

    public boolean isMostrar() {
        return mostrar;
    }

    public void setMostrar(boolean mostrar) {
        this.mostrar = mostrar;
    }

    public boolean isCrudBtns() {
        return crudBtns;
    }

    public void setCrudBtns(boolean crudBtns) {
        this.crudBtns = crudBtns;
    }

    @Override
    protected GenericFacadeLocal<Rol> getFacadeLocal() {
        return Rolfc;
    }

    @Override
    public Rol getEntity() {
        return rol;
    }

    public RolFacadeLocal getRolfc() {
        return Rolfc;
    }

    public void setRolfc(RolFacadeLocal Rolfc) {
        this.Rolfc = Rolfc;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public void onRowSelect(SelectEvent event) {
        setMostrar(false);
        setCrudBtns(true);
    }

    @PostConstruct
    public void init() {
        super.llenarLista();
    }

    @Override
    public void reset() {
        rol.setActivo(false);
        rol.setIdRol(null);
        rol.setDescripcion(null);
        rol.setNombre(null);
    }

    @Override
    public void nuevo() {
        rol = new Rol();
        setMostrar(true);
        setCrudBtns(true);
    }

    @Override
    public void cancelar() {
        rol = new Rol();
        setMostrar(false);
        setCrudBtns(true);
    }

    public List<Rol> getListaDatos() {
        return listaDatos;
    }

    public void setListaDatos(List<Rol> listaDatos) {
        this.listaDatos = listaDatos;
    }
    

}
