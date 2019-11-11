import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.tools.json.JSONWriter;
import java.util.ArrayList;
import java.util.List;

public class Produtor {

    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try (
                Connection connection = connectionFactory.newConnection();
                Channel canal = connection.createChannel();
        ) {
            String NOME_FILA = "filaJson";

            List<Livro> livros = new ArrayList<>();
            for(int i=0; i<11; i++){
                Livro livro = new Livro("Livro"+i, "Letras");
                livros.add(livro);
            }

            JSONWriter jsonWriter = new JSONWriter();
            String mensagem = jsonWriter.write(livros);



            //(queue, passive, durable, exclusive, autoDelete, arguments)
            canal.queueDeclare(NOME_FILA, false, false, false, null);

            // ​(exchange, routingKey, mandatory, immediate, props, byte[] body)
            canal.basicPublish("", NOME_FILA, false, false, null, mensagem.getBytes());

        }
    }
}


