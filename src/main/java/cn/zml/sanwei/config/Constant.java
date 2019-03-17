package cn.zml.sanwei.config;

/**
 * 常量类
 * @author fanyidong
 * @date Created in 2019-03-06
 */
public interface Constant {

    /**
     * 数字常量
     */
    Integer TWO = 2;
    Integer THOUSAND = 1000;

    /**
     * 请求状态码
     */
    Integer REQUEST_SUCCESS_CODE = 200;
    Integer REQUEST_FAILED_CODE = 500;

    /**
     * 图书类别
     * 1-小说 2-经济 3-管理 4-教育 5-文化 6-历史 7-文学 8-名著 9-军事 10-美食
     */
    Integer ONE_STROY = 1;
    Integer TWO_ECONOMICS = 2;
    Integer THREE_MANAGE = 3;
    Integer FOUR_EDUCATION = 4;
    Integer FIVE_CULTURE = 5;
    Integer SIX_HISTORY = 6;
    Integer SEVEN_LITERATURE = 7;
    Integer EIGHT_MASTERWORK = 8;
    Integer NINE_MILITARY = 9;
    Integer TEN_FOOD = 10;

    /**
     * 好书推荐
     */
    Integer GOOD_BOOK = 11;
    /**
     * 特色书籍
     */
    Integer RANDOM_BOOK = 12;

    String SYSTEM_ERROR = "系统错误，请联系管理员";

    String EDIT_FAILED = "未修改任何数据";

    String USER_NOT_EXIST = "该用户不存在";

    String WRONG_PASSWORD = "密码错误";

    String WRONG_MAIL = "邮箱格式错误";

    String MAIL_EXIST = "邮箱已被注册";

    String USER_EXIST = "用户已存在";

    String EMPTY_PARAMS = "缺少参数";

    String SUCCESS = "成功";

    String FAILED = "失败";

    String DATA_ERROR_NO_SUCH_BOOK = "数据错误，书库中无此书籍";

    String HAS_COLLECTED_BOOK = "这本书已经收藏过了";

}
