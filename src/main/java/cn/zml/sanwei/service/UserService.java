package cn.zml.sanwei.service;

import cn.zml.sanwei.config.SanweiException;
import cn.zml.sanwei.model.User;
import cn.zml.sanwei.model.UserInfo;

/**
 * User表相关的服务接口类
 * @author fanyidong
 * @date 2018-12-11
 */
public interface UserService {

    /**
     * 登录服务接口
     * @param account 账户
     * @param password 密码
     * @throws SanweiException
     * @return
     */
    User login(String account, String password) throws SanweiException;

    /**
     * 修改/新增 用户
     * @param user
     * @throws SanweiException
     */
    void applyUser(User user) throws SanweiException;

    /**
     * 获取用户信息
     * @param userId 用户id
     * @return
     * @throws SanweiException
     */
    UserInfo getUserInfo(String userId) throws SanweiException;
}
