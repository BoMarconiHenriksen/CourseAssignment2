package ExceptionHandling;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 *
 * @author Ejer
 */
public class ErrorMessage {

    public int code;
    private String message;
    private String description;
    private String stackTrace;

    public ErrorMessage() {
    }

    public ErrorMessage(Throwable ex, int code, boolean debug) {
        this.code = code;
        this.message = ex.getMessage();
        this.description = "";
        if (debug) {
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            this.stackTrace = sw.toString();
        }
     
    }

    public String getDescription() {
        return description;
    }

    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }
}
