package com.digital.service;

import com.digital.dto.ChatRequest;
import com.digital.dto.ChatResponse;

public interface ChatService {
    ChatResponse getAnswer(ChatRequest request);
}

