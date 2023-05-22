<template>
    <div class="search__box">
        <select name="subject" class="search-select">
            <option disabled selected>제목</option>
            <option value="nickname">닉네임</option>
        </select>
        <input class="search-input"/>
        <button class="search-button" @click="clickSearch">검색</button>
    </div>
</template>
  
<script>
  export default {
    name: "TheSearch",
    methods: {
        clickSearch() {
            //검색
        }
    }
  };
</script>
  
<style>
.search__box {
  width: 360px;
  display:flex;
  justify-content: space-around;
  align-items: center;
}
.search__box input,
.search__box select{
  font-size: 12px;
  padding: 8px 0px 8px 10px;  
}
.search-select {
  width: 80px;
  text-align: left;
}
.search-input {
  margin-left: 10px;
  width: 200px;
}
.search-button {
  font-size: 12px;
  width: 60px;
  padding: 8px;
}
</style>
  