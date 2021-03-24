package lesson9.exceptions;

public class MyArraySizeException extends RuntimeException{
    public MyArraySizeException() {
        super();
    }

    public MyArraySizeException(String message) {
        super(message);
    }
}
