package com.example.orderservice.service;



import com.example.orderservice.model.EventStore;

import java.time.LocalDateTime;

public interface EventServiceLog {

    void addEvent(Object event,String eventType);

    Iterable<EventStore> fetchAllEvents(String name);

    Iterable<EventStore> fetchAllEventsTillDate(String name, LocalDateTime date);
}
