<template>
  <div class="crawling-info">
    <p>asdfjdshakfjasdkjf</p>
    <img class="test" :src="news[0].image" />
  </div>
</template>

<script>
import axios from "axios";
import cheerio from "cheerio";
export default {
  name: "CrawlingInfo",
  data() {
    return {
      news: [],
      url: "https://search.naver.com/search.naver?sm=tab_hty.top&where=news&query=%EC%97%AC%ED%96%89+%ED%96%89%EC%82%AC+%EC%9D%B4%EB%B2%A4%ED%8A%B8+%EA%B4%80%EA%B4%91%EC%A7%80&oquery=%EC%97%AC%ED%96%89+%ED%96%89%EC%82%AC+%EC%9D%B4%EB%B2%A4%ED%8A%B8&tqi=ibHARlp0Jy0ssapbDDGssssst2h-240587",
    };
  },
  created() {
    const getHtml = async () => {
      try {
        // 1
        const html = await axios.get(this.url);
        const $ = cheerio.load(html.data);
        const bodyList = $(".list_news li.bx");
        bodyList.map((i, element) => {
          console.log(element);
          this.news[i] = {
            title: $(element).find("a.news_tit").text(),
            url: $(element).find("a.news_tit").attr("href"),
            img: $(element).find("dsc_thumb img").attr("src"),
          };
        });
        console.log("bodyList : ", this.news);
      } catch (error) {
        console.error(error);
      }
    };

    getHtml();
  },
};
</script>

<style>
.test {
  background-color: red;
  width: 500px;
  height: 500px;
}
</style>
