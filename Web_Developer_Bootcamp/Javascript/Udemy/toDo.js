var todos = ["Buy new Turtle"];

function listTodos() {
    console.log("************************");
    todos.forEach(function (todo, index) {
        console.log(index + ": " + todo);
    });
    console.log("************************");
}

function addTodo() {
    var newItem = prompt("Enter new Item");
    todos.push(newItem);
    console.log("Added Todo");
}

function deleteTodo() {
    var index = prompt("Enter index of todo to be deleted");
    todos.splice(index, 1);
    console.log("Deleted Todo");
}

window.setTimeout(function () {
    do {
        var input = prompt("What would you like to do?");
        if (input === "list") {
            listTodos();
        }
        else if (input === "new") {
            addTodo();
        }
        else if (input === "delete") {
            deleteTodo();
        }
    } while (input !== "quit");

    console.log("You quit the App!");
}, 500);
