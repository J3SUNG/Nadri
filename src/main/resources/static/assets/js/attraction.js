addEventListener("change", (e) => {
  if (e.target.id == "region-first") {
    //중도시 분류 가져오기
    let regionSecondURL = `https://apis.data.go.kr/B551011/KorService1/areaCode1?serviceKey=${serviceKey}&numOfRows=100&pageNo=1&MobileOS=ETC&MobileApp=AppTest&areaCode=${
      e.target.options[e.target.selectedIndex].value
    }&_type=json`;
    fetch(regionSecondURL)
      .then((res) => res.json())
      .then((data) => {
        data = data.response.body.items.item;
        document.querySelector("#region-second").innerHTML = data
          .map((e) => `<option value=${e.code}>${e.name}</option>`)
          .join("");
        moveMap();
      });
  }
  if (e.target.id == "region-second") {
    moveMap();
  }

  if (e.target.id == "content-type") {
    moveMap();
  }
});
//json데이터 가져오기
//대도시 분류 가져오기
let serviceKey =
  "NMaARK0RMfP3hYIPho85eW9zoinYx5HU4Ew2s4fkjE%2BrLeCgqu4YM0Kgt2h3ufKMwG4yXYGoLIM6IwhrwbyFzg%3D%3D";
let regionFirstURL = `https://apis.data.go.kr/B551011/KorService1/areaCode1?serviceKey=${serviceKey}&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json`;
fetch(regionFirstURL)
  .then((res) => res.json())
  .then((data) => makeFirstOption(data.response.body.items.item));
const makeFirstOption = (data) => {
  const list = document.querySelector("#region-first");
  list.innerHTML += data.map((e) => `<option value=${e.code}>${e.name}</option>`).join("");
  //중도시 분류 가져오기
  let regionSecondURL = `https://apis.data.go.kr/B551011/KorService1/areaCode1?serviceKey=${serviceKey}&numOfRows=100&pageNo=1&MobileOS=ETC&MobileApp=AppTest&areaCode=${
    list.options[list.selectedIndex].value
  }&_type=json`;
  fetch(regionSecondURL)
    .then((res) => res.json())
    .then((data) => {
      data = data.response.body.items.item;
      document.querySelector("#region-second").innerHTML = data
        .map((e) => `<option value=${e.code}>${e.name}</option>`)
        .join("");
      moveMap();
    });
};

