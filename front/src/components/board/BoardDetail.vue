<template>
  <div :class="{ 'board-detail': isNotify === 1, 'board-detail-notify': isNotify === 0 }">
    <div class="board-detail__header">
      <h3 class="board-detail__header-title">{{ title }}</h3>
      <div class="board-detail__header__right">
        <img class="board-detail__header-img" :src="imgUrl" />
        <p class="board-detail__header-nickname">{{ board.nickname }}</p>
        <p class="board-detail__header-createtime">{{ board.createTime }}</p>
      </div>
    </div>
    <hr class="board-detail__hr" />
    <div class="board-deatil__main">
      <h1 class="board-deatil__main-title">{{ board.subject }}</h1>
      <div class="board-deatil__main-imgs__box" v-if="board.boardType">
        <div class="board-deatil__main-imgs" v-for="(item, index) in imgArr" :key="index">
          <img class="board-detail__main-img" :src="item" />
        </div>
      </div>
      <p class="board-deatil__main-content">{{ board.content }}</p>
    </div>
    <hr class="board-detail__hr" />
    <div class="board-deatil__function">
      <button @click="moveBoardList">목록</button>
      <div class="board-deatil__function-heart" v-show="isNotify">
        <img class="board-deatil__function-heart-img" @click="heartClick" :src="heart" />
        <p class="board-deatil__function-heart-text">{{ this.heartCnt }}</p>
      </div>
      <div class="board-detail__function-admin">
        <button v-if="isWriter" @click="moveBoardUpdate">수정</button>
        <button v-if="isWriter" @click="deleteBoard">삭제</button>
      </div>
    </div>
    <hr class="board-detail__hr" v-if="isNotify" />
    <div class="board-deatil__comment" v-if="isNotify">
      <p class="board-deatil__comment-text">댓글</p>
      <p class="board-deatil__comment-cnt">{{ commentCnt }}</p>
      <div class="board-deatil__comment-box">
        <input class="board-deatil__comment-input" v-model="commentInput" /><button
          class="board-deatil__comment-button"
          @click="postComment"
          v-if="this.userNo !== 0"
        >
          등록
        </button>
      </div>
      <the-comment v-for="item in comments" :itemData="item" :key="item.commentNo" />
    </div>
  </div>
</template>

<script>
import http from "@/util/http-common";
import TheComment from "../comment/TheComment.vue";
import { mapState } from "vuex";

const memberStore = "memberStore";

export default {
  components: { TheComment },
  name: "BoardDetail",
  data() {
    return {
      imgArr: [],
      heart: require("@/assets/heartOff.png"),
      heartChk: false,
      heartCnt: 0,
      title: "",
      board: "",
      commentCnt: 0,
      comments: [],
      isNotify: 1,
      userNo: 0,
      isWriter: true,
      commentInput: "",
      imgUrl: "",
    };
  },
  computed: {
    ...mapState(memberStore, ["userInfo"]),
  },
  async created() {
    if (this.userInfo !== null) {
      this.userNo = this.userInfo.userNo;
    }
    const response = await http.get(`board/${this.$route.params.boardNo}/${this.userNo}`);
    this.board = response.data;
    this.loadImg();
    this.imgArr = this.board.url;
    console.log(this.board);
    console.log("-------");
    console.log(this.userInfo);
    this.heart =
      this.board.isLike == 1 ? require("@/assets/heartOn.png") : require("@/assets/heartOff.png");
    this.heartChk = this.board.isLike;
    this.heartCnt = this.board.likeCount;
    this.isNotify = this.board.boardType;
    if (this.board.boardType === 1) {
      this.title = "커뮤니티";
    } else {
      this.title = "공지사항";
    }

    const response2 = await http.get(`comment/${this.board.boardNo}`);
    this.comments = response2.data;
    console.log("AA");
    console.log(this.comments);
    this.commentCnt = this.comments.length;

    if (this.userInfo !== null && this.userNo === this.board.userNo) {
      this.isWriter = true;
    } else {
      this.isWriter = false;
    }
  },
  methods: {
    moveBoardUpdate() {
      this.$router.push({ name: "AppBoardUpdate", params: { boardNo: this.board.boardNo } });
    },
    moveBoardList() {
      if (this.board.boardType === 1) {
        this.$router.push({ name: "AppBoard" });
      } else {
        this.$router.push({ name: "AppNotify" });
      }
    },
    deleteBoard() {
      console.log(this.board.boardNo);
      if (confirm("정말 삭제하시겠습니까?")) {
        http.delete(`board/${this.board.boardNo}`).then(() => {
          if (this.board.boardType === 1) {
            this.$router.push({ name: "AppBoard" });
          } else {
            this.$router.push({ name: "AppNotify" });
          }
        });
      }
    },
    heartClick() {
      if (this.userInfo !== null) {
        if (this.heartChk === 0) {
          http.post(`boardlike/${this.board.boardNo}/${this.userNo}`).then((response) => {
            ++this.heartCnt;
            console.log(response);
          });
          this.heart = require("@/assets/heartOn.png");
        } else {
          http.delete(`boardlike/${this.board.boardNo}/${this.userNo}`).then((response) => {
            --this.heartCnt;
            console.log(response);
          });
          this.heart = require("@/assets/heartOff.png");
        }
        this.heartChk = this.heartChk === 0 ? 1 : 0;
      }
    },
    postComment() {
      let commentData = {
        content: this.commentInput,
        userNo: this.userNo,
        boardNo: this.board.boardNo,
      };
      console.log(commentData);
      // http.post(`comment`, JSON.stringify(commentData)).then((response) => {
      //   console.log(response);
      // });
      http
        .post(`comment/${commentData.content}/${commentData.userNo}/${commentData.boardNo}`)
        .then((response) => {
          console.log(response);
          window.location.reload();
        });
      // http
      //   .post(`comment?content=${this.content}&userNo=${this.userNo}&boardNo=${this.boardNo}`)
      //   .then((response) => {
      //     console.log(response);
      //   });
    },
    loadImg() {
      this.baseUrl = `${process.env.VUE_APP_API_BASE_URL}`;
      this.imgUrl = `${this.baseUrl}/image/showImage?saveFolder=${this.board.imgSaveFolder}&saveFile=${this.board.imgSaveFile}`;
    },
  },
};
</script>

<style>
.board-detail {
  margin-top: 50px;
  width: 100%;
}
.board-detail-notify {
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
  min-height: 400px;
  margin-left: 5%;
  width: 90%;
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
  margin: 30px 0px;
  display: flex;
  align-items: center;
  justify-content: space-between;
}
.board-deatil__function button {
  height: 40px;
  padding: 0px 20px;
  border-radius: 20px;
  background: var(--color-white);
  color: var(--color-black);
  border: solid 3px var(--color-darkgray);
}
.board-deatil__function-heart {
  display: flex;
  align-items: center;
}
.board-deatil__function-heart-img {
  margin-left: 40px;
  width: 36px;
  height: 36px;
  cursor: pointer;
}
.board-deatil__function-heart-text {
  margin-left: 16px;
  font-size: 28px;
  font-weight: bold;
  color: var(--color-main);
}
.board-deatil__function-heart-img:hover {
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
.board-deatil__comment {
  margin-top: 40px;
  text-align: left;
}
.board-deatil__comment-box {
  padding: 15px;
  width: calc(100%-30px);
  height: 135px;
  text-align: right;
  background-color: var(--color-lightwhite);
}
.board-deatil__comment-text {
  margin-left: 10px;
  margin-bottom: 15px;
  display: inline-block;
}
.board-deatil__comment-cnt {
  margin-left: 10px;
  display: inline-block;
  color: var(--color-main);
}
.board-deatil__comment-input {
  height: 100px;
  padding: 0 10px;
  margin: 0px;
  border: 0px;
}
.board-deatil__comment-button {
  font-size: 16px;
  width: 55px;
  height: 30px;
  padding: 0px;
  margin: 10px 0px 0px 0px;
}
.board-detail__function-admin {
  width: 200px;
}
</style>
