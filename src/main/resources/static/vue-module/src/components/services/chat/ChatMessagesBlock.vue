<script setup>
import ChatMessagesList from "@/components/services/chat/ChatMessagesList.vue";
import {onMounted, ref} from "vue";
import ChatMemberFinderBlock from "@/components/services/chat/memberFinder/ChatMemberFinderBlock.vue";

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
  <div class="chat-container__chats chat-block header-parent">
    <div class="chat-container__chats-header header-in-parent">
      <span class="chat-block-title">Чаты</span>
      <a class="chat-container__chats-add-button header-img" @click="changeFinderBlockVisible(true)"><img
          :src="addChatIconPath" alt="add_icon"/></a>
    </div>
    <div class="chat-container__chats-content chat-block-content">
      <span class="chat-container__chats-count-info" v-if="messageProps.length > 0">{{ messageProps.length }} чат(-ов)</span>
      <ChatMessagesList :messagesArray="messageProps" v-if="messageProps.length > 0"/>
      <!--        <a class="chat-container__add-chat-button" @click="changeFinderBlockVisible(true)">Добавить чат</a>-->
      <div class="chat-container__no-messages-exception empty-block" v-else>
        <span class="chat-container__no-messages-title empty-msg">Чатов еще нет :'(</span>
      </div>
      <ChatMemberFinderBlock v-if="finderBlockVisible" @hide="changeFinderBlockVisible(false)"/>
    </div>
  </div>
</template>

<style scoped>

</style>