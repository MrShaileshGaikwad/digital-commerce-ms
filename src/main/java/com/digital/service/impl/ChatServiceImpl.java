package com.digital.service.impl;


import org.springframework.stereotype.Service;

import com.digital.dto.ChatRequest;
import com.digital.dto.ChatResponse;
import com.digital.service.ChatService;

@Service
public class ChatServiceImpl implements ChatService {

    @Override
    public ChatResponse getAnswer(ChatRequest request) {
        String q = request.getQuestion().toLowerCase();

        String ans;
        if (q.contains("status")) {
            ans = "You can check employee status using GET /api/employees/{id}.";
        } else if (q.contains("help")) {
            ans = "This is Digital Commerce Employee Service. You can manage employees and their departments.";
        } else {
            ans = "I'm a demo chatbot. In production, I would call a real AI service.";
        }

        return ChatResponse.builder()
                .answer(ans)
                .build();
    }
}
