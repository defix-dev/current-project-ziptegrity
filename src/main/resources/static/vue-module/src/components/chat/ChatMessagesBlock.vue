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
  for (const chat of chats) {
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
const noMessagesDecIconPath = "/images/no_messages_dec_icon.png";
const addChatIconPath = "/images/add_chat_icon.png";
</script>

<template>
  <div class="chat-container__chats chat-block">
    <div class="chat-container__chats-header chat-block-header">
      <span class="chat-block-title">Чаты</span>
      <img class="chat-container__chats-add-button" @click="changeFinderBlockVisible(true)" :src="addChatIconPath" alt="add_icon"/>
    </div>
    <div class="chat-container__chats-content chat-block-content">
      <div v-if="messageProps.length > 0">
        <ChatMessagesList :messagesArray="messageProps"/>
<!--        <a class="chat-container__add-chat-button" @click="changeFinderBlockVisible(true)">Добавить чат</a>-->
      </div>
      <div class="chat-container__no-messages-exception" v-else>
        <img :src="noMessagesDecIconPath" alt="no_msg_dec_icon" class="chat-container__no-messages-decoration"/>
        <div class="chat-container__no-messages-info">
          <span class="chat-container__no-messages-title">Чатов еще нет...</span>
        </div>
      </div>
      <ChatMemberFinderBlock v-if="finderBlockVisible" @hide="changeFinderBlockVisible(false)"/>
    </div>
  </div>
</template>

<style scoped>

</style>