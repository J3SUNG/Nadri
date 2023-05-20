<template>
  <div class="best-plan">
    <h2 class="best-plan__title">BEST 여행노트</h2>
    <div class="best-plan__box">
      <img class="best-plan__img" :src="this.plan[this.index].img" />
      <div class="best-plan__box-right">
        <h3 class="best-plan__box-title">여행코스소개</h3>
        <hr class="best-plan__box-hr" />
        <ul class="best-plan__course-box">
          <li
            class="best-plan__course"
            v-for="(item, index) in plan[this.index].course"
            :key="item.attr_no"
          >
            <p class="best-plan__course-no">{{ index }}</p>
            <p class="best-plan__course-loc">{{ item.loc }}</p>
          </li>
        </ul>
        <hr class="best-plan__footer-hr" />
        <div class="best-plan__footer">
          <img class="best-plan__footer-img" src="@/assets/jetty.jpg" />
          <div class="best-plan__footer-right">
            <p class="best-plan__footer-nickname">{{ this.plan[this.index].nickname }}</p>
            <p class="best-plan__footer-createtime">{{ this.plan[this.index].createtime }}</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "BestPlan",
  data() {
    return {
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
  created() {
    setInterval(() => {
      this.index = this.index === 0 ? 1 : 0;
    }, 3000);
  },
};
</script>

<style>
.best-plan {
  width: 60%;
  height: 400px;
}
.best-plan__title {
  width: 100%;
  height: 10%;
  text-align: left;
  margin-left: 10px;
}
.best-plan__box {
  width: 100%;
  height: 90%;
  display: flex;
  position: relative;
  justify-content: right;
  cursor: pointer;
  /*  */
  -webkit-transition: all 0.25s cubic-bezier(1, 0.01, 0.32, 1);
  -o-transition: all 0.25s cubic-bezier(1, 0.01, 0.32, 1);
  transition: all 0.25s cubic-bezier(1, 0.01, 0.32, 1);
}
.best-plan__box {
  width: 100%;
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
</style>
