package ru.etysoft.cuteframework.storage.tables;

import ru.etysoft.cuteframework.models.Chat;
import ru.etysoft.cuteframework.models.ChatSnippet;
import ru.etysoft.cuteframework.storage.Cache;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class ChatSnippetsTable extends Table {

    public final static String CHATS_TABLE_NAME = "chatSnippets";


    public ChatSnippetsTable() throws SQLException {
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
        while (resultSet.next()) {
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
        Cache.getStatement().execute("DROP TABLE " + ChatSnippetsTable.CHATS_TABLE_NAME);
        initialize();
    }

    public ChatSnippet getChatSnippet(String id) {
        try {
            String request = "SELECT * FROM " + CHATS_TABLE_NAME + " WHERE id = '" + id + "';";
            ResultSet resultSet = Cache.getStatement().executeQuery(request);
            if(!resultSet.isClosed()) {
                id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");
                boolean isBlocked = resultSet.getBoolean("isBlocked");

                ChatSnippet chat = new ChatSnippet(type, name, id, isBlocked);
                return chat;
            }
            else
            {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


    public void deleteChatSnippet(String id) {
        try {
            String request = "DELETE FROM " + CHATS_TABLE_NAME + " WHERE id = '" + id + "';";
            Cache.getStatement().execute(request);


        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void addChat(ChatSnippet chat) throws SQLException {
        if (getChatSnippet(chat.getId()) != null) deleteChatSnippet(chat.getId());
        String request = "INSERT INTO '" + CHATS_TABLE_NAME + "' VALUES ('" + chat.getId() + "', '" +
                chat.getName() + "', " + chat.isBlocked() + ", '" + chat.getType() + "'); ";
        Cache.getStatement().execute(request);
    }
}
