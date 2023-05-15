<template>
  <div class="board__card">
    <div class="board__card__header">
      <img class="board__writer_img" :src="cardData.img" />
      <div class="board__card__header__text">
        <h3 class="board__card__title">{{ itemData.subject }}</h3>
        <p class="board__card__writer">{{ itemData.userName }}, {{ itemData.createTime }}</p>
      </div>
    </div>
    <hr class="board__card__hr" />
    <div class="board__card__body">
      <p class="board__card__content">
        {{ itemData.content }}
      </p>
    </div>
  </div>
</template>

<script>
export default {
  name: "BoardCard",
  data() {
    return {
      cardData: {
        img: require("@/assets/jetty.jpg"),
        title:
          "제티는 짖어요제티는 짖어요제티는 짖어요제티는 짖어요제티는 짖어요제티는 짖어요제티는 짖어요",
        writer: "Jetty",
        createTime: "2023-05-15",
        content:
          "왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈왈",
      },
    };
  },
  props: ["itemData"],
};
</script>

<style>
.board__card {
  width: 280px;
  height: 160px;
  border: 1px solid var(--color8-black);
  box-shadow: 0px 0px 5px var(--color6-darkgray);
  margin-left: 50px;
  margin-bottom: 20px;
  display: flex;
  flex-direction: column;
  border-radius: 20px;
  background-color: var(--color5-white);
  transition: all 0.1s linear;
  font-size: 12px;
}
.board__card:hover {
  transform: scale(1.05);
}
.board__card:hover ~ * {
  transform: scale(0.95);
}
.board__card__header {
  display: flex;
  align-items: center;
  margin: 20px 20px 10px 20px;
}
.board__card__header__text {
  display: flex;
  margin-left: 20px;
  margin-right: 20px;
  flex-direction: column;
  text-align: left;
}
.board__card__title {
  width: 160px;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
.board__writer_img {
  width: 50px;
  height: 50px;
  border-radius: 70%;
}
.board__card__hr {
  width: 90%;
  margin-left: 5%;
  margin-right: 5%;
}
.board__card__body {
  display: flex;
  align-items: center;
  margin: 10px 20px 0 20px;
}
.board__card__content {
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: normal;
  line-height: 1.2;
  height: 2.4em;
  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
}
</style>
