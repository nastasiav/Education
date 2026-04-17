package org.my.edy.decorator;

public class CryptionDecorator extends BaseDecorator {

    public CryptionDecorator(Component source) {
        super(source);
    }

    @Override
    public void execute() {
        IO.println("CryptionDecorator - before execute (encryption)");
        super.execute();
        IO.println("CryptionDecorator - after execute (decryption)");
    }
}
