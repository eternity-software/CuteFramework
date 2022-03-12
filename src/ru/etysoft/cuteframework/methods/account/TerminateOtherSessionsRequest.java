package ru.etysoft.cuteframework.methods.account;

import org.json.JSONException;
import ru.etysoft.cuteframework.consts.APIKeys;
import ru.etysoft.cuteframework.consts.APIMethods;
import ru.etysoft.cuteframework.exceptions.NoSuchValueException;
import ru.etysoft.cuteframework.exceptions.NotCachedException;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.methods.BlankResponse;
import ru.etysoft.cuteframework.models.Account;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;
import ru.etysoft.cuteframework.responses.Response;

import java.sql.SQLException;

public class TerminateOtherSessionsRequest extends RequestHolder
{
    public TerminateOtherSessionsRequest() {
        super(APIMethods.Account.TERMINATE_OTHER_SESSIONS);
    }

    public BlankResponse execute() throws ResponseException, SQLException, NotCachedException {
        Request request = makeRequest();
        return new BlankResponse(request.executeAPIWithToken(), request.getFormattedURL());
    }



}
