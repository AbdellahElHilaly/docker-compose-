package com.youcode.aftas.core.service.app_service.base;

import java.util.List;

public interface CrudVmService <T, VM, ID> {
    public VM save(T t);
    public VM  findById(ID id);
    public List<VM> getAll();
    public VM  update(T  t, ID id);
    public void deleteById(ID id);
    public void deleteAll();
    public T findOrThrow(ID id);
}
