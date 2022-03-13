package ru.etysoft.cuteframework.methods.account;

import ru.etysoft.cuteframework.consts.APIKeys;
import ru.etysoft.cuteframework.consts.APIMethods;
import ru.etysoft.cuteframework.exceptions.NotCachedException;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.methods.BlankResponse;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.SQLException;

public class EditAccountRequest extends RequestHolder {


    public EditAccountRequest() {
        super(APIMethods.Account.EDIT);
        setParams();
    }

    public void addName(String name) throws UnsupportedEncodingException {
        getParams().add(Pair.make(APIKeys.Account.NAME, URLEncoder.encode(name, "UTF-8")));
    }

    public void addStatus(String status) throws UnsupportedEncodingException {
        getParams().add(Pair.make(APIKeys.Account.STATUS, URLEncoder.encode(status, "UTF-8")));
    }

    public void addBio(String bio) throws UnsupportedEncodingException {
        getParams().add(Pair.make(APIKeys.Account.BIO, URLEncoder.encode(bio, "UTF-8")));
    }

    public BlankResponse execute() throws ResponseException, SQLException, NotCachedException {
        Request request = makeRequest();
        return new BlankResponse(request.executeAPIWithToken(), request.getFormattedURL());
    }
}
