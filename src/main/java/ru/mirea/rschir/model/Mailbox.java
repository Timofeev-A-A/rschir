package ru.mirea.rschir.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Document(collection = "mailbox")
public class Mailbox {
    @Id
    private String id;

    private String sender;
    private String receiver;
    private String theme;
    private String content;
    private Date date;

    public Mailbox() {}

    public Mailbox(String sender, String receiver, String theme, String content) {
        this.sender = sender;
        this.receiver = receiver;
        this.theme = theme;
        this.content = content;
        this.date = new Date();
    }

    public String getSender() { return sender; }

    public void setSender(String sender) { this.sender = sender; }

    public String getReceiver() { return receiver; }

    public void setReceiver(String receiver) { this.receiver = receiver; }

    public String getTheme() { return theme; }

    public void setTheme(String theme) { this.theme = theme; }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public String getId() { return id; }
}
