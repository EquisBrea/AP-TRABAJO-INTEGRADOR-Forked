package org.cursoutn.repository;

public interface IRepository<T> {
    void crear(T item);
    void leer(T item);
    void actualizar(T item);
    void eliminar(T item);
}
