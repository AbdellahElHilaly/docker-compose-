package com.youcode.aftas.core.service.app_service.base;

import java.util.List;

public interface CrudService<T, ID> {
    public T save(T t);
    public T  getById(ID id);
    public List<T > getAll();
    public T  update(T  t, ID id);
    public void deleteById(ID id);
    public void deleteAll();
}
