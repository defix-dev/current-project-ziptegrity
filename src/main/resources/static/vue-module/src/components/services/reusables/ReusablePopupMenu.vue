<script setup>
import {ref} from "vue";

defineProps({
  title: String,
  iconPath: String
});

const closeIconPath = "/images/close_icon.png";
const emit = defineEmits();

const hide = () => emit('hide');
</script>

<template>
  <div class="popup-menu">
    <div class="popup-menu__content">
      <div class="popup-menu__header">
        <span class="popup-menu__title">
      <img :src="iconPath" alt="popup_dec_icon" class="popup-menu__icon"/>{{ title }}</span>
        <a href="#" class="popup-menu__close-icon" @click="hide"><img :src="closeIconPath" alt="close_icon"/></a>
      </div>
      <slot></slot>
    </div>
  </div>
</template>

<style scoped>

</style>