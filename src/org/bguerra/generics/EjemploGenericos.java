package org.bguerra.generics;

import org.bguerra.poointerfaces.modelo.Cliente;
import org.bguerra.poointerfaces.modelo.ClientePremium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploGenericos {
    public static void main(String[] args) {
        //List clientes = new ArrayList();
        List<Cliente> clientes = new ArrayList<Cliente>();
        clientes.add(new Cliente("Brian", "Guerra"));

        //Cliente brian = (Cliente) clientes.get(0);
        Cliente brian = clientes.get(0);

        Cliente[] clientesArreglo = {new Cliente("Luci", "Martinez"),
                new Cliente("Brian", "Guerra")};
        Integer[] enterosArreglo = {1, 2, 3};

        List<Cliente> clientesLista = fromArrayToList(clientesArreglo);
        List<Integer> enteroaLista = fromArrayToList(enterosArreglo);

        clientesLista.forEach(System.out::println);
        enteroaLista.forEach(System.out::println);

        List<String> nombres = fromArrayToList(new String[]{"Andres", "Pepe",
                "Luci", "Bea", "John"}, enterosArreglo);
        nombres.forEach(System.out::println);

        List<ClientePremium> clientePremiumList = fromArrayToList(
                new ClientePremium[]{new ClientePremium("Paco", "Fernandez")});
        //List<Cliente> clientePremiumList = fromArrayToList(
        //      new ClientePremium[]{new ClientePremium("Paco", "Fernandez")});

        imprimirClientes(clientes);
        imprimirClientes(clientesLista);
        imprimirClientes(clientePremiumList);

        System.out.println("Maximo de 1, 9 y 4 es: " + maximo(1, 9, 4));
        System.out.println("Maximo de 3.9, 11.6 y 7.78 es: " + maximo(3.9, 11.6, 7.78));
        System.out.println("Maximo de zanahoria, arandanos, mazana es: " + maximo("zanahoria", "arandanos", "manzana"));
    }

    public static <T> List<T> fromArrayToList(T[] c) {
        return Arrays.asList(c);
    }

    public static <T extends Number> List<T> fromArrayToList(T[] c) {
        return Arrays.asList(c);
    }

   /* public static List<Cliente> fromArrayToList(Cliente[] c) {
        return Arrays.asList(c);
    }*/

    public static <T extends Cliente & Comparable<T>> List<T> fromArrayToList(T[] c) {
        return Arrays.asList(c);
    }

    public static <T, G> List<T> fromArrayToList(T[] c, G[] g) {
        for (G elemento : g) {
            System.out.println(elemento);
        }
        return Arrays.asList(c);
    }

    public static void imprimirClientes(List<? extends Cliente> clientes) {
        clientes.forEach(System.out::println);
    }

    public static <T extends Comparable<T>> T maximo(T a, T b, T c) {
        T max = a;
        if (b.compareTo(max) > 0) {
            max = b;
        }
        if (c.compareTo(max) > 0) {
            max = c;
        }
        return max;
    }
}
