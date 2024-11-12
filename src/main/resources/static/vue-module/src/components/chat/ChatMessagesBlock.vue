<script setup>
import ChatMessagesList from "@/components/chat/ChatMessagesList.vue";
import {onMounted, ref} from "vue";
import ChatMemberFinderBlock from "@/components/chat/memberFinder/ChatMemberFinderBlock.vue";

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

const finderBlockVisible = ref(false);
const changeFinderBlockVisible = (state) => finderBlockVisible.value = state;
</script>

<template>
  <div class="chat-container__chats">
    <span class="block-title">Текущие сообщения</span>
    <ChatMessagesList :messagesArray="messageProps"/>
    <a class="chat-container__add-chat-button" @click="changeFinderBlockVisible(true)">Добавить чат</a>
    <ChatMemberFinderBlock v-if="finderBlockVisible" @hide="changeFinderBlockVisible(false)" />
  </div>
</template>

<style scoped>

</style>