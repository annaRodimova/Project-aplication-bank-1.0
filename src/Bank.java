import java.io.BufferedWriter;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.*;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Bank {
    public String title;
    ArrayList<Client> cl = new ArrayList<>();
    // private BufferedWriter bw = new BufferedWriter(new FileWriter("client_file.txt"));
    public static Path path = Paths.get("C:\\Users\\Anna\\IdeaProjects\\Bank\\client_file.txt");

    public void add_client (Client client_1) throws IOException {
       // BufferedWriter bw = new BufferedWriter(new FileWriter("client_file.txt"));
        BufferedWriter bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
        cl.add(client_1);
        for(int i = 0 ; i < cl.size() ; i++) {
            int j = i + 1 ;
            bw.write(j + ". " + cl.get(i).getId() + " " + cl.get(i).getName() + " " +
                    cl.get(i).getSurname() + " " + cl.get(i).getAdsence() + " " +cl.get(i).getBalance());
            bw.write('\n');
        }
            bw.close();
    }
    public Bank (String title) throws IOException {
    this.title = title;
    }

}
