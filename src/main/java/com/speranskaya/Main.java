package com.speranskaya;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.apache.commons.collections4.map.LinkedMap;

import java.lang.reflect.Type;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        BidiMap<String, String> bidi = new TreeBidiMap<>();
        bidi.put("SIX", "6");
        bidi.get("SIX");
        bidi.getKey("6");
        bidi.removeValue("6");
        BidiMap<String, String> inverse = bidi.inverseBidiMap();


        Bag<String> bag = new HashBag<>();
        bag.add("ONE", 6);
        bag.remove("ONE", 2);
        bag.getCount("ONE");

        OrderedMap<String, String> map = new LinkedMap<>();
        map.put("FIVE", "5");
        map.put("SIX", "6");
        map.put("SEVEN", "7");
        map.firstKey();
        map.nextKey("FIVE");
        map.nextKey("SIX");

        CallLog callLog = new CallLog("Даниленко",
                "0649785312",
                LocalTime.of(12, 28));

        Gson gson = new Gson();
        String json = gson.toJson(callLog);
        System.out.println(json);

        CallLog callLog1 = gson.fromJson(json, CallLog.class);
        System.out.println(callLog1.getContactName()
                + " " + callLog1.getPhoneNumber()
                + " " + callLog1.getTime());

        System.out.println("--------------------------------------");
        Collection<CallLog> callLogs = new ArrayList<>();
        while (callLogs.size() < 5) {
            callLogs.add(new CallLogsFactory().createCallLog());
        }

        for (CallLog log : callLogs) {
            System.out.println(log.getContactName()
                    + " " + log.getPhoneNumber()
                    + " " + log.getTime());
        }

        Gson gson1 = new Gson();
        String json1 = gson.toJson(callLogs);
        System.out.println(json1);
        System.out.println("--------------------------------------------");
        Type collectionType = new TypeToken<Collection<CallLog>>() {
        }.getType();
        Collection<CallLog> callLogs1 = gson1.fromJson(json1, collectionType);
        for (CallLog log : callLogs1) {
            System.out.println(log.getContactName()
                    + " " + log.getPhoneNumber()
                    + " " + log.getTime());
        }
    }
}
