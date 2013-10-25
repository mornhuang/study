package com.huang.j2ee.ch01.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Properties;

/**
 * User : Morn
 * Date : 2013-10-10 16:02
 */
public class ChatService {
    private static ChatService cs;
    private Properties userList;
    private LinkedList<String> chatMsg;
    private static final String USER_FILE = ChatService.class.getResource("/").getPath() + "userFile.properties";

    private ChatService() {

    }

    public static ChatService instance(){
        if (cs == null) {
            cs = new ChatService();
        }
        return cs;
    }

    private Properties loadUser() throws IOException {
        if (userList == null) {
            File f = new File(USER_FILE);
            if (!f.exists()) {
                f.createNewFile();
            }
            userList = new Properties();
            userList.load(new FileInputStream(f));
        }
        return userList;
    }

    private boolean saveUserList() throws IOException {
        if (userList == null) {
            return false;
        }
        userList.store(new FileOutputStream(USER_FILE), "User Info List");
        return true;
    }

    public boolean validLogin(String user, String pass) throws IOException {
        String loadPass = loadUser().getProperty(user);
        if (loadPass != null && loadPass.equals(pass)) {
            return true;
        }
        return false;
    }

    public boolean addUser(String name, String pass) throws Exception {
        if (userList == null) {
            userList = loadUser();
        }
        if (userList.containsKey(name)) {
            throw new Exception("User already exist, please select another!");
        }
        userList.setProperty(name, pass);
        saveUserList();
        return true;
    }

    public String getMsg() {
        if (chatMsg == null) {
            chatMsg = new LinkedList<String>();
            return "";
        }
        StringBuilder result = new StringBuilder("");
        for (String tmp: chatMsg) {
            result.append(tmp + "\n");
        }

        return result.toString();
    }

    public void addMsg(String user, String msg) {
        if (chatMsg == null) {
            chatMsg = new LinkedList<String>();
        }

        if (chatMsg.size() > 40) {
            chatMsg.removeFirst();
        }

        chatMsg.add(user + " Said: " + msg);
    }
}
