package org.my.edy.mapreduce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class WordCount_V2 {

    // TODO: реализуй метод Map — подсчёт слов в одной главе

    static Callable<Map<String, Integer>> map(String chapter) {
        return () -> {
            Map<String, Integer> map = new HashMap<>();
            for (String s : chapter.toLowerCase().split(" "))
                map.put(s, map.getOrDefault(s, 0) + 1);
            return map;
        };
    }

    // TODO: реализуй метод Reduce — объединение результатов всех глав
    static Map<String, Integer> reduce(List<Map<String, Integer>> results) {
        return results.stream()
                .flatMap(map -> map.entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        Integer::sum
                ));
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        List<String> chapters = List.of(
                "князь андрей болконский приехал в салон анны павловны шерер в петербурге анна павловна встретила его с радостью князь андрей был умён красив и богат но казался усталым и равнодушным",
                "пьер безухов вернулся из парижа в москву пьер был добр и наивен он искал смысл жизни в философии и масонстве москва встретила пьера шумом и суетой",
                "наташа ростова танцевала на первом балу в петербурге князь андрей пригласил наташу на вальс наташа была молода красива и полна жизни князь андрей влюбился в наташу",
                "наполеон вёл французскую армию на москву русская армия отступала кутузов принял решение оставить москву солдаты были измотаны и голодны но дух армии был силён",
                "бородинское сражение началось на рассвете князь андрей был ранен на поле боя пьер наблюдал за сражением и не понимал хаоса войны русская армия сражалась с французской армией",
                "французская армия вошла в москву москва горела наполеон стоял на холме и смотрел на горящую москву пьер остался в москве и пытался спасти людей из огня",
                "пьер был взят в плен французской армией в плену пьер познакомился с платоном каратаевым платон был прост и мудр пьер нашёл в платоне душевный покой и смысл жизни",
                "денисов и долохов командовали партизанским отрядом партизаны нападали на французские обозы петя ростов присоединился к отряду денисова петя был молод и храбр но погиб в бою",
                "французская армия отступала из москвы солдаты были голодны и измотаны наполеон потерял большую часть армии русская армия преследовала французов кутузов не хотел лишних жертв",
                "князь андрей умер от ран наташа вышла замуж за пьера безухова пьер нашёл смысл жизни в семье и любви наташа стала заботливой женой и матерью москва была отстроена заново"
        );

        // Создаём пул потоков
        ExecutorService executor = Executors.newFixedThreadPool(chapters.size());

        // Отправляем каждую главу в отдельный поток
        List<Future<Map<String, Integer>>> futures = new ArrayList<>();
        for (String chapter : chapters) {
            Callable<Map<String, Integer>> callableTask = map(chapter);
            futures.add(executor.submit(callableTask));
        }

        // Собираем результаты
        List<Map<String, Integer>> mapResults = new ArrayList<>();
        for (Future<Map<String, Integer>> future : futures) {
            mapResults.add(future.get());
        }

        executor.shutdown();

        // Reduce — объединяем всё в одну мапу
        Map<String, Integer> result = reduce(mapResults);

        // Печатаем топ-10 слов
        result.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(10)
                .forEach(e -> System.out.printf("%-15s — %d%n", e.getKey(), e.getValue()));
    }
}