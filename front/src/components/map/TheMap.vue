<template>
  <div>
    <div class="map__hide-footer"></div>
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
      <input
        class="map__search"
        v-model="search"
        placeholder="주소 검색"
        @change="changeContentType"
      />
    </div>
    <div id="map" class="map">
      <div class="map__left">
        <div
          class="map__left__box"
          v-for="(item, index) in positions"
          :key="index"
          @click="detailView(item.attractionNo)"
        >
          <img class="map__left__box__img" :src="item.image1" />
          <!-- <img :src="item.image2" /> -->
          <!-- 아마 image2가 썸네일 용이라 저화질, image가 없을때 no image 처리 필요-->
          <div class="map__left__box__main">
            <div class="map__left__box__main__up">
              <h2 class="map__left__box__main__up__title">{{ item.title }}</h2>
              <p class="map__left__box__main__up__type">{{ type[item.contentType] }}</p>
            </div>
            <p class="map__left__box__main__addr">{{ item.addr1 }}</p>
            <p class="map__left__box__main__tel">{{ item.tel }}</p>
          </div>
          <!-- <div>{{ item.overview }}</div> -->
        </div>
      </div>
      <div :class="{ map__detail: true, map__detail__hide: detailHide }" @click="showTripNote">
        <img class="map__detail__img" :src="this.attr.image1" />
        <p class="map__detail__title">{{ this.attr.title }}</p>
        <p class="map__detail__addr1">주소 : {{ this.attr.addr1 }}</p>
        <p class="map__detail__tel">전화번호 : {{ this.attr.tel }}</p>
        <p class="map__detail__overview">{{ this.attr.overview }}</p>
        <button class="map__detail__btn" @click.prevent="closeDetail">x</button>
        <button class="map__detail__add" @click.prevent="addCourse">+</button>
      </div>
      <div class="map__course__toggle" v-if="isLogin && noteHide" @click="showTripNote">
        <p class="map__course__toggle__text">여행노트 작성</p>
      </div>
      <div class="map__course" v-if="isLogin && !noteHide">
        <h2 class="map__course__title">여행노트</h2>
        <hr class="map__course__hr" />
        <ul class="map__course__box__ul">
          <li class="map__course__box" v-for="(list, index) in lists" :key="list.attractionNo">
            <div class="map__course__box__small">
              <p class="map__course__box__index">{{ index * 1 + 1 }}번</p>
              <p class="map__course__box__title">{{ list.title }}{{ list.title }}</p>
            </div>
            <div class="map__course__box__small">
              <p class="map__course__box__memo">메모</p>
              <textarea class="map__course__box__input" v-model="listMemos[index]"></textarea>
            </div>
            <hr class="map__course__box__hr" />
          </li>
        </ul>
        <div class="map__course__main">
          <div class="map__course__title__box">
            <label class="map__course__title-label">제목</label>
            <input class="map__course__title-input" v-model="title" />
          </div>
          <div class="map__course__content__box">
            <label class="map__course__content-label">내용</label>
            <textarea class="map__course__content-input" v-model="content"></textarea>
          </div>
        </div>
        <div class="map__course__btn__box">
          <button class="map__course__btn map__course__post" @click.prevent="createTripNote">
            노트 생성
          </button>
          <button class="map__course__btn map__course__cancel" @click.prevent="cancelTripNote">
            취소
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import http from "@/util/http-common";
import { mapState } from "vuex";

const memberStore = "memberStore";
export default {
  name: "TheMap",
  computed: {
    ...mapState(memberStore, ["userInfo"]),
  },
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
      type: {
        12: "관광지",
        14: "문화시설",
        15: "행사",
        25: "여행코스",
        28: "레포츠",
        32: "숙박",
        38: "쇼핑",
        39: "음식점",
      },
      attr: "",
      attrNo: 0,
      userNo: 0,
      detailHide: true,
      noteHide: true,
      lists: [],
      listMemos: [],
      title: "",
      content: "",
      isLogin: false,
      polyline: "",
    };
  },
  created() {
    if (this.userInfo !== null) {
      this.userNo = this.userInfo.userNo;
      this.isLogin = true;
    }
  },
  async mounted() {
    let paramContentType = ["0"];
    let paramSearch = "";
    if (this.$route.params.contentType !== undefined) {
      this.contentType = this.$route.params.contentType;
      paramContentType = this.$route.params.contentType;
    }
    if (this.$route.params.search !== undefined) {
      this.search = this.$route.params.search;
      paramSearch = this.$route.params.search;

      this.detailView(this.$route.params.attractionNo);
    }
    if (window.kakao && window.kakao.maps) {
      // 카카오 객체가 있고, 카카오 맵그릴 준비가 되어 있다면 맵 실행
      // console.log("loadmap");
      await this.loadMap();
    } else {
      // 없다면 카카오 스크립트 추가 후 맵 실행
      // console.log("loadscript");
      await this.loadScript();
    }

    await http.get(`sidogugun`).then(({ data }) => {
      this.sidos = data;
    });
    let item = {
      //전국 좋아요 상위 200개? //현재는 테스트로 그냥 10개 가져옴
      areaCode: 0,
      sigunguCode: 0,
      contentType: paramContentType,
      search: paramSearch,
    };
    // console.log("search : " + this.search);
    await this.getAttrs(item);
  },
  methods: {
    loadScript() {
      const script = document.createElement("script");
      script.async = true;
      script.src = `//dapi.kakao.com/v2/maps/sdk.js?appkey=${process.env.VUE_APP_KAKAOMAP_KEY}&autoload=false`; // &autoload=false api를 로드한 후 맵을 그리는 함수가 실행되도록 구현
      document.head.appendChild(script); // html>head 안에 스크립트 소스를 추가
      script.onload = () => window.kakao.maps.load(this.loadMap); // 스크립트 로드가 끝나면 지도를 실행될 준비가 되어 있다면 지도가 실행되도록 구현
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
      let imageSrc = {
        12: require("@/assets/type_back_2/type_back_trip.png"),
        14: require("@/assets/type_back_2/type_back_cultural.png"),
        15: require("@/assets/type_back_2/type_back_event.png"),
        25: require("@/assets/type_back_2/type_back_course.png"),
        28: require("@/assets/type_back_2/type_back_leport.png"),
        32: require("@/assets/type_back_2/type_back_home.png"),
        38: require("@/assets/type_back_2/type_back_shopping.png"),
        39: require("@/assets/type_back_2/type_back_food.png"),
      }; // 마커 이미지
      let imageSize = new window.kakao.maps.Size(35, 35); //마커 이미지 크기
      //let imageOption = { offset: new window.kakao.maps.Point(27, 69) }; //마커 옵션 마커와 커스텀 오버레이 위치가 안맞을때

      console.log(window.kakao.maps);
      let markerImage;
      console.log(this.positions);
      console.log(this.positions[0].contentType); //타입 별로 다른 마커 이미지 구현!!!!!!!XXXXXXXXXXXXXXXXXXXXXXXX
      // let bounds = new window.kakao.maps.LatLngBounds(); // 지도 범위 재설정

      this.positions.forEach((position) => {
        const overlay = new window.kakao.maps.CustomOverlay({
          content: `<div class="customoverlay">
      <a href="https://map.kakao.com/link/map/11394059" target="_blank">
        <span class="title">${position.title}</span>
      </a>
    </div>`,
          position: position.latlng,
          //yAnchor: 2.7,//올려주기
        });
        markerImage = new window.kakao.maps.MarkerImage(
          imageSrc[position.contentType],
          imageSize
          //imageOption
        );

        const marker = new window.kakao.maps.Marker({
          map: this.map, // 마커를 표시할 지도
          position: position.latlng, // 마커를 표시할 위치
          title: position.title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
          image: markerImage, // 마커 이미지
        });

        // 마커에 클릭이벤트를 등록
        window.kakao.maps.event.addListener(marker, "click", () => {
          this.detailView(position.attractionNo);
        });
        window.kakao.maps.event.addListener(marker, "mouseover", () => {
          overlay.setMap(this.map);
        });
        window.kakao.maps.event.addListener(marker, "mouseout", () => {
          overlay.setMap(null);
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
    cancelTripNote() {
      this.noteHide = true;
      this.lists = [];
      if (this.polyline.setMap !== undefined) {
        this.polyline.setMap(null);
      }
    },
    showTripNote() {
      this.noteHide = false;
    },
    closeDetail() {
      this.detailHide = true;
    },
    detailView(num) {
      http.get(`map/${num}/${this.userNo}`).then((response) => {
        this.attr = response.data;
        console.log(this.attr);
        if (this.attr.image1 === "") {
          this.attr.image1 =
            "https://media.istockphoto.com/id/1357365823/vector/default-image-icon-vector-missing-picture-page-for-website-design-or-mobile-app-no-photo.jpg?s=612x612&w=0&k=20&c=PM_optEhHBTZkuJQLlCjLz-v3zzxp-1mpNQZsdjrbns=";
        }
      });
      this.detailHide = false;
    },
    addCourse() {
      this.lists.push(this.attr);
      console.log(this.lists);
      this.closeDetail();
      this.drawLine();
    },
    drawLine() {
      var linePath = [];
      for (let i = 0; i < this.lists.length; ++i) {
        console.log(this.lists[i].latitude);
        console.log(this.lists[i].longitude);
        linePath[i] = new window.kakao.maps.LatLng(this.lists[i].latitude, this.lists[i].longitude);
      }

      // 지도에 표시할 선을 생성합니다
      this.polyline = new window.kakao.maps.Polyline({
        path: linePath, // 선을 구성하는 좌표배열 입니다
        strokeWeight: 5, // 선의 두께 입니다
        strokeColor: "red", // 선의 색깔입니다
        strokeOpacity: 0.7, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
        strokeStyle: "solid", // 선의 스타일입니다
      });

      this.polyline.setMap(this.map);
    },
    createTripNote() {
      let tripsData = [];
      for (let i = 0; i < this.lists.length; ++i) {
        tripsData[i] = {
          order: i,
          memo: this.listMemos[i],
          attractionNo: this.lists[i].attractionNo,
          image1: this.lists[i].image1,
        };
        console.log("@@");
        console.log(this.lists[0]);
      }
      let planData = {
        subject: this.title,
        content: this.content,
        userNo: this.userNo,
        trips: tripsData,
      };
      console.log("!!!!");
      console.log(planData);
      http.post(`plan`, JSON.stringify(planData)).then((response) => {
        console.log(response);
        if (response.data === "success") {
          alert(`성공`);
          this.$router.push({ name: "AppPlan" });
        } else {
          alert("실패");
        }
      });
    },
  },
};
</script>

<style>
.map__course__toggle {
  margin-top: 100px;
  width: 30px;
  padding: 20px;
  min-height: 100px;
  top: 45px;
  right: -5px;
  position: absolute;
  z-index: 10;
  backdrop-filter: brightness(20%);
  border-radius: 10px;
  cursor: pointer;
}
.map__course__toggle__text {
  font-size: 24px;
  color: var(--color-white);
}
.map__course {
  margin-top: 100px;
  width: 360px;
  padding: 0px 20px;
  min-height: 320px;
  max-height: 740px;
  top: 45px;
  right: 0px;
  position: absolute;
  z-index: 10;
  backdrop-filter: brightness(20%);
  border-radius: 5px;
  overflow: scroll;
  overflow-x: hidden;
  margin-bottom: 20px;
}
.map__course__title {
  margin-top: 20px;
}
.map__course__hr {
  width: 320px;
  margin: 20px 20px 0px 20px;
}
.map__course__box__ul {
  width: 320px;
  padding: 0px 20px;
  display: flex;
  justify-content: center;
  flex-direction: column;
}
.map__course__box {
  text-align: center;
  width: 100%;
}
.map__course__box__small {
  display: flex;
  align-items: center;
  width: 100%;
  margin-top: 20px;
}
.map__course__box p {
  color: var(--color-white);
}
.map__course__box__index {
  width: 40px;
  padding-right: 10px;
}
.map__course__box__title {
  text-align: left;
  width: 270px;
}
.map__course__box__input {
  width: 250px;
  height: 60px;
  padding: 10px;
  border-radius: 5px;
}
.map__course__box__memo {
  font-size: 14px;
  width: 40px;
  padding-right: 10px;
}
.map__course__box__hr {
  margin-top: 20px;
  color: gray;
}
.map__course__main {
  width: 320px;
  padding: 0px 20px;
  display: flex;
  justify-content: center;
  flex-direction: column;
}
.map__course__title__box {
  display: flex;
  align-items: center;
  width: 100%;
  margin-top: 20px;
}
.map__course__content__box {
  display: flex;
  align-items: center;
  width: 100%;
}
.map__course__title-label,
.map__course__content-label {
  width: 40px;
  padding-right: 10px;
  color: var(--color-white);
}
.map__course__title-input {
  width: 270px;
  border-radius: 5px;
}

.map__course__content-input {
  width: 250px;
  border-radius: 5px;
  height: 100px;
  padding: 10px;
}
.map__course__btn__box {
  display: flex;
  align-items: center;
  justify-content: space-around;
  margin-left: 40px;
  margin-top: 5px;
  margin-bottom: 15px;
}
.map__course__btn {
  padding: 5px;
  /* border: solid 3px tomato; */
  border-radius: 20px;
  background-color: var(--color-main);
  /* background-color: transparent; */
  color: white;
  font-size: 14px;
  width: 80px;
}
.map__course__cancel {
  background-color: var(--color-tomato);
}

.map__detail {
  margin-top: 100px;
  padding-bottom: 20px;
  width: 400px;
  min-height: 400px;
  max-height: 600px;
  top: 45px;
  left: 365px;
  position: absolute;
  z-index: 10;
  backdrop-filter: brightness(20%);
  border-radius: 5px;
  overflow: scroll;
  overflow-x: hidden;
}
.map__detail__img {
  margin-top: 20px;
  width: 340px;
  height: 240px;
}
.map__detail p {
  color: var(--color-white);
  width: 360px;
  text-align: left;
  margin: 0px 20px;
}
.map__detail__title {
  font-size: 24px;
  padding-bottom: 15px;
}
.map__detail__addr1 {
  font-size: 18px;
  padding-bottom: 10px;
}
.map__detail__tel {
  font-size: 18px;
  padding-bottom: 10px;
}
.map__detail__overview {
  font-size: 14px;
}
.map__detail__btn {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 40px;
  height: 40px;
  margin: 0px;
  background-color: transparent;
  font-size: 24px;
  border-radius: 70px;
  backdrop-filter: brightness(50%);
  position: absolute;
  right: 25px;
  top: 25px;
}
.map__detail__add {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 40px;
  height: 40px;
  margin: 0px;
  background-color: transparent;
  font-size: 24px;
  border-radius: 70px;
  backdrop-filter: brightness(50%);
  position: absolute;
  right: 25px;
  top: 215px;
}
.map__detail__hide {
  visibility: hidden;
}

.map__left {
  margin-top: 100px;
  width: 360px;
  height: 100vh;
  top: 45px;
  left: 0;
  position: absolute;
  z-index: 10;
  overflow: scroll;
  backdrop-filter: brightness(20%);
  border-radius: 5px;
  cursor: pointer;
  overflow-x: hidden;
}
.map__left p,
h2 {
  color: white;
}
.map__left__box {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100px;
  border-bottom: 1px solid;
}
.map__left__box:hover {
  /* animation: scaling 1s ease-in-out infinite; */
}
.map__left__box__img {
  margin-left: 10px;
  min-width: 80px;
  min-height: 80px;
  width: 80px;
  height: 80px;
  object-fit: cover;
}
.map__left__box__main {
  margin-left: 20px;
  width: 100%;
  flex-wrap: wrap;
  display: flex;
  flex-direction: column;
  align-items: start;
}
.map__left__box__main > p {
  font-size: 14px;
  text-align: left;
  width: 180px;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  height: 20px;
}
.map__left__box__main__up {
  width: 230px;
  margin-right: 20px;
  display: flex;
  align-items: center;
  justify-content: space-between;
  height: 40px;
}
.map__left__box__main__up__title {
  width: 180px;
  text-align: left;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  font-size: 16px;
}
.map__left__box__main__up__type {
  font-size: 14px;
}

.map__box {
  display: flex;
  justify-content: space-around;
  align-items: center;
  z-index: 10;
  position: absolute;
  top: 80px;
  width: 1140px;
  height: 60px;
  backdrop-filter: brightness(40%);
  border-radius: 10px;
}
.map {
  position: absolute;
  display: flex;
  justify-content: center;
  left: 0;
  top: 0;
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
  text-align: center;
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
.map__checkbox__box label {
  color: white;
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
