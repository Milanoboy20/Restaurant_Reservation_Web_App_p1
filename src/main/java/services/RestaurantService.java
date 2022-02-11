package services;

import java.util.List;

public interface RestaurantService<E> {

    public E addEntity(E entity);
    public E getByID(int id);
    public E update(E entity);
    public List<E> allEntities();
    public boolean deleteByID(int id);

}
