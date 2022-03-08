package ru.etysoft.cuteframework.methods.account;

import ru.etysoft.cuteframework.consts.APIMethods;
import ru.etysoft.cuteframework.exceptions.NotCachedException;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.methods.BlankResponse;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

import java.sql.SQLException;

public class ResendCodeRequest  extends RequestHolder {
    public ResendCodeRequest() {
        super(APIMethods.Account.RESEND_CODE);
    }

    public BlankResponse execute() throws ResponseException, SQLException, NotCachedException {
        Request request = makeRequest();
        return new BlankResponse(request.executeAPIWithToken(), request.getFormattedURL());
    }


}