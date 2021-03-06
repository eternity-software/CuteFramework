package ru.etysoft.cuteframework.models;

import org.json.JSONObject;
import ru.etysoft.cuteframework.consts.APIKeys;
import ru.etysoft.cuteframework.exceptions.NoSuchValueException;

public class Account extends Model {

    private final String name;
    private String login;
    private String email;
    private String status;
    private String id;
    private String bio;
    private boolean isConfirmed;
    private final boolean isBlocked;

    public Account(JSONObject jsonObject) {
        super(jsonObject);

        name = jsonObject.getString(APIKeys.Account.NAME);
        if(jsonObject.has(APIKeys.Account.LOGIN)) {
            // TODO: Remove this block
            login = jsonObject.getString(APIKeys.Account.LOGIN);
        }
        if(jsonObject.has(APIKeys.Account.EMAIL))
        {
            email = jsonObject.getString(APIKeys.Account.EMAIL);
        }
        isBlocked = jsonObject.getBoolean(APIKeys.Account.IS_BLOCKED);
        id = jsonObject.getString(APIKeys.Account.ID);

        if(jsonObject.has(APIKeys.Account.IS_CONFIRMED))
        {
            isConfirmed = jsonObject.getBoolean(APIKeys.Account.IS_CONFIRMED);
        }
        else
        {
            isConfirmed = true;
        }


        if(jsonObject.has(APIKeys.Account.ADDITIONAL_INFO))
        {
            status = jsonObject.getJSONObject(APIKeys.Account.ADDITIONAL_INFO).getString(APIKeys.Account.STATUS);
            bio = jsonObject.getJSONObject(APIKeys.Account.ADDITIONAL_INFO).getString(APIKeys.Account.BIO);
        }
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }


    public boolean isConfirmed() {
        return isConfirmed;
    }


    public String getId() {
        return id;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    /**
     * Additional information
     */
    public String getEmail() throws NoSuchValueException {
        if(email == null) throw new NoSuchValueException();
        return email;
    }

    public String getStatus() throws NoSuchValueException {
        if(status == null) throw new NoSuchValueException();
        return status;
    }

    public String getBio() throws NoSuchValueException {
        if(bio == null) throw new NoSuchValueException();
        return bio;
    }

}
