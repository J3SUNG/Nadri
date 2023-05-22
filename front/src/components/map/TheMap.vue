<template>
  <div>
    <div class="map__box">
      <div class="map__select__box">
        <select class="map__select map__select-sido" v-model="sidoCode" @change="changeSido">
          <option selected value="0">시도 선택</option>
          <option v-for="(sido, index) in sidos" :key="index" :value="sido.sidoNo">
            {{ sido.sidoName }}
          </option>
        </select>
        <select class="map__select map__select-gugun" v-model="gugunCode" @change="changeGugun">
          <option selected value="0">구군 선택</option>
          <option v-for="(gugun, index) in guguns" :key="index" :value="gugun.gugunNo">
            {{ gugun.gugunName }}
          </option>
        </select>
      </div>

      <!-- check box start  **************************-->
      <div class="map__checkbox__box">
        <label class="map__checkbox-label">관광지</label>
        <input
          class="map__checkbox-chkbox"
          type="checkbox"
          name="attr"
          v-model="contentType"
          value="12"
          @change="changeContentType"
        />
        <label class="map__checkbox-label">문화시설</label>
        <input
          class="map__checkbox-chkbox"
          type="checkbox"
          name="attr"
          v-model="contentType"
          value="14"
          @change="changeContentType"
        />
        <label class="map__checkbox-label">행사</label>
        <input
          class="map__checkbox-chkbox"
          type="checkbox"
          name="attr"
          v-model="contentType"
          value="15"
          @change="changeContentType"
        />
        <label class="map__checkbox-label">여행코스</label>
        <input
          class="map__checkbox-chkbox"
          type="checkbox"
          name="attr"
          v-model="contentType"
          value="25"
          @change="changeContentType"
        />
        <label class="map__checkbox-label">레포츠</label>
        <input
          class="map__checkbox-chkbox"
          type="checkbox"
          name="attr"
          v-model="contentType"
          value="28"
          @change="changeContentType"
        />
        <label class="map__checkbox-label">숙박</label>
        <input
          class="map__checkbox-chkbox"
          type="checkbox"
          name="attr"
          v-model="contentType"
          value="32"
          @change="changeContentType"
        />
        <label class="map__checkbox-label">쇼핑</label>
        <input
          class="map__checkbox-chkbox"
          type="checkbox"
          name="attr"
          v-model="contentType"
          value="38"
          @change="changeContentType"
        />
        <label class="map__checkbox-label">음식점</label>
        <input
          class="map__checkbox-chkbox"
          type="checkbox"
          name="attr"
          v-model="contentType"
          value="39"
          @change="changeContentType"
        />
      </div>
      <!-- 12:관광지, 14:문화시설, 15:축제공연행사, 25:여행코스, 28:레포츠, 32:숙박, 38:쇼핑, 39:음식점-->
      <!-- check box        ***************************-->
      <input class="map__search" v-model="search" />
    </div>
    <div id="map" class="map">
      <map-left />
    </div>
    <div>
      <div v-for="(item, index) in positions" :key="index">
        <img :src="item.image1" />
        <!-- <img :src="item.image2" /> -->
        <!-- 아마 image2가 썸네일 용이라 저화질, image가 없을때 no image 처리 필요-->
        <div>{{ item.title }} {{ item.addr1 }} {{ item.addr2 }} {{ item.tel }}</div>
        <div>{{ item.overview }}</div>
      </div>
    </div>
  </div>
</template>

<script>
import http from "@/util/http-common";
import MapLeft from "./MapLeft.vue";
export default {
  components: { MapLeft },
  name: "TheMap",
  data() {
    return {
      map: null,
      search: "",
      sidos: [{ sidoNo: 0, sidoName: null }],
      guguns: [{ gugunNo: 0, sidoNo: 0, gugunName: null }],
      sidoCode: 0,
      gugunCode: 0,
      contentType: [],
      markers: [],
      positions: [],
      file_name: "파일을 선택하세요.",
      message: "Hello, world",
      file: "",
      img_src: "",
    };
  },
  created() {},
  async mounted() {
    if (window.kakao && window.kakao.maps) {
      // 카카오 객체가 있고, 카카오 맵그릴 준비가 되어 있다면 맵 실행
      // console.log("loadmap");
      this.loadMap();
    } else {
      // 없다면 카카오 스크립트 추가 후 맵 실행
      // console.log("loadscript");
      this.loadScript();
    }

    await http.get(`sidogugun`).then(({ data }) => {
      this.sidos = data;
    });
    let item = {
      //전국 좋아요 상위 200개? //현재는 테스트로 그냥 10개 가져옴
      areaCode: 0,
      sigunguCode: 0,
      contentType: ["0"],
      search: "",
    };
    // console.log("search : " + this.search);
    this.getAttrs(item);
  },
  methods: {
    loadScript() {
      const script = document.createElement("script");
      script.src = `//dapi.kakao.com/v2/maps/sdk.js?appkey=${process.env.VUE_APP_KAKAOMAP_KEY}&autoload=false`; // &autoload=false api를 로드한 후 맵을 그리는 함수가 실행되도록 구현
      script.onload = () => window.kakao.maps.load(this.loadMap); // 스크립트 로드가 끝나면 지도를 실행될 준비가 되어 있다면 지도가 실행되도록 구현

      document.head.appendChild(script); // html>head 안에 스크립트 소스를 추가
    },
    loadMap() {
      const container = document.getElementById("map"); // 지도를 담을 DOM 영역
      const options = {
        // 지도를 생성할 때 필요한 기본 옵션
        center: new window.kakao.maps.LatLng(35.87222, 127.6025), // 지도의 중심좌표
        level: 13, // 지도의 레벨(확대, 축소 정도)
      };
      this.map = new window.kakao.maps.Map(container, options); // 지도 생성 및 객체 리턴
    },

    changeSido() {
      console.log("시도 선택 ::: " + this.sidoCode);
      this.gugunCode = "0";

      //해당 시도 코드로 sidos 서버에서 가져오기
      http.get(`sidogugun/${this.sidoCode}`).then(({ data }) => {
        this.guguns = data;
      });

      let item = {
        //전국 좋아요 상위 200개? //현재는 테스트로 그냥 20개 가져옴
        areaCode: this.sidoCode,
        sigunguCode: this.gugunCode,
        contentType: this.contentType,
      };
      this.getAttrs(item);
    },
    changeGugun() {
      // this.levelSet(9);
      console.log("구군 선택 ::: " + this.gugunCode);
      let item = {
        areaCode: this.sidoCode,
        sigunguCode: this.gugunCode,
        contentType: this.contentType,
      };
      this.getAttrs(item);
    },
    changeContentType() {
      // let value = e.target.value;
      let item = {
        areaCode: this.sidoCode,
        sigunguCode: this.gugunCode,
        contentType: this.contentType,
      };
      // item.contentType.push(value);
      console.log("change content type ");
      console.log(item);
      this.getAttrs(item);
    },
    getAttrs(item) {
      if (item.contentType.length == 0) {
        console.log("item cont-type null");
        item.contentType = ["0"];
      }
      item.search = this.search;
      console.log(item);
      http.post(`/map`, JSON.stringify(item)).then(({ data }) => {
        // console.log("관광지 데이터 갱신");
        this.attractions = data;
        // console.log(this.attractions);
        if (!this.attractions.length == 0) this.setMarkers(data);
        else alert("검색 결과가 없습니다.");
      });
    },
    setMarkers(data) {
      this.positions = [];
      this.removeMarkers(); //기존에 있던 마커들을 지운다.
      // console.log(data);
      data.forEach((area) => {
        let markerInfo = {
          title: area.title, // 관광지 이름
          contentType: area.contentType,
          latlng: new window.kakao.maps.LatLng(area.latitude, area.longitude), // 위도 경도 정보 가지고 좌표값 가진 객체 생성
          addr1: area.addr1,
          addr2: area.addr2,
          attractionNo: area.attractionNo,
          gugunCode: area.gugunCode,
          image1: area.image1,
          image2: area.image2,
          overview: area.overview,
          sidoCode: area.sidoCode,
          tel: area.tel,
          zipcode: area.zipcode,
        };
        if (markerInfo.image1 == "") {
          markerInfo.image1 =
            "https://media.istockphoto.com/id/1357365823/vector/default-image-icon-vector-missing-picture-page-for-website-design-or-mobile-app-no-photo.jpg?s=612x612&w=0&k=20&c=PM_optEhHBTZkuJQLlCjLz-v3zzxp-1mpNQZsdjrbns=";
          // console.log("no-image");
        }
        this.positions.push(markerInfo);
        // console.log(markerInfo);
      });
      this.displayMarker();
    },
    removeMarkers() {
      if (this.markers.length > 0) {
        this.markers.forEach((item) => {
          item.setMap(null);
        });
      }
    },
    displayMarker() {
      let imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; // 마커 이미지
      let imageSize = new window.kakao.maps.Size(24, 35); //마커 이미지 크기
      let markerImage = new window.kakao.maps.MarkerImage(imageSrc, imageSize);
      //console.log(this.positions[0].contentType); //타입 별로 다른 마커 이미지 구현!!!!!!!XXXXXXXXXXXXXXXXXXXXXXXX
      // let bounds = new window.kakao.maps.LatLngBounds(); // 지도 범위 재설정

      this.positions.forEach((position) => {
        const infowindow = new window.kakao.maps.InfoWindow({
          content: `<img src="${position.image1}" width="100px" height="100px"/><p>
          ${position.title}<br>
          주소 : ${position.addr1} ${position.addr2}<br>
          </p>`,
          removable: false,
        });

        const marker = new window.kakao.maps.Marker({
          map: this.map, // 마커를 표시할 지도
          position: position.latlng, // 마커를 표시할 위치
          title: position.title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
          image: markerImage, // 마커 이미지
        });

        // 마커에 클릭이벤트를 등록
        window.kakao.maps.event.addListener(marker, "mouseover", () => {
          infowindow.open(this.map, marker);
        });
        window.kakao.maps.event.addListener(marker, "mouseout", () => {
          infowindow.close(this.map, marker);
        });
        this.markers.push(marker);
      }); //positions foreach end ****************

      // bounds에 추가된 마커들에 대해 지도 범위 재설정 ******************
      const bounds = this.positions.reduce(
        (bounds, position) => bounds.extend(position.latlng),
        new window.kakao.maps.LatLngBounds()
      );
      this.map.setBounds(bounds);
    },
  },
};
</script>

<style>
.map__left {
  width: 400px;
  height: 100vh;
  background-color: tomato;
  position: absolute;
  z-index: 10;
}
.map__box {
  display: flex;
  justify-content: space-between;
  align-content: center;
  margin-bottom: 20px;
}
.map {
  position: absolute;
  left: 0;
  top: 0;
  width: 100vw;
  height: 100vh;
  z-index: 0;
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
