package web;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import web.config.HibernateConfig;
import web.config.SpringConfig;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImpl;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(HibernateConfig.class);

        UserService userService = context.getBean(UserService.class);
        userService.addUser(new User("sd","Sd",(byte)5));
    }
}
