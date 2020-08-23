import java.io.BufferedWriter;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bank {
    public String title;
    private boolean change = false;
    private Pattern pat_ID = Pattern.compile("[0-9]{6}");
    private Pattern pat_Balance = Pattern.compile("\\s[0-9.]{1,}");
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

    public void replenish (long ID) throws IOException {
        change =  true;
        Scanner scan_balance = new Scanner(System.in);
        System.out.println("Введите сумму пополнения");
        double sum = scan_balance.nextDouble();
        Matcher mat;
        BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8);
        Scanner scan_file = new Scanner(br);
        double Balance = 0;
        while(scan_file.hasNext()) {
            String A = scan_file.nextLine();
            mat = pat_ID.matcher(A); //разбери
            long ID_ = 0;
            while (mat.find()) {
                ID_ = Long.parseLong(mat.group()); // переведем из строки в число
            }
            mat = pat_Balance.matcher(A);
            while (mat.find()) {
                Balance = Double.parseDouble(mat.group()); // переведем из строки в число
            }
            if(ID_ == ID) {
                Balance = Balance + sum;
                break;
            }
        }
        br.close();
        BufferedWriter bw_file = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
        for(int i = 0 ; i < cl.size() ; i++) {
            int j = i + 1 ;
            if(ID == cl.get(i).getId()) {
                cl.get(i).setBalance(Balance);
                bw_file.write(j + ". " + cl.get(i).getId() + " " + cl.get(i).getName() + " " +
                        cl.get(i).getSurname() + " " + cl.get(i).getAdsence() + " " + Balance);
                bw_file.write('\n');
                continue;
            }
            bw_file.write(j + ". " + cl.get(i).getId() + " " + cl.get(i).getName() + " " +
                    cl.get(i).getSurname() + " " + cl.get(i).getAdsence() + " " +cl.get(i).getBalance());
            bw_file.write('\n');

        }
        bw_file.close();
    }
    public void consumption (long ID) throws IOException {
        change = true;
        Scanner scan_balance = new Scanner(System.in);
        System.out.println("Введите сумму снятия");
        double sum = scan_balance.nextDouble();
        Matcher mat;
        BufferedReader br_ = Files.newBufferedReader(path, StandardCharsets.UTF_8);
        Scanner scan_file = new Scanner(br_);
        double Balance = 0;
        while(scan_file.hasNext()) {
            String A = scan_file.nextLine();
            mat = pat_ID.matcher(A); //разбери
            long ID_ = 0;
            while (mat.find()) {
                ID_ = Long.parseLong(mat.group()); // переведем из строки в число
            }
            mat = pat_Balance.matcher(A);
            while (mat.find()) {
                Balance = Double.parseDouble(mat.group()); // переведем из строки в число
            }
            if(ID_ == ID) {
                Balance = Balance - sum;
                break;
            }
        }
        br_.close();
        BufferedWriter bw_file_ = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
        for(int i = 0 ; i < cl.size() ; i++) {
            int j = i + 1 ;
            if(ID == cl.get(i).getId()) {
                cl.get(i).setBalance(Balance);
                bw_file_.write(j + ". " + cl.get(i).getId() + " " + cl.get(i).getName() + " " +
                        cl.get(i).getSurname() + " " + cl.get(i).getAdsence() + " " + Balance);
                bw_file_.write('\n');
                continue;
            }
            bw_file_.write(j + ". " + cl.get(i).getId() + " " + cl.get(i).getName() + " " +
                    cl.get(i).getSurname() + " " + cl.get(i).getAdsence() + " " +cl.get(i).getBalance());
            bw_file_.write('\n');

        }
        bw_file_.close();
    }
    public void request_balance (long ID) throws IOException {
        Matcher mat;
        BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8);
        Scanner scan_file = new Scanner(br);
        while(scan_file.hasNext()) {
            String A = scan_file.nextLine();
            mat = pat_ID.matcher(A); //разбери
            long ID_ = 0;
            while (mat.find()) {
                ID_ = Long.parseLong(mat.group()); // переведем из строки в число
            }
            mat = pat_Balance.matcher(A);
            double Balance = 0;
            while (mat.find()) {
                Balance = Double.parseDouble(mat.group()); // переведем из строки в число
            }
            if(ID_ == ID) {
                System.out.println(Balance);
            }
        }
        br.close();
    }
    public void update (long ID) throws IOException {
        if (change) {
            System.out.println("Ваш баланс изменился и сейчас составляет ");
            request_balance(ID);
        } else {
            System.out.println("изменений нет");
        }
    }
}
