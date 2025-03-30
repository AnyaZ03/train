package ru.azotchenko.console;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.azotchenko.console.config.SpringConfig;
import ru.azotchenko.console.controller.ConsoleController;
import ru.azotchenko.domain.model.OpenQuestionCard;
import ru.azotchenko.domain.repo.QuestionRepository;
import ru.azotchenko.domain.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class App implements CommandLineRunner {
    @Autowired
    private ConsoleController controller;
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        ConsoleController controller = context.getBean(ConsoleController.class);
        SpringApplication.run(App.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        controller.interactWithUser();
    }
}
