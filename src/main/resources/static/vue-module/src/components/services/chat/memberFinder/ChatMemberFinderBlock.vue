<script setup>
import ReusablePopupMenu from "@/components/services/reusables/ReusablePopupMenu.vue";
import ChatFinderUsersList from "@/components/services/chat/memberFinder/ChatFinderUsersList.vue";
import {ref} from "vue";

const searchIconPath = "/images/search_icon.png";
const searchMembersIconPath = "/images/search_members_icon.png";

const emit = defineEmits();
const hide = () => emit("hide");

const foundedUsers = ref([]);
const recommendedUsers = ref([]);
</script>

<template>
  <ReusablePopupMenu :iconPath="searchMembersIconPath" title="Поиск собеседников" @hide="hide">
    <div class="chat-container__finder-container">
      <form class="chat-container__finder-search-block">
        <input type="text" placeholder="Введите имя пользователя..." class="chat-container__finder-search-input"/>
        <button class="chat-container__finder-search-button"><img :src="searchIconPath" alt="search_icon"/></button>
      </form>
      <span class="chat-container__finder-mini-title">Поиск <span
          class="chat-container__finder-search-info" v-if="foundedUsers.length > 0">Найдено {{ foundedUsers.length }}</span></span>
      <ChatFinderUsersList :users="foundedUsers" />
      <span class="chat-container__finder-mini-title">Рекомендации</span>
      <ChatFinderUsersList :users="recommendedUsers"/>
    </div>
  </ReusablePopupMenu>
</template>

<style scoped>

</style>