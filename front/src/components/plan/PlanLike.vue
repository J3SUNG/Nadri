<template>
  <div class="like-plan">
    <h2 class="like-plan__title">찜한 여행노트</h2>
    <div class="like-plan__box">
      <ul class="like-paln__box-small">
        <li
          class="like-plan__my-plan like-plan__my-plan-on"
          v-for="item in list"
          :key="item.planNo"
          @click="movePlanDetail(item.planNo)"
        >
          <img class="like-plan__img" :src="item.img" />
          <div class="like-plan__main">
            <div class="like-plan__main__top">
              <img class="like-plan__main-img" src="@/assets/location-pin.png" />
              <h3 class="like-plan__main-title">{{ item.subject }}</h3>
            </div>
            <div class="like-plan__main__bottom">
              <div class="like-plan__main__bottom__main">
                <img class="like-plan__user-img" :src="item.imgUrl" />
                <div class="like-plan__main__bottom__main__right">
                  <p class="like-plan__main__bottom__main__right-loc">{{ item.loc }}</p>
                  <p class="like-plan__main__bottom__main__right-user">{{ item.nickname }}</p>
                </div>
              </div>
            </div>
          </div>
        </li>
        <li class="like-plan__my-plan like-plan__my-plan-none" v-if="!isLikePlan[0]">
          <p>찜한 내용이 없습니다.</p>
        </li>
        <li class="like-plan__my-plan like-plan__my-plan-none" v-if="!isLikePlan[1]">
          <p>찜한 내용이 없습니다.</p>
        </li>
        <li class="like-plan__my-plan like-plan__my-plan-none" v-if="!isLikePlan[2]">
          <p>찜한 내용이 없습니다.</p>
        </li>
        <li class="like-plan__save-plan">
          <img class="like-plan__save-plan__icon" src="@/assets/favorite.png" />
          <div class="like-plan__save-plan__text">
            <h3 class="like-plan__save-plan__text-title">내가 찜한 여행노트</h3>
            <p class="like-plan__save-plan__text-sub">최근 좋아요 누른 여행노트를 한눈에..!</p>
          </div>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import http from "@/util/http-common";
import { mapState } from "vuex";

const memberStore = "memberStore";
export default {
  components: {},
  name: "LikePlan",
  computed: {
    ...mapState(memberStore, ["userInfo"]),
  },
  data() {
    return {
      list: "",
      userNo: 0,
      isLogin: false,
      isLikePlan: [false, false, false],
    };
  },
  methods: {
    loadImg() {
      this.baseUrl = `${process.env.VUE_APP_API_BASE_URL}`;
      for (let i = 0; i < this.list.length; ++i) {
        this.imgUrl = `${this.baseUrl}/image/showImage?saveFolder=${this.list[i].imgSaveFolder}&saveFile=${this.list[i].imgSaveFile}`;
        this.list[i].imgUrl = this.imgUrl;
      }
    },
    movePlanDetail(num) {
      this.$router.push({ name: "AppPlanDetail", params: { planNo: num } });
    },
  },
  created() {
    if (this.userInfo !== null) {
      this.userNo = this.userInfo.userNo;
      http.get(`plan/mylikelist/${this.userNo}`).then((response) => {
        this.list = response.data;
        this.loadImg();
        console.log(this.list);

        if (this.list.length === 0) {
          this.isLikePlan = [false, false, false];
        } else if (this.list.length === 1) {
          this.isLikePlan = [true, false, false];
        } else if (this.list.length === 2) {
          this.isLikePlan = [true, true, false];
        } else {
          this.isLikePlan = [true, true, true];
        }
      });
    }
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
  color: var(--color-black);
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
.like-plan__my-plan-on {
  cursor: pointer;
}
.like-plan__my-plan-none {
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: var(--color-week2);
}
.like-plan__my-plan-none p {
  font-size: 22px;
}
.like-plan__img {
  height: 100%;
  min-width: 140px;
  max-width: 140px;
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
