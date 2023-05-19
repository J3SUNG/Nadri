import Vue from "vue";
import VueRouter from "vue-router";
import AppHome from "@/views/AppHome.vue";
import AppLogin from "@/views/AppLogin.vue";
import AppMypage from "@/views/AppMypage.vue";
import AppFindPwd from "@/views/AppFindPwd.vue";
import AppBoard from "@/views/AppBoard.vue";
import AppBoardDetail from "@/views/AppBoardDetail.vue";
import AppBoardCreate from "@/views/AppBoardCreate.vue";
import AppBoardUpdate from "@/views/AppBoardUpdate.vue";
import AppNotifyDetail from "@/views/AppNotifyDetail.vue";
import AppNotifyCreate from "@/views/AppNotifyCreate.vue";
import AppNotifyUpdate from "@/views/AppNotifyUpdate.vue";
import AppPlan from "@/views/AppPlan.vue";
import AppNotify from "@/views/AppNotify.vue";
import AppMap from "@/views/AppMap.vue";
import AppSignup from "@/views/AppSignup.vue";
import AppError from "@/views/AppError.vue";

import store from "@/store";

Vue.use(VueRouter);

// https://v3.router.vuejs.org/kr/guide/advanced/navigation-guards.html
const onlyAuthUser = async (to, from, next) => {
  const checkUserInfo = store.getters["memberStore/checkUserInfo"];
  const checkToken = store.getters["memberStore/checkToken"];
  let token = sessionStorage.getItem("access-token");
  console.log("로그인 처리 전", checkUserInfo, token);

  if (checkUserInfo != null && token) {
    console.log("토큰 유효성 체크하러 가자!!!!");
    await store.dispatch("memberStore/getUserInfo", token);
  }
  if (!checkToken || checkUserInfo === null) {
    alert("로그인이 필요한 페이지입니다..");
    // next({ name: "login" });
    // router.push({ name: "AppLogin" });
  } else {
    console.log("로그인 했다!!!!!!!!!!!!!.");
    next();
  }
};

const routes = [
  {
    path: "/",
    name: "AppHome",
    component: AppHome,
  },
  {
    path: "/login",
    name: "AppLogin",
    component: AppLogin,
  },
  {
    path: "/mypage",
    name: "AppMypage",
    component: AppMypage,
  },
  {
    path: "/findPwd",
    name: "AppFindPwd",
    component: AppFindPwd,
  },
  {
    path: "/plan",
    name: "AppPlan",
    component: AppPlan,
  },
  {
    path: "/board",
    name: "AppBoard",
    component: AppBoard,
  },
  {
    path: "/boardDetail/:boardNo",
    name: "AppBoardDetail",
    component: AppBoardDetail,
  },
  {
    path: "/boardUpdate/:boardNo",
    name: "AppBoardUpdate",
    beforeEnter: onlyAuthUser,
    component: AppBoardUpdate,
  },
  {
    path: "/boardCreate/:boardType",
    name: "AppBoardCreate",
    beforeEnter: onlyAuthUser,
    component: AppBoardCreate,
  },
  {
    path: "/notifyDetail/:boardNo",
    name: "AppNotifyDetail",
    component: AppNotifyDetail,
  },
  {
    path: "/notifyUpdate/:boardNo",
    name: "AppNotifyUpdate",
    beforeEnter: onlyAuthUser,
    component: AppNotifyUpdate,
  },
  {
    path: "/notifyCreate",
    name: "AppNotifyCreate",
    beforeEnter: onlyAuthUser,
    component: AppNotifyCreate,
  },
  {
    path: "/notify",
    name: "AppNotify",
    component: AppNotify,
  },
  {
    path: "/map",
    name: "AppMap",
    component: AppMap,
  },
  {
    path: "/signup",
    name: "AppSignup",
    component: AppSignup,
  },
  {
    path: "/*",
    name: "AppError",
    component: AppError,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
