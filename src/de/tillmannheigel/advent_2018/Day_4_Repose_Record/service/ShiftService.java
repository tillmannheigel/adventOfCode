package de.tillmannheigel.advent_2018.Day_4_Repose_Record.service;

import de.tillmannheigel.advent_2018.Day_4_Repose_Record.data.EventType;
import de.tillmannheigel.advent_2018.Day_4_Repose_Record.data.Shift;
import de.tillmannheigel.advent_2018.Day_4_Repose_Record.data.Event;

import java.util.ArrayList;
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
}
