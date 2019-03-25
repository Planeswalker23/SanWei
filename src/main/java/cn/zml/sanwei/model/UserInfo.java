package cn.zml.sanwei.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * 个人中心实体类
 * @author fanyidong
 * @date Created in 2019-03-24
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfo extends User {

    List<UserBooksComments> personalComments;

    public List<UserBooksComments> getPersonalComments() {
        return personalComments;
    }

    public void setPersonalComments(List<UserBooksComments> personalComments) {
        this.personalComments = personalComments;
    }
}
