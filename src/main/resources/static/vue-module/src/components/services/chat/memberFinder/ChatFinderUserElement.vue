<script setup>
import {computed} from "vue";

const props = defineProps({
  username: String,
  status: String
});

const linkIconPath = "/images/link_blue.png"

async function addChat() {
  await fetch(`/api/chat/add_chat?username=${props.username}`, {
    method: "POST"
  });
}
</script>

<template>
  <div class="chat-container__finder-user">
    <div class="chat-container__finder-user-left">
      <span class="chat-container__finder-user-name">{{ username }}</span>
      <span class="chat-container__finder-user-status">{{ status }}</span>
    </div>
    <a @click="addChat" class="chat-container__finder-user-open-button"><img :src="linkIconPath" alt="link_icon"/></a>
  </div>
</template>

<style scoped>

</style>