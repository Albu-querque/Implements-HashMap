package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws ClassNotFoundException {
        /*StorageStrategy strategy = new HashMapStorageStrategy();
        testStrategy(strategy, (long) 10000);

        StorageStrategy strategy2 = new OurHashMapStorageStrategy();
        testStrategy(strategy2, (long) 10000);

        StorageStrategy strategy3 = new FileStorageStrategy();
        testStrategy(strategy3, (long) 1000);

        StorageStrategy strategy4 = new OurHashBiMapStorageStrategy();
        testStrategy(strategy4, 10000);

        StorageStrategy strategy5 = new HashBiMapStorageStrategy();
        testStrategy(strategy5, 10000);*/
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> res = new HashSet<>();
        for(String string : strings)
            res.add(shortener.getId(string));

        return res;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> res = new HashSet<>();
        for(Long id : keys)
            res.add(shortener.getString(id));

        return res;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> res = new HashSet<>();
        Shortener shortener = new Shortener(strategy);
        for(long i = 0; i < elementsNumber; ++i) {
            res.add(Helper.generateRandomString());
        }
        Date time = new Date();
        Set<Long> setIds = getIds(shortener, res);
        Helper.printMessage((new Date().getTime() - time.getTime()) + "");

        Date time2 = new Date();
        Set<String> setStrings = getStrings(shortener, setIds);
        Helper.printMessage((new Date().getTime() - time2.getTime()) + "");

        if(res.containsAll(setStrings))
            Helper.printMessage("Тест пройден.");
        else
            Helper.printMessage("Тест не пройден.");
    }
}
