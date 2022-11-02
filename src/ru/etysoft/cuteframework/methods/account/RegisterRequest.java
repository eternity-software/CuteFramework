package ru.etysoft.cuteframework.methods.account;

import ru.etysoft.cuteframework.consts.APIKeys;
import ru.etysoft.cuteframework.consts.APIMethods;
import ru.etysoft.cuteframework.exceptions.NotCachedException;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.models.Device;
import ru.etysoft.cuteframework.requests.POST;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.RequestHolder;

import java.sql.SQLException;

public class RegisterRequest extends RequestHolder {
    public RegisterRequest(String login, String password, String email, Device device) throws SQLException, NotCachedException {
        super(APIMethods.Authorization.SIGN_UP);
        addBody(Pair.make(APIKeys.Account.LOGIN, login),
                Pair.make(APIKeys.Account.EMAIL, email),
                Pair.make(APIKeys.Token.DEVICE, device.getJsonModel()),
                Pair.make(APIKeys.Account.PASSWORD, password));

    }

    public SignInRequest.Response execute() throws ResponseException {

        return new SignInRequest.Response(POST.execute(this), getUrl());
    }
}
