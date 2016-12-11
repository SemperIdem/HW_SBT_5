package View;

import Terminal.ImpTermnal;
import Terminal.Terminal;
import Database.Database;
import Exceptions.CardErrorPinException;
import Exceptions.CardNotFoundException;
import Exceptions.MoneyIncorrectException;
import Model.Card;
import Model.Client;

import java.io.*;

import static Terminal.ImpTermnal.*;

/**
 * Created by Gennady on 10.12.2016.
 */
public class Task1 {
    public static void main(String args[]) throws IOException, ClassNotFoundException, CardErrorPinException, CardNotFoundException, MoneyIncorrectException {
        Database base = new Database();
        Terminal terminal = new ImpTermnal(base);
        Client client = new Client("Vasya","Pupkin");
        Card test1 = new Card(client,"123456789999","1122",20);

     /*   base.addCard(test1);
        terminal.login(test1,"1122");
        terminal.fillMoney(100);
        System.out.println(terminal.getMoney());*/



        //байтовый поток
        outputCardInfo(test1,new FileOutputStream("out.bin"));
        Card test2 = inputCardInfo(new FileInputStream("out.bin"));


        //символьный поток
        writeCardInfo(test1,new FileWriter("out.txt"));
        Card test3 =readCardInfo(new FileReader("out.txt"));



        //сериализация и десериализация
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("out2.bin"));
        out.writeObject(test1);
        out.close();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("out2.bin"));
        Card test4 = (Card) in.readObject();
        System.out.println();


    }
}
