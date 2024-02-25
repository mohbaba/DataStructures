package Account.Exceptions;

public class AccountNotFound extends NullPointerException{
    public AccountNotFound(String message){
        super(message);
    }
}
