package com.example.local_llm_chat;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Theme(value = "local-llm-chat")
public class LocalLlmBootChatApplication implements AppShellConfigurator {

	public static void main(String[] args) {
		SpringApplication.run(LocalLlmBootChatApplication.class, args);
	}

}
