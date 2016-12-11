package Exceptions;

/**
 * Created by Gennady on 06.12.2016.
 */
public class ClientDuplicateException extends Exception {
    public ClientDuplicateException() {
        super("Данный клиент уже существует");
    }
}
