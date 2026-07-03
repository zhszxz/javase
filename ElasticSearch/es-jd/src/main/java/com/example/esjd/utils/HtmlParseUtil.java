package com.example.esjd.utils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HtmlParseUtil {

    static class Product {
        String title;
        String price;
        String imgUrl;

        @Override
        public String toString() {
            return "商品标题: " + title + "\n价格: " + price + "\n图片: " + imgUrl + "\n";
        }
    }

    public static void main(String[] args) throws Exception {
        List<Product> products = crawlJD("java");
        products.forEach(System.out::println);
    }

    public static List<Product> crawlJD(String keyword) throws IOException {
        List<Product> list = new ArrayList<>();
        String url = "https://search.jd.com/Search?keyword=" + keyword + "&enc=utf-8";

        // 1️⃣ 获取HTML
        Document doc = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0 Safari/537.36")
                .timeout(10000)
                .get();

        // 2️⃣ 解析商品列表
        Elements goods = doc.getElementsByClass("_main_1tgyq_2");
        System.out.println(doc.text());
        List<String> skuList = new ArrayList<>();

        for (Element g : goods) {
            Product p = new Product();
            p.title = g.select(".p-name em").text();
            p.imgUrl = "https:" + g.select(".p-img img").attr("data-lazy-img");
            if (p.imgUrl.equals("https:")) { // 若图片懒加载属性不同
                p.imgUrl = "https:" + g.select(".p-img img").attr("src");
            }
            String sku = g.attr("data-sku");
            skuList.add(sku);
            list.add(p);
        }

        // 3️⃣ 获取价格（通过接口）
        if (!skuList.isEmpty()) {
            String skuParam = String.join(",", skuList);
            String priceUrl = "https://p.3.cn/prices/mgets?skuIds=" +
                    skuList.stream().map(s -> "J_" + s).reduce((a, b) -> a + "," + b).get();

            String json = Jsoup.connect(priceUrl)
                    .ignoreContentType(true)
                    .userAgent("Mozilla/5.0")
                    .get().text();

            JSONArray arr = JSONArray.parseArray(json);
            for (int i = 0; i < arr.size() && i < list.size(); i++) {
                JSONObject obj = arr.getJSONObject(i);
                list.get(i).price = obj.getString("p");
            }
        }

        return list;
    }
}
