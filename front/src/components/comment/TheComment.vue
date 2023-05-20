<template>
  <div class="comment">
    <img class="comment__writer-img" :src="comment.img" />
    <div class="comment__main">
      <div class="comment__up">
        <p class="comment__writer-nickname">{{ itemData.nickname }}</p>
        <p class="comment__createtime">{{ itemData.createTime }}</p>
      </div>
      <div class="comment__down"></div>
      <p class="comment__content">{{ itemData.content }}</p>
    </div>
  </div>
</template>

<script>
export default {
  name: "TheComment",
  data() {
    return {
      comment: {
        img: require("@/assets/jetty.jpg"),
        nickname: "제티",
        createtime: "2023-05-18",
        content: "우유엔 제티 초코지!",
      },
    };
  },
  props: ["itemData"],
};
</script>

<style>
.comment {
  height: 100px;
  width: calc(100%-40px);
  display: flex;
  align-items: center;
  margin: 0px;
  padding: 0px 20px;
  border-bottom: 2px solid var(--color-lightwhite);
}
.comment__writer-img {
  width: 50px;
  height: 50px;
  border-radius: 70px;
  margin-right: 20px;
}
.comment__main {
  display: flex;
  flex-direction: column;
}
.comment__up {
  display: flex;
  margin-bottom: 10px;
  align-items: center;
}
.comment__writer-nickname {
  font-size: 18px;
  margin-right: 20px;
}
.comment__down {
  display: flex;
}
</style>
