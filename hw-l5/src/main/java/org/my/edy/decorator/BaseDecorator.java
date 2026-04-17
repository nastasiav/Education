package org.my.edy.decorator;

public class BaseDecorator implements Component {
    Component wrappee;

    public BaseDecorator(Component source) {
        this.wrappee = source;
    }

    @Override
    public void execute() {
        IO.println("BaseDecorator - before execute");
        wrappee.execute();
        IO.println("BaseDecorator - after execute");
    }
}
