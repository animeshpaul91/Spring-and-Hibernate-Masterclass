package academy.learnprogramming.model;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class TodoData {
    // == fields ==
    private static int idValue;
    private final List<TodoItem> items;

    public TodoData() {
        idValue = 1;
        items = new ArrayList<>();

        // add some dummy data using the addItem() method
        addItem(new TodoItem("first", "first details", LocalDate.now()));
        addItem(new TodoItem("second", "second details", LocalDate.now()));
        addItem(new TodoItem("third", "third details", LocalDate.now()));
    }

    // == public methods
    public List<TodoItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addItem(@NonNull TodoItem item) {
        item.setId(idValue);
        items.add(item);
        idValue++;
    }

    public void removeItem(int id) {
        ListIterator<TodoItem> itemIterator = items.listIterator();
        while (itemIterator.hasNext()) {
            TodoItem item = itemIterator.next();

            if (item.getId() == id) {
                itemIterator.remove();
                break;
            }
        }
    }

    public TodoItem getItem(int id) {
        for (TodoItem item : items)
            if (item.getId() == id)
                return item;

        return null;
    }

    public void updateItem(@NonNull TodoItem itemToUpdate) {
        ListIterator<TodoItem> itemIterator = items.listIterator();
        while (itemIterator.hasNext()) {
            TodoItem item = itemIterator.next();

            if (item.equals(itemToUpdate)) {
                itemIterator.set(itemToUpdate);
                break;
            }
        }
    }
}
