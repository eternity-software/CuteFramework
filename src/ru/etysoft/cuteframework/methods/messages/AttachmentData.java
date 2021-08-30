package ru.etysoft.cuteframework.methods.messages;

import org.json.JSONObject;
import ru.etysoft.cuteframework.data.APIKeys;

public class AttachmentData {

    private int height;
    private int width;

    public AttachmentData(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public static AttachmentData fromJSON(JSONObject attachmentData)
    {
        int height = attachmentData.getInt(APIKeys.Attachment.ATTACHMENT_HEIGHT);
        int width = attachmentData.getInt(APIKeys.Attachment.ATTACHMENT_WIDTH);
        return new AttachmentData(height, width);
    }
}
