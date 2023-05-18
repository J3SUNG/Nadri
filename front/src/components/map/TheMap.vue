<template>
  <div>
    <div class="map__box">
      <div class="map__select__box">
        <select class="map__select map__select-sido">
          <option>세종특별자치시</option>
          <option>대구</option>
        </select>
        <select class="map__select map__select-gugun">
          <option>세종특별자치시</option>
          <option>달서구</option>
        </select>
      </div>
      <div class="map__checkbox__box">
        <label class="map__checkbox-label">관광지</label>
        <input class="map__checkbox-chkbox" type="checkbox" name="attr" />
        <label class="map__checkbox-label">문화시설</label>
        <input class="map__checkbox-chkbox" type="checkbox" name="attr" />
        <label class="map__checkbox-label">행사</label>
        <input class="map__checkbox-chkbox" type="checkbox" name="attr" />
        <label class="map__checkbox-label">여행코스</label>
        <input class="map__checkbox-chkbox" type="checkbox" name="attr" />
        <label class="map__checkbox-label">레포츠</label>
        <input class="map__checkbox-chkbox" type="checkbox" name="attr" />
        <label class="map__checkbox-label">숙박</label>
        <input class="map__checkbox-chkbox" type="checkbox" name="attr" />
        <label class="map__checkbox-label">쇼핑</label>
        <input class="map__checkbox-chkbox" type="checkbox" name="attr" />
        <label class="map__checkbox-label">음식점</label>
        <input class="map__checkbox-chkbox" type="checkbox" name="attr" />
      </div>
      <input class="map__search" />
    </div>
    <div id="map" class="map"></div>
  </div>
</template>

<script>
export default {
  name: "TheMap",
  data() {
    return {
      map: null,
    };
  },
  mounted() {
    if (window.kakao && window.kakao.maps) {
      // 카카오 객체가 있고, 카카오 맵그릴 준비가 되어 있다면 맵 실행
      this.loadMap();
    } else {
      // 없다면 카카오 스크립트 추가 후 맵 실행
      this.loadScript();
    }
  },
  methods: {
    loadScript() {
      console.log(process.env.VUE_APP_KAKAOMAP_KEY);
      const script = document.createElement("script");
      script.src = `//dapi.kakao.com/v2/maps/sdk.js?appkey=${process.env.VUE_APP_KAKAOMAP_KEY}&autoload=false`; // &autoload=false api를 로드한 후 맵을 그리는 함수가 실행되도록 구현
      script.onload = () => window.kakao.maps.load(this.loadMap); // 스크립트 로드가 끝나면 지도를 실행될 준비가 되어 있다면 지도가 실행되도록 구현

      document.head.appendChild(script); // html>head 안에 스크립트 소스를 추가
    },
    loadMap() {
      const container = document.getElementById("map"); // 지도를 담을 DOM 영역
      const options = {
        // 지도를 생성할 때 필요한 기본 옵션
        center: new window.kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3, // 지도의 레벨(확대, 축소 정도)
      };

      this.map = new window.kakao.maps.Map(container, options); // 지도 생성 및 객체 리턴
    },
  },
};
</script>

<style>
.map__box {
  display: flex;
  justify-content: space-between;
  align-content: center;
  margin-bottom: 20px;
}
.map {
  width: 100%;
  height: 600px;
}
.map__select__box {
  width: 310px;
  display: flex;
  align-content: center;
  justify-content: space-between;
}
.map__select {
  text-align-last: center;
  width: 200px;
}
.map__search {
  width: 200px;
}
.map__box input,
.map__box select {
  height: 30px;
  width: 150px;
  padding: 0px;
  margin: 0px;
}
.map__checkbox__box {
  display: flex;
  align-content: center;
}
.map__checkbox-label {
  position: relative;
  text-align: right;
  width: auto;
  top: 2px;
  margin-right: 5px;
}
.map__checkbox__box > .map__checkbox-chkbox {
  position: relative;
  width: 16px;
  margin-right: 15px;
}
</style>
