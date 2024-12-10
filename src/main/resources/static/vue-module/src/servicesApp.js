import {createApp} from "vue";
import ServicesApp from "./ServicesApp.vue";
import router from "@/router/index.js";

createApp(ServicesApp).use(router).mount("#services");