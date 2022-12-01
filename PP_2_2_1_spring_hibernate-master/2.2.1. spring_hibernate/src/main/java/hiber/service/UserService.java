package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    User getUserByCarModel(String model);

    User getUserByCarSeries(int series);

    User getUserByCarModelAndSeries(String model, int series);
}
