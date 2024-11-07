<script setup>
import {computed} from "vue";

const props = defineProps({
  chatName: String,
  message: String,
  messageOwner: String,
  date: String,
  username: String
});

const messageIconPath = computed(() => (props.username === props.messageOwner) ? "/images/message_out.png" : "/images/message_in.png");
</script>

<template>
  <div class="chat-container__message block-shadow">
    <div class="chat-container__message-left">
      <span class="chat-container__message-username">{{ chatName }}</span>
      <span class="chat-container__message-text"><img :src="messageIconPath" alt="text_type_icon" />{{ message }}</span>
    </div>
    <div class="chat-container__message-right">
      <span class="chat-container__message-date">{{ date }}</span>
      <a href="#" class="chat-container__message-edit-button" style="display: none">
        <img src="#" alt="edit"/>
      </a>
    </div>
  </div>
</template>

<style scoped>

</style>