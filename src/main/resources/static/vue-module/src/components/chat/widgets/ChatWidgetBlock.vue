<script setup>
import ChatWidgetsList from "@/components/chat/widgets/ChatWidgetsList.vue";

const widgetMorePath = "/images/more_widgets_icon.png";
</script>

<template>
  <div class="chat-container__widgets">
    <div class="chat-container__widgets-header">
      <span class="block-title">Виджеты</span>
      <a href="#" class="chat-container__widgets-more-icon"><img :src="widgetMorePath" alt="widgets_more_icon"/></a>
    </div>
    <ChatWidgetsList/>
  </div>
</template>

<style scoped>

</style>