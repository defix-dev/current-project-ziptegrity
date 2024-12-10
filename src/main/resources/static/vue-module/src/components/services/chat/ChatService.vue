<script setup>
import ChatMessagesBlock from "@/components/services/chat/ChatMessagesBlock.vue";
import {onMounted, ref} from "vue";
import ErrorBlock from "@/components/services/ErrorBlock.vue";

const authorized = ref(false);

onMounted(async () => {
  authorized.value = (await (await fetch('/api/authorization/check_auth_status')).text()) === "true";
})
</script>

<template>
  <div>
    <link rel="stylesheet" href="/css/app/pages/chat_page.css"/>
    <div class="chat-container">
      <ChatMessagesBlock/>

      <div class="chat-container__selected-group chat-block header-parent">
        <div class="chat-container__selected-group-header header-in-parent">
          <span class="chat-block-title">Переписка</span>
        </div>
        <div class="chat-container__selected-group-content chat-block-content">
          <div class="chat-container__selected-group-no-selected empty-block">
            <span class="chat-container__selected-group-title empty-msg">Выберите чат в блоке «Чаты», чтобы посмотреть переписку</span>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!--  <ErrorBlock v-else reason="Для использования сервиса войдите в аккаунт."/>-->
</template>

<style scoped>

</style>