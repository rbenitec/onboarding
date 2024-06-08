package com.utp.hackaton.onborading.user_service.service.impl;

import com.utp.hackaton.onborading.user_service.entity.EventEntity;
import com.utp.hackaton.onborading.user_service.repository.EventRepository;
import com.utp.hackaton.onborading.user_service.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    @Override
    public EventEntity saveEvent(EventEntity event) {
        return eventRepository.save(event);
    }

    @Override
    public List<EventEntity> findAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public void deleteEvent(Integer id) {
        eventRepository.deleteById(id);
    }
}
