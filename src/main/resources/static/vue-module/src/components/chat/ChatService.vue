<script setup>
import ChatMessagesBlock from "@/components/chat/ChatMessagesBlock.vue";
import ChatWidgetBlock from "@/components/chat/widgets/ChatWidgetBlock.vue";
import {onMounted, ref} from "vue";
import ErrorBlock from "@/components/ErrorBlock.vue";

const authorized = ref(false);

onMounted(async () => {
  authorized.value = (await (await fetch('/api/authorization/check_auth_status')).text()) === "true";
})
</script>

<template>
  <div v-if="authorized">
    <link rel="stylesheet" href="/css/pages/chat_page.css"/>
    <div class="chat-container">
      <ChatMessagesBlock/>
      <ChatWidgetBlock/>

      <div class="chat-container__selected-group" style="display: none">

      </div>
    </div>
  </div>
  <ErrorBlock v-else reason="Для использования сервиса войдите в аккаунт."/>
</template>

<style scoped>

</style>