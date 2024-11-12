<script setup>
import ChatFinderUserElement from "@/components/chat/memberFinder/ChatFinderUserElement.vue";

defineProps({
  users: Array
});
</script>

<template>
  <div class="chat-container__finder-users-default-container">
    <ChatFinderUserElement v-for="(item, index) in users" :key="index"
                           :username="item.username"
                           :status="item.status" v-if="users.length > 0"/>
    <span class="chat-container__finder-users-empty" v-else>Пусто.</span>
  </div>
</template>

<style scoped>

</style>