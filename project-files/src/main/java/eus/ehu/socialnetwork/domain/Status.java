package eus.ehu.socialnetwork.domain;

import java.util.List;

public class Status {
    String id;
    String created_at;
    String url;

    String content;
    boolean reblogged;
    Status reblog;
    Account account;
    List<Media_Attachments> media_attachments;

    public String toString(){
        return "Status{"+
                "id= '" + id + '\'' +
                ", created_at='" + created_at + '\'' +
                ", url='" + url + '\'' +
                ", avatar='"  +
                ", content='" + content + '\'' +
                ", reblog='" + reblog + '\'' +
                ", account='" + account +
                ", media_attachments='" + media_attachments +
                '}';
    }

    public String getId() {
        return id;
    }
    public String getCreated_at() {
        return created_at;
    }

    public String getContent() {
        return content;
    }

    public Status getReblog(){
        return reblog;
    }

    public Account getAccount() {
        return account;
    }

    public List<Media_Attachments> getMedia_attachment_list(){
        return media_attachments;
    }

    public String getUrl(){
        return url;
    }

    public class Account{
        String id;
        String username;
        String avatar;
        String acct;
        String display_name;
        boolean locked;
        boolean bot;
        boolean discoverable;


        @Override
        public String toString() {
            return "Account{" +
                    "id='" + id + '\'' +
                    ", username='" + username + '\'' +
                    ", avatar='" + avatar + '\'' +
                    ", display_name='" + display_name + '\'' +
                    '}';
        }

        public String getAvatar() {
            return avatar;
        }

        public String getId() {
            return id;
        }

        public String getUsername() {
            return username;
        }

        public String getAcct() {
            return acct;
        }

        public String getDisplay_name() {
            return display_name;
        }

        public boolean isLocked() {
            return locked;
        }

        public boolean isBot() {
            return bot;
        }

        public boolean isDiscoverable() {
            return discoverable;
        }
    }

    public class Media_Attachments{

        String url;

        public String getUrl() {
            return url;
        }

        @Override
        public String toString() {
            return "Media_Attachments{" +
                    "url='" + url + '\'' +
                    '}';
        }
    }

}
