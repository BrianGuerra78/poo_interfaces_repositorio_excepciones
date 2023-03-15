package org.bguerra.poointerfaces.repositorio;

import org.bguerra.poointerfaces.modelo.BaseEntity;
import org.bguerra.poointerfaces.repositorio.excepciones.*;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractaListRepositorio<T extends BaseEntity> implements OrdenablePaginableCrudRepositorio<T> {


    protected List<T> dataSource;

    public AbstractaListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<T> listar() {
        return dataSource;
    }

    @Override
    public T porId(Integer id) throws LecturaAccesoDatoExcepcion {
        if (id == null || id <= 0) {
            throw new LecturaAccesoDatoExcepcion("Id invalido debe ser > 0");
        }
        T resultado = null;
        for (T cli : dataSource) {
            if (cli.getId() != null && cli.getId().equals(id)) {
                resultado = cli;
                break;
            }
        }
        if (resultado == null) {
            throw new LecturaAccesoDatoExcepcion("No existe el registro con id: " + id);
        }
        return resultado;
    }

    @Override
    public void crear(T t) throws EscrituraAccesoDatoExcepcion {
        if (t == null) {
            throw new EscrituraAccesoDatoExcepcion("Error al insertar un objeto null");
        }
        if (this.dataSource.contains(t)) {
            throw new RegistoDuplicadoAccesoDatoException("Error el objeto con id " + t.getId()
                    + " ya existe en el repositorio");
        }
        this.dataSource.add(t);
    }

    @Override
    public void eliminar(Integer id) throws LecturaAccesoDatoExcepcion {
        //Cliente c = this.porId(id);
        //this.dataSource.remove(c);
        this.dataSource.remove(this.porId(id));
    }

    @Override
    public List<T> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);
    }

    @Override
    public int total() {
        return this.dataSource.size();
    }
}
