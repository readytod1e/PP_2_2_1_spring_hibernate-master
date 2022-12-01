package hiber;

import hiber.config.AppConfig;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

     /* userService.add(new User("ИВАН1", "ИВАНОВ1", "vanya1@mail.ru", new Car("lada1", 123)));
      userService.add(new User("ИВАН2", "ИВАНОВ2", "vanya2@mail.ru", new Car("lada2", 456)));
      userService.add(new User("ИВАН3", "ИВАНОВ3", "vanya3@mail.ru", new Car("lada3", 789)));
      userService.add(new User("ИВАН4", "ИВАНОВ4", "vanya4@mail.ru", new Car("lada4", 000)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car = " + user.getUserCar());
         System.out.println();
      }

      System.out.println(userService.getUserByCarModel("lada2"));
      System.out.println(userService.getUserByCarSeries(123));*/
      System.out.println(userService.getUserByCarModelAndSeries("lada2", 456));

      context.close();
   }
}

