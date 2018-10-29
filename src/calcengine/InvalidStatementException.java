/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcengine;

/**
 *
 * @author Jabneel
 */
public class InvalidStatementException extends Exception {
    public InvalidStatementException(String reason, String statement){
        super(reason + ": " + statement);
    }
    
    public InvalidStatementException(String reason, String statement, Throwable cause){
        super(reason + ": " + statement, cause);
    }
    
}
