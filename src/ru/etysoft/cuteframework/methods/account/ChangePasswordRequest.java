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

public class ChangePasswordRequest extends RequestHolder {
    public ChangePasswordRequest(String newPassword, String oldPassword) {
        super(APIMethods.Account.CHANGE_PASSWORD);
        setParams(Pair.make(APIKeys.Account.OLD_PASSWORD, oldPassword),
                Pair.make(APIKeys.Account.NEW_PASSWORD, newPassword));
    }

    public BlankResponse execute() throws ResponseException, SQLException, NotCachedException {
        Request request = makeRequest();
        return new BlankResponse(request.executeAPIWithToken(), request.getFormattedURL());
    }


}
