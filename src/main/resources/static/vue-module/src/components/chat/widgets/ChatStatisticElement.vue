<script setup>
defineProps({
  name: String,
  value: String
});
</script>

<template>
  <div class="chat-container__statistics-item">
    <span class="chat-container__statistics-name">{{ name }}</span>
    <span class="chat-container__statistics-value">{{ value }}</span>
  </div>
</template>

<style scoped>

</style>