<script setup>
import LoginAuthButtonContent from "@/components/LoginAuthButtonContent.vue";
import RegisterAuthButtonContent from "@/components/RegisterAuthButtonContent.vue";
import {computed} from "vue";
import {authPanType} from "@/router/index.js";

const props = defineProps({
  login: Boolean,
  panState: Number
});

const emit = defineEmits(['update:panState']);
const setPanState = (state) => emit('update:panState', state);

function addBlur() {
  const authorization = document.querySelector(".header-container__authorization");

  if (authorization) {
    // Устанавливаем фильтр blur, если он ещё не применён
    authorization.style.backdropFilter = "blur(15px)";
  }
}

function delBlur() {
  const authorization = document.querySelector(".header-container__authorization");

  if (authorization) {
    // Убираем фильтр blur
    authorization.style.backdropFilter = "blur(0px)";
  }
}
</script>

<template>
  <div v-if="login">
    <LoginAuthButtonContent @open="addBlur" @close="delBlur" :closeAction="() => setPanState(authPanType.HIDE)" :registerAction="() => setPanState(authPanType.REGISTER)"/>
  </div>
  <div v-else>
    <RegisterAuthButtonContent @open="addBlur" @close="delBlur" :closeAction="() => setPanState(authPanType.HIDE)" :loginAction="() => setPanState(authPanType.LOGIN)"/>
  </div>
</template>

<style scoped>

</style>