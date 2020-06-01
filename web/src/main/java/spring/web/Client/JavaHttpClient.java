package spring.web.Client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import spring.web.Client.Telegram.ResultBotTelegramList;
import spring.web.Dto.ResultBotTelegram;

import java.io.IOException;

@Component
public class JavaHttpClient {
    @Value("$(telegram.api)")
    private String BASE_PATH;
    @Value("$(telegram.token)")
    private String TOKEN;

    private HttpClient httpClient;
    private ObjectMapper objectMapper;

    public JavaHttpClient(ObjectMapper objectMapper) {
        this.httpClient = HttpClient.newHttpClient ();
        this.objectMapper = objectMapper;
    }

    public ResultBotTelegramList buscarAtualização() {
        ResultBotTelegramList resultBotTelegramList = null;
        HttpRequest request = HttpRequest.newBuilder ()
                .uri (URI.create (BASE_PATH + TOKEN + "/getUpdates"))
                .GET ()
                .build ();

        HttpResponse<String> stringHttpResponse = sendRequest (request);

        try {
            resultBotTelegramList = objectMapper.readValue (stringHttpResponse.body () , ResultBotTelegramList.class);
        } catch (IOException e) {
            e.printStackTrace ();
        }
        return resultBotTelegramList;
    }

    public ResultBotTelegram enviarMensagem(MessageSend mag){
        ResultBotTelegram resultBotTelegram = null;
        String mensagem = null;
        try {
            mensagem = objectMapper.writeValueAsString(msg);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }

        httpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_PATH +TOKEN + "/sendMessage"))
                .header("Content-Type","application/json")
                .POST(HttpRequest.BodyPublishers.ofString(mensagem))
                .build();

        HttpsResponse<String> stringHttpsResponse = sendRequest (request);

        try{
            resultBotTelegram = objectMapper.readValue(sringHttpResponse.body(),ResultBotTelegram.class);
        }catch(IOException e){
            e.printStackTrace ();
        }
        return resultBotTelegram;
    }
    private HttpResponse<String>sendRequest(HttpsRequest request){
        HttpsReponse<String> httpsReponse = null;
        try{
            httpsReponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        }catch (IOException | InterruptedException e){
            e.printStackTrace ();
        }
        return httpsReponse;
    }
}
