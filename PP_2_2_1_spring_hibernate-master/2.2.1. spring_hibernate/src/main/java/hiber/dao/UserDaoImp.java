package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User userByCarModel(String model) {
      Query query = sessionFactory.getCurrentSession()
              .createQuery("FROM User usr LEFT OUTER JOIN FETCH usr.userCar WHERE usr.userCar.model =:model")
              .setParameter("model", model);
      return (User) query.getSingleResult();
   }

   @Override
   public User userByCarSeries(int series) {
      Query query = sessionFactory.getCurrentSession()
              .createQuery("FROM User usr LEFT OUTER JOIN FETCH usr.userCar WHERE usr.userCar.series =:series")
              .setParameter("series", series);
      return (User) query.getSingleResult();
   }

   @Override
   public User userByCarModelAndSeries(String model, int series) {
      Query query = sessionFactory.getCurrentSession()
              .createQuery("FROM User as usr where userCar.model =: model and userCar.series =: series")
              .setParameter("model", model)
              .setParameter("series", series);
      return (User) query.getSingleResult();
   }

}
