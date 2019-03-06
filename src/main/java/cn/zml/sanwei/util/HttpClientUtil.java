package cn.zml.sanwei.util;

import cn.zml.sanwei.model.BookDetailComments;
import cn.zml.sanwei.model.Comment;
import cn.zml.sanwei.model.Detail;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static cn.zml.sanwei.common.Constant.TWO;


/**
 * 获取图书信息工具类
 * 使用httpclient请求网页
 * 使用jsoup解析返回内容
 * @author nanbei
 */
public class HttpClientUtil {

    /**
     * 使用Jsoup解析网页信息
     * @param bookDetailComments book传输类实体，用于detail和comments的赋值
     * @return 返回BookDetailComments对象
     * @throws IOException
     */
    public static BookDetailComments getDetailAndComments(BookDetailComments bookDetailComments) throws IOException {
        Document doc = Jsoup.parse(HttpClientUtil.doPost(bookDetailComments.getDetailUrl()));
        //获取内容简介
        Element content = doc.getElementById("link-report");
        //获取作者简介
        String writer = null;
        Elements writerElements = doc.getElementsByClass("intro");
        if (writerElements.size() < TWO) {
            writer = null;
        } else {
            writer = writerElements.get(1).text().replaceAll(" ", "\n");
        }
        //获取目录
        int len = bookDetailComments.getDetailUrl().length();
        //豆瓣图书的序号
        String no = bookDetailComments.getDetailUrl().substring("https://book.douban.com/subject/".length(), len - 1);
        String contentId = "dir_" + no + "_full";
        Element catalogElement = doc.getElementById(contentId);
        //目录
        String catalog = "";
        if (catalogElement != null) {
            List<TextNode> catalogs = catalogElement.textNodes();
            for (TextNode node : catalogs) {
                catalog += node.text() + "\n";
            }
        }
        //新建Detail对象
        Detail detail = new Detail();
        detail.setBookId(bookDetailComments.getBookId());
        detail.setDetailId(UUID.randomUUID().toString());
        detail.setContent(content == null ? null : content.text());
        detail.setWriter(writer);
        detail.setCatalog(catalog);
        bookDetailComments.setDetail(detail);
        //获取书评
        Elements commentsPart = doc.getElementsByClass("comments by_rank");
        if (commentsPart == null || commentsPart.size() == 0) {
            System.out.println("无书评 ----- " + bookDetailComments.getName() + " - ID=" + bookDetailComments.getBookId());
        } else {
            commentsPart = commentsPart.get(0).getElementsByClass("ctsh clearfix");
        }
        for (Element e : commentsPart) {
            //书评用户信息
            Element userElement = e.getElementsByClass("user").get(0);
            String userName = userElement.getElementsByTag("a").get(0).text();
            //评分
            Element gradeElement = e.getElementsByTag("span").get(0);
            String commentGrade = gradeElement.attr("title");
            //评论内容
            Elements contentElement = e.getElementsByClass("short").get(0).getElementsByTag("span");
            String commentContent = contentElement.get(0).text();
            //评论时间
            int dateIndex = 0;
            if (contentElement.size() == 3 || contentElement.size() == 2) {
                dateIndex = 1;
            } else if (contentElement.size() == 4) {
                dateIndex = 2;
            }
            String commentDate = contentElement.get(dateIndex).text();
            Comment comment = new Comment(bookDetailComments.getBookId(), userName, commentContent, commentDate, commentGrade);
            bookDetailComments.getComments().add(comment);
        }
        return bookDetailComments;
    }

    public static String doPost(String url) throws IOException {
        String result = null;
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        HttpResponse response = httpClient.execute(httpPost);
        if (response != null) {
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                result = EntityUtils.toString(resEntity, "utf8");
            }
        }
        return result;
    }
}
