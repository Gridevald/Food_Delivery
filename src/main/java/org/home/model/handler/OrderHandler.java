package org.home.model.handler;

import org.home.listener.EMFListener;
import org.home.model.entity.Customer;
import org.home.model.entity.Dish;
import org.home.model.entity.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Map;

public class OrderHandler {

    @SuppressWarnings("unchecked")
    public static void addOrder(Map<Dish, Integer> dishData, Map<String, String> customerData) {

        EntityManager em = null;
        EntityTransaction tr = null;

        boolean customerMarker = checkCustomer(customerData.get("number"));

        try {
            em = EMFListener.getEntityManager();
            tr = em.getTransaction();
            tr.begin();

            Customer customer;
            if (customerMarker) {
                String cQuery = "from Customer customer where customer.number = :number";
                List<Customer> cTemp = (List<Customer>) em.createQuery(cQuery)
                        .setParameter("number", customerData.get("number"))
                        .getResultList();
                customer = cTemp.get(0);
                customer.setName(customerData.get("name"));
                customer.setAddress(customerData.get("address"));
                em.flush();
            } else {
                customer = new Customer(customerData.get("name"),
                        customerData.get("address"),
                        customerData.get("number"));
            }

            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Dish, Integer> entity : dishData.entrySet()) {
                sb.append("{").append(entity.getKey().getName()).append("[").append(entity.getValue()).append("]}");
            }

            Order order = new Order(customer, sb.toString());
            customer.getOrders().add(order);

            em.persist(customer);
            tr.commit();


        } catch (RuntimeException e) {
            e.printStackTrace();
            if (tr != null) {
                tr.rollback();
            }
        } finally {
            EMFListener.closeEntityManager(em);
        }
    }

    @SuppressWarnings("unchecked")
    private static boolean checkCustomer(String number) {
        EntityManager em = null;
        List<Customer> customers;
        boolean marker = false;

        try {
            em = EMFListener.getEntityManager();
            em.getTransaction().begin();
            String query = "from Customer customer where customer.number = :number";
            customers = (List<Customer>) em.createQuery(query)
                    .setParameter("number", number)
                    .getResultList();
            em.getTransaction().commit();
            marker = customers.size() > 0;
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            EMFListener.closeEntityManager(em);
        }

        return marker;
    }
}
