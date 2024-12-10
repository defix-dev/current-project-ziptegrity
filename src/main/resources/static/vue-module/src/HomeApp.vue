<script setup>
import {nextTick} from "vue";

const arrowIconPath = "/images/home/arrow_down_icon.png";

function goDown() {
  const currentScroll = document.body.scrollTop || document.documentElement.scrollTop;
  document.body.scrollTop = currentScroll + window.innerHeight;
}
</script>

<template>
  <div class="header__container">

  </div>
  <div class="page__container">
    <div class="general__container">
      <div class="arrow-down" @click="goDown"><img :src="arrowIconPath" alt="arrow_icon" /></div>
    </div>
    <div class="advantages__container">
      <div class="arrow-down" @click="goDown"><img :src="arrowIconPath" alt="arrow_icon" /></div>
    </div>
    <div class="services__container">

    </div>
  </div>
  <div class="footer__container">

  </div>
</template>

<style scoped>

</style>