package Terminal;

import Exceptions.*;
import Model.Card;
import Model.Client;

/**
 * Created by Gennady on 06.12.2016.
 */
public interface Terminal {
    void fillMoney(int money) throws MoneyIncorrectException;
    void takeMoney(int money) throws MoneyIncorrectException;
    int getMoney();
    void createClient(String firstName, String lastName) throws ClientDuplicateException;
    void createCard(Client client, String numberCard, String pinCode,int money) throws CardDuplicateException;
    void removeCard(String numberCard) throws CardNotFoundException;
    void removeClient(String firstName, String lastName);
    void login(Card card,String pinCode) throws CardErrorPinException, CardNotFoundException;

}
