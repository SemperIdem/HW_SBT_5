package Exceptions;

/**
 * Created by Gennady on 09.12.2016.
 */
public class ClientNotFoundException extends Exception {
    public ClientNotFoundException() {
        super("Клиент не найден в базе данных");
    }

}