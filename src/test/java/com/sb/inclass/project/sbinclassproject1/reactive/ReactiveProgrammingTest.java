package com.sb.inclass.project.sbinclassproject1.reactive;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ReactiveProgrammingTest {

    @Test
    public void method1() {
      Mono<String> mono =   Mono.just("data1");  //producer
      //mono.subscribe();

     mono.subscribe(System.out::println);

     Mono<?> monoWithException = Mono.just("data2")
            .then(Mono.error(new RuntimeException("Exception")))
            .log();

     monoWithException.subscribe(System.out::println, (e) -> System.out.print(e.getMessage()));
     }


     @Test
    public void method2() {
        Flux<String> flux =   Flux.just("data1", "data2", "data3");

       //flux.subscribe(System.out::println);

        Flux<?> monoWithException = flux
                //.concatWith(Flux.error(new RuntimeException("Exception")))
                .log();

         monoWithException.subscribe(System.out::println, (e) -> System.out.print(e.getMessage()));
    }
}
