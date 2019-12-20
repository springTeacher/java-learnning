package com.xiaoniu.concurrent.demo;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @author lhj
 * @date 2019/12/19 14:06
 */
public class Test {

    public static void main(String[] args) {
        List<Shop> list = Arrays.asList(new Shop("one"),
                new Shop("two"),
                new Shop("three"),
                new Shop("four"));
        long start = System.currentTimeMillis();
//        List<String> stringList = list.parallelStream()
//                .map(shop -> String.format("%s price: %.2f", shop.getName(), shop.getPrice(shop.getName())))
//                .collect(Collectors.toList());

        List<CompletableFuture<String>> collect = list.stream().map(shop -> CompletableFuture.supplyAsync(
                () -> String.format("%s price: %.2f", shop.getName(), shop.getPrice(shop.getName()))))
                .collect(Collectors.toList());

        List<String> collect1 = collect.parallelStream().map(CompletableFuture::join).collect(Collectors.toList());

        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }


}
