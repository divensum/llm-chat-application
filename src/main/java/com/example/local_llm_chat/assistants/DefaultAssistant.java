package com.example.local_llm_chat.assistants;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.TokenStream;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface DefaultAssistant {

    @SystemMessage(fromResource = "prompts/assistant-system-prompt.txt")
    TokenStream steamChat(String message);
}
