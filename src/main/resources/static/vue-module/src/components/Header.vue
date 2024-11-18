<script setup>
import Navigation from "@/components/Navigation.vue";
import HeaderAuthButton from "@/components/HeaderAuthButton.vue";
import {computed, onMounted, ref, watch, watchEffect} from "vue";
import {useRoute} from "vue-router";
import {authPanType, pageType} from "../router/index.js";
import AuthButtonContent from "@/components/AuthButtonContent.vue";

const logoPath = "/images/elemply_logo.png";

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
</script>

<template>
  <div class="header-container">
    <div class="header-container__content">
      <div class="header-container__left">
        <img class="header-container__logo-icon" :src="logoPath" alt="Logo"/>
      </div>
      <div class="header-container__right">
        <span class="header-container__plan header-button">План</span>
        <span class="header-container__api header-button">API</span>
        <a class="header-container__account" @click="showDefAuthPan"><img :src="accountIconPath" alt="account_icon" /></a>
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