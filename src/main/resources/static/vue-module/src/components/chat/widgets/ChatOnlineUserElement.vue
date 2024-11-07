<script setup>
const linkBluePath = "/images/link_blue.png";

defineProps({
  username: String
});
</script>

<template>
  <div class="chat-container__online-user">
    <span class="chat-container__online-username">{{ username }}</span>
    <a href="#" class="chat-container__online-next"><img :src="linkBluePath" alt="link" /></a>
  </div>
</template>

<style scoped>

</style>