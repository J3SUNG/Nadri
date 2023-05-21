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
    <div id="map" class="map">
      <div class="map__test">hello</div>
    </div>
  </div>
</template>

<script>
import http from "@/util/http-common";
export default {
  name: "TheMap",
  data() {
    return {
      map: null,
      sidos: [{ sidoNo: 0, sidoName: null }],
      guguns: [{ gugunNo: 0, sidoNo: 0, gugunName: null }],
      sidoCode: 0,
      gugunCode: 0,
      contentType: 0,
      markers: [],
      positions: [],
      input: {
        image: "",
      },
    };
  },
  created() {
    http.get(`sidogugun`).then(({ data }) => {
      this.sidos = data;
    });
    let item = {
      //전국 좋아요 상위 200개? //현재는 테스트로 그냥 20개 가져옴
      areaCode: 0,
      sigunguCode: 0,
      types: [0],
    };
    this.getAttrs(item);
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
      this.gugunCode = 0;

      //해당 시도 코드로 sidos 서버에서 가져오기
      http.get(`sidogugun/${this.sidoCode}`).then(({ data }) => {
        this.guguns = data;
      });
      //getAttrs();
    },
    changeGugun() {
      console.log("구군 선택 ::: " + this.gugunCode);
      //getAttrs();
    },
    getAttrs(item) {
      http.post(`/map`, JSON.stringify(item)).then(({ data }) => {
        // console.log(data);
        this.setMarkers(data);
        //가져왔다 이제 맵에 찍어주심 됌!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
      });
    },
    setMarkers(data) {
      this.positions = [];
      //removeMarkers(); //기존에 있던 마커들을 지운다.
      // console.log(data);
      data.forEach((area) => {
        // console.log(area.latitude, area.longitude);
        let markerInfo = {
          title: area.title, // 관광지 이름
          latlng: new window.kakao.maps.LatLng(area.latitude, area.longitude), // 위도 경도 정보 가지고 좌표값 가진 객체 생성
        };
        this.positions.push(markerInfo);
        // console.log(markerInfo);
      });
      this.displayMarker();
    },
    removeMarker() {
      // for (var i = 0; i < markers.length; i++) {
      //   // 좌표 넣어둔 배열만큼
      //   markers[i].setMap(null);
      // }
    },
    displayMarker() {
      // 마커 이미지의 이미지 주소입니다

      var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; // 마커 이미지

      for (var i = 0; i < this.positions.length; i++) {
        // 좌표 넣어둔 배열만큼
        // 마커 이미지의 이미지 크기 입니다
        let imageSize = new window.kakao.maps.Size(24, 35);
        // console.log(imageSrc);
        // console.log(imageSize);
        // 마커 이미지를 생성합니다
        let markerImage = new window.kakao.maps.MarkerImage(imageSrc, imageSize);
        // console.log(markerImage);
        // 마커를 생성합니다
        var marker = new window.kakao.maps.Marker({
          // map: this.map, // 마커를 표시할 지도
          position: this.positions[i].latlng, // 마커를 표시할 위치
          title: this.positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
          image: markerImage, // 마커 이미지
        });
        // let marker = new window.kakao.maps.Marker({
        //   position: this.positions,
        // });
        // console.log(marker);

        console.log("마커를 보여주자");
        marker.setMap(this.map);

        // 생성된 마커를 배열에 추가합니다
        this.markers.push(marker);

        // infowindow
        // var infowindow = window.kakao.maps.InfoWindow({
        //   content: this.positions[i].title,
        //   position: this.positions[i].latLng,
        // });

        // 마커 이벤트 추가 (누르면 정보 오버레이 표시)
        // window.kakao.maps.event.addListener(marker, "click", makeClickListener(marker, infowindow));

        // function makeClickListener(marker, infowindow) {
        //   return function () {
        //     !!selectedInfoWindow && selectedInfoWindow.close();
        //     infowindow.open(this.map, marker);
        //     // selectedMarker = selected;
        //     selectedInfoWindow = infowindow;
        //   };
        // }
      }

      // 첫번째 검색 정보를 이용하여 지도 중심을 이동 시킵니다
      this.map.setCenter(this.positions[0].latlng);
      // markers가 다 보이게 레벨 자동으로 지정
      console.log(this.positions);
    },
  },
};
</script>

<style>
/* .map__test {
  width: 400px;
  height: 100vh;
  background-color: red;
  z-index: 1000;
  position: absolute;
} */
.map__box {
  display: flex;
  justify-content: space-between;
  align-content: center;
  margin-bottom: 20px;
}
.map {
  position: absolute;
  top: 0;
  left: 0;
  width: 100vw;
  height: 100vh;
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
