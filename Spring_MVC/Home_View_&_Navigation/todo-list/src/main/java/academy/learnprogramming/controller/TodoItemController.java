package academy.learnprogramming.controller;

import academy.learnprogramming.model.TodoData;
import academy.learnprogramming.model.TodoItem;
import academy.learnprogramming.service.TodoItemService;
import academy.learnprogramming.util.AttributeNames;
import academy.learnprogramming.util.Mappings;
import academy.learnprogramming.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Slf4j
@Controller
public class TodoItemController {

    // == private fields ==
    private final TodoItemService todoItemService;

    @Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    // == model attribute section ==
    @ModelAttribute
    // the model attribute nams is the name of the class with the first letter in lowercase i.e -> todoData
    public TodoData todoData() {
        return todoItemService.getData();
    }

    // == handler methods ==
    // http://localhost:8080/todo-list/items
    @GetMapping(Mappings.ITEMS)
    public String items() {
        return ViewNames.ITEMS_LIST;
    }

    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(@RequestParam(required = false, defaultValue = "-1") int id, Model model) {
        log.info("Editing id = {}", id);
        TodoItem todoItem = todoItemService.getItem(id);

        if (todoItem == null) // item not present
            todoItem = new TodoItem("", "", LocalDate.now()); // create new item

        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        log.info("Model = {}", model);
        return ViewNames.ADD_ITEM;
    }

    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam int id) {
        log.info("Deleting item with item id = {}", id);
        todoItemService.removeItem(id);
        return "redirect:/" + Mappings.ITEMS;
    }

    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem) { // name of the property is todoItem
        log.info("todoItem from form = {}", todoItem);

        if (todoItem.getId() == 0)
            todoItemService.addItem(todoItem);
        else
            todoItemService.updateItem(todoItem);

        return "redirect:/" + Mappings.ITEMS;
        // this will redirect to Mapping GetMapping ITEMS i.e // http://localhost:8080/todo-list/items
    }
}
