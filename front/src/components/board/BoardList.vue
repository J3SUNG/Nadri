<template>
  <div class="board">
    <h1 class="board__title">커뮤니티</h1>
    <div class="board__header__box">
      <div class="board__write">
        <button class="board__write-button" @click="moveBoardCreate" v-if="isUser">글쓰기</button>
      </div>
    </div>
    <div class="board__cards">
      <board-card v-for="item in boards" :itemData="item" :key="item.boardNo" />
    </div>
    <div class="board__search__box">
      <select name="subject" class="board__search-select">
        <option value="subject" selected>제목</option>
        <option value="nickname">닉네임</option>
      </select>
      <input v-model="search" class="board__search-input" />
      <button class="board__search-button" @click="clickSearch">검색</button>
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

const memberStore = "memberStore";

export default {
  name: "BoardList",
  components: {
    BoardCard,
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
      isUser: true,
      search: "",
    };
  },
  created() {
    let userNo = this.userInfo === null ? 0 : this.userInfo.userNo;
    http.get(`board?type=${this.type}&userNo=${userNo}`).then((response) => {
      this.boards = response.data.list;
      this.pageNav = response.data.pageNavigation;
      this.loadImg();

      if (this.userInfo != null) {
        this.isUser = true;
      } else {
        this.isUser = false;
      }
    });
  },
  methods: {
    moveBoardCreate() {
      this.$router.push({ name: "AppBoardCreate", params: { boardType: this.type } });
    },
    loadImg() {
      this.baseUrl = `${process.env.VUE_APP_API_BASE_URL}`;
      for (let i = 0; i < this.boards.length; ++i) {
        this.imgUrl = `${this.baseUrl}/image/showImage?saveFolder=${this.boards[i].imgSaveFolder}&saveFile=${this.boards[i].imgSaveFile}`;
        this.boards[i].imgUrl = this.imgUrl;

        this.thumUrl = `${this.baseUrl}/image/showImage?saveFolder=${this.boards[i].saveFolder}&saveFile=${this.boards[i].saveFile}`;
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
    clickSearch() {
      http.get(`board?pg=${this.nextPage}&type=${this.type}&word=${this.search}`).then;
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
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: end;
  align-items: center;
}
.board__search__box {
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}
.board__search__box input,
.board__search__box select {
  font-size: 12px;
  padding: 8px 0px 8px 10px;
}
.board__search-select {
  width: 80px;
  text-align: left;
}
.board__search-input {
  margin-left: 12px;
  width: 200px;
}
.board__search-button {
  font-size: 12px;
  width: 60px;
  padding: 8px;
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
  color: var(--color-lightgray);
  cursor: default;
}
</style>
