<template>
  <div class="best-plan">
    <h2 class="best-plan__title">BEST 여행노트</h2>
    <div class="best-plan__img">
      <div class="best-plan__img-right">
        <h3>여행코스소개</h3>
        <ul class="best-plan__course-box">
          <li class="best-plan__course" v-for="(item, index) in plan[0].course" :key="item.attr_no">
            <p class="best-plan__course-no">{{ index }}</p>
            <p class="best-plan__course-loc">{{ item.loc }}</p>
          </li>
        </ul>
        <hr class="best-plan__footer-hr" />
        <div class="best-plan__footer">
          <img class="best-plan__footer-img" src="@/assets/jetty.jpg" />
          <div class="best-plan__footer-right">
            <p class="best-plan__footer-nickname">{{ this.plan[0].nickname }}</p>
            <p class="best-plan__footer-createtime">{{ this.plan[0].createtime }}</p>
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
          },
          createtime: "2023-05-20 21:20",
          nickname: "jetty",
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
        },
      },
    };
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
}
.best-plan__img {
  width: 100%;
  height: 90%;
  background-image: url("@/assets/dummy1.jpg");
  background-repeat: no-repeat;
  background-size: 100% 100%;
  display: flex;
  justify-content: right;
}
.best-plan__img-right {
  padding: 18px;
  width: 40%;
  height: 90%;
  text-align: left;
  backdrop-filter: brightness(30%);
}
.best-plan__img-right h3,
.best-plan__img-right p {
  color: var(--color-white);
}
.best-plan__course-box {
  min-height: 65%;
  margin-top: 30px;
  display: flex;
  flex-direction: column;
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
  margin-top: 5px;
}
.best-plan__footer {
  margin-top: 10px;
  display: flex;
}
.best-plan__footer-right {
  margin-left: 10px;
  display: flex;
  flex-direction: column;
}
.best-plan__footer-img {
  width: 40px;
  height: 40px;
  border-radius: 70px;
}
</style>
