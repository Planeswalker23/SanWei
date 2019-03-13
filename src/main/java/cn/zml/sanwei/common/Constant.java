package cn.zml.sanwei.common;

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
     * 图书类别
     * 1-小说 2-经济 3-管理 4-教育 5-文化 6-历史 7-文学 8-名著 9-军事 10-美食
     */
    Integer STROY = 1;
    Integer ECONOMICS = 2;
    Integer MANAGE = 3;
    Integer EDUCATION = 4;
    Integer CULTURE = 5;
    Integer HISTORY = 6;
    Integer LITERATURE = 7;
    Integer MASTERWORK = 8;
    Integer MILITARY = 9;
    Integer FOOD = 10;

    /**
     * 好书推荐
     */
    Integer GOOD_BOOK = 11;
    Integer RANDOM_BOOK = 12;

    String SYSTEM_ERROR = "系统错误，请联系管理员";

}
