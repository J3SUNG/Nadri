<template>
  <div class="map-left">
    <div class="map-left__input__box">
      <input class="map-left__input" placeholder="장소 검색" v-model="search" />
    </div>
    <div class="map-left__select__box">
      <select
        class="map-left__select map-left__select-sido"
        v-model="sidoCode"
        @change="changeSido"
      >
        <option selected value="0">시도 선택</option>
        <option v-for="(sido, index) in sidos" :key="index" :value="sido.sidoNo">
          {{ sido.sidoName }}
        </option>
      </select>
      <select
        class="map-left__select map-left__select-gugun"
        v-model="gugunCode"
        @change="changeGugun"
      >
        <option selected value="0">구군 선택</option>
        <option v-for="(gugun, index) in guguns" :key="index" :value="gugun.gugunNo">
          {{ gugun.gugunName }}
        </option>
      </select>
    </div>
    <div class="map-left__checkbox__box">
      <div class="map-left__checkbox__box__small">
        <label class="map-left__checkbox__label">전체</label>
        <input
          class="map-left__checkbox__chkbox"
          type="checkbox"
          name="attr"
          v-model="contentType"
          value=""
          @change="changeContentType"
        />
      </div>
      <div class="map-left__checkbox__box__small">
        <label class="map-left__checkbox__label">관광지</label>
        <input
          class="map-left__checkbox__chkbox"
          type="checkbox"
          name="attr"
          v-model="contentType"
          value="12"
          @change="changeContentType"
        />
      </div>
      <div class="map-left__checkbox__box__small">
        <label class="map-left__checkbox__label">문화시설</label>
        <input
          class="map-left__checkbox__chkbox"
          type="checkbox"
          name="attr"
          v-model="contentType"
          value="14"
          @change="changeContentType"
        />
      </div>
      <div class="map-left__checkbox__box__small">
        <label class="map-left__checkbox__label">행사</label>
        <input
          class="map-left__checkbox__chkbox"
          type="checkbox"
          name="attr"
          v-model="contentType"
          value="15"
          @change="changeContentType"
        />
      </div>
      <div class="map-left__checkbox__box__small">
        <label class="map-left__checkbox__label">여행코스</label>
        <input
          class="map-left__checkbox__chkbox"
          type="checkbox"
          name="attr"
          v-model="contentType"
          value="25"
          @change="changeContentType"
        />
      </div>
      <div class="map-left__checkbox__box__small">
        <label class="map-left__checkbox__label">레포츠</label>
        <input
          class="map-left__checkbox__chkbox"
          type="checkbox"
          name="attr"
          v-model="contentType"
          value="28"
          @change="changeContentType"
        />
      </div>
      <div class="map-left__checkbox__box__small">
        <label class="map-left__checkbox__label">숙박</label>
        <input
          class="map-left__checkbox__chkbox"
          type="checkbox"
          name="attr"
          v-model="contentType"
          value="32"
          @change="changeContentType"
        />
      </div>
      <div class="map-left__checkbox__box__small">
        <label class="map-left__checkbox__label">쇼핑</label>
        <input
          class="map-left__checkbox__chkbox"
          type="checkbox"
          name="attr"
          v-model="contentType"
          value="38"
          @change="changeContentType"
        />
      </div>
      <div class="map-left__checkbox__box__small">
        <label class="map-left__checkbox__label">음식점</label>
        <input
          class="map-left__checkbox__chkbox"
          type="checkbox"
          name="attr"
          v-model="contentType"
          value="39"
          @change="changeContentType"
        />
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "MapLeft",
  data() {
    return {
      filter: {
        sido: "서울",
        gungu: "강북",
        type: {
          0: "관광지",
          1: "음식점",
        },
      },
    };
  },
  methods: {
    changeContentType() {
      this.$emit("changeContentType");
    },
    changeGugun() {
      this.$emit("changeGugun");
    },
    changeSido() {
      this.$emit("changeSido");
    },
  },
};
</script>

<style>
.map-left {
  width: 500px;
  height: 100vh;
  background-color: var(--color-white);
  position: absolute;
  z-index: 10;
  display: flex;
  align-items: center;
  flex-direction: column;
}
.map-left__input__box {
  margin-top: 100px;
}
.map-left__input {
  width: 420px;
  height: auto;
  border: solid 2px var(--color-main);
  border-radius: 5px;
}
.map-left__filter__box {
  width: 80%;
  display: flex;
  justify-content: space-between;
}
.map-left__filter {
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 30px;
  background-color: var(--color-main);
  height: 30px;
  width: 140px;
  font-size: 16px;
  text-align: center;
}
.map-left__filter p {
  color: var(--color-white);
}
.map-left__filter__text {
  margin-left: 5px;
}
.map-left__checkbox__box {
  width: 80%;
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: space-around;
}
.map-left__checkbox__box__small {
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  height: 80px;
}
.map-left__checkbox__label {
  font-size: 18px;
}
.map-left__checkbox__chkbox {
  width: 20px;
  height: 20px;
  cursor: pointer;
}
/* .map-left__filter-type__li-all {
  background-color: saddlebrown;
}
.map-left__filter-type__li-course {
  background-color: magenta;
}
.map-left__filter-type__li-cultural {
  background-color: teal;
}
.map-left__filter-type__li-event {
  background-color: indigo;
}
.map-left__filter-type__li-food {
  background-color: gold;
}
.map-left__filter-type__li-home {
  background-color: red;
}
.map-left__filter-type__li-leport {
  background-color: blue;
}
.map-left__filter-type__li-shopping {
  background-color: green;
}
.map-left__filter-type__li-trip {
  background-color: orange;
} */
</style>
