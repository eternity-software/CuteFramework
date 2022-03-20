package ru.etysoft.cuteframework.models;

import org.json.JSONObject;
import ru.etysoft.cuteframework.consts.APIKeys;

public class ChatMember extends Model
{

    public static final String TYPE_USER = "user";
    public static final String TYPE_MODERATOR = "moderator";
    public static final String TYPE_ADMIN = "admin";
    public static final String TYPE_OWNER = "owner";

    private String permissionsGroup, name, login, accountId;

    public ChatMember(JSONObject jsonObject) {
        super(jsonObject);
        permissionsGroup = jsonObject.getString(APIKeys.Account.PERMISSIONS_GROUP);
        name = jsonObject.getString(APIKeys.Account.NAME);
        login = jsonObject.getString(APIKeys.Account.LOGIN);
        accountId = jsonObject.getString(APIKeys.Account.ACCOUNT_ID);
    }

    public String getPermissionsGroup() {
        return permissionsGroup;
    }

    public void setPermissionsGroup(String permissionsGroup) {
        this.permissionsGroup = permissionsGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
