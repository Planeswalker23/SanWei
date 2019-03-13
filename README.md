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
		"detailUrl": "https://book.douban.com/subject/26698660/",
		"createTime": "2019-03-04 17:49:30.0",
		"updateTime": "2019-03-04 17:49:30.0",
		"detail": {
			"detailId": "3a6799b3-a2b5-4ab8-90f1-580e4667c2d7",
			"bookId": "ce703fd2-3e62-11e9-8f83-1c2b8518ea4c",
			"writer": "肯·福莱特\nKen\nFollett\n(1949\n-)，现象级畅销小说大师。1978年出版了处女作《风暴岛》，并于次年获得爱伦坡奖，声名鹊起，专职写作。2010年，荣登全球作家富豪榜上第5名。2013年，获得爱伦坡终身大师奖。他的小说出版前，都会请历史学家审读书稿，绝不容许出现任何史实错误。有出版人曾指出，肯·福莱特\n“没有一个饱受折磨的灵魂”，他愉快地承认了，“大家都在写内心的痛苦，可我总是觉得很开心”。他说：“很多作家只写能取悦他们自己的东西，并模模糊糊地希望这也能取悦别人。但我每写一页都在清醒地思考：读者会怎么想？读者觉得这真的会发生吗？读者关心这些吗？读者想要知道接下来会发生什么吗？我敬佩那些用文字和新奇结构进行文学实验的作家，但我从不这么玩。”\n作者官方网站：www.ken-follett.com",
			"content": "在第一次世界大战的硝烟中，每一个迈向死亡的生命都在热烈地生长——威尔士的矿工少年、刚失恋的美国法律系大学生、穷困潦倒的俄国兄弟、富有英俊的英格兰伯爵，以及痴情的德国特工… 从充满灰尘和危险的煤矿到闪闪发光的皇室宫殿，从代表着权力的走廊到爱恨纠缠的卧室，五个家族迥然不同又纠葛不断的命运逐渐揭晓，波澜壮阔地展现了一个我们自认为了解，但从未如此真切感受过的20世纪。",
			"catalog": " 序 成人礼\n Part 1 天地失色\n Part 2 巨人之战\n Part 3 世界重生\n · · · · · · (\n) \n",
			"createTime": "2019-03-05 19:49:53.0",
			"updateTime": "2019-03-05 19:49:53.0"
		},
		"comments": [{
			"commentId": "3ffcc935-4b38-4f7e-994b-c5d8e5a2a800",
			"bookId": "ce703fd2-3e62-11e9-8f83-1c2b8518ea4c",
			"person": "CHANTEY",
			"commentContent": "超级小说《巨人的陨落》征集超级好书评！",
			"commentDate": "2016-09-27 11:38",
			"comentGrade": null,
			"createTime": "2019-03-05 19:49:53.0",
			"updateTime": "2019-03-05 19:49:53.0"
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
        },
        {
            "bookId": "ce71fdb8-3e62-11e9-8f83-1c2b8518ea4c",
            "name": "姚著中国史",
            "writer": "姚大中",
            "img": "https://img1.doubanio.com/view/subject/l/public/s29302238.jpg",
            "grade": "9.8",
            "people": "164"
        },
        {
            "bookId": "ce70f80a-3e62-11e9-8f83-1c2b8518ea4c",
            "name": "深入浅出数字信号处理",
            "writer": "江志红",
            "img": "https://img1.doubanio.com/view/subject/l/public/s8888419.jpg",
            "grade": "9.7",
            "people": "33"
        },
        {
            "bookId": "ce71aa70-3e62-11e9-8f83-1c2b8518ea4c",
            "name": "珍爱生命",
            "writer": "刘文利编",
            "img": "https://img1.doubanio.com/view/subject/l/public/s28837989.jpg",
            "grade": "9.7",
            "people": "164"
        },
        {
            "bookId": "ce71b2fe-3e62-11e9-8f83-1c2b8518ea4c",
            "name": "艺术的故事",
            "writer": "[英]贡布里希(SirE.H.Gombrich)/范景中、杨成凯",
            "img": "https://img3.doubanio.com/view/subject/l/public/s3219163.jpg",
            "grade": "9.6",
            "people": "8610"
        },
        {
            "bookId": "ce7219ce-3e62-11e9-8f83-1c2b8518ea4c",
            "name": "红楼梦",
            "writer": "[清]曹雪芹著、高鹗续",
            "img": "https://img1.doubanio.com/view/subject/l/public/s1070959.jpg",
            "grade": "9.6",
            "people": "145336"
        },
        {
            "bookId": "ce70a206-3e62-11e9-8f83-1c2b8518ea4c",
            "name": "经济学原理(第7版):微观经济学分册+宏观经济学分册(套装共2册)",
            "writer": "曼昆(N.GregoryMankiw)/梁小民、梁砾",
            "img": "https://img1.doubanio.com/view/subject/l/public/s28120578.jpg",
            "grade": "9.6",
            "people": "1099"
        },
        {
            "bookId": "ce727fb8-3e62-11e9-8f83-1c2b8518ea4c",
            "name": "抗日战争正面战场（上中下）",
            "writer": "中国第二历史档案馆",
            "img": "https://img1.doubanio.com/view/subject/l/public/s9069467.jpg",
            "grade": "9.5",
            "people": "78"
        },
        {
            "bookId": "ce728c56-3e62-11e9-8f83-1c2b8518ea4c",
            "name": "麒麟之生死與共",
            "writer": "桔子樹",
            "img": "https://img1.doubanio.com/view/subject/l/public/s6781748.jpg",
            "grade": "9.5",
            "people": "2194"
        },
        {
            "bookId": "ce71e044-3e62-11e9-8f83-1c2b8518ea4c",
            "name": "史记（全十册）",
            "writer": "司马迁/（索引）司马贞，（正义）张守节",
            "img": "https://img3.doubanio.com/view/subject/l/public/s1953384.jpg",
            "grade": "9.5",
            "people": "13370"
        }
    ]
}
```

## 2. 根据类别获取图书列表
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
            },
            {
                "bookId": "ce70982e-3e62-11e9-8f83-1c2b8518ea4c",
                "name": "生活与命运",
                "writer": "[俄罗斯]瓦·格罗斯曼/力冈",
                "publisher": "广西师范大学出版社",
                "date": "2015-8-20",
                "img": "https://img1.doubanio.com/view/subject/m/public/s28265238.jpg",
                "type": 1,
                "introduce": "★梁文道“最想为读者推荐的一本书”。《纽约时报》《华盛顿邮报》《华尔街日报》《卫报》《世界报》等全球媒体鼎力推荐，欧美书界誉为“当代的《战争与和平》”，“2...",
                "grade": "9.2",
                "people": "992",
                "price": "118.00",
                "no": "26394018",
                "detailUrl": "https://book.douban.com/subject/26394018/",
                "createTime": "2019-03-04 17:49:30.0",
                "updateTime": "2019-03-13 22:24:24.0"
            },
            {
                "bookId": "ce72126c-3e62-11e9-8f83-1c2b8518ea4c",
                "name": "生活与命运",
                "writer": "[俄罗斯]瓦·格罗斯曼/力冈",
                "publisher": "广西师范大学出版社",
                "date": "2015-8-20",
                "img": "https://img1.doubanio.com/view/subject/m/public/s28265238.jpg",
                "type": 7,
                "introduce": "★梁文道“最想为读者推荐的一本书”。《纽约时报》《华盛顿邮报》《华尔街日报》《卫报》《世界报》等全球媒体鼎力推荐，欧美书界誉为“当代的《战争与和平》”，“2...",
                "grade": "9.2",
                "people": "992",
                "price": "118.00",
                "no": "26394018",
                "detailUrl": "https://book.douban.com/subject/26394018/",
                "createTime": "2019-03-04 17:49:30.0",
                "updateTime": "2019-03-13 22:24:24.0"
            },
            {
                "bookId": "ce70940a-3e62-11e9-8f83-1c2b8518ea4c",
                "name": "清明上河图密码",
                "writer": "冶文彪",
                "publisher": "北京联合出版公司",
                "date": "2015-1-1",
                "img": "https://img1.doubanio.com/view/subject/m/public/s27956707.jpg",
                "type": 1,
                "introduce": "全图824位人物，每个人都有名有姓，佯装、埋伏在舟船车轿、酒肆楼阁中。看似太平盛世，其实杀机四伏。翻开本书，在小贩的叫卖声中，金、辽、西夏、高丽等国的间谍、...",
                "grade": "8.2",
                "people": "9914",
                "price": "49.90",
                "no": "26265745",
                "detailUrl": "https://book.douban.com/subject/26265745/",
                "createTime": "2019-03-04 17:49:30.0",
                "updateTime": "2019-03-13 22:24:24.0"
            },
            {
                "bookId": "ce71eeae-3e62-11e9-8f83-1c2b8518ea4c",
                "name": "清明上河图密码",
                "writer": "冶文彪",
                "publisher": "北京联合出版公司",
                "date": "2015-1-1",
                "img": "https://img1.doubanio.com/view/subject/m/public/s27956707.jpg",
                "type": 7,
                "introduce": "全图824位人物，每个人都有名有姓，佯装、埋伏在舟船车轿、酒肆楼阁中。看似太平盛世，其实杀机四伏。翻开本书，在小贩的叫卖声中，金、辽、西夏、高丽等国的间谍、...",
                "grade": "8.2",
                "people": "9914",
                "price": "49.90",
                "no": "26265745",
                "detailUrl": "https://book.douban.com/subject/26265745/",
                "createTime": "2019-03-04 17:49:30.0",
                "updateTime": "2019-03-13 22:24:24.0"
            },
            {
                "bookId": "ce7236de-3e62-11e9-8f83-1c2b8518ea4c",
                "name": "傲慢与偏见",
                "writer": "[英]奥斯丁/张玲、张扬",
                "publisher": "人民文学出版社",
                "date": "1993-7",
                "img": "https://img3.doubanio.com/view/subject/m/public/s4250062.jpg",
                "type": 8,
                "introduce": "《傲慢与偏见》是简·奥斯汀的代表作，是一部描写爱情与婚姻的经典小说。作品以男女主人公达西和伊丽莎白由于傲慢和偏见而产生的爱情纠葛为线索，共写了四起姻缘：伊丽...",
                "grade": "8.8",
                "people": "98869",
                "price": "13.00",
                "no": "1083428",
                "detailUrl": "https://book.douban.com/subject/1083428/",
                "createTime": "2019-03-04 17:49:30.0",
                "updateTime": "2019-03-13 22:24:24.0"
            },
            {
                "bookId": "ce723f94-3e62-11e9-8f83-1c2b8518ea4c",
                "name": "傲慢与偏见",
                "writer": "[英]奥斯丁/张玲、张扬",
                "publisher": "人民文学出版社",
                "date": "1993-7",
                "img": "https://img3.doubanio.com/view/subject/m/public/s4250062.jpg",
                "type": 9,
                "introduce": "《傲慢与偏见》是简·奥斯汀的代表作，是一部描写爱情与婚姻的经典小说。作品以男女主人公达西和伊丽莎白由于傲慢和偏见而产生的爱情纠葛为线索，共写了四起姻缘：伊丽...",
                "grade": "8.8",
                "people": "98869",
                "price": "13.00",
                "no": "1083428",
                "detailUrl": "https://book.douban.com/subject/1083428/",
                "createTime": "2019-03-04 17:49:30.0",
                "updateTime": "2019-03-13 22:24:24.0"
            },
            {
                "bookId": "ce709b80-3e62-11e9-8f83-1c2b8518ea4c",
                "name": "通往奴役之路",
                "writer": "(英)弗里德利希·奥古斯特·哈耶克/王明毅、冯兴元、等",
                "publisher": "中国社会科学出版社",
                "date": "1997-08-01",
                "img": "https://img3.doubanio.com/view/subject/m/public/s8879166.jpg",
                "type": 2,
                "introduce": "《通往奴役之路》一书在哈耶克的学术生涯中占有极其重要地位，这本书为他赢得广泛的注意，他的世界性声誉就是由此奠定的。他在这本书中论证道，当时正在计划中的福利国...",
                "grade": "8.8",
                "people": "9859",
                "price": "16.00",
                "no": "1077528",
                "detailUrl": "https://book.douban.com/subject/1077528/",
                "createTime": "2019-03-04 17:49:30.0",
                "updateTime": "2019-03-13 22:24:24.0"
            },
            {
                "bookId": "ce7289ea-3e62-11e9-8f83-1c2b8518ea4c",
                "name": "解放战争（上）（1945年8月—1948年9月）",
                "writer": "王树增",
                "publisher": "人民文学出版社",
                "date": "2009-8",
                "img": "https://img1.doubanio.com/view/subject/m/public/s3934457.jpg",
                "type": 10,
                "introduce": "《解放战争》为王树增非虚构文学著述中规模最大的作品。武器简陋、兵力不足的军队对抗拥有现代武器装备的兵力庞大的军队，数量不多、面积有限的解放区最终扩展成为九百...",
                "grade": "8.1",
                "people": "985",
                "price": "60.00",
                "no": "3924388",
                "detailUrl": "https://book.douban.com/subject/3924388/",
                "createTime": "2019-03-04 17:49:30.0",
                "updateTime": "2019-03-13 22:24:24.0"
            },
            {
                "bookId": "ce72ba8c-3e62-11e9-8f83-1c2b8518ea4c",
                "name": "贪食纪",
                "writer": "殳俏、龙荻（插图）",
                "publisher": "生活·读书·新知三联书店",
                "date": "2012-8",
                "img": "https://img3.doubanio.com/view/subject/m/public/s22704736.jpg",
                "type": 11,
                "introduce": "不知不觉，写美食专栏这件事已经到了第十个年头。……做跟食物打交道的事情，其实真的微不足道。但就是这样的小事，在最寂寞的时候要坚持下去，在最热闹的时候更要坚持...",
                "grade": "8.1",
                "people": "984",
                "price": "35.00",
                "no": "11627774",
                "detailUrl": "https://book.douban.com/subject/11627774/",
                "createTime": "2019-03-04 17:49:30.0",
                "updateTime": "2019-03-13 22:24:24.0"
            }
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
        "navigatepageNums": [
            1,
            2,
            3,
            4,
            5,
            6,
            7,
            8
        ],
        "navigateFirstPage": 1,
        "navigateLastPage": 8,
        "firstPage": 1,
        "lastPage": 8
    }
}
```