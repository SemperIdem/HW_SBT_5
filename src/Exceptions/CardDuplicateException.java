package Exceptions;

/**
 * Created by Gennady on 09.12.2016.
 */
public class CardDuplicateException extends Exception {
    public CardDuplicateException() {
        super("Карта с заданным номером уже существует");
    }
}
