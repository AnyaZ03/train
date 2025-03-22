package ru.azotchenko;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.azotchenko.config.SpringConfig;
import ru.azotchenko.controller.ConsoleController;
import ru.azotchenko.storage.QuestionlnMemoryStorage;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        ConsoleController controller = context.getBean(ConsoleController.class);
        controller.interactWithUser();
    }
}
