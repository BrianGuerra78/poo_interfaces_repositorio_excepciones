package org.bguerra.genericsclass;

public class EjemploGenericos {
    public static void main(String[] args) {

        Camion<Animal> transporteCaballos = new Camion<Animal>(5);
        transporteCaballos.add(new Animal("Peregrino ", "Caballo"));
        transporteCaballos.add(new Animal("Grillo", "Caballo"));
        transporteCaballos.add(new Animal("Trunquen", "Caballo"));
        transporteCaballos.add(new Animal("Topocalma", "Caballo"));
        transporteCaballos.add(new Animal("Longotoma", "Caballo"));

        //for (Object o : transporteCaballos) {
        //Animal a = (Animal) o;
        /*for (Animal a : transporteCaballos) {
            System.out.println(a.getNombre() + " Tipo: " + a.getTipo());
        }*/
        imprimirCamion(transporteCaballos);

        Camion<Maquinaria> transMaquinas = new Camion<Maquinaria>(3);
        transMaquinas.add(new Maquinaria("Bulldozer"));
        transMaquinas.add(new Maquinaria("Grua Horquilla"));
        transMaquinas.add(new Maquinaria("Perforadora"));

        // for (Object o : transMaquinas) {
        //   Maquinaria m = (Maquinaria) o;
       /* for (Maquinaria m : transMaquinas) {
            System.out.println(m.getTipo());
        }*/
        imprimirCamion(transMaquinas);

        Camion<Automovil> transAuto = new Camion<Automovil>(3);
        transAuto.add(new Automovil("Toyota"));
        transAuto.add(new Automovil("Mitsubishi"));
        transAuto.add(new Automovil("Chevrolet"));

        //for (Object o : transAuto) {
        //  Automovil a = (Automovil) o;
        /*for (Automovil a : transAuto) {
            System.out.println(a.getMarca());
        }*/
        imprimirCamion(transAuto);
    }

    public static <T> void imprimirCamion(Camion<T> camion) {
        for (T a : camion) {
            if (a instanceof Animal) {
                System.out.println((((Animal) a).getNombre() + " Tipo: " + ((Animal) a).getTipo()));
            } else if (a instanceof Automovil) {
                System.out.println(((Automovil) a).getMarca());
            } else if (a instanceof Maquinaria) {
                System.out.println(((Maquinaria) a).getTipo());
            }
        }
    }
}
