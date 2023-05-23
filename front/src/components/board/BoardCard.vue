<template>
  <div class="board__card" @click="moveBoardDetail">
    <img class="board__card__img" :src="itemData.thumUrl" />
    <h3 class="board__card__subject">{{ itemData.subject }}</h3>
    <p class="board__card__content">
      {{ itemData.content }}
    </p>
    <hr class="board__card__hr" />
    <div class="board__card__footer">
      <div class="board__card__footer__left">
        <img class="board__card__footer__writer-img" :src="itemData.imgUrl" />
        <p class="board__card__footer__writer-nickname">{{ itemData.nickname }}</p>
      </div>
      <div class="board__card__footer__right">
        <img
          class="board__card__footer__icon board__card__footer__icon-comment"
          src="@/assets/comment.png"
        />
        <p class="board__card__footer__text">{{ itemData.commentCount }}</p>
        <img
          class="board__card__footer__icon board__card__footer__icon-heart"
          @click="heartClick"
          :src="heart"
        />
        <p class="board__card__footer__text">{{ heartCnt }}</p>
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
      if (!(event.target.classList[1] === "board__card__footer__icon-heart")) {
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
  width: 340px;
  height: 340px;
  border: 0px solid var(--color-black);
  margin-bottom: 40px;
  display: flex;
  align-items: center;
  flex-direction: column;
  background-color: var(--color-white);
  transition: all 0.1s linear;
  font-size: 16px;
  text-align: left;
  cursor: pointer;
}
.board__card:hover {
  transform: scale(1.04);
  box-shadow: 0px 0px 5px var(--color-darkgray);
}
.board__card__img {
  width: 320px;
  height: 200px;
  margin: 10px;
  /* overflow: hidden; */
}
.board__card__subject {
  width: 90%;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
.board__card__content {
  width: 90%;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
.board__card__hr {
  width: 90%;
  margin: 10px;
}
.board__card__footer {
  width: 90%;
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.board__card__footer__left {
  display: flex;
  justify-content: start;
  align-items: center;
}
.board__card__footer__right {
  display: flex;
  justify-content: end;
  align-items: center;
}
.board__card__footer__icon {
  margin-left: 5px;
  width: 20px;
  height: 20px;
}
@keyframes scaling {
  from {
    transform: scale(1);
  }
  to {
    transform: scale(1.3);
  }
}
.board__card__footer__icon-heart:hover {
  animation: scaling 1s ease-in-out infinite;
}
.board__card__footer__text {
  margin-left: 10px;
  width: 28px;
  height: 28px;
}
.board__card__footer__writer-img {
  width: 28px;
  height: 28px;
  border-radius: 70px;
}
.board__card__footer__writer-nickname {
  font-weight: bold;
  margin-left: 5px;
}
</style>
