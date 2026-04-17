package org.my.edy.decorator;

public class ConcreteComponent implements Component {
    @Override
    public void execute() {
        IO.println("ConcreteComponent - execute()");
    }
}
