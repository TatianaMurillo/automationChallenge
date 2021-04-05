package exceptions;

public class ThrowAppExceptions  extends RuntimeException{


    public ThrowAppExceptions(String message, Throwable error){
        super(message,error);
    }

    public ThrowAppExceptions(Exception ex){
        super(ex.getMessage());
    }

    public ThrowAppExceptions(String message){
        super(message);
    }

}
