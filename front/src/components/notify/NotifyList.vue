<template>
  <div class="notify">
    <div class="notify__box">
      <h1>공지사항</h1>
      <div class="notify__header__box">
        <button v-if="isAdmin" class="notify__write-button" @click="moveNotifyCreate">
          글쓰기
        </button>
      </div>
      <div class="notify__table__box">
        <table class="notify__table">
          <colgroup class="notify__colgroup">
            <col width="200px" />
            <col width="512px" />
            <col width="200px" />
          </colgroup>
          <thead>
            <tr class="notify__table__tr">
              <th>번호</th>
              <th>제목</th>
              <th>작성일</th>
            </tr>
          </thead>
          <tbody>
            <notify-list-item
              v-for="board in boards"
              :key="board.boardNo"
              :board="board"
              class="notify__table__data"
            ></notify-list-item>
          </tbody>
        </table>
      </div>
      <div class="notify__search__box">
        <input v-model="search" class="notify__search-input" />
        <button class="notify__search-button" @click="clickSearch">검색</button>
      </div>
      <div class="notify__pagenation__box">
        <button
          :class="{
            notify__pagenation: true,
            notify__pagenation__hidden: !this.pageNav.startRange,
          }"
          @click="movePage(startPage - 1)"
        >
          &lt;
        </button>
        <button
          :class="{ notify__pagenation: true, notify__pagenation__selected: this.selected[0] }"
          @click="movePage(startPage)"
        >
          {{ this.startPage }}
        </button>
        <button
          :class="{ notify__pagenation: true, notify__pagenation__selected: this.selected[1] }"
          @click="movePage(startPage + 1)"
        >
          {{ this.startPage + 1 }}
        </button>
        <button
          :class="{ notify__pagenation: true, notify__pagenation__selected: this.selected[2] }"
          @click="movePage(startPage + 2)"
        >
          {{ this.startPage + 2 }}
        </button>
        <button
          :class="{ notify__pagenation: true, notify__pagenation__selected: this.selected[3] }"
          @click="movePage(startPage + 3)"
        >
          {{ this.startPage + 3 }}
        </button>
        <button
          :class="{ notify__pagenation: true, notify__pagenation__selected: this.selected[4] }"
          @click="movePage(startPage + 4)"
        >
          {{ this.startPage + 4 }}
        </button>
        <button
          :class="{ notify__pagenation: true, notify__pagenation__hidden: !this.pageNav.endRange }"
          @click="movePage(startPage + 5)"
        >
          &gt;
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
import http from "@/util/http-common";
import NotifyListItem from "@/components/notify/NotifyListItem.vue";

const memberStore = "memberStore";

export default {
  name: "NotifyList",
  computed: {
    ...mapState(memberStore, ["userInfo"]),
  },
  components: {
    NotifyListItem,
  },
  data() {
    return {
      boards: [],
      pageNav: {},
      type: "0",
      nextPage: 1,
      startPage: 1,
      selected: [true, false, false, false, false],
      search: "",
      isAdmin: true,
      isUser: false,
    };
  },
  created() {
    http.get(`board?pg=${this.nextPage}&type=${this.type}`).then((response) => {
      this.boards = response.data.list;
      this.pageNav = response.data.pageNavigation;
      console.log(this.pageNav);
    });
    console.log(this.userInfo);
    if (this.userInfo === null) {
      this.isUser = false;
      this.iseAdmin = false;
    } else if (this.userInfo.grade === "A") {
      this.isAdmin = true;
    } else {
      this.isAdmin = false;
    }
  },
  methods: {
    moveNotifyCreate() {
      this.$router.push({ name: "AppNotifyCreate", params: { boardType: this.type } });
    },
    movePage(page) {
      this.nextPage = page;
      if (this.nextPage <= 0) {
        this.nextPage = 1;
      } else if (this.nextPage >= this.pageNav.totalPageCount) {
        this.nextPage = this.pageNav.totalPageCount;
      }
      http
        .get(`board?pg=${this.nextPage}&type=${this.type}&word=${this.search}`)
        .then((response) => {
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
        });
    },
    clickSearch() {
      http
        .get(`board?pg=${this.nextPage}&type=${this.type}&word=${this.search}`)
        .then((response) => {
          this.boards = response.data.list;
          this.pageNav = response.data.pageNavigation;
        });
    },
  },
};
</script>

<style>
.notify {
  width: 80%;
  margin-left: 10%;
  height: 100%;
}
.notify__box {
  width: 100%;
  height: 100%;
}
.notify__table__box {
  width: 100%;
  height: 550px;
}
.notify__table {
  width: 100%;
}
.notify__tr {
  height: 50px;
}
.notify__colgroup {
  width: 100%;
}
.notify__header__box {
  display: flex;
  justify-content: end;
  align-items: center;
  margin-top: 20px;
}
.notify__search__box {
  margin-top: 30px;
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}
.notify__search__box input,
.notify__search__box select {
  font-size: 14px;
  padding: 8px 0px 8px 10px;
}
.notify__search-select {
  width: 80px;
  text-align: left;
}
.notify__search-input {
  margin-left: 10px;
  width: 200px;
}
.notify__search-button {
  font-size: 14px;
  width: 60px;
  padding: 8px;
}
.notify__write-button {
  display: flex;
  width: 90px;
  height: 40px;
  border-radius: 30px;
  justify-content: center;
  align-items: center;
  font-size: 16px;
}
.notify__table__tr {
  height: 50px;
}
.notify__table__data {
  height: 50px;
}
.notify__table__tr th {
  border-bottom: 1px solid var(--color-lightgray);
  border-top: 1px solid var(--color-lightgray);
}
.notify__pagenation {
  color: black;
  background-color: white;
}
.notify__pagenation__selected {
  color: var(--color-main);
}
.notify__pagenation__hidden {
  color: var(--color-lightgray);
  cursor: default;
}
</style>
