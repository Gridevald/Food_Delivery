package org.home.model.handler;

import org.home.listener.EMFListener;
import org.home.model.entity.Dish;

import javax.persistence.EntityManager;
import java.util.List;

public class DishHandler {

    @SuppressWarnings("unchecked")
    public static List<Dish> getDishList() {
        EntityManager em = null;
        List<Dish> dishes = null;
        try {
            em = EMFListener.getEntityManager();
            em.getTransaction().begin();
            String query = "from Dish";
            dishes = em.createQuery(query).getResultList();
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            EMFListener.closeEntityManager(em);
        }
        //may be I should check for null List value
        return dishes;
    }

    @SuppressWarnings("unchecked")
    public static Dish findDish(String name) {
        EntityManager em = null;
        Dish out = null;
        List<Dish> temp = null;
        try {
            em = EMFListener.getEntityManager();
            em.getTransaction().begin();
            String query = "from Dish dish where dish.name = :name";
            temp = em.createQuery(query)
                    .setParameter("name", name)
                    .getResultList();
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            EMFListener.closeEntityManager(em);
        }
        if (temp != null && temp.size() > 0) {
            out = temp.get(0);
        } else {
            System.err.println("didn't find DISH in dish table!!! : DishHandler.findDish : " + name);
        }
        return out;
    }
}
