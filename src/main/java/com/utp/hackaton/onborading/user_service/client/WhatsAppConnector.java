package com.utp.hackaton.onborading.user_service.client;

import com.utp.hackaton.onborading.user_service.model.whatsapp.request.MessageRequest;
import com.utp.hackaton.onborading.user_service.model.whatsapp.response.MessageResponse;

import java.util.Optional;

public interface WhatsAppConnector {
    Optional<MessageResponse> sendMessageWhatsApp (MessageRequest messageRequest);
}
