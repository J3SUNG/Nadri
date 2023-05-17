import Vue from "vue";
import VueRouter from "vue-router";
import AppHome from "@/views/AppHome.vue";
import AppLogin from "@/views/AppLogin.vue";
import AppFindPwd from "@/views/AppFindPwd.vue";
import AppBoard from "@/views/AppBoard.vue";
import AppBoardDetail from "@/views/AppBoardDetail.vue";
import AppBoardCreate from "@/views/AppBoardCreate.vue";
import AppBoardUpdate from "@/views/AppBoardUpdate.vue";
import AppPlan from "@/views/AppPlan.vue";
import AppNotify from "@/views/AppNotify.vue";
import AppMap from "@/views/AppMap.vue";
import AppSignup from "@/views/AppSignup.vue";
import AppError from "@/views/AppError.vue";

Vue.use(VueRouter);

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
    path: "/boardCreate",
    name: "AppBoardCreate",
    component: AppBoardCreate,
  },
  {
    path: "/boardDetail",
    name: "AppBoardDetail",
    component: AppBoardDetail,
  },
  {
    path: "/boardUpdate/:boardNo",
    name: "AppBoardUpdate",
    component: AppBoardUpdate,
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
