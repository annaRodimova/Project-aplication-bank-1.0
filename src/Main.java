import java.io.IOException;

public class Main {
    public static void main(String Args[]) throws IOException {
        Bank sberbank = new Bank("Сбербанк");
        Client client_number1 = new Client("Сергей", "Сергеев", "Сергеевич",
                111111, 500, "qwerty123" );

        Client client_number2 = new Client("Анна","Родимова", "Ивановна",
                222222, 10500, "cdj,jlf2020!");
        sberbank.add_client(client_number1);
        sberbank.add_client(client_number2);
        sberbank.request_balance(client_number1.getId());
        sberbank.replenish(client_number1.getId());
        sberbank.update(client_number1.getId());
        sberbank.consumption(client_number2.getId());
        sberbank.update(client_number2.getId());



    }

}
