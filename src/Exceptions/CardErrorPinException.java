package Exceptions;

/**
 * Created by Gennady on 06.12.2016.
 */
public class CardErrorPinException extends Exception {
    public CardErrorPinException() {
        super("Неверный пин-код");
    }
}
