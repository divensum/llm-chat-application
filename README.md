# Simple AI Chat application (can communicate with remote and local LLM models)

## Technologies used
<div style="display: flex; justify-content: center; flex-wrap: wrap; gap: 30px;">
  <a href="https://www.java.com/" style="flex: 1 1 10%; text-align: center;">
    <img style="width: 50px;" title="Java" src="src/main/resources/media/java-original.svg" alt="Java">
  </a>
  <a href="https://docs.langchain4j.dev/" style="flex: 1 1 10%; text-align: center;">
    <img style="width: 45px;" title="Spring" src="src/main/resources/media/langChain4j.jpg" alt="LangChain4j">
  </a>
  <a href="https://maven.apache.org/" style="flex: 1 1 10%; text-align: center;">
    <img style="width: 50px;" title="Maven" src="src/main/resources/media/ApacheMaven.svg" alt="Maven">
  </a>
  <a href="https://vaadin.com/" style="flex: 1 1 10%; text-align: center;">
    <img style="width: 50px;" title="Maven" src="src/main/resources/media/vaadin.png" alt="Vaadin">
  </a>
 <a href="https://react.dev/" style="flex: 1 1 10%; text-align: center;">
    <img style="width: 50px;" title="Maven" src="src/main/resources/media/React.svg" alt="React">
  </a>
</div>

## Requirements

- Java 21
- OpenAI API key in `OPENAI_API_KEY` environment variable (for `remote` spring profile)

## Running the application

1. Run the app by running `LocalLlmBootChatApplication.java` in your IDE. We have 2 spring profiles for running:
- `--spring.profiles.active=remote` - for using remote LLM model.
- `--spring.profiles.active=local` - for using local LLM model.

For setup and running local LLM models we use [**Ollama project**](https://ollama.com/)

### Working spaces

screencast here

[**Chat**](http://localhost:8080/) - Simple LLM chat. When we use this view we need to spend some time waiting for the response to be generated, after which the response will be output immediately and completely.

[**Streaming Chat**](http://localhost:8080/stream-chat) - LLMs generate text one token at a time, so many LLM providers, including OpenAI, offer a way to stream the response token-by-token instead of waiting for the entire text to be generated. This significantly improves the user experience, as the user does not need to wait an unknown amount of time and can start reading the response almost immediately.

[**Assistant Chat**](http://localhost:8080/stream-assistant) - AI Assistant with memory for a more or less meaningful dialogue with LLM. For initialization used system prompt: `You are a knowledgeable and friendly AI assistant named Donald.
Your role is to help users by answering their questions, providing information,
and offering guidance to the best of your abilities.
When responding, use a warm and professional tone, and break down complex topics into easy-to-understand explanations.
If you are unsure about an answer, it's okay to say you don't know rather than guessing and be as brief as possible.`

[**Assistant Chat**](http://localhost:8080/stream-assistant) - AI Game, using assistant. Try to get a free ride from greedy taxi driver. For AI Assistant behavior modification used the system prompt: `You are an angry and greedy taxi driver, your name is Jackson.
You are always short of money, and you try your best to earn more.
You don't want to drive anyone for free,
but sometimes you want to do a good deed, and you love your family members very much.`

