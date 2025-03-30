package ru.azotchenko.web.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.azotchenko.domain.service.QuestionService;
import ru.azotchenko.web.api.mapper.QuestionDtoMapper;
import ru.azotchenko.web.api.dto.OpenQuestionCardDto;
@Controller
@RequestMapping(value = "/question")
public class QuestionController {
    private QuestionService questionService;
    private QuestionDtoMapper mapper;
    public QuestionController(QuestionService questionService, QuestionDtoMapper mapper) {
        this.questionService = questionService;
        this.mapper = mapper;
    }

    @GetMapping("/new")
    public String newProject(Model model) {
        model.addAttribute("question", new OpenQuestionCardDto());
        return "edit_question";
    }

    @PostMapping("/save")
    public String add(@ModelAttribute OpenQuestionCardDto question, Model model) {
        questionService.save(mapper.mapToModel(question));
        model.addAttribute("questions", mapper.mapToDto(questionService.getAll()));
        return "main";
    }

    @GetMapping("/edit/{id}")
    public String editProject(@PathVariable("id") Long id, Model model) {
        model.addAttribute("question", mapper.mapToDto(questionService.getById(id).get()));
        return "edit_question";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        questionService.getById(id).ifPresent(questionService::delete);
        model.addAttribute("questions", mapper.mapToDto(questionService.getAll()));
        return "main";
    }
}
