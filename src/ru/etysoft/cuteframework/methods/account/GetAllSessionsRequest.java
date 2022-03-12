package ru.etysoft.cuteframework.methods.account;

import org.glassfish.grizzly.utils.ArraySet;
import org.json.JSONArray;
import org.json.JSONException;
import ru.etysoft.cuteframework.consts.APIKeys;
import ru.etysoft.cuteframework.consts.APIMethods;
import ru.etysoft.cuteframework.exceptions.NotCachedException;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.models.Session;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;
import ru.etysoft.cuteframework.responses.Response;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GetAllSessionsRequest extends RequestHolder {
    public GetAllSessionsRequest() {
        super(APIMethods.Account.GET_ALL_SESSIONS);
    }


    public GetAllSessionsResponse execute() throws ResponseException, SQLException, NotCachedException {
        Request request = makeRequest();
        return new GetAllSessionsResponse(request.executeAPIWithToken(), request.getFormattedURL());
    }

    public static class GetAllSessionsResponse extends Response {

        private List<Session> sessions = new ArrayList<Session>();

        public GetAllSessionsResponse(String jsonResponse, String url) throws JSONException {
            super(jsonResponse, url);
        }

        @Override
        public void onSuccess() {
            JSONArray jsonArray = getJsonResponse().getJSONArray(APIKeys.Response.DATA);

            for(int i = 0; i < jsonArray.length(); i++)
            {
                sessions.add(new Session(jsonArray.getJSONObject(i)));
            }
        }

        public List<Session> getSessions() {
            return sessions;
        }
    }
}


