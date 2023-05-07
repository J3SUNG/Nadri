import { createWebHistory, createRouter } from "vue-router";

const router = createRouter({
  history: createWebHistory(),
  routes: [{ path: "/", name: "index", component: "index" }],
});

export default router;
