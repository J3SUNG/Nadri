<template>
  <div class="popular-place-month">
    <div class="popular-place-month__main__visited">
      <h2 class="popular-place-month__main__visited__title">월간 인기 관광지</h2>
      <div class="popular-place-month__visited__slideShow">
        <ul class="popular-place-month__visited__slides" :style="`left:${this.left}`">
          <li v-for="item in plans" :key="item.planNo"><plan-card :itemData="item" /></li>
        </ul>
        <p class="popular-place-month__visited__controller">
          <img
            src="@/assets/next.png"
            class="popular-place-month__visited__prev"
            @click="moveLeft"
          />
          <img
            src="@/assets/next.png"
            class="popular-place-month__visited__next"
            @click="moveRight"
          />
        </p>
      </div>
    </div>
  </div>
</template>

<script>
import PlanCard from "@/components/plan/PlanCard.vue";
export default {
  name: "PopularPlaceMonth",
  data() {
    return {
      left: 0,
      currentIdx: 0, //현재 슬라이드 index
      slideCount: 3, // 슬라이드 개수

      plans: {
        0: {
          content: "멋진 여행계획을 만들어봤습니다.",
          createTime: "2023-05-16 17:27:01",
          endDate: "2023-06-23 17:27:01",
          image1: "http://tong.visitkorea.or.kr/cms/resource/96/2690196_image2_1.jpg",
          isLike: 1,
          likeCount: 11,
          nickname: "예삐",
          planNo: 1,
          readCount: 13,
          startDate: "2023-06-16 17:27:01",
          subject: "첫번째 여행계획",
          trips: null,
          userNo: 1,
        },
        1: {
          content: "멋진 여행계획을 만들어봤습니다.",
          createTime: "2023-05-16 17:27:01",
          endDate: "2023-06-23 17:27:01",
          image1: "http://tong.visitkorea.or.kr/cms/resource/96/2690196_image2_1.jpg",
          isLike: 1,
          likeCount: 11,
          nickname: "예삐",
          planNo: 2,
          readCount: 13,
          startDate: "2023-06-16 17:27:01",
          subject: "첫번째 여행계획",
          trips: null,
          userNo: 1,
        },
        2: {
          content: "멋진 여행계획을 만들어봤습니다.",
          createTime: "2023-05-16 17:27:01",
          endDate: "2023-06-23 17:27:01",
          image1: "http://tong.visitkorea.or.kr/cms/resource/96/2690196_image2_1.jpg",
          isLike: 1,
          likeCount: 11,
          nickname: "예삐",
          planNo: 3,
          readCount: 13,
          startDate: "2023-06-16 17:27:01",
          subject: "첫번째 여행계획",
          trips: null,
          userNo: 1,
        },
        4: {
          content: "멋진 여행계획을 만들어봤습니다.",
          createTime: "2023-05-16 17:27:01",
          endDate: "2023-06-23 17:27:01",
          image1: "http://tong.visitkorea.or.kr/cms/resource/96/2690196_image2_1.jpg",
          isLike: 1,
          likeCount: 11,
          nickname: "예삐",
          planNo: 4,
          readCount: 13,
          startDate: "2023-06-16 17:27:01",
          subject: "첫번째 여행계획",
          trips: null,
          userNo: 1,
        },
        5: {
          content: "멋진 여행계획을 만들어봤습니다.",
          createTime: "2023-05-16 17:27:01",
          endDate: "2023-06-23 17:27:01",
          image1: "http://tong.visitkorea.or.kr/cms/resource/96/2690196_image2_1.jpg",
          isLike: 1,
          likeCount: 11,
          nickname: "예삐",
          planNo: 5,
          readCount: 13,
          startDate: "2023-06-16 17:27:01",
          subject: "첫번째 여행계획",
          trips: null,
          userNo: 1,
        },
      },
    };
  },
  methods: {
    moveUserUpdate() {
      this.$router.push({ name: "AppUserUpdate" });
    },
    //
    moveSlide(num) {
      this.left = -num * 370 + "px";
      this.currentIdx = num;
    },
    moveLeft() {
      if (this.currentIdx !== 0) this.moveSlide(this.currentIdx - 1);
    },
    moveRight() {
      if (this.currentIdx !== this.slideCount - 1) {
        this.moveSlide(this.currentIdx + 1);
      }
    },
  },
  components: {
    PlanCard,
  },
};
</script>

<style>
.popular-place-month__main__visited {
  /* opacity: 0;
  animation: fadeInUp 0.5s;
  animation-delay: 0.5s;
  animation-fill-mode: forwards; */
}
.popular-place-month__main__visited__title {
  text-align: left;
  margin-bottom: 10px;
  margin-left: 20px;
}
.popular-place-month__main__visited .popular-place-month__card {
  margin: 10px 0 0 0;
  padding: 0px;
}
@keyframes fadeInUp {
  0% {
    opacity: 0;
    transform: translate3d(0, 10%, 0);
  }
  to {
    opacity: 1;
    transform: translateZ(0);
  }
}
/* slide */
.popular-place-month__visited__slideShow {
  width: 100%;
  height: 400px;
  position: relative;
  overflow: hidden;
}
.popular-place-month__visited__slides {
  position: absolute;
  left: 0;
  top: 0;
  width: 2000px;
  transition: left 0.3s ease-out;
}
.popular-place-month__visited__slides .plan__card {
  margin: 10px 30px 0 0px;
}
.popular-place-month__visited__slides li:first-child {
  margin-left: 30px;
}
.popular-place-month__visited__slides li:child {
  margin-right: 25px;
}
.popular-place-month__visited__slides li:not(:child) {
  float: left;
  margin-right: 20px;
}
.popular-place-month__visited__slides li {
  float: left;
}
.popular-place-month__visited__controller img {
  position: absolute;
  background-color: transparent;
  color: black;
  text-align: center;
  top: 50%;
  cursor: pointer;
}
.popular-place-month__visited__prev {
  width: 40px;
  height: 40px;
  left: 0px;
  backdrop-filter: brightness(90%);
  border-radius: 70px;
}
.popular-place-month__visited__prev:hover {
  backdrop-filter: brightness(70%);
}
.popular-place-month__visited__next {
  width: 40px;
  height: 40px;
  right: 0px;
  backdrop-filter: brightness(90%);
  border-radius: 70px;
  transform: rotate(180deg);
}
.popular-place-month__visited__next:hover {
  backdrop-filter: brightness(70%);
  transform: rotate(180deg);
}
</style>
