/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author DELL
 */
public interface DAO<T> {

    List<T> getAll();

    Optional<T> get(int d);

    boolean insert(T t);

    boolean update(T t);

    boolean delete(T t);

    List<T> search(String name);
}
