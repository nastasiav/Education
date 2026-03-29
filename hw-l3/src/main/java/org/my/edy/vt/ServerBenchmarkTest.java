package org.my.edy.vt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

public class ServerBenchmarkTest {

    private static final long SEQUENTIAL_TIME = 10_000L * 50;

    private static Result resultCommon;
    private static Result resultVT;

    @BeforeAll
    static void setup() throws ExecutionException, InterruptedException {
        resultCommon = ServerBenchmark_V2.processWithPlatformThreads();
        resultVT = ServerBenchmark_V2.processWithVirtualThreads();
    }

    // TODO: проверь что обычные потоки быстрее последовательного выполнения
    // подсказка: SEQUENTIAL_TIME = 10_000 * 50ms = 500_000ms
    @Test
    void platformThreadsShouldBeFasterThanSequential() throws ExecutionException, InterruptedException {
        Assertions.assertTrue(resultCommon.getTime() < SEQUENTIAL_TIME);
    }

    // TODO: проверь что виртуальные потоки быстрее последовательного выполнения
    @Test
    void virtualThreadsShouldBeFasterThanSequential() throws ExecutionException, InterruptedException {
        Assertions.assertTrue(resultVT.getTime() < resultCommon.getTime());
    }

    // TODO: проверь что виртуальные потоки быстрее обычных минимум в 2 раза
    // подсказка: virtualTime * 2 < platformTime
    @Test
    void virtualThreadsShouldBeFasterThanPlatform() {
        Assertions.assertTrue(resultVT.getTime() * 2 < resultCommon.getTime());
    }

    // TODO: измени методы чтобы возвращали List<String> с результатами
    // проверь что размер списка равен 10_000
    @Test
    void allRequestsShouldBeProcessed() {
        Assertions.assertNotNull(resultCommon.getResult());
        Assertions.assertNotNull(resultVT.getResult());
        Assertions.assertEquals(10_000, resultCommon.getResult().size());
        Assertions.assertEquals(10_000, resultVT.getResult().size());
    }

    // TODO: проверь что результаты обычных потоков содержат "pool-" в имени
    @Test
    void platformThreadsShouldHaveCorrectThreadNames() {
        Assertions.assertNotNull(resultCommon.getResult());
        Assertions.assertEquals(10_000, resultCommon.getResult().size());
        for (String res : resultCommon.getResult()) {
            Assertions.assertTrue(res.contains("pool-"));
        }
    }

    // TODO: проверь что результаты виртуальных потоков содержат "virtual" в имени
    @Test
    void virtualThreadsShouldHaveCorrectThreadNames() {
        Assertions.assertNotNull(resultVT.getResult());
        Assertions.assertEquals(10_000, resultVT.getResult().size());
        for (String res : resultVT.getResult()) {
            Assertions.assertTrue(res.contains("virtual"));
        }

    }
}