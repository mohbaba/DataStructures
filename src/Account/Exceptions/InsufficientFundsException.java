package Account.Exceptions;

public class InsufficientFundsException extends RuntimeException{
    public InsufficientFundsException(String statement){
        super(statement);
    }
}
