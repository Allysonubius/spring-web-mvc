package spring.web.Service;

import org.springframework.stereotype.Service;
import spring.web.Client.JavaHttpClient;
import spring.web.Client.Telegram.ResultBotTelegramList;
import spring.web.Dto.MessageSend;
import spring.web.Dto.ResultBotTelegram;

@Service
public class Telegram {
    private RestTemplateClient restTemplateClient;
    private FeingClient feingClient;
    private JavaHttpClient javaHttpClient;

    public Telegram (RestTemplateClient restTemplateClient,FeingClient feingClient,JavaHttpClient javaHttpClient){
        this.restTemplateClient = restTemplateClient;
        this.feingClient = feingClient;
        this.javaHttpClient = javaHttpClient;
    }

    public void enviarMensagem(MessageSend messagem){
        //FeingClient
        ResultBotTelegram resulBotTelegramResponseEntity = javaHttpClient.enviarMensagem (mensagem);
        ResultBotTelegram resultBotTelegram = feingClient.enviarMensagem1(mensagem);
    }
    public ResultBotTelegramList buscarAtualização(){
        //FeingClient
        ResultBotTelegramList resultBotTelegramList = javaHttpClient.buscarAtualização ();
        return resultBotTelegramList;
    }
}
