package ru.etysoft.cuteframework.models;

import org.json.JSONObject;
import ru.etysoft.cuteframework.consts.APIKeys;

public class TrackInfo extends Model {

    private String name, id, cover, artist, path;

    public TrackInfo(JSONObject jsonObject) {
        super(jsonObject);
        id = jsonObject.getString(APIKeys.Music.ID);
        name = jsonObject.getString(APIKeys.Music.NAME);
        cover = jsonObject.getString(APIKeys.Music.COVER);
        artist = jsonObject.getString(APIKeys.Music.ARTIST);

        if(jsonObject.has(APIKeys.Music.PATH)) path = jsonObject.getString(APIKeys.Music.PATH);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getCover() {
        return cover;
    }

    public String getArtist() {
        return artist;
    }

    public String getPath() {
        return path;
    }
}
