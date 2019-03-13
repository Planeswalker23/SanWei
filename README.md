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

## 3. 获取出版日期最近的20本
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
            "detailUrl": "https://book.douban.com/subject/27089758/",
            "createTime": "2019-03-04 17:49:30.0",
            "updateTime": "2019-03-13 22:24:24.0"
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
            "detailUrl": "https://book.douban.com/subject/27086102/",
            "createTime": "2019-03-04 17:49:30.0",
            "updateTime": "2019-03-13 22:24:24.0"
        },
        {
            "bookId": "ce7040d6-3e62-11e9-8f83-1c2b8518ea4c",
            "name": "房思琪的初恋乐园",
            "writer": "林奕含",
            "publisher": "北京联合出版公司",
            "date": "2018-1",
            "img": "https://img3.doubanio.com/view/subject/m/public/s29651121.jpg",
            "type": 1,
            "introduce": "令人心碎却无能为力的真实故事。向死而生的文学绝唱打动万千读者的年度华语小说。李银河戴锦华骆以军张悦然冯唐詹宏志蒋方舟史航等多位学者作...",
            "grade": "9.2",
            "people": "36095",
            "price": "45.00",
            "no": "27614904",
            "detailUrl": "https://book.douban.com/subject/27614904/",
            "createTime": "2019-03-04 17:49:30.0",
            "updateTime": "2019-03-13 22:24:24.0"
        },
        {
            "bookId": "ce7215d2-3e62-11e9-8f83-1c2b8518ea4c",
            "name": "房思琪的初恋乐园",
            "writer": "林奕含",
            "publisher": "北京联合出版公司",
            "date": "2018-1",
            "img": "https://img3.doubanio.com/view/subject/m/public/s29651121.jpg",
            "type": 8,
            "introduce": "令人心碎却无能为力的真实故事。向死而生的文学绝唱打动万千读者的年度华语小说。李银河戴锦华骆以军张悦然冯唐詹宏志蒋方舟史航等多位学者作...",
            "grade": "9.2",
            "people": "36095",
            "price": "45.00",
            "no": "27614904",
            "detailUrl": "https://book.douban.com/subject/27614904/",
            "createTime": "2019-03-04 17:49:30.0",
            "updateTime": "2019-03-13 22:24:24.0"
        },
        {
            "bookId": "ce710a7a-3e62-11e9-8f83-1c2b8518ea4c",
            "name": "原则",
            "writer": "[美]瑞·达利欧/刘波、綦相",
            "publisher": "中信出版社",
            "date": "2018-1",
            "img": "https://img3.doubanio.com/view/subject/m/public/s29643861.jpg",
            "type": 4,
            "introduce": "※华尔街投资大神、对冲基金公司桥水创始人，人生经验之作作者瑞·达利欧出身美国普通中产家庭，26岁时被炒鱿鱼后在自己的两居室内创办了桥水，现在桥水管理资金...",
            "grade": "8.4",
            "people": "7418",
            "price": "98.00",
            "no": "27608239",
            "detailUrl": "https://book.douban.com/subject/27608239/",
            "createTime": "2019-03-04 17:49:30.0",
            "updateTime": "2019-03-13 22:24:24.0"
        },
        {
            "bookId": "ce70d370-3e62-11e9-8f83-1c2b8518ea4c",
            "name": "月亮",
            "writer": "[德]贝恩德·布伦纳/甘锡安",
            "publisher": "北京联合出版公司",
            "date": "2017-8",
            "img": "https://img3.doubanio.com/view/subject/m/public/s29771555.jpg",
            "type": 3,
            "introduce": "国家天文台苟利军教授、郑永春博士（月球专家、2016年卡尔萨根奖得主）联袂推荐你对月亮的所有好奇，都能在本书中找到答案。寒冷、满是岩石、没有生命的小卫星，...",
            "grade": "8.0",
            "people": "178",
            "price": "60.00",
            "no": "27054641",
            "detailUrl": "https://book.douban.com/subject/27054641/",
            "createTime": "2019-03-04 17:49:30.0",
            "updateTime": "2019-03-13 22:24:24.0"
        },
        {
            "bookId": "ce70d8d4-3e62-11e9-8f83-1c2b8518ea4c",
            "name": "维多利亚时代的互联网",
            "writer": "[英]汤姆·斯丹迪奇/多绥婷",
            "publisher": "后浪丨江西人民出版社",
            "date": "2017-8",
            "img": "https://img3.doubanio.com/view/subject/m/public/s29483946.jpg",
            "type": 3,
            "introduce": "人类历史上的第一次大连接回顾互联网的前世预言互联网的未来………………※编辑推荐※☆《财富》杂志推荐的75本商务人士必读书之一☆回顾互联网的前世...",
            "grade": "7.9",
            "people": "167",
            "price": "38.00",
            "no": "27078260",
            "detailUrl": "https://book.douban.com/subject/27078260/",
            "createTime": "2019-03-04 17:49:30.0",
            "updateTime": "2019-03-13 22:24:24.0"
        },
        {
            "bookId": "ce7048ba-3e62-11e9-8f83-1c2b8518ea4c",
            "name": "双峰: 神秘史",
            "writer": "[美]马克·弗罗斯特/胡逍扬",
            "publisher": "北京时代华文书局",
            "date": "2017-7-16",
            "img": "https://img1.doubanio.com/view/subject/m/public/s29497457.jpg",
            "type": 1,
            "introduce": "☆殿堂级奇幻佳作，邪典巨制。全彩专色印刷，超过300张图文、100张彩色档案资料，包含共济会秘密图腾、神秘邪恶宗教手记、FBI绝密资料、凶案嫌疑人档案、真实...",
            "grade": "8.4",
            "people": "904",
            "price": "188.00",
            "no": "26981446",
            "detailUrl": "https://book.douban.com/subject/26981446/",
            "createTime": "2019-03-04 17:49:30.0",
            "updateTime": "2019-03-13 22:24:24.0"
        },
        {
            "bookId": "ce722360-3e62-11e9-8f83-1c2b8518ea4c",
            "name": "双峰: 神秘史",
            "writer": "[美]马克·弗罗斯特/胡逍扬",
            "publisher": "北京时代华文书局",
            "date": "2017-7-16",
            "img": "https://img1.doubanio.com/view/subject/m/public/s29497457.jpg",
            "type": 8,
            "introduce": "☆殿堂级奇幻佳作，邪典巨制。全彩专色印刷，超过300张图文、100张彩色档案资料，包含共济会秘密图腾、神秘邪恶宗教手记、FBI绝密资料、凶案嫌疑人档案、真实...",
            "grade": "8.4",
            "people": "904",
            "price": "188.00",
            "no": "26981446",
            "detailUrl": "https://book.douban.com/subject/26981446/",
            "createTime": "2019-03-04 17:49:30.0",
            "updateTime": "2019-03-13 22:24:24.0"
        },
        {
            "bookId": "ce71e724-3e62-11e9-8f83-1c2b8518ea4c",
            "name": "命运攸关的抉择",
            "writer": "[英]伊恩·克肖/顾剑",
            "publisher": "后浪丨浙江人民出版社",
            "date": "2017-7",
            "img": "https://img3.doubanio.com/view/subject/m/public/s29452314.jpg",
            "type": 7,
            "introduce": "作者伊恩·克肖用十个章节的篇幅考察了1940年5月至1941年12月间第二次世界大战中，英国、美国、苏联、德国、意大利和日本等六个主要国家做出的十个互相关联...",
            "grade": "9.0",
            "people": "286",
            "price": "88.00",
            "no": "27046300",
            "detailUrl": "https://book.douban.com/subject/27046300/",
            "createTime": "2019-03-04 17:49:30.0",
            "updateTime": "2019-03-13 22:24:24.0"
        },
        {
            "bookId": "ce723990-3e62-11e9-8f83-1c2b8518ea4c",
            "name": "不可思议的朋友",
            "writer": "[日]田岛征彦/李秀芬",
            "publisher": "北京联合出版公司",
            "date": "2017-7",
            "img": "https://img3.doubanio.com/view/subject/m/public/s29889846.jpg",
            "type": 8,
            "introduce": "第十三届文津奖入围作品豆瓣2017年度高分图书第三名第20届日本绘本奖大奖作品改编自真实故事的自闭症题材绘本.......................",
            "grade": "9.0",
            "people": "1300",
            "price": "45.00",
            "no": "27069925",
            "detailUrl": "https://book.douban.com/subject/27069925/",
            "createTime": "2019-03-04 17:49:30.0",
            "updateTime": "2019-03-13 22:24:24.0"
        },
        {
            "bookId": "ce70472a-3e62-11e9-8f83-1c2b8518ea4c",
            "name": "醒来的女性",
            "writer": "[美]玛丽莲·弗伦奇/余莉",
            "publisher": "未读·文艺家·北京联合出版公司",
            "date": "2017-7",
            "img": "https://img3.doubanio.com/view/subject/m/public/s29469414.jpg",
            "type": 1,
            "introduce": "我们来认识一下米拉。她是一位喜爱读书的小镇女孩，从小就是个独立而聪明的孩子。她十四岁读尼采和潘恩，开学第一天就学完了全部课本，学校只得让她跳级。可这是二十...",
            "grade": "8.8",
            "people": "1942",
            "price": "90.00",
            "no": "27042344",
            "detailUrl": "https://book.douban.com/subject/27042344/",
            "createTime": "2019-03-04 17:49:30.0",
            "updateTime": "2019-03-13 22:24:24.0"
        },
        {
            "bookId": "ce7220ae-3e62-11e9-8f83-1c2b8518ea4c",
            "name": "醒来的女性",
            "writer": "[美]玛丽莲·弗伦奇/余莉",
            "publisher": "未读·文艺家·北京联合出版公司",
            "date": "2017-7",
            "img": "https://img3.doubanio.com/view/subject/m/public/s29469414.jpg",
            "type": 8,
            "introduce": "我们来认识一下米拉。她是一位喜爱读书的小镇女孩，从小就是个独立而聪明的孩子。她十四岁读尼采和潘恩，开学第一天就学完了全部课本，学校只得让她跳级。可这是二十...",
            "grade": "8.8",
            "people": "1942",
            "price": "90.00",
            "no": "27042344",
            "detailUrl": "https://book.douban.com/subject/27042344/",
            "createTime": "2019-03-04 17:49:30.0",
            "updateTime": "2019-03-13 22:24:24.0"
        },
        {
            "bookId": "ce71b75e-3e62-11e9-8f83-1c2b8518ea4c",
            "name": "吴清源回忆录",
            "writer": "[日]吴清源/陈翰希",
            "publisher": "后浪丨北京联合出版公司",
            "date": "2017-7",
            "img": "https://img3.doubanio.com/view/subject/m/public/s29451584.jpg",
            "type": 6,
            "introduce": "本书写于吴清源先生七十岁引退之际。在本书中，吴清源回忆了从出生、丧父、东渡日本，到扬名日本棋界、开创“新布局”、在十五年间将日本超一流棋士悉数降级的动荡而充...",
            "grade": "8.6",
            "people": "494",
            "price": "42.00",
            "no": "27045564",
            "detailUrl": "https://book.douban.com/subject/27045564/",
            "createTime": "2019-03-04 17:49:30.0",
            "updateTime": "2019-03-13 22:24:24.0"
        },
        {
            "bookId": "ce71d734-3e62-11e9-8f83-1c2b8518ea4c",
            "name": "音乐与情感",
            "writer": "[美]查尔斯·罗森/罗逍然",
            "publisher": "浙江大学出版社·启真馆",
            "date": "2017-7",
            "img": "https://img3.doubanio.com/view/subject/m/public/s29491645.jpg",
            "type": 6,
            "introduce": "本书是著名钢琴家、文艺批评家查尔斯•罗森谈音乐何以动人心弦的一本书。罗森从乐理出发，结合自身丰富的演奏经验，清晰、有条理地解释了音乐怎样对人的情感带来波动，...",
            "grade": "8.5",
            "people": "97",
            "price": "39.00",
            "no": "27085617",
            "detailUrl": "https://book.douban.com/subject/27085617/",
            "createTime": "2019-03-04 17:49:30.0",
            "updateTime": "2019-03-13 22:24:24.0"
        },
        {
            "bookId": "ce7296b0-3e62-11e9-8f83-1c2b8518ea4c",
            "name": "厨艺的常识",
            "writer": "[美]迈克尔·鲁尔曼著、唐娜·鲁尔曼摄/潘昱均",
            "publisher": "后浪丨江西人民出版社",
            "date": "2017-7",
            "img": "https://img1.doubanio.com/view/subject/m/public/s29520918.jpg",
            "type": 11,
            "introduce": "下厨前一定要学会的现代烹调基本原理只需掌握20个核心技法，就能变化出做菜的无尽可能！饮食作家庄祖宜、韩良忆诚意推荐.....................",
            "grade": "8.5",
            "people": "306",
            "price": "80.00",
            "no": "27029478",
            "detailUrl": "https://book.douban.com/subject/27029478/",
            "createTime": "2019-03-04 17:49:30.0",
            "updateTime": "2019-03-13 22:24:24.0"
        },
        {
            "bookId": "ce7084a6-3e62-11e9-8f83-1c2b8518ea4c",
            "name": "七根凶简",
            "writer": "尾鱼",
            "publisher": "中国友谊出版公司",
            "date": "2017-7",
            "img": "https://img1.doubanio.com/view/subject/m/public/s29460229.jpg",
            "type": 1,
            "introduce": "上古之时，有七则恶念，凡接触之人，总会心性突变，犯下不赦命案。老子西出函谷关时，引七则恶念于七根木简，并以凤凰鸾扣封印，从此天下太平。但谁料凶简会再次流...",
            "grade": "8.0",
            "people": "3273",
            "price": "39.80",
            "no": "27035382",
            "detailUrl": "https://book.douban.com/subject/27035382/",
            "createTime": "2019-03-04 17:49:30.0",
            "updateTime": "2019-03-13 22:24:24.0"
        },
        {
            "bookId": "ce71ab10-3e62-11e9-8f83-1c2b8518ea4c",
            "name": "父母：挑战",
            "writer": "[美]鲁道夫•德雷克斯/花莹莹",
            "publisher": "生活•读书•新知三联书店生活书店出版有限公司",
            "date": "2017-6-15",
            "img": "https://img1.doubanio.com/view/subject/m/public/s29498208.jpg",
            "type": 5,
            "introduce": "三联书店畅销20万的儿童心理学奠基之作《孩子：挑战》正统姊妹篇！父母是未来的基础，我们可以成为更好的父母全球畅销60多年的教育心理学经典《父母：挑战》...",
            "grade": "8.5",
            "people": "80",
            "price": "49.00",
            "no": "27060577",
            "detailUrl": "https://book.douban.com/subject/27060577/",
            "createTime": "2019-03-04 17:49:30.0",
            "updateTime": "2019-03-13 22:24:24.0"
        },
        {
            "bookId": "ce70d122-3e62-11e9-8f83-1c2b8518ea4c",
            "name": "无人驾驶",
            "writer": "[美]胡迪·利普森、[美]梅尔芭·库曼/林露茵、金阳",
            "publisher": "文汇出版社",
            "date": "2017-6-15",
            "img": "https://img3.doubanio.com/view/subject/m/public/s29464920.jpg",
            "type": 3,
            "introduce": "你初次拥有的智能机器人，很可能就是你的汽车，你会把自己的性命交给它！随着无人驾驶技术普及，在车上可以聚会、吃饭、工作、长期居住，人类的时空观念将被改变；停...",
            "grade": "8.0",
            "people": "266",
            "price": "58.00",
            "no": "27058912",
            "detailUrl": "https://book.douban.com/subject/27058912/",
            "createTime": "2019-03-04 17:49:30.0",
            "updateTime": "2019-03-13 22:24:24.0"
        },
        {
            "bookId": "ce708db6-3e62-11e9-8f83-1c2b8518ea4c",
            "name": "幽灵",
            "writer": "[挪]尤·奈斯博/林立仁",
            "publisher": "博集天卷|湖南文艺出版社",
            "date": "2017-6-10",
            "img": "https://img3.doubanio.com/view/subject/m/public/s29450044.jpg",
            "type": 1,
            "introduce": "▶两个孤独少年×一位孤勇警探，如父如子的亲情，失而复得的挚爱，触不可及的未来▶全球销量突破3300万册，北欧悬疑小说天王尤•奈斯博《猎豹》之后再创销...",
            "grade": "8.5",
            "people": "2533",
            "price": "42.00",
            "no": "27042830",
            "detailUrl": "https://book.douban.com/subject/27042830/",
            "createTime": "2019-03-04 17:49:30.0",
            "updateTime": "2019-03-13 22:24:24.0"
        }
    ]
}
```