package com.speranskaya;

import java.time.LocalTime;

public class CallLogsFactory {

    public int minHour;
    public int maxHour;
    public int minMinute;
    public int maxMinute;
    public String[] names;
    public String[] numbers;

    public CallLogsFactory() {
        names = new String[]{"Донченко", "Артеменко", "Воеводов"};
        numbers = new String[]{"0633455897", "0975863241", "0475893125"};
        minHour = 0;
        maxHour = 23;
        minMinute = 0;
        maxMinute = 59;
    }

    public CallLog createCallLog() {

        int randomIndex = (int) (Math.random() * names.length);
        String randomContactName = names[randomIndex];

        int randomIndex2 = (int) (Math.random() * numbers.length);
        String randomPhoneNumber = numbers[randomIndex2];

        int randomHour = (int) ((Math.random() * (maxHour - minHour + 1)) + minHour);
        int randomMinute = (int) ((Math.random() * (maxMinute - minMinute + 1)) + minMinute);

        CallLog callLog = new CallLog(randomContactName, randomPhoneNumber,
                LocalTime.of(randomHour, randomMinute));

        return callLog;
    }
}
