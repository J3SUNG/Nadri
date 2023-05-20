<template>
  <div class="board__card" @click="moveBoardDetail">
    <img class="card__img" :src="img[num]" />
    <h3 class="card__subject">{{ itemData.subject }}</h3>
    <p class="card__content">
      {{ itemData.content }}
    </p>
    <hr class="card__hr" />
    <div class="card__footer">
      <div class="card__footer__left">
        <img class="card__footer__writer-img" src="@/assets/jetty.jpg" />
        <p class="card__footer__writer-nickname">{{ itemData.nickname }}</p>
      </div>
      <div class="card__footer__right">
        <img class="card__footer__icon card__footer__icon-comment" src="@/assets/comment.png" />
        <p class="card__footer__text">{{ itemData.commentCount }}</p>
        <img class="card__footer__icon card__footer__icon-heart" @click="heartClick" :src="heart" />
        <p class="card__footer__text">{{ heartCnt }}</p>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
import http from "@/util/http-common";

const memberStore = "memberStore";

export default {
  name: "BoardCard",
  data() {
    return {
      img: [
        require("@/assets/dummy1.jpg"),
        require("@/assets/dummy2.jpg"),
        require("@/assets/dummy3.jpg"),
        require("@/assets/dummy4.jpg"),
        require("@/assets/dummy5.jpg"),
        require("@/assets/dummy6.jpg"),
      ],
      num: Math.ceil(Math.random() * 6 - 1),
      commentCnt: Math.ceil(Math.random() * 20),
      heart: "",
      heartCnt: this.itemData.likeCount,
      heartChk: this.itemData.isLike,
    };
  },
  computed: {
    ...mapState(memberStore, ["userInfo"]),
  },
  props: ["itemData"],
  mounted() {
    this.heart =
      this.itemData.isLike === 0
        ? require("@/assets/heartOff.png")
        : require("@/assets/heartOn.png");
  },
  methods: {
    moveBoardDetail(event) {
      if (!(event.target.classList[1] === "card__footer__icon-heart")) {
        this.$router.push({
          name: "AppBoardDetail",
          params: { boardNo: this.itemData.boardNo },
        });
      }
    },
    heartClick() {
      if (this.heartChk === 0) {
        http.post(`boardlike/${this.itemData.boardNo}/${this.userInfo.userNo}`).then((response) => {
          ++this.heartCnt;
          console.log(response);
        });
        this.heart = require("@/assets/heartOn.png");
      } else {
        http
          .delete(`boardlike/${this.itemData.boardNo}/${this.userInfo.userNo}`)
          .then((response) => {
            --this.heartCnt;
            console.log(response);
          });
        this.heart = require("@/assets/heartOff.png");
      }
      this.heartChk = this.heartChk === 0 ? 1 : 0;
    },
  },
};
</script>

<style>
.board__card {
  width: 280px;
  height: 280px;
  border: 0px solid var(--color-black);
  margin-left: 37.5px;
  margin-bottom: 40px;
  display: flex;
  align-items: center;
  flex-direction: column;
  background-color: var(--color-white);
  transition: all 0.1s linear;
  font-size: 12px;
  text-align: left;
  cursor: pointer;
}
.board__card:hover {
  transform: scale(1.04);
  box-shadow: 0px 0px 5px var(--color-darkgray);
}
.card__img {
  width: 260px;
  height: 170px;
  margin: 10px;
  /* overflow: hidden; */
}
.card__subject {
  width: 90%;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
.card__content {
  width: 90%;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
.card__hr {
  width: 90%;
  margin: 10px;
}
.card__footer {
  width: 90%;
  display: flex;
  justify-content: space-between;
}
.card__footer__left {
  display: flex;
  justify-content: start;
  align-content: center;
}
.card__footer__right {
  display: flex;
  justify-content: end;
  align-content: center;
}
.card__footer__icon {
  margin-left: 5px;
  width: 18px;
  height: 18px;
}
.card__footer__icon-heart:hover {
  animation: scaling 1s ease-in-out infinite;
}
@keyframes scaling {
  from {
    transform: scale(1);
  }
  to {
    transform: scale(1.3);
  }
}
.card__footer__text {
  margin-left: 10px;
  width: 18px;
  height: 18px;
}
.card__footer__writer-img {
  width: 18px;
  height: 18px;
  border-radius: 70px;
}
.card__footer__writer-nickname {
  font-weight: bold;
  margin-left: 5px;
}
</style>
