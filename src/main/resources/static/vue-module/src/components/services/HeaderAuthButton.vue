<script setup>
defineProps({
  isLogin: Boolean
});
</script>

<template>
<div class="header-container__auth-button">
  <div v-if="isLogin">
    <span>Выход</span>
  </div>
  <div v-else>
    <span>Вход</span>
  </div>
</div>
</template>

<style scoped>

</style>