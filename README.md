# 三味书屋图书商店后台
## 1. 根据bookId获取图书所有内容（简介、详情、评论）
* url地址：/getBookById
* 请求方式：post
* 参数：
```$xslt
bookId:ce703fd2-3e62-11e9-8f83-1c2b8518ea4c
```  
* 返回格式：
```$xslt
{
	"code": 200,
	"reason": null,
	"res": {
		"bookId": "ce703fd2-3e62-11e9-8f83-1c2b8518ea4c",
		"name": "巨人的陨落",
		"writer": "[英]肯·福莱特/于大卫",
		"publisher": "江苏凤凰文艺出版社",
		"date": "2016-5-1",
		"img": "https://img3.doubanio.com/view/subject/m/public/s28668834.jpg",
		"type": 1,
		"introduce": "在第一次世界大战的硝烟中，每一个迈向死亡的生命都在热烈地生长——威尔士的矿工少年、刚失恋的美国法律系大学生、穷困潦倒的俄国兄弟、富有英俊的英格兰伯爵，以及痴...",
		"grade": "8.9",
		"people": "42803",
		"price": "129.80",
		"no": "26698660",
		"detail": {
			"detailId": "3a6799b3-a2b5-4ab8-90f1-580e4667c2d7",
			"bookId": "ce703fd2-3e62-11e9-8f83-1c2b8518ea4c",
			"writer": "肯·福莱特\nKen\nFollett\n(1949\n-)，现象级畅销小说大师。1978年出版了处女作《风暴岛》，并于次年获得爱伦坡奖，声名鹊起，专职写作。2010年，荣登全球作家富豪榜上第5名。2013年，获得爱伦坡终身大师奖。他的小说出版前，都会请历史学家审读书稿，绝不容许出现任何史实错误。有出版人曾指出，肯·福莱特\n“没有一个饱受折磨的灵魂”，他愉快地承认了，“大家都在写内心的痛苦，可我总是觉得很开心”。他说：“很多作家只写能取悦他们自己的东西，并模模糊糊地希望这也能取悦别人。但我每写一页都在清醒地思考：读者会怎么想？读者觉得这真的会发生吗？读者关心这些吗？读者想要知道接下来会发生什么吗？我敬佩那些用文字和新奇结构进行文学实验的作家，但我从不这么玩。”\n作者官方网站：www.ken-follett.com",
			"content": "在第一次世界大战的硝烟中，每一个迈向死亡的生命都在热烈地生长——威尔士的矿工少年、刚失恋的美国法律系大学生、穷困潦倒的俄国兄弟、富有英俊的英格兰伯爵，以及痴情的德国特工… 从充满灰尘和危险的煤矿到闪闪发光的皇室宫殿，从代表着权力的走廊到爱恨纠缠的卧室，五个家族迥然不同又纠葛不断的命运逐渐揭晓，波澜壮阔地展现了一个我们自认为了解，但从未如此真切感受过的20世纪。",
			"catalog": " 序 成人礼\n Part 1 天地失色\n Part 2 巨人之战\n Part 3 世界重生\n · · · · · · (\n) \n",
		},
		"comments": [{
			"commentId": "3ffcc935-4b38-4f7e-994b-c5d8e5a2a800",
			"bookId": "ce703fd2-3e62-11e9-8f83-1c2b8518ea4c",
			"person": "CHANTEY",
			"commentContent": "超级小说《巨人的陨落》征集超级好书评！",
			"commentDate": "2016-09-27 11:38",
			"comentGrade": null,
		}]
	}
}
```

## 2. 获取评分前十的图书
* url地址：/getGradeTop10
* 请求方式：post
* 参数：
```$xslt
无
```  
* 返回格式：
```$xslt
{
    "code": 200,
    "reason": null,
    "res": [
        {
            "bookId": "ce72a86c-3e62-11e9-8f83-1c2b8518ea4c",
            "name": "Modernist Cuisine",
            "writer": "NathanMyhrvold、ChrisYoung、MaximeBilet",
            "img": "https://img3.doubanio.com/view/subject/l/public/s27280490.jpg",
            "grade": "9.8",
            "people": "68"
        },{……}
    ]
```

## 3. 根据类别获取图书列表
* url地址：/getBooksByType
* 请求方式：post
* 参数：
```$xslt
type:1 (11-好书推荐 12 特色书籍 1-小说 2-经济 3-管理 4-教育 5-文化 6-历史 7-文学 8-名著 9-军事 10-美食)
pageNum:1 (当前页码)
pageSize:10 (每页显示的数目)
```  
* 返回格式：
```$xslt
{
    "code": 200,
    "reason": null,
    "res": {
        "total": 815,
        "list": [
            {
                "bookId": "ce71f89a-3e62-11e9-8f83-1c2b8518ea4c",
                "name": "大秦帝国",
                "writer": "孙皓晖",
                "publisher": "河南文艺出版社",
                "date": "2008-5-1",
                "img": "https://img3.doubanio.com/view/subject/m/public/s3097044.jpg",
                "type": 7,
                "introduce": "大秦帝国作为时代精神汇集的帝国，集中地体现了那个时代中华民族的强势生存精神。中华民族的整个文明体系其所以能够绵延如大河奔涌，秦帝国时代开创奠定的强势生存传统...",
                "grade": "8.7",
                "people": "9957",
                "price": "369.00",
                "no": "3079029",
                "detailUrl": "https://book.douban.com/subject/3079029/",
                "createTime": "2019-03-04 17:49:30.0",
                "updateTime": "2019-03-13 22:24:24.0"
            },{……}
        ],
        "pageNum": 1,
        "pageSize": 10,
        "size": 10,
        "startRow": 1,
        "endRow": 10,
        "pages": 82,
        "prePage": 0,
        "nextPage": 2,
        "isFirstPage": true,
        "isLastPage": false,
        "hasPreviousPage": false,
        "hasNextPage": true,
        "navigatePages": 8,
        "navigatepageNums": [1,2,3,4,5,6,7,8],
        "navigateFirstPage": 1,
        "navigateLastPage": 8,
        "firstPage": 1,
        "lastPage": 8
    }
}
```

## 4. 获取出版日期最近的20本
* url地址：/getBooksOrderByDate
* 请求方式：post
* 参数：
```$xslt
无
```  
* 返回格式：
```$xslt
{
    "code": 200,
    "reason": null,
    "res": [
        {
            "bookId": "ce7283f0-3e62-11e9-8f83-1c2b8518ea4c",
            "name": "日俄战争",
            "writer": "[日]和田春树/易爱华、张剑",
            "publisher": "生活·读书·新知三联书店",
            "date": "2018-2",
            "img": "https://img3.doubanio.com/view/subject/m/public/s29718335.jpg",
            "type": 10,
            "introduce": "“日俄战争是世界史上巨大的事件，它不仅给日本和俄罗斯国民，而且给朝鲜和中国国民都带来了深刻的影响。尽管如此，关于这场战争，建立在对日本和俄罗斯资料进行深入调...",
            "grade": "7.9",
            "people": "79",
            "price": "148.00",
            "no": "27089758",
        },
        {
            "bookId": "ce72110e-3e62-11e9-8f83-1c2b8518ea4c",
            "name": "国王的两个身体",
            "writer": "[德]恩斯特·康托洛维茨/徐震宇",
            "publisher": "华东师范大学出版社",
            "date": "2018-1-1",
            "img": "https://img3.doubanio.com/view/subject/m/public/s29640403.jpg",
            "type": 7,
            "introduce": "对嗣后的思考是人类最基本的思考，政治体亦然。“国王的两个身体”是伊丽莎白一世时期英国法学家创制的概念：国王有一个“自然之体”，他个体的肉身，可生病、会疲弱...",
            "grade": "9.0",
            "people": "347",
            "price": "168.00",
            "no": "27086102",
        },{……}
    ]
}
```

## 5. 注册
* url地址：/apply
* 请求方式：post
* 参数：
```$xslt
account:zhangzhang
password:1
email:123@qq.com
mobile:10086
```
* 返回格式：
```$xslt
{
    "code": 200,
    "reason": "成功",
    "res": null
}
```

## 6. 登录
* url地址：/login
* 请求方式：post
* 参数：
```$xslt
account:dd
password:1
```  
* 返回格式：
```$xslt
{
    "code": 200,
    "reason": null,
    "res": {
        "userId": "8f00b259-47e3-11e9-9e5f-00163e0097c7",
        "account": "zhangzhang",
        "password": "c4ca4238a0b923820dcc509a6f75849b",
        "mobile": "10086",
        "email": "1235@qq.com",
        "createTime": "2019-03-16 20:03:49.0",
        "updateTime": "2019-03-16 20:05:09.0"
    }
}
```



## 3. 获取个人信息
* url地址：/userInfo
* 请求方式：post
* 参数：
```$xslt
userId:8f00b259-47e3-11e9-9e5f-00163e0097c7
```
* 返回格式：
```$xslt
{
    "code": 200,
    "reason": null,
    "res": {
        "userId": "8f00b259-47e3-11e9-9e5f-00163e0097c7",
        "account": "zhangzhang",
        "password": "c4ca4238a0b923820dcc509a6f75849b",
        "mobile": "10086",
        "email": "1235@qq.com",
        "createTime": "2019-03-16 20:03:49.0",
        "updateTime": "2019-03-16 20:05:09.0"
    }
}
```

## 4. 修改个人信息
* url地址：/apply
* 请求方式：post
* 参数：
```$xslt
userId:8f00b259-47e3-11e9-9e5f-00163e0097c7
account:zhangzhang
email:1234@qq.com
mobile:10086
```
* 返回格式：
```$xslt
{
    "code": 200,
    "reason": "成功",
    "res": null
}
```