<template>
  <div class="board">
    <h1 class="board__title">커뮤니티</h1>
    <div class="board__header__box">
      <the-search />
      <div class="board__write">
        <button class="board__write-button" @click="moveBoardCreate">글쓰기</button>
      </div>
    </div>
    <div class="board__cards">
      <board-card v-for="item in boards" :itemData="item" :key="item.boardNo" />
    </div>
    <div class="board__pagenation__box">
      <button
        :class="{
          board__pagenation: true,
          board__pagenation__hidden: !this.pageNav.startRange,
        }"
        @click="movePage(startPage - 1)"
      >
        &lt;
      </button>
      <button
        :class="{ board__pagenation: true, board__pagenation__selected: this.selected[0] }"
        @click="movePage(startPage)"
      >
        {{ this.startPage }}
      </button>
      <button
        :class="{ board__pagenation: true, board__pagenation__selected: this.selected[1] }"
        @click="movePage(startPage + 1)"
      >
        {{ this.startPage + 1 }}
      </button>
      <button
        :class="{ board__pagenation: true, board__pagenation__selected: this.selected[2] }"
        @click="movePage(startPage + 2)"
      >
        {{ this.startPage + 2 }}
      </button>
      <button
        :class="{ board__pagenation: true, board__pagenation__selected: this.selected[3] }"
        @click="movePage(startPage + 3)"
      >
        {{ this.startPage + 3 }}
      </button>
      <button
        :class="{ board__pagenation: true, board__pagenation__selected: this.selected[4] }"
        @click="movePage(startPage + 4)"
      >
        {{ this.startPage + 4 }}
      </button>
      <button
        :class="{ board__pagenation: true, board__pagenation__hidden: !this.pageNav.endRange }"
        @click="movePage(startPage + 5)"
      >
        &gt;
      </button>
    </div>
  </div>
</template>

<script>
import http from "@/util/http-common";
import BoardCard from "./BoardCard.vue";
import { mapState } from "vuex";
import TheSearch from "../search/TheSearch.vue";

const memberStore = "memberStore";

export default {
  name: "BoardList",
  components: {
    BoardCard,
    TheSearch,
  },
  computed: {
    ...mapState(memberStore, ["userInfo"]),
  },
  data() {
    return {
      boards: [],
      pageNav: {},
      type: "1",
      nextPage: 1,
      startPage: 1,
      selected: [true, false, false, false, false],
      imgUrl: "",
      thumUrl: "",
      baseUrl: "",
      index: 0,
    };
  },
  created() {
    let userNo = this.userInfo === null ? 0 : this.userInfo.userNo;
    http.get(`board?type=${this.type}&userNo=${userNo}`).then((response) => {
      this.boards = response.data.list;
      this.pageNav = response.data.pageNavigation;
      console.log(this.boards);
      console.log(this.pageNav);
      this.loadImg();
      console.log(this.boards);
    });
  },
  methods: {
    moveBoardCreate() {
      this.$router.push({ name: "AppBoardCreate", params: { boardType: this.type } });
    },
    loadImg() {
      this.baseUrl = "http://192.168.31.78";
      // "http://192.168.31.78"  "http://59.151.232.152"
      for (let i = 0; i < this.boards.length; ++i) {
        this.imgUrl = `${this.baseUrl}:7777/image/showImage?saveFolder=${this.boards[i].imgSaveFolder}&saveFile=${this.boards[i].imgSaveFile}`;
        this.boards[i].imgUrl = this.imgUrl;

        this.thumUrl = `${this.baseUrl}:7777/image/showImage?saveFolder=${this.boards[i].saveFolder}&saveFile=${this.boards[i].saveFile}`;
        this.boards[i].thumUrl = this.thumUrl;
      }
    },
    movePage(page) {
      this.nextPage = page;
      if (this.nextPage <= 0) {
        this.nextPage = 1;
      } else if (this.nextPage >= this.pageNav.totalPageCount) {
        this.nextPage = this.pageNav.totalPageCount;
      }
      http.get(`board?pg=${this.nextPage}&type=${this.type}`).then((response) => {
        this.boards = response.data.list;
        this.pageNav = response.data.pageNavigation;
        console.log(this.pageNav);
        if (!this.pageNav.startRange) {
          this.startPage = 1;
          this.selected = [true, false, false, false, false];
        } else if (!this.pageNav.endRange) {
          this.startPage = this.pageNav.totalPageCount - 4;
          this.selected = [false, false, false, false, true];
        } else if (!this.pageNav.startRange2) {
          this.startPage = 1;
          this.selected = [false, true, false, false, false];
        } else if (!this.pageNav.endRange2) {
          this.startPage = this.pageNav.totalPageCount - 4;
          this.selected = [false, false, false, true, false];
        } else {
          this.startPage = this.pageNav.currentPage - 2;
          this.selected = [false, false, true, false, false];
        }
        this.loadImg();
      });
    },
  },
};
</script>

<style>
.board {
  width: 100%;
  height: 100%;
}
.board__header__box {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin: 20px 0px 0 10px;
}
.board__write {
  text-align: right;
  height: 100%;
  display: flex;
  justify-content: end;
  align-items: center;
}
.board__cards {
  width: 100%;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
}
.board__write-button {
  display: flex;
  width: 90px;
  height: 40px;
  border-radius: 30px;
  justify-content: center;
  align-items: center;
  font-size: 16px;
}
.board__pagenation {
  color: black;
  background-color: white;
}
.board__pagenation__selected {
  color: var(--color-main);
}
.board__pagenation__hidden {
  visibility: hidden;
}
</style>
