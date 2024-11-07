<script setup>

import ChatOnlineUsersList from "@/components/chat/widgets/ChatOnlineUsersList.vue";
</script>

<template>
  <div class="chat-container__online block-shadow widget-block">
    <span class="widget-title">Сейчас онлайн</span>
    <ChatOnlineUsersList/>
    <a href="#" class="chat-container__online-more-button">Найти еще</a>
  </div>
</template>

<style scoped>

</style>