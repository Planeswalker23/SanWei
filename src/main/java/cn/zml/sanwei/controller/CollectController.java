package cn.zml.sanwei.controller;

import cn.zml.sanwei.config.SanWeiRes;
import cn.zml.sanwei.config.SanweiException;
import cn.zml.sanwei.model.Collect;
import cn.zml.sanwei.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static cn.zml.sanwei.config.Constant.REQUEST_FAILED_CODE;

/**
 * 收藏功能控制层
 * @author fanyidong
 * @date Created in 2019-03-17
 */
@RestController
public class CollectController {

    @Autowired
    private CollectService collectService;

    /**
     * 判断参数是否缺少的公用方法
     * @param collect
     * @return
     */
    private SanWeiRes noParamReturn(Collect collect) {
        if (StringUtils.isEmpty(collect.getUserId())) {
            return SanWeiRes.noParam("用户id");
        } else if (StringUtils.isEmpty(collect.getBookId())) {
            return SanWeiRes.noParam("书籍id");
        }
        return SanWeiRes.success();
    }

    @PostMapping("addCollect")
    @Transactional(rollbackFor = Exception.class)
    public SanWeiRes addCollect(Collect collect) throws SanweiException {
        // 验证参数是否缺失
        SanWeiRes paramCheck = noParamReturn(collect);
        if (REQUEST_FAILED_CODE.equals(paramCheck.getCode())) {
            return paramCheck;
        }
        collectService.insert(collect);
        return SanWeiRes.success();
    }

    @PostMapping("deleteCollect")
    @Transactional(rollbackFor = Exception.class)
    public SanWeiRes deleteCollect(Collect collect) {
        // 验证参数是否缺失
        SanWeiRes paramCheck = noParamReturn(collect);
        if (REQUEST_FAILED_CODE.equals(paramCheck.getCode())) {
            return paramCheck;
        }
        collectService.delete(collect);
        return SanWeiRes.success();
    }

    @PostMapping("getCollections")
    @Transactional(rollbackFor = Exception.class)
    public SanWeiRes getCollections(String userId) {
        // 验证参数是否缺失
        if (StringUtils.isEmpty(userId)) {
            return SanWeiRes.noParam("用户id");
        }
        return SanWeiRes.success(collectService.getCollectionsFromBookAndCollectByUserId(userId));
    }
}
