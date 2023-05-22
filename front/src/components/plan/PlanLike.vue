<template>
  <div class="like-plan">
    <h2 class="like-plan__title">찜한 여행노트</h2>
    <div class="like-plan__box">
      <ul class="like-paln__box-small">
        <li class="like-plan__my-plan" v-for="item in list" :key="item.planNo">
          <img class="like-plan__img" :src="item.img" />
          <div class="like-plan__main">
            <div class="like-plan__main__top">
              <img class="like-plan__main-img" src="@/assets/location-pin.png" />
              <h3 class="like-plan__main-title">{{ item.subject }}</h3>
            </div>
            <div class="like-plan__main__bottom">
              <div class="like-plan__main__bottom__main">
                <img class="like-plan__user-img" src="@/assets/jetty.jpg" />
                <div class="like-plan__main__bottom__main__right">
                  <p class="like-plan__main__bottom__main__right-loc">{{ item.loc }}</p>
                  <p class="like-plan__main__bottom__main__right-user">{{ item.nickname }}</p>
                </div>
              </div>
            </div>
          </div>
        </li>
        <li class="like-plan__save-plan">
          <img class="like-plan__save-plan__icon" src="@/assets/favorite.png" />
          <div class="like-plan__save-plan__text">
            <h3 class="like-plan__save-plan__text-title">내가 찜한 여행노트</h3>
            <p class="like-plan__save-plan__text-sub">좋아요 누른 여행노트를 한눈에..!</p>
          </div>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: "LikePlan",
  data() {
    return {
      list: {
        0: {
          img: require("@/assets/dummy3.jpg"),
          subject: "백두산 여행",
          loc: "백두산",
          nickname: "jetty",
          planNo: 0,
        },
        1: {
          img: require("@/assets/dummy4.jpg"),
          subject: "여행가자",
          loc: "서울",
          nickname: "jetty",
          planNo: 1,
        },
        2: {
          img: require("@/assets/dummy5.jpg"),
          subject: "배낭여행",
          loc: "전주",
          nickname: "jetty",
          planNo: 2,
        },
      },
    };
  },
};
</script>

<style>
.like-plan {
  width: 440px;
  height: 440px;
}
.like-plan__title {
  width: 100%;
  height: 10%;
  text-align: left;
}
.like-plan__box {
  width: 100%;
  height: 90%;
  display: flex;
  position: relative;
}
.like-paln__box-small {
  width: 100%;
  display: flex;
  justify-content: space-between;
  flex-direction: column;
}
.like-plan__my-plan {
  width: 100%;
  height: 23%;
  display: flex;
  padding-bottom: 3px;
  border-bottom: 1px solid var(--color-lightgray);
}
.like-plan__img {
  height: 100%;
  width: 140px;
}
.like-plan__main {
  display: flex;
  flex-direction: column;
  margin-left: 20px;
  width: 100%;
}
.like-plan__main__top {
  display: flex;
  align-items: center;
  height: 40%;
  border-bottom: 2px dotted var(--color-lightgray);
}
.like-plan__main-img {
  width: 20px;
  height: 20px;
  margin-right: 10px;
}
.like-plan__user-img {
  width: 36px;
  height: 36px;
  border-radius: 70px;
  margin-right: 10px;
}
.like-plan__main__bottom {
  height: 60%;
  display: flex;
}
.like-plan__main__bottom__hr {
  width: 100%;
}
.like-plan__main__bottom__main {
  display: flex;
  align-items: center;
}
.like-plan__main__bottom__main__right-loc {
  text-align: left;
  font-size: 14px;
}
.like-plan__main__bottom__main__right-user {
  text-align: left;
  font-size: 12px;
}
.like-plan__save-plan {
  width: 100%;
  height: 24%;
  background-color: salmon;
  display: flex;
  align-items: center;
}
.like-plan__save-plan__icon {
  margin-left: 20px;
  width: 50px;
  height: 50px;
}
.like-plan__save-plan__text {
  display: flex;
  flex-direction: column;
  text-align: left;
  width: 100%;
  justify-content: center;
  margin-left: 16px;
}
.like-plan__save-plan__text h3,
.like-plan__save-plan__text p {
  color: var(--color-white);
}
.like-plan__save-plan__text-title {
  font-size: 22px;
}
.like-plan__save-plan__text-sub {
  font-size: 12px;
}
</style>
