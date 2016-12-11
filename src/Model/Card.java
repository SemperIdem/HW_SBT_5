package Model;

import java.io.Serializable;

/**
 * Created by Gennady on 05.12.2016.
 */
public class Card implements Serializable {
    private int money;
    private String pinCode;
    private String numberCard;
    private Client client;


    public Card(Client client, String numberCard,String pinCode,int money) {
        this.numberCard=numberCard;
        this.pinCode=pinCode;
        this.client=client;
        this.money=money;
    }


    public String getPinCode() {
        return pinCode;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money=money;
    }

    public String getNumberCard() {
        return numberCard;
    }

    public Client getClient() {
        return client;
    }




}
