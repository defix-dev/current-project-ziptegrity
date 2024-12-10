<script setup>
import ChatMessageElement from "@/components/services/chat/ChatMessageElement.vue";
import {onMounted, ref} from "vue";

defineProps({
  messagesArray: Array
});

const username = ref("");

onMounted(async () => {
  username.value =
      await (await fetch('/api/authorization/get_account_username')).text();
});
</script>

<template>
  <div class="chat-container__chats-container">
    <ChatMessageElement v-for="(item, index) in messagesArray" :key="index"
                        :chatName="item.chatName"
                        :message="item.message"
                        :messageOwner="item.messageOwner"
                        :date="item.sentAt"
                        :username="username"/>
  </div>
</template>

<style scoped>

</style>