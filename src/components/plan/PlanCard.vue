<template>
  <div class="plan__card">
    <div class="plan__card__header">
      <img class="plan__img" :src="planImg" />
    </div>
    <hr class="plan__card__hr" />
    <div class="plan__card__body">
      <img class="plan__writer_img" :src="img" />
      <div class="plan__card__header__text">
        <h3 class="plan__card__title">{{ itemData.subject }}</h3>
        <p class="plan__card__writer">{{ itemData.nickname }}, {{ itemData.createTime }}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "BoardCard",
  data() {
    return {
      planImg:
        "https://www.kagoshima-kankou.com/storage/tourism_themes/12/responsive_images/ElwnvZ2u5uZda7Pjcwlk4mMtr08kLNydT8zXA6Ie__1673_1115.jpeg",
      img: require("@/assets/jetty.jpg"),
      itemData: {
        subject: "제티와 함께하는 산책산책산책산책산책",
        nickname: "jetty",
        createTime: "2023-05-16 15:17",
      },
    };
  },
  // data() {
  //   return {
  //     img: require("@/assets/jetty.jpg"),
  //   };
  // },
  // props: ["itemData"],
};
</script>

<style>
.plan__card {
  width: 240px;
  height: 300px;
  border: 1px solid var(--color8-black);
  box-shadow: 0px 0px 5px var(--color6-darkgray);
  margin-left: 50px;
  margin-bottom: 40px;
  display: flex;
  flex-direction: column;
  border-radius: 20px;
  background-color: var(--color5-white);
  transition: all 0.1s linear;
  font-size: 12px;
  text-align: left;
  cursor: pointer;
}
.plan__card:hover {
  transform: scale(1.04);
}
.plan__card__header {
  display: flex;
  flex-direction: column;
  margin: 20px 20px 10px 20px;
}
.plan__card__hr {
  width: 80%;
  margin: 0px 10%;
}
.plan__card__header__text {
  display: flex;
  margin-left: 20px;
  margin-right: 20px;
  flex-direction: column;
  text-align: left;
}
.plan__img {
  width: 200px;
  height: 200px;
}
.plan__card__title {
  width: 140px;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
.plan__writer_img {
  width: 40px;
  height: 40px;
  border-radius: 70%;
}
.plan__card__body {
  display: flex;
  align-items: center;
  margin: 10px 20px 0 20px;
}
</style>
