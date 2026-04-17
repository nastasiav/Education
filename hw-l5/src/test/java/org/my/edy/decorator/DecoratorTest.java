package org.my.edy.decorator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class DecoratorTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void concreteComponentShouldPrintSingleLine() {
        Component component = new ConcreteComponent();
        component.execute();

        assertEquals("ConcreteComponent - execute()", outContent.toString().trim());
    }

    @Test
    void cryptionDecoratorShouldAddBeforeAndAfterBehavior() {
        Component decorated = new CryptionDecorator(new ConcreteComponent());
        decorated.execute();

        String output = outContent.toString().trim();
        String[] lines = output.split("\\r?\\n");

        assertEquals(5, lines.length, "Должно быть ровно 5 строк вывода");
        assertEquals("CryptionDecorator - before execute (encryption)", lines[0]);
        assertEquals("BaseDecorator - before execute",            lines[1]);
        assertEquals("ConcreteComponent - execute()",             lines[2]);
        assertEquals("BaseDecorator - after execute",             lines[3]);
        assertEquals("CryptionDecorator - after execute (decryption)", lines[4]);
    }

    @Test
    void doubleWrappingWithBaseDecoratorShouldDuplicateOutput() {
        Component buggyDecorated = new CryptionDecorator(new BaseDecorator(new ConcreteComponent()));
        buggyDecorated.execute();

        String output = outContent.toString();
        long baseDecoratorOccurrences = output.lines()
                .filter(line -> line.contains("BaseDecorator"))
                .count();

        assertEquals(4, baseDecoratorOccurrences,
                "BaseDecorator встречается дважды: его before/after печатается по 2 раза");
    }

    @Test
    void chainingMultipleDecorators() {
        Component c = new ConcreteComponent();
        Component decorated = new CryptionDecorator(c);

        decorated.execute();
        String output = outContent.toString().trim();

        assertTrue(output.startsWith("CryptionDecorator - before execute (encryption)"));
        assertTrue(output.endsWith("CryptionDecorator - after execute (decryption)"));
        assertTrue(output.contains("ConcreteComponent - execute()"));
    }
}