package Terminal;

import Database.Database;
import Exceptions.*;
import Model.Card;
import Model.Client;

import java.io.*;

/**
 * Created by Gennady on 06.12.2016.
 */
public class ImpTermnal implements Terminal {

    private Database base;
    private Card card;

    public ImpTermnal(Database base) {
        this.base=base;
    }

    public void login(Card card, String pinCode) throws CardErrorPinException, CardNotFoundException {
        for(Card c :base.getCards()) {
            if(c.getNumberCard().equals(card.getNumberCard())) {
                if(!c.getPinCode().equals(pinCode))
                    throw new CardErrorPinException();
                this.card=c;
            }
        }
        if(card==null)
            throw new CardNotFoundException();

    }

    @Override
    public void fillMoney(int money) throws MoneyIncorrectException {
        if(money%100==0 && money>0)
            card.setMoney(card.getMoney()+money);
        else
            throw new MoneyIncorrectException("Неверная сумма не может быть зачислена");
    }

    @Override
    public void takeMoney(int money) throws MoneyIncorrectException {
        if(money%100==0 && money>0)
            card.setMoney(card.getMoney()-money);
        else
            throw new MoneyIncorrectException("Неверная сумма не может быть выдана");

    }

    @Override
    public int getMoney() {
        return card.getMoney();
    }

    @Override
    public void createClient(String firstName, String lastName) throws ClientDuplicateException {
        for(Client cl:base.getClients()) {
            if(cl.getFirstName().equals(firstName) && cl.getLastName().equals(lastName))
                throw new ClientDuplicateException();
        }
        base.addClient(new Client(firstName,lastName));
    }

    @Override
    public void createCard(Client client,String number,String pincode,int money) throws CardDuplicateException {
        for(Client cl:base.getClients()) {
            if(cl.getFirstName().equals(client.getFirstName()) && cl.getLastName().equals(client.getLastName())) {
                for(Card cr:base.getCards()) {
                    if(cr.getNumberCard().equals(number)) {
                        throw new CardDuplicateException();
                    }
                }
                base.addCard(new Card(cl,number,pincode,money));
                return;
            }
        }

    }

    @Override
    public void removeCard(String numberCard) throws CardNotFoundException {
        for (Card cr:base.getCards()) {
            if(cr.getNumberCard().equals(numberCard)) {
                base.removeCard(cr);
                return;
            }
        }
        throw new CardNotFoundException();
    }


    @Override
    public void removeClient(String firstName,String lastName) {
        for(Client cl:base.getClients()) {
            if(cl.getFirstName().equals(firstName) && (cl.getLastName().equals(lastName))) {
                for(Card cr:base.getCards()) {
                    if(card.getClient().getFirstName().equals(firstName) && card.getClient().getLastName().equals(lastName)) {
                        base.removeCard(cr);
                    }
                }
            }
        }
    }

    public static void  outputCardInfo(Card card, OutputStream out) throws IOException {
        DataOutputStream str = new DataOutputStream(out);
        str.writeUTF(card.getClient().getFirstName());
        str.writeUTF(card.getClient().getLastName());
        str.writeUTF(card.getNumberCard());
        str.writeUTF(card.getPinCode());
        str.writeInt(card.getMoney());
    }

    public static Card inputCardInfo(InputStream in) throws IOException {
        DataInputStream str = new DataInputStream(in);
        return new Card(new Client(str.readUTF(),str.readUTF()),str.readUTF(),str.readUTF(),str.readInt());
    }

    public static void writeCardInfo(Card card,Writer out) {
        PrintWriter str = new PrintWriter(out);
        str.println(card.getClient().getFirstName());
        str.println(card.getClient().getLastName());
        str.println(card.getNumberCard());
        str.println(card.getPinCode());
        str.println(card.getMoney());
        str.flush();
    }


    public static Card readCardInfo(Reader in) throws IOException {
        StreamTokenizer str = new StreamTokenizer(in);
        str.resetSyntax();
        str.wordChars(0x23, 0xFF);
        str.whitespaceChars(0x00, 0x20);
        str.nextToken();
        String fname = str.sval;
        str.nextToken();
        String lname=str.sval;
        str.nextToken();
        String number= str.sval;
        str.nextToken();
        String pin = str.sval;
        str.nextToken();
        int money = Integer.parseInt(str.sval);
        return new Card(new Client(fname,lname),number,pin,money);
    }

}
