package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();
   User userByCarModel(String model);

   User userByCarSeries(int series);

   User userByCarModelAndSeries(String model, int series);
}
