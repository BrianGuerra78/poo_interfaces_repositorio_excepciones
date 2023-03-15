package org.bguerra.poointerfaces.repositorio.lista;

import org.bguerra.poointerfaces.modelo.Cliente;
import org.bguerra.poointerfaces.repositorio.AbstractaListRepositorio;
import org.bguerra.poointerfaces.repositorio.Direccion;
import org.bguerra.poointerfaces.repositorio.OrdenableRepositorio;
import org.bguerra.poointerfaces.repositorio.excepciones.LecturaAccesoDatoExcepcion;

import java.util.ArrayList;
import java.util.List;

public class ClienteListRepositorio extends AbstractaListRepositorio<Cliente> {

    @Override
    public void editar(Cliente cliente) throws LecturaAccesoDatoExcepcion {
        Cliente c = this.porId(cliente.getId());
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
    }


    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        List<Cliente> listaOrdenada = new ArrayList<>(this.dataSource);
        listaOrdenada.sort((a, b) -> {
            int resultado = 0;
            if (dir == Direccion.ASC) {
                //resultado = this.ordenar(campo, a, b);
                resultado = OrdenableRepositorio.ordenar(campo, a, b);
            } else if (dir == Direccion.DES) {
                //resultado = this.ordenar(campo, b, a);
                resultado = OrdenableRepositorio.ordenar(campo, b, a);
            }
            return resultado;
        });
        return listaOrdenada;
    }


    private int ordenar(String campo, Cliente a, Cliente b) {
        int resultado = 0;
        switch (campo) {
            case "id" -> resultado = a.getId().compareTo(b.getId());
            case "nombre" -> resultado = a.getNombre().compareTo(b.getNombre());
            case "apellido" -> resultado = a.getApellido().compareTo(b.getApellido());
        }
        return resultado;
    }

}
