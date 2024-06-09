package com.utp.hackaton.onborading.user_service.service;

import com.utp.hackaton.onborading.user_service.entity.EventEntity;

import java.util.List;

public interface EventService {

    EventEntity saveEvent (EventEntity event);
    List<EventEntity> findAllEvents ();
    void deleteEvent (Integer id);
}
