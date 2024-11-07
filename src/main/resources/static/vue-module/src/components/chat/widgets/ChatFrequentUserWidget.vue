<script setup>
import {ref} from "vue";

const linkWhitePath = "/images/link_white.png";

const username = ref("Username");
</script>

<template>
  <div class="chat-container__freq-friend block-shadow widget-block">
    <span class="widget-title">Самый частый собеседник</span>
    <a href="#" class="chat-container__freq-friend-link"><img :src="linkWhitePath" alt="link" />{{ username }}</a>
  </div>
</template>

<style scoped>

</style>