package lesson9.exceptions;

public class MyArrayDataException extends RuntimeException{

    public MyArrayDataException() {
        super();
    }

    public MyArrayDataException(String message) {
        super(message);
    }

}
