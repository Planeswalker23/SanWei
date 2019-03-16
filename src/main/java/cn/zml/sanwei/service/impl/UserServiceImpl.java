package cn.zml.sanwei.service.impl;

import cn.zml.sanwei.common.SanweiException;
import cn.zml.sanwei.dao.UserDao;
import cn.zml.sanwei.model.User;
import cn.zml.sanwei.service.UserService;
import cn.zml.sanwei.util.CheckUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import static cn.zml.sanwei.common.Constant.*;

/**
 * User表相关的服务接口实现类
 * @author fanyidong
 * @date 2018-12-11
 */
@Service
public class UserServiceImpl implements UserService {

    private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public User login(String account, String password) throws SanweiException {
        //查询结果对象
        User resUser = userDao.queryByAccount(account);
        // 验证用户是否存在
        if (resUser == null) {
            throw new SanweiException(USER_NOT_EXIST);
        }
        // 验证密码
        if (!resUser.getPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()))) {
            throw new SanweiException(WRONG_PASSWORD);
        }
        log.info("日志信息 => 登录成功 ***** " + resUser.toString());
        return resUser;
    }

    @Override
    public void applyUser(User newUser) throws SanweiException {
        String email = newUser.getEmail();
        if (!StringUtils.isEmpty(email)&&!CheckUtils.checkEmail(email)) {
            throw new SanweiException(WRONG_MAIL);
        }
        // 根据邮箱及userId查询非本userId的邮箱是否存在
        if (!StringUtils.isEmpty(email) && userDao.queryBySelectiveNotUserId(newUser)!=null) {
            throw new SanweiException(MAIL_EXIST);
        }
        User existUserSelective = new User();
        existUserSelective.setAccount(newUser.getAccount());
        // 根据account查询该用户是否存在
        int existNum = userDao.countUser(existUserSelective);
        if (StringUtils.isEmpty(newUser.getUserId())) {
            // 注册
            if(addUser(newUser,existNum) == 0) {
                log.info("日志信息 => 注册失败");
                throw new SanweiException(FAILED);
            }
            log.info("日志信息 => 注册成功");
        } else {
            // 修改信息
            if (editUser(newUser, existNum) == 0) {
                log.info("日志信息 => 修改个人信息失败");
                throw new SanweiException(EDIT_FAILED);
            }
            log.info("日志信息 => 修改个人信息成功");
        }
    }

    @Override
    public User getUserInfo(String userId) throws SanweiException {
        User selective = new User();
        selective.setUserId(userId);
        // 验证查询结果是否为空
        User resUser = userDao.queryBySelective(selective);
        if (resUser == null) {
            throw new SanweiException(USER_NOT_EXIST);
        }
        log.info("日志信息 => 用户个人信息 ***** " + resUser.toString());
        return resUser;
    }

    public int addUser(User newUser, Integer existNum) throws SanweiException {
        if (existNum > 0) {
            throw new SanweiException(USER_EXIST);
        }
        // 密码使用md5加密
        newUser.setPassword(DigestUtils.md5DigestAsHex(newUser.getPassword().getBytes()));
        // 新增用户
        return userDao.addUser(newUser);
    }

    private int editUser(User newUser, Integer existNum) throws SanweiException {
        if (existNum == 0) {
            throw new SanweiException(USER_NOT_EXIST);
        }
        if (!StringUtils.isEmpty(newUser.getPassword())) {
            newUser.setPassword(DigestUtils.md5DigestAsHex(newUser.getPassword().getBytes()));
        }
        // 修改信息
        return userDao.editByUserId(newUser);
    }
}
