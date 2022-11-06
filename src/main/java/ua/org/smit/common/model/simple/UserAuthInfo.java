package ua.org.smit.common.model.simple;

import ua.org.smit.common.model.filed.id.user.UserAuthId;
import ua.org.smit.common.model.simple.user.NickName;

public class UserAuthInfo {

    private UserAuthId id;
    private NickName nickName;

    public UserAuthId getId() {
        return id;
    }

    public void setId(UserAuthId id) {
        this.id = id;
    }

    public NickName getNickName() {
        return nickName;
    }

    public void setNickName(NickName nickName) {
        this.nickName = nickName;
    }

}
