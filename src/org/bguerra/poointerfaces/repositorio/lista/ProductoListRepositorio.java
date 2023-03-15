package org.bguerra.poointerfaces.repositorio.lista;

import org.bguerra.poointerfaces.modelo.Producto;
import org.bguerra.poointerfaces.repositorio.AbstractaListRepositorio;
import org.bguerra.poointerfaces.repositorio.Direccion;
import org.bguerra.poointerfaces.repositorio.OrdenableRepositorio;
import org.bguerra.poointerfaces.repositorio.excepciones.LecturaAccesoDatoExcepcion;

import java.util.ArrayList;
import java.util.List;

public class ProductoListRepositorio extends AbstractaListRepositorio<Producto> {
    @Override
    public void editar(Producto producto) throws LecturaAccesoDatoExcepcion {
        Producto p= porId(producto.getId());
        p.setDescripcion(producto.getDescripcion());
        p.setPrecio(producto.getPrecio());
    }

    @Override
    public List<Producto> listar(String campo, Direccion dir) {
        List<Producto> listaOrdenada = new ArrayList<>(this.dataSource);
        listaOrdenada.sort((a, b) -> {
            int resultado = 0;
            if (dir == Direccion.ASC) {
                resultado = OrdenableRepositorio.ordenar2(campo, a, b);
            } else if (dir == Direccion.DES) {
                resultado = OrdenableRepositorio.ordenar2(campo, b, a);
            }
            return resultado;
        });
        return listaOrdenada;
    }

    private int ordenar2(String campo, Producto a, Producto b) {
        int resultado = 0;
        switch (campo) {
            case "id" -> resultado = a.getId().compareTo(b.getId());
            case "descripcion" -> resultado = a.getDescripcion().compareTo(b.getDescripcion());
            case "precio" -> resultado = a.getPrecio().compareTo(b.getPrecio());
        }
        return resultado;
    }
}
