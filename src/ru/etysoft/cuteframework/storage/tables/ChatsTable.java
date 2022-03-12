package ru.etysoft.cuteframework.storage.tables;

import ru.etysoft.cuteframework.Logger;
import ru.etysoft.cuteframework.models.Chat;
import ru.etysoft.cuteframework.storage.Cache;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class ChatsTable extends Table{

    public final static String CHATS_TABLE_NAME = "chats";


    public ChatsTable() throws SQLException {
        super(CHATS_TABLE_NAME);
        initialize();
    }

    private static void initialize() throws SQLException {
        String request = "CREATE TABLE if not exists '" + CHATS_TABLE_NAME + "' ('id' text, 'name' text, 'isBlocked' bool, 'type' text);";


        Cache.getStatement().execute(request);

    }

    public HashMap<String, Chat> getAllChats() throws SQLException {
        ResultSet resultSet = getAllRows();
        int i = 0;

        HashMap<String, Chat> chats = new HashMap<>();
        while (resultSet.next())
        {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String type = resultSet.getString("type");
            boolean isBlocked = resultSet.getBoolean("isBlocked");
            Chat chat = new Chat();
            chat.setId(id);
            chat.setName(name);
            chat.setType(type);
            chat.setBlocked(isBlocked);
            chats.put(id, chat);

            i++;
        }
        return chats;
    }

    public void clean() throws SQLException {
        Cache.getStatement().execute("DROP TABLE " + ChatsTable.CHATS_TABLE_NAME);
        initialize();
    }

    public void addChat(Chat chat) throws SQLException {
        String request = "INSERT INTO '"+ CHATS_TABLE_NAME +"' VALUES ('"+ chat.getId() + "', '" +
                chat.getName() + "', " + chat.isBlocked() + ", '" + chat.getType() + "'); ";
        Cache.getStatement().execute(request);
    }
}
