package com.example.local_llm_chat.controllers;

import com.example.local_llm_chat.services.ChatService;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import dev.hilla.BrowserCallable;
import dev.hilla.Endpoint;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.io.IOException;

@RestController
@RequestMapping("ai")
@RequiredArgsConstructor
@Endpoint
@AnonymousAllowed
@BrowserCallable
public class ChatController {

    private final ChatService chatService;

    @GetMapping("/chat")
    public String chat(@RequestParam String prompt) {

        return chatService.chat(prompt);
    }

    @GetMapping(value = "/stream-chat", produces = "text/event-stream")
    public Flux<String> streamChat(@RequestParam String prompt) {

        return chatService.streamChat(prompt);
    }

    @GetMapping(value = "/stream-assistant", produces = "text/event-stream")
    public Flux<String> streamAssistant(@RequestParam String prompt) {

        return chatService.streamAssistant(prompt);
    }

    @GetMapping(value = "/stream-greedy-driver", produces = "text/event-stream")
    public Flux<String> greedyDriverChat(@RequestParam String prompt) {

        return chatService.greedyDriverChat(prompt);
    }

    @GetMapping("/get-image")
    public void generateImage(HttpServletResponse httpServletResponse,
                              @RequestParam("prompt") String prompt) throws IOException {

        var response = chatService.generateImage(prompt);
        httpServletResponse.sendRedirect(String.valueOf(response.content().url()));

    }
}
