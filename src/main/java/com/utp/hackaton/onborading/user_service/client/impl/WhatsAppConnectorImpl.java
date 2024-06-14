package com.utp.hackaton.onborading.user_service.client.impl;

import com.utp.hackaton.onborading.user_service.client.WhatsAppConnector;
import com.utp.hackaton.onborading.user_service.model.whatsapp.request.MessageRequest;
import com.utp.hackaton.onborading.user_service.model.whatsapp.response.MessageResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
@Slf4j
@RequiredArgsConstructor
public class WhatsAppConnectorImpl implements WhatsAppConnector {

    private final RestTemplate restTemplate;

    @Value("${config.api.whatsapp.url}")
    private String urlUtp;

    @Value("${config.api.whatsapp.token}")
    private String whatsappToken;

    /*
    public Optional<MessageResponse> getUserUtp (MessageRequest messageRequest) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(whatsappToken);

            MessageResponse responseEntity = restTemplate.exchange(
                    urlUtp,
                    HttpMethod.POST,
                    new HttpEntity<>(messageRequest),
                    MessageResponse.class).getBody();
            assert responseEntity != null;
            return Optional.of(responseEntity);
        } catch (Exception e) {
            log.error("Error while getting la consulta al api utp-interface: {}", e.getMessage());
        }
        return Optional.empty();
    }

     */

    @Override
    public Optional<MessageResponse> sendMessageWhatsApp(MessageRequest messageRequest) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(whatsappToken);
            HttpEntity<MessageRequest> requestEntity = new HttpEntity<>(messageRequest, headers);
            MessageResponse responseEntity = restTemplate.exchange(
                    urlUtp,
                    HttpMethod.POST,
                    requestEntity,
                    MessageResponse.class).getBody();
            assert responseEntity != null;
            return Optional.of(responseEntity);
        } catch (Exception e) {
            log.error("Error while getting la consulta al api utp-interface: {}", e.getMessage());
        }
        return Optional.empty();
    }
}
