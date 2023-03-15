package org.bguerra.poointerfaces;

import org.bguerra.poointerfaces.modelo.Cliente;
import org.bguerra.poointerfaces.modelo.Producto;
import org.bguerra.poointerfaces.repositorio.Direccion;
import org.bguerra.poointerfaces.repositorio.OrdenablePaginableCrudRepositorio;
import org.bguerra.poointerfaces.repositorio.excepciones.AccesoDatoExcepcion;
import org.bguerra.poointerfaces.repositorio.excepciones.LecturaAccesoDatoExcepcion;
import org.bguerra.poointerfaces.repositorio.lista.ProductoListRepositorio;

import java.util.List;

public class EjemploRepositorioProducto {
    public static void main(String[] args) {

        try {
            OrdenablePaginableCrudRepositorio<Producto> repo = new ProductoListRepositorio();
            repo.crear(new Producto("Mesa", 50.52));
            repo.crear(new Producto("Silla", 18));
            repo.crear(new Producto("Lampara", 15.5));
            repo.crear(new Producto("Notebook", 400.89));

            List<Producto> productos = repo.listar();
            productos.forEach(System.out::println);
            System.out.println("=======Paginable=======");
            //List<Cliente> paginable = ((PaginableRepositorio) repo).listar(1, 3);
            List<Producto> paginable = repo.listar(1, 3);
            paginable.forEach(System.out::println);

            System.out.println("=======Ordenar=====");
            //List<Cliente> clientesOrdenAsc = ((OrdenableRepositorio) repo).listar("nombre", Direccion.ASC);
            List<Producto> productosOrdenAsc = repo.listar("descripcion", Direccion.ASC);
            for (Producto c : productosOrdenAsc) {
                System.out.println(c);
            }

            System.out.println("=======Editar=======");
            Producto lamparaActualizar = new Producto("Lampara de escritrio", 23);
            lamparaActualizar.setId(3);
            repo.editar(lamparaActualizar);
            Producto lampara = repo.porId(3);
            System.out.println(lampara);
            System.out.println("=======Ordenar=====");
            //((OrdenableRepositorio) repo).listar("nombre", Direccion.ASC).forEach(System.out::println);
            repo.listar("descripcion", Direccion.ASC).forEach(System.out::println);

            System.out.println("=======Eliminar=====");
            repo.eliminar(2);
            repo.listar().forEach(System.out::println);
            System.out.println("=======Total======");
            System.out.println("Total registros: " + repo.total());
        } catch (LecturaAccesoDatoExcepcion e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (AccesoDatoExcepcion e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
