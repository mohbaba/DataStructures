package Account.Exceptions;

public class InvalidAmountException extends RuntimeException  {
    public InvalidAmountException(String statement){
        super(statement);
    }
}
