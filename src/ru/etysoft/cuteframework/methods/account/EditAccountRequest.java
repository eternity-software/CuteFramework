package ru.etysoft.cuteframework.methods.account;

import ru.etysoft.cuteframework.consts.APIKeys;
import ru.etysoft.cuteframework.consts.APIMethods;
import ru.etysoft.cuteframework.exceptions.NotCachedException;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.methods.BlankResponse;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

import java.sql.SQLException;

public class EditAccountRequest extends RequestHolder {


    public EditAccountRequest() {
        super(APIMethods.Account.EDIT);
    }

    public void addName(String name)
    {
        getParams().add(Pair.make(APIKeys.Account.NAME, name));
    }

    public void addStatus(String status)
    {
        getParams().add(Pair.make(APIKeys.Account.STATUS, status));
    }

    public void addBio(String bio)
    {
        getParams().add(Pair.make(APIKeys.Account.BIO, bio));
    }


    public BlankResponse execute() throws ResponseException, SQLException, NotCachedException {
        Request request = makeRequest();
        return new BlankResponse(request.executeAPIWithToken(), request.getFormattedURL());
    }
}
