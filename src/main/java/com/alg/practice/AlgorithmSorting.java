package com.alg.practice;

import com.alg.practice.MyDataStructure.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlgorithmSorting {

    /**
     *
     * Sally: [(8, 12), (14, 15), (18, 19)]
     * Tina: [(11.4, 12.5), (14.5, 16)]
     * Kevin: [(10, 12), (12, 12.4), (18, 18.5)]
     * Bob: [(0, 2), (22, 24)]
     *
     * [(2,8), (12.5, 14), ...]
     *
     * @param schedules
     * @return
     */
    public static List<Schedule> getFreeTime(List<Schedule> schedules) {
        Collections.sort(schedules, (a, b) -> a.end.compareTo(b.end));

        int i = 0;
        int j = 1;

        List<Schedule> freeTimes = new ArrayList<>();

        while(j < schedules.size()) {
            Schedule schedule = schedules.get(i);
            Schedule schedule1 = schedules.get(j);

            if(schedule1.start > schedule.end) {
                freeTimes.add(new Schedule(schedule.end, schedule1.start));
            }

            i++;
            j++;
        }

        return freeTimes;
    }


    public static void main(String args[]) {
        Schedule schedule = new Schedule(8.0, 12.0);
        Schedule schedule1 = new Schedule(14.0, 15.0);
        Schedule schedule2 = new Schedule(18.0, 19.0);
        Schedule schedule3 = new Schedule(11.4, 12.5);
        Schedule schedule4 = new Schedule(14.5, 16.0);
        Schedule schedule5 = new Schedule(10.0, 12.0);
        Schedule schedule6 = new Schedule(12.0, 12.4);
        Schedule schedule7 = new Schedule(18.0, 18.5);
        Schedule schedule8 = new Schedule(0.0, 2.0);
        Schedule schedule9 = new Schedule(22.0, 24.0);

        List<Schedule> schedules = new ArrayList<>();
        schedules.add(schedule);
        schedules.add(schedule1);
        schedules.add(schedule2);
        schedules.add(schedule3);
        schedules.add(schedule4);
        schedules.add(schedule5);
        schedules.add(schedule6);
        schedules.add(schedule7);
        schedules.add(schedule8);
        schedules.add(schedule9);

        for(Schedule temp : getFreeTime(schedules)) {
            System.out.println(temp.start + "," + temp.end);
        }
    }

}
