package threeinarow.common.command;

import java.util.Stack;

public class CommandHistory {
    private final Stack<Command> commands; //TODO

    public CommandHistory() {
        this.commands = new Stack<>();
    }

    //запросы
    public Command peek() {
        return commands.peek();
    }

    //команды
    public void push(Command command) {
        commands.push(command);
    }
}
