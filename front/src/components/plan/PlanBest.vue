<template>
  <div class="best-plan">
    <h2 class="best-plan__title">BEST 여행노트</h2>
    <div class="best-plan__slideShow">
      <ul class="best-plan__slides" :style="`left:${left}`">
        <li v-for="item in plan" :key="item.attrNo">
          <div class="best-plan__img__box">
            <img class="best-plan__img" :src="item.img" />
            <div class="best-plan__box-right">
              <h3 class="best-plan__box-title">여행코스소개</h3>
              <hr class="best-plan__box-hr" />
              <ul class="best-plan__course-box">
                 <li
                  class="best-plan__course"
                  v-for="(courseItem, index) in item.course"
                  :key="courseItem.attr_no"
                >
                  <p class="best-plan__course-no">{{ index }}</p>
                  <p class="best-plan__course-loc">{{ courseItem.loc }}</p>
                </li> 
              </ul>
              <hr class="best-plan__footer-hr" />
              <div class="best-plan__footer">
                <img class="best-plan__footer-img" src="@/assets/jetty.jpg" />
                <div class="best-plan__footer-right">
                  <p class="best-plan__footer-nickname">{{ item.nickname }}</p>
                  <p class="best-plan__footer-createtime">{{ item.createtime }}</p>
                </div>
              </div>
            </div>
          </div>
        </li>
      </ul>
      <p class="best-plan__controller">
        <img src="@/assets/next.png" class="best-plan__prev" @click="moveLeft" />
        <img src="@/assets/next.png" class="best-plan__next" @click="moveRight" />
      </p>
    </div>    
  </div>
</template>

<script>
export default {
  name: "BestPlan",
  data() {
    return {
      left: 0,
      currentIdx: 0, //현재 슬라이드 index
      slideCount: 2, // 슬라이드 개수
      index: 0,
      plan: {
        0: {
          course: {
            0: {
              attr_no: 1,
              loc: "해운대 해수욕장",
            },
            1: {
              attr_no: 2,
              loc: "해운대 식당",
            },
            2: {
              attr_no: 3,
              loc: "해운대 카페",
            },
            3: {
              attr_no: 4,
              loc: "해운대 횟집",
            },
            4: {
              attr_no: 5,
              loc: "해운대 숙소",
            },
            5: {
              attr_no: 6,
              loc: "해운대 숙소",
            },
            6: {
              attr_no: 7,
              loc: "해운대 숙소",
            },
            7: {
              attr_no: 8,
              loc: "해운대 숙소",
            },
            8: {
              attr_no: 9,
              loc: "해운대 숙소",
            },
            9: {
              attr_no: 10,
              loc: "해운대 숙소",
            },
          },
          createtime: "2023-05-20 21:20",
          nickname: "jetty",
          img: require("@/assets/dummy1.jpg"),
        },
        1: {
          course: {
            0: {
              attr_no: 11,
              loc: "첨성대 해수욕장",
            },
            1: {
              attr_no: 12,
              loc: "첨성대 식당",
            },
            2: {
              attr_no: 13,
              loc: "첨성대 카페",
            },
            3: {
              attr_no: 14,
              loc: "첨성대 횟집",
            },
            4: {
              attr_no: 15,
              loc: "첨성대 숙소",
            },
          },
          createtime: "2023-05-20 21:20",
          nickname: "cola",
          img: require("@/assets/dummy2.jpg"),
        },
      },
    };
  },
  methods: {
    moveSlide(num) {
      this.left = -num * 540 + "px";
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
    timerStart() {
      // 1초에 한번씩 start 호출
      this.TimeCounter = 180;
      var interval = setInterval(() => {
        if (this.currentIdx === this.slideCount - 1) {
          this.currentIdx = -1;
          this.left = 0;
        }
        this.moveRight();
      }, 3000);
      return interval;
    },
  },
  created() {
    setInterval(() => {
      this.index = this.index === 0 ? 1 : 0;
    }, 3000);
  },
  mounted() {
    this.timerStart();
  }
};
</script>

<style>
.best-plan {
  width: 540px;
  height: 400px;
}
.best-plan__title {
  width: 100%;
  height: 10%;
  text-align: left;
  margin-left: 10px;
}
.best-plan__img__box {
  width: 540px;
  height: 100%;
  display: flex;
  position: relative;
  justify-content: right;
  cursor: pointer;
}
.best-plan__box-hr {
  margin: 10px 0px;
  opacity: 0.8;
  width: 45%;
}
.best-plan__box-right {
  position: absolute;
  padding: 18px;
  width: 40%;
  height: 90%;
  text-align: left;
  backdrop-filter: brightness(30%);
}
.best-plan__box-right h3,
.best-plan__box-right p {
  color: var(--color-white);
}
.best-plan__course-box {
  height: 65%;
  margin-top: 10px;
  display: flex;
  flex-direction: column;
  overflow: hidden;
}
.best-plan__course {
  display: flex;
}
.best-plan__course-no {
  display: block;
}
.best-plan__course-loc {
  display: block;
  margin-left: 20px;
}
.best-plan__footer-hr {
  margin-top: 10px;
  opacity: 0.6;
}
.best-plan__footer {
  margin-top: 10px;
  display: flex;
}
.best-plan__footer-right {
  margin-left: 16px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  font-size: 14px;
}
.best-plan__footer-img {
  width: 40px;
  height: 40px;
  border-radius: 70px;
}
.best-plan__footer-createtime {
  font-size: 12px;
}
.best-plan__img {
  width: 100%;
  height: 100%;
  border-radius: 20px;
}
/* slide */
.best-plan__slideShow {
  width: 100%;
  height: 90%;
  display: flex;
  position: relative;
  justify-content: right;
  cursor: pointer;
  border-radius: 20px;
  position: relative;
  overflow: hidden;
}
.best-plan__slides {
  position: absolute;
  left: 0;
  top: 0;
  width: 200%;
  height:100%;
  transition: left 0.3s ease-out;
}
.best-plan__slides li:first-child {
  margin-left: 0px;
}
.best-plan__slides li:last-child {
  margin-right: 0px;
}
.best-plan__slides li:not(:last-child) {
  float: left;
  margin-right: 0px;
}
.best-plan__slides li {
  float: left;
}
.best-plan__controller img {
  position: absolute;
  background-color: transparent;
  color: black;
  text-align: center;
  cursor: pointer;
  top: 10px;
  border-radius: 20px;
}
.best-plan__prev {
  width: 40px;
  height: 40px;
  right: 52px;
  backdrop-filter: brightness(300%);
}
.best-plan__prev:hover {
  backdrop-filter: brightness(400%);
}
.best-plan__next {
  width: 40px;
  height: 40px;
  right: 10px;
  backdrop-filter: brightness(300%);

  transform: rotate(180deg);
}
.best-plan__next:hover {
  backdrop-filter: brightness(400%);
  transform: rotate(180deg);
}
</style>
