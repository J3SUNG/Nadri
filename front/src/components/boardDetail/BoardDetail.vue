<template>
  <div class="board-detail">
    <div class="board-detail__header">
      <h3 class="board-detail__header-title">{{ title }}</h3>
      <div class="board-detail__header__right">
        <img class="board-detail__header-img" :src="userImg" />
        <p class="board-detail__header-nickname">{{ board.nickname }}</p>
        <p class="board-detail__header-createtime">{{ board.createTime }}</p>
      </div>
    </div>
    <hr class="board-detail__hr" />
    <div class="board-deatil__main">
      <h1 class="board-deatil__main-title">{{ board.subject }}</h1>
      <div class="board-deatil__main-imgs" v-for="(item, index) in imgArr" :key="index">
        <img class="board-detail__main-img" :src="item" />
      </div>
      <p class="board-deatil__main-content">{{ board.content }}</p>
    </div>
    <hr class="board-detail__hr" />
    <div class="board-deatil__function">
      <button @click="moveBoardList">목록</button>
      <div class="board-deatil__function-heart">
        <TheHeart :heartCnt="this.board.likeCount" />
      </div>
      <div class="board-detail__function-admin">
        <button @click="moveBoardUpdate">수정</button>
        <button @click="deleteBoard">삭제</button>
      </div>
    </div>
  </div>
</template>

<script>
import http from "@/util/http-common";
import TheHeart from "@/components/heart/TheHeart.vue";
export default {
  name: "BoardDetail",
  data() {
    return {
      userImg: require("@/assets/jetty.jpg"),
      imgArr: [require("@/assets/dummy1.jpg"), require("@/assets/dummy2.jpg")],
      heart: [require("@/assets/heartOn.png"), require("@/assets/heartOff.png")],
      heartChk: false,
      title: "",
      board: "",
    };
  },
  created() {
    http.get(`board/${this.$route.params.boardNo}`).then((response) => {
      this.board = response.data;
      console.log(this.board);
      if (this.boardType === 0) {
        this.title = "커뮤니티";
      } else {
        this.title = "공지사항";
      }
    });
  },
  methods: {
    moveBoardUpdate() {
      this.$router.push({ name: "AppBoardUpdate", params: { boardNo: this.board.boardNo } });
    },
    moveBoardList() {
      this.$router.push({ name: "AppBoard" });
    },
    deleteBoard() {
      console.log(this.board.boardNo);
      http.delete(`board/${this.board.boardNo}`).then(() => {
        if (this.board.boardType === 1) {
          this.$router.push({ name: "AppBoard" });
        } else {
          this.$router.push({ name: "AppNotify" });
        }
      });
    },
  },
  components: { TheHeart },
};
</script>

<style>
.board-detail {
  margin-top: 50px;
  margin-left: 10%;
  width: 80%;
}
.board-detail__header {
  display: flex;
  justify-content: space-between;
}
.board-detail__header-title {
  font-size: 20px;
  font-weight: bold;
}
.board-detail__header__right {
  display: flex;
  align-items: center;
  font-weight: bold;
  font-size: 18px;
}
.board-detail__header-img {
  width: 40px;
  height: 40px;
  border-radius: 70px;
  margin-right: 10px;
}
.board-detail__header-nickname {
  margin-right: 10px;
}
.board-detail__header-nickname::after {
  content: " | ";
  color: darkgray;
}
.board-detail__header-createtime {
  margin-right: 10px;
  color: darkgray;
}
.board-detail__hr {
  margin: 10px 0;
}
.board-deatil__main {
  text-align: left;
}
.board-deatil__main-title {
  margin: 24px 0px;
}
.board-detail__main-img {
  max-width: 100%;
  height: auto;
}
.board-deatil__main-content {
  margin: 20px 0px;
  font-size: 20px;
  font-weight: bold;
}
.board-deatil__function {
  display: flex;
  justify-content: space-between;
}
</style>
