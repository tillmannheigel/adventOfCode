package de.tillmannheigel.advent_2018.Day_4_Repose_Record.service;

import de.tillmannheigel.advent_2018.Day_4_Repose_Record.data.BestSleepingMinuteContainer;
import de.tillmannheigel.advent_2018.Day_4_Repose_Record.data.EventType;
import de.tillmannheigel.advent_2018.Day_4_Repose_Record.data.Shift;
import de.tillmannheigel.advent_2018.Day_4_Repose_Record.data.Event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShiftService {

    public void printShift(Shift shift){
        System.out.println("Guard Id:" + shift.getGuardId());
        String hasEvent = ".";
        for (int i = 0; i < 60; i++) {
            for (Event event :shift.getEvents()) {
                if (event.getEventType()== EventType.FALLS_ASLEEP && event.getTime().getMinutes()==i){
                    hasEvent = "#";
                }
                if (event.getEventType()== EventType.WAKES_UP && event.getTime().getMinutes()==i){
                    hasEvent = ".";
                }
            }
            System.out.print(hasEvent);
        }
    }

    public int calcMinutesAsleep(Shift shift){
        int minutesAsleep = 0;
        int sleeps = 0;
        for (int i = 0; i < 60; i++) {
            for (Event event :shift.getEvents()) {
                if (event.getEventType()== EventType.FALLS_ASLEEP && event.getTime().getMinutes()==i){
                    sleeps = 1;
                }
                if (event.getEventType()== EventType.WAKES_UP && event.getTime().getMinutes()==i){
                    sleeps = 0;
                }
            }
            minutesAsleep+=sleeps;
        }
        System.out.println(minutesAsleep);
        return minutesAsleep;
    }

    public List<Shift> getShifts(List<Event> shiftEvents) {
        List<Shift> shifts = new ArrayList<>();

        for (int i = 0; i < shiftEvents.size(); i++) {
            Event event = shiftEvents.get(i);
            if(event.getId().isPresent()){
                ArrayList<Event> events = new ArrayList<>();
                events.add(event);
                shifts.add(Shift.builder().guardId(event.getId().get()).events(events).build());
            } else {
                Shift shift = shifts.get(shifts.size()-1);
                shift.getEvents().add(event);
            }
        }
        return shifts;
    }

    public int[] calcBestMinute(List<Shift> shifts){
        int[] minutes = new int[60];
        for (int i = 0; i < 60; i++) {
            for (int j = 0; j < shifts.size(); j++) {
                if(isSleeping(i, shifts.get(j))){
                    minutes[i]++;
                }
            }
        }
        return minutes;
    }

    private boolean isSleeping(int minute, Shift shift){
        int sleeps = 0;
        for (int i = 0; i < 60; i++) {
            if(minute==i && sleeps == 1) return true;
            for (Event event :shift.getEvents()) {
                if (event.getEventType()== EventType.FALLS_ASLEEP && event.getTime().getMinutes()==i){
                    sleeps = 1;
                }
                if (event.getEventType()== EventType.WAKES_UP && event.getTime().getMinutes()==i){
                    sleeps = 0;
                }
            }
        }
        return false;
    }
    public static List<String> getGuards(List<Shift> shifts) {

        List<String> guards = new ArrayList<>();

        for (Shift shift : shifts) {
            String guardId = shift.getGuardId();
            if (!guards.contains(guardId)) {
                guards.add(guardId);
            }
        }
        return guards;
    }

    public List<BestSleepingMinuteContainer> getBestSleepingMinutes(List<String> guards, HashMap<String, List<Shift>> shiftsByGuard){
        List<BestSleepingMinuteContainer> bestSleepingMinutes = new ArrayList<>();
        for (String guard : guards) {
            List<Shift> guardsShifts = shiftsByGuard.get(guard);
            int[] minutes = this.calcBestMinute(guardsShifts);
            BestSleepingMinuteContainer bestSleepingMinute = this.calculateBestMinuteAndOccurrencyOfSleep(guard, minutes);
            bestSleepingMinutes.add(bestSleepingMinute);
        }
        return bestSleepingMinutes;
    }

    public static HashMap<String, List<Shift>> shiftsByGuard(List<Shift> shifts) {
        HashMap<String, List<Shift>> shiftsByGuard = new HashMap<>();

        for (Shift shift : shifts) {
            String guardId = shift.getGuardId();
            if (!shiftsByGuard.containsKey(guardId)) {
                shiftsByGuard.put(guardId, new ArrayList<>());
            }
            shiftsByGuard.get(guardId).add(shift);
        }
        return shiftsByGuard;
    }

    public void printTimeline() {
        for (int i = 0; i < 60; i++) {
            if (i<10){
                System.out.print(" " + i + " ");
            } else {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public BestSleepingMinuteContainer calculateBestMinuteAndOccurrencyOfSleep(String guardId, int[] minutes){
        int highestValue = 0;
        int highestValueMinute = 0;
        for (int i = 0; i < minutes.length; i++) {
            int currentValue = minutes[i];
            if (currentValue > highestValue){
                highestValue = currentValue;
                highestValueMinute = i;
            }
        }

        return BestSleepingMinuteContainer.builder()
                .guardId(guardId).minute(highestValueMinute)
                .timesAtSleep(highestValue)
                .build();
    }
}
