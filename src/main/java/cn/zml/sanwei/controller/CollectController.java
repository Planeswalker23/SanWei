package cn.zml.sanwei.controller;

import cn.zml.sanwei.config.SanWeiRes;
import cn.zml.sanwei.config.SanweiException;
import cn.zml.sanwei.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 收藏功能控制层
 * @author fanyidong
 * @date Created in 2019-03-17
 */
@RestController
public class CollectController {

    @Autowired
    private CollectService collectService;

    @PostMapping("addCollect")
    @Transactional(rollbackFor = Exception.class)
    public SanWeiRes addCollect(String userId, String bookId) throws SanweiException {
        if (StringUtils.isEmpty(userId)) {
            return SanWeiRes.notLogin();
        }
        collectService.insert(userId, bookId);
        return SanWeiRes.success();
    }

    @PostMapping("deleteCollect")
    @Transactional(rollbackFor = Exception.class)
    public SanWeiRes deleteCollect(String userId, String bookId) {
        if (StringUtils.isEmpty(userId)) {
            return SanWeiRes.notLogin();
        }
        collectService.delete(userId, bookId);
        return SanWeiRes.success();
    }

    @PostMapping("getCollections")
    @Transactional(rollbackFor = Exception.class)
    public SanWeiRes getCollections(String userId) {
        if (StringUtils.isEmpty(userId)) {
            return SanWeiRes.notLogin();
        }
        return SanWeiRes.success(collectService.getCollectionsFromBookAndCollectByUserId(userId));
    }
}
