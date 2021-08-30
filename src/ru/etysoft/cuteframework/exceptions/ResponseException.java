package ru.etysoft.cuteframework.exceptions;

/**
 * Response exception, throws when data processing is unsuccessful
 */
public class ResponseException extends Exception {

    public ResponseException(String message)
    {
      super(message);
    }

}
