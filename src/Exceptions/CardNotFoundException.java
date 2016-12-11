package Exceptions;

/**
 * Created by Gennady on 06.12.2016.
 */
public class CardNotFoundException extends Exception {
    public CardNotFoundException() {
        super("Карта не действительна");
    }
}
