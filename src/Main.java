import java.io.IOException;

public class Main {
    public static void main(String Args[]) throws IOException {
        Bank sberbank = new Bank("Сбербанк");
        Client client_number1 = new Client("Сергей", "Сергеев", "Сергеевич",
                1111, 500, "qwerty123" );

        Client client_number2 = new Client("Анна","Родимова", "Ивановна",
                010101, 10500, "cdj,jlf2020!");
        sberbank.add_client(client_number1);
        sberbank.add_client(client_number2);
        //client_number1.request_balance();
        //client_number1.replenish();
        //client_number1.request_balance();

    }

}
