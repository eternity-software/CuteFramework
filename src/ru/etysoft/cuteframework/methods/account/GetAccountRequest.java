package ru.etysoft.cuteframework.methods.account;

import org.json.JSONException;
import ru.etysoft.cuteframework.consts.APIKeys;
import ru.etysoft.cuteframework.consts.APIMethods;
import ru.etysoft.cuteframework.exceptions.NoSuchValueException;
import ru.etysoft.cuteframework.exceptions.NotCachedException;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.methods.BlankResponse;
import ru.etysoft.cuteframework.models.Account;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;
import ru.etysoft.cuteframework.responses.Response;

import java.sql.SQLException;

public class GetAccountRequest extends RequestHolder {

    public GetAccountRequest(String id)
    {
        super(APIMethods.Account.GET);
        setParams(new Pair(APIKeys.Account.ID, id));
    }

    public GetAccountRequest()
    {
        super(APIMethods.Account.GET);
        setParams();
    }

    public GetAccountResponse execute() throws ResponseException, SQLException, NotCachedException {
        Request request = makeRequest();
        return new GetAccountResponse(request.executeAPIWithToken(), request.getFormattedURL());
    }


    public static class GetAccountResponse extends Response
    {

        private Account account;

        public GetAccountResponse(String jsonResponse, String url) throws JSONException {
            super(jsonResponse, url);
        }

        @Override
        public void onSuccess() {
            account = new Account(getJsonResponse().getJSONObject(APIKeys.Response.DATA).getJSONObject(APIKeys.Account.ACCOUNT));
        }

        public Account getAccount() throws NoSuchValueException {
            if(isSuccess())
            {
                return account;
            }
            else
            {
                throw new NoSuchValueException();
            }

        }
    }

}
