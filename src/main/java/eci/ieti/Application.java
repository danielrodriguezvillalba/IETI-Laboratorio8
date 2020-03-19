package eci.ieti;

import eci.ieti.data.CustomerRepository;
import eci.ieti.data.ProductRepository;
import eci.ieti.data.TodoRepository;
import eci.ieti.data.UserRepository;
import eci.ieti.data.model.Customer;
import eci.ieti.data.model.Product;

import eci.ieti.data.model.Todo;
import eci.ieti.data.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoOperations;

import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class Application implements CommandLineRunner {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private ProductRepository productRepository;
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        MongoOperations mongoOperation = (MongoOperations) applicationContext.getBean("mongoTemplate");

        userRepository.deleteAll();

        userRepository.save(new User("Carla Sanchez", "carla@mail.com"));
        userRepository.save(new User("Carlos Sanchez", "carlos@mail.com"));
        userRepository.save(new User("Juan Ramirez", "juan@mail.com"));
        userRepository.save(new User("Fidel Sanchez", "fidel@mail.com"));
        userRepository.save(new User("Daniel Ramirez", "daniel@mail.com"));
        userRepository.save(new User("David Ramirez", "david@mail.com"));
        userRepository.save(new User("Sergio Mar", "sergio@mail.com"));
        userRepository.save(new User("Antonio Diaz", "antonio@mail.com"));
        userRepository.save(new User("Camilo Rodriguez", "camilo@mail.com"));
        userRepository.save(new User("Laura Rodriguez", "laura@mail.com"));


        System.out.println("Users found with findAll():");
        System.out.println("-------------------------------");

        userRepository.findAll().stream().forEach(System.out::println);
        System.out.println();

        todoRepository.deleteAll();

        todoRepository.save(new Todo("Nuevo todo 1", 2, new Date(1957, Calendar.JANUARY,9), "carla@mail.com", "ready"));
        todoRepository.save(new Todo("Nuevo todo 2", 1, new Date(1958, Calendar.FEBRUARY, 13), "carlos@mail.com", "ready"));
        todoRepository.save(new Todo("Nuevo todo 3", 3, new Date(1957,Calendar.APRIL, 14), "juan@mail.com", "ready"));
        todoRepository.save(new Todo("Nuevo todo 4", 4, new Date(1957, Calendar.JULY, 9), "fidel@mail.com", "pending"));
        todoRepository.save(new Todo("Nuevo todo 5", 4, new Date(1957, Calendar.AUGUST, 13), "daniel@mail.com", "pending"));
        todoRepository.save(new Todo("Nuevo todo 6", 5, new Date(1960, Calendar.NOVEMBER, 14), "david@mail.com", "pending"));
        todoRepository.save(new Todo("Nuevo todo 7", 4, new Date(1960, Calendar.SEPTEMBER, 9), "sergio@mail.com", "pending"));
        todoRepository.save(new Todo("Nuevo todo 8", 3, new Date(1961,Calendar.JANUARY,13), "antonio@mail.com", "in progress"));
        todoRepository.save(new Todo("Nuevo todo 9", 2, new Date(1961, Calendar.JULY, 14), "camilo@mail.com", "in progress"));
        todoRepository.save(new Todo("Nuevo todo 10", 1, new Date(1961, Calendar.NOVEMBER, 9), "laura@mail.com", "in progress"));
        todoRepository.save(new Todo("Nuevo todo 11", 5, new Date(2000, Calendar.JANUARY, 13), "carla@mail.com", "ready"));
        todoRepository.save(new Todo("Nuevo todo 12", 4, new Date(2000, Calendar.JULY, 14), "carlos@mail.com", "in progress"));
        todoRepository.save(new Todo("Nuevo todo 13", 5, new Date(2000,Calendar.NOVEMBER, 15), "juan@mail.com", "ready"));
        todoRepository.save(new Todo("Nuevo todo 14", 2, new Date(2015, Calendar.JANUARY, 22), "fidel@mail.com", "in progress"));
        todoRepository.save(new Todo("Nuevo todo 15", 3, new Date(2015, Calendar.JULY, 7), "daniel@mail.com", "ready"));
        todoRepository.save(new Todo("Nuevo todo 16", 4, new Date(2015, Calendar.NOVEMBER, 11), "david@mail.com", "in progress"));
        todoRepository.save(new Todo("Nuevo todo 17", 1, new Date(2022, Calendar.JANUARY, 30), "sergio@mail.com", "in progress"));
        todoRepository.save(new Todo("Nuevo todo 18", 2, new Date(2022, Calendar.JULY, 22), "antonio@mail.com", "pending"));
        todoRepository.save(new Todo("Nuevo todo 19", 1, new Date(2022, Calendar.NOVEMBER, 17), "camilo@mail.com", "pending"));
        todoRepository.save(new Todo("Nuevo todo 20", 2, new Date(2019, Calendar.JANUARY, 14), "laura@mail.com", "ready"));
        todoRepository.save(new Todo("Nuevo todo 21", 3, new Date(2019, Calendar.JULY, 13), "laura@mail.com", "pending"));
        todoRepository.save(new Todo("Nuevo todo 22", 4, new Date(2019, Calendar.NOVEMBER,30), "antonio@mail.com", "ready"));
        todoRepository.save(new Todo("Nuevo todo 23", 5, new Date(2200, Calendar.JANUARY, 21), "sergio@mail.com", "ready"));
        todoRepository.save(new Todo("Nuevo todo 24", 3, new Date(2200, Calendar.JULY, 5), "fidel@mail.com", "ready"));
        todoRepository.save(new Todo("Nuevo todo 25", 4, new Date(2200, Calendar.NOVEMBER, 13), "fidel@mail.com", "pending"));

        System.out.println("Paginated search of todos by criteria:");
        System.out.println("-------------------------------");

        todoRepository.findByResponsible("fidel@mail.com", PageRequest.of(0, 2)).stream()
                .forEach(System.out::println);

        System.out.println();



        /**
        customerRepository.deleteAll();

        customerRepository.save(new Customer("Alice", "Smith"));
        customerRepository.save(new Customer("Bob", "Marley"));
        customerRepository.save(new Customer("Jimmy", "Page"));
        customerRepository.save(new Customer("Freddy", "Mercury"));
        customerRepository.save(new Customer("Michael", "Jackson"));

        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        
        customerRepository.findAll().stream().forEach(System.out::println);
        System.out.println();
        
        productRepository.deleteAll();

        productRepository.save(new Product(1L, "Samsung S8", "All new mobile phone Samsung S8"));
        productRepository.save(new Product(2L, "Samsung S8 plus", "All new mobile phone Samsung S8 plus"));
        productRepository.save(new Product(3L, "Samsung S9", "All new mobile phone Samsung S9"));
        productRepository.save(new Product(4L, "Samsung S9 plus", "All new mobile phone Samsung S9 plus"));
        productRepository.save(new Product(5L, "Samsung S10", "All new mobile phone Samsung S10"));
        productRepository.save(new Product(6L, "Samsung S10 plus", "All new mobile phone Samsung S10 plus"));
        productRepository.save(new Product(7L, "Samsung S20", "All new mobile phone Samsung S20"));
        productRepository.save(new Product(8L, "Samsung S20 plus", "All new mobile phone Samsung S20 plus"));
        productRepository.save(new Product(9L, "Samsung S20 ultra", "All new mobile phone Samsung S20 ultra"));
        
        System.out.println("Paginated search of products by criteria:");
        System.out.println("-------------------------------");
        
        productRepository.findByDescriptionContaining("plus", PageRequest.of(0, 2)).stream()
        	.forEach(System.out::println);
   
        System.out.println();
         */
    }

}