<script setup>
import {computed} from "vue";

const props = defineProps({
  chatName: String,
  message: String,
  messageOwner: String,
  date: String,
  username: String
});
</script>

<template>
  <div class="chat-container__message block-shadow">
    <span class="chat-container__message-username">{{ chatName }}</span>
    <span class="chat-container__message-text">{{ message }}</span>
    <span class="chat-container__message-date">{{ date }}</span>
    <a href="#" class="chat-container__message-edit-button" style="display: none">
      <img src="#" alt="edit"/>
    </a>
  </div>
</template>

<style scoped>

</style>