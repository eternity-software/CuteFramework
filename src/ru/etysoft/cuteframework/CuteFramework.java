package ru.etysoft.cuteframework;


import ru.etysoft.cuteframework.methods.account.ChangeAvatar.ChangeAvatarRequest;
import ru.etysoft.cuteframework.methods.account.ChangeAvatar.ChangeAvatarResponse;
import ru.etysoft.cuteframework.methods.account.Confirmation.SendConfirmCodeRequest;
import ru.etysoft.cuteframework.methods.account.Confirmation.ConfirmCodeResponse;
import ru.etysoft.cuteframework.methods.account.Confirmation.ConfirmationRequest;
import ru.etysoft.cuteframework.methods.account.Confirmation.ConfirmationResponse;
import ru.etysoft.cuteframework.methods.account.Edit.EditRequest;
import ru.etysoft.cuteframework.methods.account.Edit.EditResponse;
import ru.etysoft.cuteframework.methods.account.Login.LoginRequest;
import ru.etysoft.cuteframework.methods.account.GetAccount.GetAccountRequest;
import ru.etysoft.cuteframework.methods.account.Registration.RegistrationRequest;
import ru.etysoft.cuteframework.methods.account.Login.LoginResponse;
import ru.etysoft.cuteframework.methods.account.GetAccount.GetAccountResponse;
import ru.etysoft.cuteframework.methods.account.Registration.RegistrationResponse;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.methods.chat.ChatList.ChatListRequest;
import ru.etysoft.cuteframework.methods.chat.ChatList.ChatListResponse;
import ru.etysoft.cuteframework.methods.chat.Creation.ChatCreateRequest;
import ru.etysoft.cuteframework.methods.chat.Creation.ChatCreateResponse;
import ru.etysoft.cuteframework.methods.media.UploadImageRequest;
import ru.etysoft.cuteframework.methods.media.UploadImageResponse;
import ru.etysoft.cuteframework.methods.chat.GetHistory.GetMessageListRequest;
import ru.etysoft.cuteframework.methods.chat.GetHistory.GetMessageListResponse;
import ru.etysoft.cuteframework.methods.user.Get.GetUserRequest;
import ru.etysoft.cuteframework.methods.user.Get.GetUserResponse;
import ru.etysoft.cuteframework.methods.user.Search.SearchUserRequest;
import ru.etysoft.cuteframework.methods.user.Search.SearchUserResponse;
import ru.etysoft.cuteframework.requests.attachements.ImageFile;

public class CuteFramework {

    public static String domain = "https://api.mcute.ru/";
    public static String mediaDomain = "https://api.mcute.ru";
    public static String mainDomain = "https://mcute.ru/";
    public static String longpollDomain = "ws://188.225.33.56:8181";
    public static String options = "&v=0.0.2";

    public static LoginResponse authorize(String login, String password) throws ResponseException {
        return (new LoginRequest(login, password)).execute();
    }

    public static RegistrationResponse register(String login, String email, String password, String display_name) throws ResponseException {
        return (new RegistrationRequest(login, email, password, display_name)).execute();
    }

    public static GetAccountResponse getInfo(String sessionKey) throws ResponseException {
        return (new GetAccountRequest(sessionKey).execute());
    }
    public static EditResponse editDisplayName(String token, String newName) throws ResponseException{
        return (new EditRequest(token,newName).execute());
    }
    public static ConfirmCodeResponse sendConfirmCode(String token) throws ResponseException{
        return (new SendConfirmCodeRequest(token).execute());
    }
    public static ConfirmationResponse confirmation(String token, int code) throws ResponseException{
        return (new ConfirmationRequest(token, code).execute());
    }
    public static ChatListResponse getChatList(String token) throws ResponseException{
        return (new ChatListRequest(token).execute());
    }
    public static GetMessageListResponse getMessageList(String token, String id) throws ResponseException{
        return (new GetMessageListRequest(token, id).execute());
    }
    public static ChatCreateResponse createChat(String token, String name, String description, String type) throws ResponseException{
        return (new ChatCreateRequest(token,name, description, type).execute());
    }
    public static GetUserResponse getUser(String token, String id) throws ResponseException{
        return (new GetUserRequest(token ,id).execute());
    }
    public static SearchUserResponse searchUser(String token, String name) throws ResponseException{
        return (new SearchUserRequest(token ,name).execute());
    }
    public static UploadImageResponse uploadImage(ImageFile object, String token) throws ResponseException{
        return (new UploadImageRequest(object, token).execute());
    }
    public static ChangeAvatarResponse changeAvatar(String token, String mediaId) throws ResponseException{
        return (new ChangeAvatarRequest(token, mediaId).execute());
    }





    public static void setApiVersion(String apiVersion) {

        options = "&v=" + apiVersion;
    }


}
