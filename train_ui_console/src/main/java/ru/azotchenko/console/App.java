package ru.azotchenko.console;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.azotchenko.console.config.SpringConfig;
import ru.azotchenko.console.controller.ConsoleController;
import ru.azotchenko.domain.model.OpenQuestionCard;
import ru.azotchenko.domain.repo.QuestionRepository;
import ru.azotchenko.domain.service.QuestionService;



public class App
{
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        ConsoleController controller = context.getBean(ConsoleController.class);
        controller.interactWithUser();
    }
}
