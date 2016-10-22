package ru.sbt.service;

import ru.sbt.annotations.Cache;

//@org.springframework.stereotype.Service
public class UtilsImpl implements Utils {

    public UtilsImpl() {
//        System.out.println("Start UtilsImpl");
    }

    @Override
    @Cache
    public String doWorker(String item, int i) {
        item = item.toUpperCase();
        String result = "";
        for (int j = 0; j < i; j++) {
            result += item;
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
}