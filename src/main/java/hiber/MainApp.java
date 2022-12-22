package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.JoinColumn;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.addCar(new Car("Bentley Continental GT", 777));
      userService.addCar(new Car("Bugatti Veyron", 228));
      userService.addCar(new Car("Cadillac Escalade", 322));
      userService.addCar(new Car("BMW X5", 101));

      List<Car> cars = userService.listCars();

      userService.add(new User(cars.get(1),"User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User(cars.get(2), "User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User(cars.get(3),"User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User(cars.get(0),"User4", "Lastname4", "user4@mail.ru"));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+ user.getId());
         System.out.println("First Name = "+ user.getFirstName());
         System.out.println("Last Name = "+ user.getLastName());
         System.out.println("Email = "+ user.getEmail());
         System.out.println("Car = " + user.getCar());
         System.out.println();
      }
      System.out.println(userService.getCarOwner("Bentley Continental GT", 777));

      context.close();
   }
}
