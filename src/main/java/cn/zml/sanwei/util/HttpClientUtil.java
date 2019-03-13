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

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
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

    /**
     * 使用URLConnection下载文件或图片并保存到本地
     * @param urlString img路径地址
     * @param filename 文件名
     * @throws Exception
     */
    public static void downloadImg(String urlString, String filename) throws Exception {
        // 构造URL
        URL url = new URL(urlString);
        // 打开连接
        URLConnection con = url.openConnection();
        // 输入流
        InputStream is = con.getInputStream();
        // 1K的数据缓冲
        byte[] bs = new byte[1024];
        // 读取到的数据长度
        int len;
        // 输出的文件流
        OutputStream os = new FileOutputStream(filename);
        // 开始读取
        while ((len = is.read(bs)) != -1) {
            os.write(bs, 0, len);
        }
        // 完毕，关闭所有链接
        os.close();
        is.close();
    }
}
