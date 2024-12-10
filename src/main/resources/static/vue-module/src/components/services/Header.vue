<script setup>
import Navigation from "@/components/services/Navigation.vue";
import HeaderAuthButton from "@/components/services/HeaderAuthButton.vue";
import {computed, onMounted, ref, watch, watchEffect} from "vue";
import {useRoute} from "vue-router";
import {authPanType, pageType} from "@/router/index.js";
import AuthButtonContent from "@/components/services/AuthButtonContent.vue";

let authContentType = ref(authPanType.HIDE);

function showDefAuthPan() {
  authContentType.value = authPanType.LOGIN;
}

async function logout() {
  await fetch('/authorization/logout', {
    method: "POST"
  }).then(() => {
    window.location.reload();
  });
}

const currentPagePath = computed(() => pagePath.value);
const accountIconPath = "/images/account_icon.png";

const isLogin = ref(false);

onMounted(async () => {
  const f = await fetch('/api/authorization/check_auth_status')
  if(f.ok) isLogin.value = await f.text() === 'true';
});

const lightTheme = ref(true);
const themeIconPath = computed(() => `/images/${lightTheme.value ? "light" : "dark"}_theme.png`);
const logoPath = computed(() => `/images/logo_${lightTheme.value ? "light" : "dark"}.png`);
const changeTheme = () => {
  lightTheme.value = !lightTheme.value;
  document.body.classList.toggle("dark-theme");
}
</script>

<template>
  <div class="header-container">
    <div class="header-container__content">
      <div class="header-container__left">
        <img class="header-container__logo-icon" :src="logoPath" alt="Logo"/>
      </div>
      <div class="header-container__right">
        <span class="header-container__plan header-button">Тарифный план</span>
        <span class="header-container__api header-button">Действия с API</span>
        <div class="header-container__dividing-line"></div>
        <a class="header-container__account-login" v-if="!isLogin" @click="showDefAuthPan">Войти</a>
        <a class="header-container__account-register" v-if="!isLogin">Регистрация</a>
        <a class="header-container__account-logout" v-if="isLogin" @click="logout">Выход</a>
        <a class="header-container__theme-changer" @click="changeTheme"><img :src="themeIconPath" alt="current_theme_icon" /></a>
<!--        <HeaderAuthButton @click="showDefAuthPan" :isLogin="isLogin" v-if="isLogin === false"/>
        <HeaderAuthButton @click="logout" :isLogin="isLogin" v-if="isLogin === true"/>-->
      </div>
    </div>
    <div v-if="authContentType === authPanType.LOGIN">
      <AuthButtonContent :login="true" v-model:panState="authContentType" />
    </div>
    <div v-else-if="authContentType === authPanType.REGISTER">
      <AuthButtonContent :login="false" v-model:panState="authContentType" />
    </div>
  </div>
</template>

<style scoped>

</style>