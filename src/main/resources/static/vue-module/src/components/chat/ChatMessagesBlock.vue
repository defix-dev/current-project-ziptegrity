<script setup>
import ChatMessagesList from "@/components/chat/ChatMessagesList.vue";
import {onMounted, ref} from "vue";

const messageProps = ref([]);

onMounted(async () => {
  const result = await fetch('/api/chat/get_chats', {
    method: 'GET',
    headers: {
      "Accept": "application/json"
    }
  })

  if (!result.ok) return;

  const chats = await result.json();
  for(const chat of chats) {
    messageProps.value.push({
      chatName: chat.chatMemberUsername,
      messageOwner: chat.messageOwner,
      message: chat.message,
      sentAt: chat.messageSentAt,
      chatId: chat.chatId
    });
  }
});
</script>

<template>
  <div class="chat-container__chats">
    <span class="block-title">Текущие сообщения</span>
    <ChatMessagesList :messagesArray="messageProps"/>
    <a href="#" class="chat-container__add-chat-button">Добавить чат</a>
  </div>
</template>

<style scoped>

</style>