<script setup>
defineProps({
  reason: String
});

const pathToErrorImg = "/images/error_decoration_img.png";
</script>

<template>
  <div class="error-container">
    <img :src="pathToErrorImg" alt="error_img" class="error-container__decoration-img"/>
    <div class="error-container__info">
      <span class="error-container__title">Произошла ошибка!</span>
      <span class="error-container__reason">{{ reason }}</span>
    </div>
  </div>
</template>

<style scoped>

</style>