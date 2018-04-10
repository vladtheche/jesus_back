package main;

public class WrongSpeedException extends RuntimeException {
    public WrongSpeedException(){
        super("Speed can't be less than 0");
    }
}
