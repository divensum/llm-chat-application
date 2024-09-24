package com.example.local_llm_chat.services;

import com.example.local_llm_chat.assistants.DefaultAssistant;
import com.example.local_llm_chat.assistants.GreedyDriverAssistant;
import dev.langchain4j.data.image.Image;
import dev.langchain4j.model.StreamingResponseHandler;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.chat.StreamingChatLanguageModel;
import dev.langchain4j.model.image.ImageModel;
import dev.langchain4j.model.output.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatLanguageModel chatLanguageModel;
    private final StreamingChatLanguageModel streamingChatLanguageModel;
    private final DefaultAssistant defaultAssistant;
    private final GreedyDriverAssistant greedyDriverAssistant;
    private final ImageModel imageModel;


    public Response<Image> generateImage(String prompt) {
        return imageModel.generate(prompt);
    }

    public String chat(String prompt) {
        return chatLanguageModel.generate(prompt);
    }

    public Flux<String> streamChat(String prompt) {
        Sinks.Many<String> sink = Sinks.many().unicast().onBackpressureBuffer();

        streamingChatLanguageModel.generate(prompt, new StreamingResponseHandler<>() {
            @Override
            public void onNext(String token) {
                sink.tryEmitNext(token);
            }

            @Override
            public void onError(Throwable error) {
                sink.tryEmitError(error);
            }

        });
        return sink.asFlux();
    }

    public Flux<String> streamAssistant(String prompt) {
        Sinks.Many<String> sink = Sinks.many().unicast().onBackpressureBuffer();

        defaultAssistant.steamChat(prompt)
                .onNext(sink::tryEmitNext)
                .onComplete(c -> sink.tryEmitComplete())
                .onError(sink::tryEmitError)
                .start();

        return sink.asFlux();
    }

    public Flux<String> greedyDriverChat(String prompt) {
        Sinks.Many<String> sink = Sinks.many().unicast().onBackpressureBuffer();

        greedyDriverAssistant.steamChat(prompt)
                .onNext(sink::tryEmitNext)
                .onComplete(c -> sink.tryEmitComplete())
                .onError(sink::tryEmitError)
                .start();

        return sink.asFlux();
    }

}
