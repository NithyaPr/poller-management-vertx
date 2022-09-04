package se.pollermanagement.vertx;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Consumer;
import io.vertx.core.Vertx;

public class SingleExample {
    public static void main(String[] args) {
        System.out.println("hello");

        learnBySimpleSingle();
    }

    private static void learnBySimpleSingle() {
        int a = 0;
        Single.just(1).doOnSuccess(integer -> {System.out.println("I print sucess integer " + integer);})
                .doOnSubscribe(integer -> System.out.println("I print integer on subscribe" + integer))
                .subscribe(integer -> {System.out.println("I print integer " + integer);printInteger(a,integer);});


        Single.just(2).doOnSuccess(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println("I 2 print integer " + integer);
            }
        }).map(i -> printInteger(i,i)).subscribe();
    }

    private static Integer printInteger(Integer integer, Integer integer1) {
        System.out.println("I print method integer " + integer);
        return  integer;
    }


}
