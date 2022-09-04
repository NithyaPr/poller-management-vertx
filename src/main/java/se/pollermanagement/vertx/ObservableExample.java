package se.pollermanagement.vertx;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Function;

import java.util.ArrayList;
import java.util.List;

public class ObservableExample {

    public static void main(String[] args) {
        System.out.println("hello");


        List<String> hiList = List.of("nithya","prbhakar");

        List<String> helloList = List.of("samini","achyut");
        List<String> hej = List.of("Earth","Mars");

        Single<List<String>> stringList1 =
                Single.just(hiList);
        //stringList1.toObservable().flatMapIterable()

        //Observable<List<String>> obs  =



    }

    private static Single<List<String>> getNames(String name) {
        List<String> helloList = List.of("samini","achyut");
        List<String> hej = List.of("Earth","Mars");

        if(name.equals("nithya")){
            return Single.just(helloList);
        }else{
            return Single.just(hej);
        }
    }

}
