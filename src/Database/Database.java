package Database;


import Model.Card;
import Model.Client;

import java.util.ArrayList;

/**
 * Created by Gennady on 06.12.2016.
 */
public class Database {
    ArrayList<Card> cards;
    ArrayList<Client> clients;

    public Database() {
        cards = new ArrayList<>();
        clients = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void removeClient(Client client) {
        clients.remove(client);
    }

    public void removeCard(Card card) {
        cards.remove(card);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }
}
