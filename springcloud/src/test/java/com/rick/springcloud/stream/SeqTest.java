package com.rick.springcloud.stream;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Rick.Tu
 * @program JavaLearn
 * @description
 * @create 2023-06-16 16:19
 **/
@SpringBootTest
public class SeqTest {

    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Seq<Integer> seq = list::forEach;
        seq.map(i -> i + 1).consume(System.out::println);
        seq.flatMap(i -> Seq.unit(i + 1)).consume(System.out::println);
        seq.consume(System.out::println);
        list.forEach(System.out::println);
    }
}
