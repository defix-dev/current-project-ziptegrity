<script setup>
import Navigation from "@/components/Navigation.vue";
import HeaderAuthButton from "@/components/HeaderAuthButton.vue";
import {computed, onMounted, ref, watch, watchEffect} from "vue";
import {useRoute} from "vue-router";
import {authPanType, pageType} from "../router/index.js";
import AuthButtonContent from "@/components/AuthButtonContent.vue";

const logoPath = "/images/elemply_logo.png";
const pagePath = ref('');
const route = useRoute();

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

function parsePageKey(path) {
  return path.substring(path.lastIndexOf('/') + 1) || 'none';
}

pagePath.value = parsePageKey(route.path);

watch(() => route.path, (newPath) => {
  pagePath.value = parsePageKey(newPath);
});

const currentPagePath = computed(() => pagePath.value);
const moreIconPath = "/images/more_icon.png";

const isLogin = ref(false);

onMounted(async () => {
  const f = await fetch('/api/authorization/check_auth_status')
  if(f.ok) isLogin.value = await f.text() === 'true';
});
</script>

<template>
  <div class="header-container">
    <div class="header-container__up">
      <div class="header-container__left">
        <img class="header-container__logo-icon" :src="logoPath" alt="Logo"/>
        <span class="header-container__logo-name">Elemply</span>
      </div>
      <div class="header-container__middle">
        <span class="header-container__page-name">{{ pageType[pagePath] }}</span>
      </div>
      <div class="header-container__right">
        <HeaderAuthButton @click="showDefAuthPan" :isLogin="isLogin" v-if="isLogin === false"/>
        <HeaderAuthButton @click="logout" :isLogin="isLogin" v-if="isLogin === true"/>
      </div>
    </div>
    <div class="header-container__down">
      <Navigation :pagePath="currentPagePath"/>
      <div class="header-container__more-button">
        <img alt="more" :src="moreIconPath"/>
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